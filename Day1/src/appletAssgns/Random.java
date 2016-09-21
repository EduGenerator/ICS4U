package appletAssgns;
import java.applet.*;
import java.awt.*;

public class Random extends Applet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6218311776282709876L;
	final int WIDTH=250;
	final int HEIGHT=275;
	final int RADIUS=20;
	int x,y;
	
	public void init()
	{
		this.resize(WIDTH, HEIGHT);
	}
	
	public void paint(Graphics g)
	{
		for (int i=1; i<=10; i++)
		{
			x = (int) (Math.random()*(WIDTH-2*RADIUS))+RADIUS;
			y = (int) (Math.random()*(HEIGHT-2*RADIUS))+RADIUS;
			drawBall(g, x, y, RADIUS, Color.blue);
		}
	}
	
	public void drawBall(Graphics g, int x, int y, int r, Color clr)
	{
		g.setColor(clr);
		g.fillOval(x-r, y-r, 2*r, 2*r);
	}
}
