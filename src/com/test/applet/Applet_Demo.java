package com.test.applet;
import java.awt.*;
import java.applet.*;

public class Applet_Demo extends Applet
{
	String str=new String("Applet_Demo");
	public void paint(Graphics g)
	{
		g.drawString(str, 30, 30);
	}
	
	public void init()
	{
		str+="==INIT==";		
		repaint();
	}
	
	public void start()
	{
		str+="==START==";
		repaint();
	}
	
	public void stop()
	{
		str+="==STOP==";
		repaint();
	}
	
	public void destroy()
	{
		str+="==DESTROY==";
		repaint();
	}
}
