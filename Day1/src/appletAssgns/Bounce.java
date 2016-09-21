package appletAssgns;
import java.applet.*;
import java.awt.*;

public class Bounce extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5960691186510125480L;
	int x,y;
	int dx,dy;
	final int WIDTH=277;
	final int HEIGHT=112;
	
	public void init()
	{
		x=10;
		y=0;
		dx=1;
		dy=1;
		
	}
	public void paint(Graphics g)
	{
		g.fillOval(x, y, 10, 10);
	}
	public void run()
	{
		if (x+dx>WIDTH || x+dx<0)
		{
			dx = -dx;
		}
		if (y+dy>HEIGHT || y+dy<0)
		{
			dy= -dy;
		}
		x += dx;
		y += dy;
		
		while(true)
		{
			repaint ();
			
			try
			{
				Thread.sleep(500); // 5 ms
			}
			catch  (InterruptedException e)
			{
				//do nothing
			
			}
		}
	}
	public void start ()
	{
		Thread th = new Thread (this);
		th.start ();
	}
}
