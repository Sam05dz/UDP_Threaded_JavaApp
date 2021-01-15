
//package udp_multithreaded;

/**
 * L3 - ISIL 2020-2021
 * @author Houssam HAMOUDA
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public final class Server extends Thread {

    private DatagramSocket datagramSocket;
    private int portNumber = 8080;


    public Server() throws SocketException {
          setName("TP SID - Serveur UDP MultiThread");
          System.out.println("Tp SID - Serveur UDP MultiThread");
          // create a DatagramSocket instance and bind it to the specified port number
          datagramSocket = new DatagramSocket(portNumber);
    }


    public void run(){
        
        try{
            
                while (! isInterrupted()) {
                    
                      // Build a DatagramPacket object to receive a packet
                      byte[] buffer = new byte[256];
                      DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                        
                      // Receive a packet from a client. The method "receive" blocks until a packet arrives
                      datagramSocket.receive(requestPacket);
                     
                      // Get the string contained in the received packet
                      String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
                      
                      if(request.equals("Bonjour")){
                         
                            // Build a DatagramPacket object to send a response packet to the client
                            String response = new String("Message du Serveur : Bien recu");
                            buffer = response.getBytes();
                            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, requestPacket.getAddress(), requestPacket.getPort());
                            System.out.println(request);
                            // Send the packet to the client
                            datagramSocket.send(responsePacket);
                            
                      }   
                }
          }
          catch(IOException e){
                e.printStackTrace();
          }
         // finally{
                // close the DatagramSocket instance before termination
              //  datagramSocket.close();
        //  }
    }
    
}
