/*******************************************************************************
 * Copyright (c) 2015 .
 * All rights reserved. If you want to use this project ask to author.
 *
 * Developed by Raelix
 *
 * Libraries:
 *     J2Mod - Modbus library
 *     MigLayout - Swing UI
 *******************************************************************************/
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetAddress;

import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersResponse;
import com.ghgande.j2mod.modbus.msg.WriteMultipleRegistersRequest;
import com.ghgande.j2mod.modbus.msg.WriteMultipleRegistersResponse;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import com.ghgande.j2mod.modbus.procimg.Register;
import com.ghgande.j2mod.modbus.procimg.SimpleRegister;

import model.AbstractModel;
import view.AbstractView;

public class Controller implements AbstractController, ActionListener, ItemListener, MouseListener {

	private int lastReaded;
	private AbstractView view;
	private AbstractModel model;

	public Controller(AbstractView view, AbstractModel model) {
		this.view = view;
		this.model = model;
		initView();
	}

	private void initView(){
		view.setDefaultPort(model.getDefaultPort());
		view.setDefaultTimeout(model.getDefaultTimeout());
		view.getBtnLettura().addActionListener(this);
		view.getBtnScrittura().addActionListener(this);
		view.getChkDefaultPort().addItemListener(this);
		view.getChkOptionsDialog().addMouseListener(this);
	}

	public TCPMasterConnection getConnection() throws Exception {
		TCPMasterConnection con = new TCPMasterConnection(InetAddress.getByName(view.getIpAddress()));
		if(!view.isDefaultPort())
			con.setPort(view.getPort());
		else con.setPort(model.getDefaultPort());
		con.connect();
		con.setTimeout(view.getSettedTimeout());
		return con;
	}

	public void readValue(boolean isCheck){
		try {
			ReadMultipleRegistersRequest request = new ReadMultipleRegistersRequest(view.getRegisterAddress() - 1, 1);
			ModbusTCPTransaction trans = new ModbusTCPTransaction(getConnection());
			request.setUnitID(view.getMachineID());
			trans.setRequest(request);
			trans.execute();
			ReadMultipleRegistersResponse response = (ReadMultipleRegistersResponse) trans.getResponse();
			if(!isCheck){
				view.getConsole().append(model.getDefaultStringReaded(response.getRegister(0).getValue()));
			}
			view.setReadedValue(response.getRegister(0).getValue());
			lastReaded = response.getRegister(0).getValue();
		} catch (Exception e) {
			view.getConsole().append(model.getErrorMessage(e.getMessage()));
		}
	}


	public void writeValue(){
		try {

			WriteMultipleRegistersRequest request = new WriteMultipleRegistersRequest(view.getRegisterAddress() - 1,
					new Register[]{new SimpleRegister(view.getValue())} );
			ModbusTCPTransaction trans = new ModbusTCPTransaction(getConnection());
			request.setUnitID(view.getMachineID());
			trans.setRequest(request);
			trans.execute();
			WriteMultipleRegistersResponse response = (WriteMultipleRegistersResponse) trans.getResponse();
			if(response.getMessage()[0] == 0)
				view.getConsole().append(model.getDefaultStringWrited());
			if(view.isCheckWrite())
				readValue(true);			
			if(view.getValue() == lastReaded)
				view.getConsole().append(model.getDefaultStringConfirmed());
		} catch (Exception e) {
			view.getConsole().append(model.getErrorMessage(e.getMessage()));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == view.getChkDefaultPort()){
			if(view.getChkDefaultPort().getState())
				view.setDefaultPort(model.getDefaultPort());
			else view.setDefaultPort(-1);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBtnLettura())
			readValue(false);
		else if(e.getSource() == view.getBtnScrittura())
			writeValue();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == view.getChkOptionsDialog()){
			if(!view.isShowingDialog())
				view.showOptions();
			else
				view.hideOptions();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
