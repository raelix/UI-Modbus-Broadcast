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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Options extends JFrame implements AbstractOptions {

	private static final long serialVersionUID = 1L;
	private JTextField timeoutValue;
	private Checkbox checkConfirm;

	public Options() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(228,138);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);

		JLabel lblTimeout = new JLabel("Timeout:");
		lblTimeout.setBounds(10, 11, 80, 14);
		getContentPane().add(lblTimeout);

		timeoutValue = new JTextField();
		timeoutValue.setBounds(10, 36, 86, 20);
		getContentPane().add(timeoutValue);
		timeoutValue.setColumns(10);

		checkConfirm = new Checkbox("Controlla avvenuta scrittura");
		checkConfirm.setBounds(10, 62, 192, 22);
		getContentPane().add(checkConfirm);

	}

	@Override
	public int getTimeout() {
		return Integer.parseInt(timeoutValue.getText());

	}

	@Override
	public void setTimeout(int timeout) {
		timeoutValue.setText(""+timeout);

	}

	@Override
	public boolean isConfirmEnable() {
		return checkConfirm.getState();
	}

}
