import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main(String args[]) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("10.2.11.146");
		byte[] sendData = new byte[32];
		byte[] receiveData = new byte[100];
		
		String str = new String("Daniel");
		int a = 21;
		double d = 44.674;
		
		byte[] strname = new byte[20];
		strname = str.getBytes();
		byte[] intfield = new byte[4];
		intfield= intToByte(a);
		byte[] doublefield = new byte[8];
		doublefield = doubleToByte(d);
		
		int lenint = intfield.length;
		int lendouble = doublefield.length;
		
		for (int i = 0; i < str.length(); i++) 
			sendData[i]=strname[i];
		
		for (int i = 0; i < lenint; i++) 
			sendData[i+20]=intfield[i];
	
		for (int i = 0; i < lendouble; i++) 
			sendData[i+24]=doublefield[i];
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);
		clientSocket.send(sendPacket);
	}

	public static byte[] intToByte(int a) throws Exception {
		ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
		DataOutputStream dOS = new DataOutputStream(bAOS);
		dOS.writeInt(a);
		return bAOS.toByteArray();
	}
	public static byte[] doubleToByte(double a) throws Exception {
		ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
		DataOutputStream dOS = new DataOutputStream(bAOS);
		dOS.writeDouble(a);
		return bAOS.toByteArray();
	}

}
