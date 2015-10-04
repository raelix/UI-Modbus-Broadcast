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
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;

public interface AbstractController {
	
	public void readValue(boolean isForCheckingConfirm);
	public TCPMasterConnection getConnection() throws Exception;
	public void writeValue();
	
}
