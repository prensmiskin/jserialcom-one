/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.serialpundit.serial.SerialComManager;
import com.serialpundit.serial.SerialComManager.BAUDRATE;
import com.serialpundit.serial.SerialComManager.DATABITS;
import com.serialpundit.serial.SerialComManager.FLOWCONTROL;
import com.serialpundit.serial.SerialComManager.PARITY;
import com.serialpundit.serial.SerialComManager.STOPBITS;
import java.io.IOException;

/**
 *
 * @author vezir
 */
public class NewClass {
  	private static int osType;

  public static void main(String[] args) {
		try {	
			SerialComManager scm = new SerialComManager();

			String PORT = null;
			String PORT1 = null;
			
				PORT = "/dev/ttyUSB0";
				PORT1 = "/dev/ttyUSB1";
			
			int x = 0;
			long handle;
			long handle1;

			handle = scm.openComPort(PORT, true, true, true);
			scm.configureComPortData(handle, DATABITS.DB_8, STOPBITS.SB_1, PARITY.P_NONE, BAUDRATE.B115200, 0);
			scm.configureComPortControl(handle, FLOWCONTROL.NONE, 'x', 'x', false, false);
			handle1 = scm.openComPort(PORT1, true, true, true);
			scm.configureComPortData(handle1, DATABITS.DB_8, STOPBITS.SB_1, PARITY.P_NONE, BAUDRATE.B115200, 0);
			scm.configureComPortControl(handle1, FLOWCONTROL.NONE, 'x', 'x', false, false);
			
			for(x=0; x<10000; x++) {
				scm.writeString(handle, "testing", 0);
				scm.writeString(handle1, "testing1", 0);
			}

			for(x=0; x<10000; x++) {
				if(scm.writeString(handle, "testing", 0) == false) {
					throw new IOException("write failed");
				}
				if(scm.writeString(handle1, "testing1", 0) == false) {
					throw new IOException("write 1 failed");
				}

				Thread.sleep(10);
				System.out.println("data1 read is : " + scm.readString(handle1));
				System.out.println("data read is : " + scm.readString(handle));
			}

			System.out.println("close status : " + scm.closeComPort(handle));
			System.out.println("close status : " + scm.closeComPort(handle1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
