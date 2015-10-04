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
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;

public interface AbstractView {
	
	/* getter and setter of JComponents */
	public JButton getBtnScrittura();
	public JButton getBtnLettura();
	public JLabel getChkOptionsDialog();
	public TextArea getConsole();
	public Checkbox getChkDefaultPort();
	
	/* getter and setter of primitive */
	public String getIpAddress();
	public int getPort();
	public int getRegisterAddress();
	public int getMachineID();
	public int getValue();
	public int getSettedTimeout();
	public boolean isDefaultPort();
	public boolean isCheckWrite();
	public boolean isShowingDialog();
	public void setDefaultPort(int port);
	public void setReadedValue(int value);
	public void setDefaultTimeout(int timeout);
	public void showOptions();
	public void hideOptions();
	
}
