/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;



/**
 *
 * @author vezir
 */
public class Mavenproject1  {

    public static void main(String[] args) {
       /* System.out.println("Hello World!");
        
        String []oneargs = new String[5];
        oneargs[0] = "one";
        oneargs[1] = "two";
        oneargs[2] = "three";
        oneargs[3] = "four";
        oneargs[4] = "five";
                System.out.println("Dizinin Boyutu \n" + oneargs.length);

        for (int i = 0; i < 5; i++){
        System.out.println(oneargs[i]);
        }*/
       
       
       /* int []randomargs = new int[101];
        
        
        
        
        for (int i = 0; i < randomargs.length; i++){
               Random random =   new Random();
       
      int randomsayi = random.nextInt(100)+1;
      
randomargs[i] = randomsayi;
System.out.println(randomargs[i]);
        
        }
       
       
*/
       
      SerialPort comPort = SerialPort.getCommPorts()[0];

     //SerialPort [] AvailablePorts = SerialPort.getCommPorts();
      // SerialPort comPort = SerialPort.getCommPorts()[0];

        //Open the first Available port
        //SerialPort MySerialPort = AvailablePorts[0];
                  System.out.println(" ss "+comPort);

        //MySerialPort.openPort(); //open the port
                                 //Arduino May get reset 

        /*if (MySerialPort.isOpen())//Check whether port open/not
              System.out.println("is Open ");
        else
           System.out.println(" Port not open ");

        MySerialPort.closePort(); //Close the port

      if (MySerialPort.isOpen())
            System.out.println(" is Open ");
        else
            System.out.println("\n Port not open ");
        
    */
//SerialPort comPort = SerialPort.getCommPorts()[0];
//comPort.openPort();

      //      System.out.println(" is Open "+comPort);

/*comPort.addDataListener(new SerialPortDataListener() {
   @Override
   public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }
   @Override
   public void serialEvent(SerialPortEvent event)
   {
      byte[] newData = event.getReceivedData();
      System.out.println("Received data of size: " + newData.length);
      for (int i = 0; i < newData.length; ++i)
         System.out.print((char)newData[i]);
      System.out.println("\n");
   }
});

*/
 }
}