package main_Pack;
import java.applet.*;
import java.awt.*;

public class SimpleMath extends Applet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8538045463582533413L;
	double x,y;
	
	public void init()
	{
		x=3;
		y=4;
	}
	public void paint(Graphics g)
	{
		double z=Math.sqrt(x*x+y*y);
		g.drawString("The answer is: "+z, 20, 20);
	}
}
