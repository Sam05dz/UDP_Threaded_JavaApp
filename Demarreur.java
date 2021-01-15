
//package udp_multithreaded;

/**
 *L3 - ISIL 2020-2021
 * @author Houssam HAMOUDA
 */
import java.net.SocketException;

public final class Demarreur {

    public static void main(String[] args){
          try{
                Server udpServer = new Server();
                System.out.println("Server Start");
                udpServer.start();
          }
          catch(SocketException e){
                e.printStackTrace();
          }
    }
}
