package com.test.applet;
import java.awt.*;
import java.applet.*;

public class Applet_Accept_Param extends Applet
{
	String score=new String("Applet_Accept_Param");
	String str_temp=new String("not yet");
	
	public void init()
	{
		str_temp = getParameter("ParamHtml");
	}
	
	public void paint(Graphics g)
	{
		g.drawString(score, 30, 30);
		g.drawString(str_temp, 30, 60);
	}
}
