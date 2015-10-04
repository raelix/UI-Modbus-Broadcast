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
package view;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View extends JFrame implements AbstractView {

	private static final long serialVersionUID = 1L;
	private JTextField ipAddr;
	private JTextField id;
	private JTextField regNumber;
	private JTextField port;
	private JTextField valueWrite;
	private JButton btnLeggi;
	private JButton btnScrivi;
	private JLabel valueReaded;
	private Checkbox defaultPort;
	private TextArea textArea ;
	private JLabel lblConsole;
	private Options dialog;
	private JLabel lblOpzioniAvanzate;

	public View() {
		super();
		initView();
		setVisible(true);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initView(){
		dialog = new Options();
		setSize(314,445);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ipAddr = new JTextField();
		ipAddr.setBounds(10, 36, 156, 20);
		getContentPane().add(ipAddr);
		ipAddr.setColumns(10);

		JLabel lblInserisciIndirizzoIp = new JLabel("Inserisci IP Modbus:");
		lblInserisciIndirizzoIp.setBounds(10, 11, 156, 14);
		getContentPane().add(lblInserisciIndirizzoIp);

		JLabel lblInserisciIdModbus = new JLabel("Inserisci ID Modbus (0 Broadcast):");
		lblInserisciIdModbus.setBounds(10, 67, 221, 14);
		getContentPane().add(lblInserisciIdModbus);

		id = new JTextField();
		id.setBounds(10, 92, 41, 20);
		getContentPane().add(id);
		id.setColumns(10);

		JLabel lblInserisciLindirizzoDel = new JLabel("Inserisci il numero del registro:");
		lblInserisciLindirizzoDel.setBounds(10, 123, 221, 14);
		getContentPane().add(lblInserisciLindirizzoDel);

		regNumber = new JTextField();
		regNumber.setBounds(10, 148, 41, 20);
		getContentPane().add(regNumber);
		regNumber.setColumns(10);

		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(176, 11, 46, 14);
		getContentPane().add(lblPorta);

		port = new JTextField();
		port.setBounds(176, 36, 46, 20);
		getContentPane().add(port);
		port.setColumns(10);

		btnScrivi = new JButton("Scrivi");
		btnScrivi.setBounds(10, 235, 89, 23);
		getContentPane().add(btnScrivi);

		btnLeggi = new JButton("Leggi");
		btnLeggi.setBounds(176, 235, 89, 23);
		getContentPane().add(btnLeggi);

		JLabel lblValoreLetto = new JLabel("Valore letto:");
		lblValoreLetto.setHorizontalAlignment(SwingConstants.LEFT);
		lblValoreLetto.setBounds(176, 179, 89, 14);
		getContentPane().add(lblValoreLetto);

		valueReaded = new JLabel("");
		valueReaded.setBounds(176, 198, 118, 33);
		getContentPane().add(valueReaded);

		JLabel lblInserisciIlValore = new JLabel("Inserisci il valore:");
		lblInserisciIlValore.setHorizontalAlignment(SwingConstants.LEFT);
		lblInserisciIlValore.setBounds(10, 179, 147, 14);
		getContentPane().add(lblInserisciIlValore);

		valueWrite = new JTextField();
		valueWrite.setBounds(10, 204, 86, 20);
		getContentPane().add(valueWrite);
		valueWrite.setColumns(10);

		defaultPort = new Checkbox("default");
		defaultPort.setBounds(228, 34, 95, 22);
		getContentPane().add(defaultPort);
		defaultPort.setState(true);

		textArea = new TextArea();
		textArea.setBounds(10, 289, 262, 83);
		getContentPane().add(textArea);

		lblConsole = new JLabel("Console:");
		lblConsole.setBounds(10, 269, 89, 14);
		getContentPane().add(lblConsole);
		getRootPane().setDefaultButton(btnScrivi);

		lblOpzioniAvanzate = new JLabel("Opzioni avanzate");
		lblOpzioniAvanzate.setBounds(10, 378, 135, 14);
		getContentPane().add(lblOpzioniAvanzate);
		Font font = lblOpzioniAvanzate.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblOpzioniAvanzate.setFont(font.deriveFont(attributes));

	}

	@Override
	public JButton getBtnScrittura() {
		return btnScrivi;
	}

	@Override
	public JButton getBtnLettura() {
		return btnLeggi;
	}

	@Override
	public String getIpAddress() {
		return ipAddr.getText();
	}

	@Override
	public int getPort() {
		return Integer.parseInt(port.getText());
	}

	@Override
	public int getRegisterAddress() {
		return Integer.parseInt(regNumber.getText());
	}

	@Override
	public int getValue() {
		return Integer.parseInt(valueWrite.getText());
	}

	@Override
	public void setReadedValue(int value) {
		valueReaded.setText(""+value);

	}

	@Override
	public int getMachineID() {
		return Integer.parseInt(id.getText());
	}

	@Override
	public boolean isDefaultPort() {
		return defaultPort.getState();
	}

	@Override
	public TextArea getConsole() {
		return textArea;
	}

	@Override
	public void setDefaultPort(int portNumber) {
		if(portNumber != -1)
			port.setText(""+portNumber);
		else
			port.setText("");
	}

	@Override
	public Checkbox getChkDefaultPort() {
		return defaultPort;
	}

	@Override
	public boolean isCheckWrite() {
		return dialog.isConfirmEnable();
	}

	@Override
	public void showOptions() {
		dialog.setVisible(true);

	}

	@Override
	public void hideOptions() {
		dialog.setVisible(false);

	}

	@Override
	public JLabel getChkOptionsDialog() {
		return lblOpzioniAvanzate;
	}

	@Override
	public void setDefaultTimeout(int timeout) {
		dialog.setTimeout(timeout);

	}

	@Override
	public int getSettedTimeout() {
		return dialog.getTimeout();
	}

	@Override
	public boolean isShowingDialog() {
		return dialog.isShowing();
	}
}
