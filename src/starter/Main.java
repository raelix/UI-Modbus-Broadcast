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
package starter;
import controller.Controller;
import model.Model;
import view.View;

public class Main {
	public static void main(String[] args) {
		new Controller(new View(), new Model());
	}
}
