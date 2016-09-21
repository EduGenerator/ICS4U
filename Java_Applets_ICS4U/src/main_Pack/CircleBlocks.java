package main_Pack;
import java.applet.*;
import java.awt.*;

public class CircleBlocks extends Applet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6287613043303774110L;
	
	public void paint(Graphics g)
	{
        g.setColor(Color.red);
        for (int angle=0; angle<360; angle+=20)
        {
            double radius = 100;
			int x=250+(int)(Math.sin(angle*Math.PI/180)*radius);
            int y=250+(int)(Math.cos(angle*Math.PI/180)*radius);
            g.fillRect(x,y,10,10);
        }

	}
}
