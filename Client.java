
//package udp_multithreaded;

/**
 *L3 - ISIL 2020-2021
 * @author Houssam HAMOUDA
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class Client {

    private void process() {
          DatagramSocket datagramSocket = null;
            
          try{
                // Build a DatagramSocket and bind it to any available local port number
                datagramSocket = new DatagramSocket();
                               
                // Build a DatagramPacket object to send a request packet to the server (the server is running locally)
                String request = "Bonjour";
                byte[] buffer = request.getBytes();
                InetAddress serverAddress = InetAddress.getByName("localhost");
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length, serverAddress, 8080);
                
                // Send the packet to the server
                for(int j=0;j<10;j++){
                datagramSocket.send(requestPacket);
                
                }
                // Receive the response packet from the server
                buffer = new byte[256];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(responsePacket);

                // Get the string contained in the received packet
                String received = new String(responsePacket.getData(), 0, responsePacket.getLength());

                // Display the received string
                System.out.println(received);
          }
          catch(IOException e){
                e.printStackTrace();
          }
        //  finally{
                // Close the DatagramSocket
               // if(datagramSocket != null)
                  //    datagramSocket.close();
          //}
    }

    public static void main(String[] args){
          new Client().process();
    }
}