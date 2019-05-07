import java.io.*;
import java.net.*;

class udpServer
{
   public static void main(String args[]) throws Exception
      {
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
         DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
	    String Sentence="";
            while(!Sentence.equals("Over"))
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("Client Sayes : " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  Sentence = inFromUser.readLine();
                  sendData = Sentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}
