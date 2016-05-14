package com.test.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Scoket_Receive
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket udp_socket=new DatagramSocket(9000);
		
//		DatagramPacket(byte[] buf, int length) 
//        构造 DatagramPacket，用来接收长度为 length 的数据包。
		byte buf[]=new byte[1024];
		DatagramPacket udp_packet=new DatagramPacket(buf, 1024);
		
		boolean flag=true;
		String str;
		while(flag)
		{
			udp_socket.receive(udp_packet);

			str =   "Receive UDP packet from " 
					+ udp_packet.getAddress() 
					+ " : "
					+ udp_packet.getPort()
					+ " : "
					+new String(udp_packet.getData(), 0, udp_packet.getLength());
			System.out.println(str);			
		}		
		udp_socket.close();
	}
}
