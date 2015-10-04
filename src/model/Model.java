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
package model;

public class Model implements AbstractModel {
	
	private int defaultPort = 502;
	private int defaultTimeout = 3000;
	
	public Model() {
	this.defaultPort = 502;
	this.defaultTimeout = 3000;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public void setDefaultPort(int defaultPort) {
		this.defaultPort = defaultPort;
	}

	public int getDefaultTimeout() {
		return defaultTimeout;
	}

	public void setDefaultTimeout(int defaultTimeout) {
		this.defaultTimeout = defaultTimeout;
	}

	@Override
	public String getDefaultStringReaded(int value) {
		return "Valore letto = " + value+"\n";
	}

	@Override
	public String getDefaultStringWrited() {
		return "Valore scritto!"+"\n";
	}

	@Override
	public String getDefaultStringConfirmed() {
		return "Scrittura confermata!"+"\n";
	}

	@Override
	public String getErrorMessage(String message) {
		return "Errore: "+message+"\n";
	}
	
	
	
}
