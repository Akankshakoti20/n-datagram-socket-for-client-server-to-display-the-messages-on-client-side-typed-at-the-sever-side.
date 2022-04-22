import java.io.*;
import java.net.*;
import java.util.Scanner;
class UDPServer{
public static void main(String args[]) throws Exception{
DatagramSocket serverSocket= new DatagramSocket(9876);
System.out.println("Server started");
byte[] receiveData=new byte[1024];
byte[] sendData=new byte[1024];
DatagramPacket receivePacket =new
DatagramPacket(receiveData,receiveData.length);
serverSocket.receive(receivePacket);
receivePacket.getData();
InetAddress IPAddress=receivePacket.getAddress();
int port=receivePacket.getPort();
System.out.println("client connected");
Scanner input=new Scanner(System.in);
System.out.println("enter the msg to be sent");
String message=input.nextLine();
sendData=message.getBytes();
DatagramPacket sendPacket =new
DatagramPacket(sendData,sendData.length,IPAddress,port);
serverSocket.send(sendPacket);
System.exit(0);
}
}
