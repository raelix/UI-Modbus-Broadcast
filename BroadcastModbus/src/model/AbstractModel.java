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

public interface AbstractModel {

	public String getDefaultStringReaded(int value);
	public String getDefaultStringWrited();
	public String getDefaultStringConfirmed();
	public String getErrorMessage(String message);
	public int getDefaultTimeout();
	public int getDefaultPort();
}
