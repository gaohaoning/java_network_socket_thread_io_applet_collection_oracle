package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Socket_Send
{
	public static void main(String[] args) throws Exception
	{
		//DatagramSocket udp_socket = new DatagramSocket(9000);
		//发送端口和接收端口可以不同
		DatagramSocket udp_socket = new DatagramSocket(3000);
		//目的地址要写成这种形式
		byte addr[]={(byte)127,0,0,1};
		
		BufferedReader std_in=new BufferedReader(new InputStreamReader(System.in));
		String user_input;
		DatagramPacket udp_packet;
		while((user_input=std_in.readLine())!=null)
		{
//			DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
//	          构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
			udp_packet = new DatagramPacket(
					user_input.getBytes(),
					user_input.length(),
					//InetAddress.getLocalHost(),
					InetAddress.getByAddress(addr),				
					9000);
			udp_socket.send(udp_packet);
		}
		
		udp_socket.close();
	}
}
