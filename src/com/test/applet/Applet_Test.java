package com.test.applet;
import java.awt.*;
import java.applet.*;

public class Applet_Test extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("Hello Applet =====", 5, 30);
		g.drawString("This is a Test =====", 10, 60);
	}
}
