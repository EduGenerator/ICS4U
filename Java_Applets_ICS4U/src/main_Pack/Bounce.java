package main_Pack;
import java.applet.*;
import java.awt.*;

public class Bounce extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -98483566553137160L;
	int x,y;
	int dx,dy;
	final int HEIGHT=250;
	final int WIDTH=200;
	
	public void start ()
	{
		// make a new thread from this class
        Thread th = new Thread (this);
        // start the thread
        th.start ();
    } 


	
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
		g.setColor(Color.CYAN);
	}
	
	public void run()
	{
		while(true)
		{
			 if (x+dx>WIDTH || x+dx<0)
	            {
	                dx = -dx;
	            }
	         if (y+dy>HEIGHT || y+dy<0)
	            {
	                dy = -dy;
	            }

			x += dx;
			y += dy;
			
			repaint ();
			
			try
            {
                Thread.sleep (5); // 5 ms
            }
            catch (InterruptedException e)
            {
                // do nothing
            }


		}
	}
}
