/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author vezir
 */
public class NewClass1 {
  String ff;
  Array dd[];
  
  
  	static public void main(String[] args){

  
		System.out.println("\nUsing Library Version v" + SerialPort.getVersion());
		SerialPort.addShutdownHook(new Thread() { public void run() { System.out.println("\nRunning shutdown hook"); } });
		SerialPort[] ports = SerialPort.getCommPorts();
		System.out.println("\nAvailable Ports:\n"+ports);
		for (int i = 0; i < ports.length; ++i)
			System.out.println("   [" + i + "] " + ports[i].getSystemPortName() + " (" + ports[i].getSystemPortPath() + "): " + ports[i].getDescriptivePortName() + " - " + ports[i].getPortDescription() + " @ " + ports[i].getPortLocation() + " (VID = " + ports[i].getVendorID() + ", PID = " + ports[i].getProductID() + ", Serial = " + ports[i].getSerialNumber() + ")");
		System.out.println("\nRe-enumerating ports again in 2 seconds...\n");
                        SerialPort MySerialPort = ports[0];
		System.out.println("\nport name " + ports[0]);
               MySerialPort.openPort();
                
                if (MySerialPort.isOpen())//Check whether port open/not
              System.out.println("is Open ");
                
                
                MySerialPort.addDataListener(new SerialPortDataListener() {

            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    return;
                }
                byte[] newData = new byte[MySerialPort.bytesAvailable()];
                int numRead = MySerialPort.readBytes(newData, newData.length);
                System.out.println("Read " + numRead + " bytes.");
            }
        });
           byte[] sendData = new byte[]{(byte) 0xE3};
            MySerialPort.writeBytes(sendData, 5);

        for (int j = 0; j < 10; ++j) {

           // byte[] sendData = new byte[]{(byte) 0xE3};
            //MySerialPort.writeBytes(sendData, j);

        }
                
     /*           try 
 {
    while (true)
    {

      byte[] readBuffer = new byte[100];

      int numRead = MySerialPort.readBytes(readBuffer,
                                           readBuffer.length);

      System.out.print("Read " + numRead + " bytes -");
      
      //Convert bytes to String
      String S = new String(readBuffer, "UTF-8"); 

      System.out.println("Received -> "+ S);

    }
} 
catch (Exception e) 
{

      e.printStackTrace(); 
}
*/
//MySerialPort.closePort(); //Close the por
        /*
           System.out.println(" Port not open ");
           System.out.println("\njjj" + ports[1].getSystemPortName());


                try { Thread.sleep(2000); } catch (Exception e) {}
		ports = SerialPort.getCommPorts();
		System.out.println("Available Ports:\n");
		for (int i = 0; i < ports.length; ++i)
			System.out.println("   [" + i + "] " + ports[i].getSystemPortName() + " (" + ports[i].getSystemPortPath() + "): " + ports[i].getDescriptivePortName() + " - " + ports[i].getPortDescription() + " @ " + ports[i].getPortLocation() + " (VID = " + ports[i].getVendorID() + ", PID = " + ports[i].getProductID() + ", Serial = " + ports[i].getSerialNumber() + ")");

                                
		SerialPort ubxPort;
		System.out.print("\nChoose your desired serial port or enter -1 to specify a port directly: ");
		int serialPortChoice = -2;
		Scanner inputScanner = new Scanner(System.in);
		try {
			serialPortChoice = inputScanner.nextInt();
		} catch (Exception e) {}
		if (serialPortChoice == -2)
		{
			inputScanner.close();
			return;
		}
		else if (serialPortChoice == -1)
		{
			String serialPortDescriptor = "";
			System.out.print("\nSpecify your desired serial port descriptor: ");
			try {
				while (serialPortDescriptor.isEmpty())
					serialPortDescriptor = inputScanner.nextLine();
			} catch (Exception e) { e.printStackTrace(); }
			ubxPort = SerialPort.getCommPort(serialPortDescriptor);
		}
		else
			ubxPort = ports[serialPortChoice];
		ubxPort.allowElevatedPermissionsRequest();
		byte[] readBuffer = new byte[2048];
		System.out.println("\nPre-setting RTS: " + (ubxPort.setRTS() ? "Success" : "Failure"));
		boolean openedSuccessfully = ubxPort.openPort(0);
		System.out.println("\nOpening " + ubxPort.getSystemPortName() + ": " + ubxPort.getDescriptivePortName() + " - " + ubxPort.getPortDescription() + ": " + openedSuccessfully);
		if (!openedSuccessfully)
		{
			System.out.println("Error code was " + ubxPort.getLastErrorCode() + " at Line " + ubxPort.getLastErrorLocation());
			inputScanner.close();
			return;
		}
		System.out.println("Setting read timeout mode to non-blocking");
		ubxPort.setBaudRate(115200);
		ubxPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1000, 0);
		try
		{
			for (int i = 0; i < 3; ++i)
			{
				System.out.println("\nReading #" + i);
				System.out.println("Available: " + ubxPort.bytesAvailable());
				int numRead = ubxPort.readBytes(readBuffer, readBuffer.length);
				System.out.println("Read " + numRead + " bytes.");
			}
		} catch (Exception e) { e.printStackTrace(); }
		System.out.println("\nSetting read timeout mode to semi-blocking with a timeout of 200ms");
		ubxPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 200, 0);
		try
		{
			for (int i = 0; i < 3; ++i)
			{
				System.out.println("\nReading #" + i);
				System.out.println("Available: " + ubxPort.bytesAvailable());
				int numRead = ubxPort.readBytes(readBuffer, readBuffer.length);
				System.out.println("Read " + numRead + " bytes.");
			}
		} catch (Exception e) { e.printStackTrace(); }
		System.out.println("\nSetting read timeout mode to semi-blocking with no timeout");
		ubxPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		System.out.println("\nWaiting for available bytes to read...");
		while (ubxPort.bytesAvailable() == 0);
		System.out.println("Available: " + ubxPort.bytesAvailable());
		System.out.println("Flushing read buffers: " + ubxPort.flushIOBuffers());
  */
}
}