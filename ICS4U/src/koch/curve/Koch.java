package koch.curve;

import java.applet.*;
import java.awt.*;

public class Koch extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8657778329797473104L;
	TextField text = new TextField (10);
	
	public void init(){
		
		this.add (text);	
	}
	
	public boolean action (Event evt, Object obj)
	{
	repaint ();
	return true;
	}

	
	public void koch (Graphics g, int x1, int y1, int x5, int y5, int n)
	{
		int x2, y2, x3, y3, x4, y4;
		double d, a, h;
		Integer.parseInt(text.getText()) ;
		try {
			 
			}
			catch ( NumberFormatException e ) {
			   System.out.println( "Not a legal number." );
			   
			}
		

		if (n == 0 || (x5 - x1) == 0){
			g.drawLine (x1, getHeight() - y1, x5, getHeight() - y5); //Draw the line
			return;
		}

		d = Math.sqrt ((x5-x1) * (x5-x1) + (y5-y1) * (y5-y1)) / 3;	// 1/3 of the length
		a = Math.atan2 ((double) (y5-y1), (double) (x5-x1));			// angle of the line
		h = 2 * d * Math.cos (30 * Math.PI / 180);					// distance to peak
		 
		x2 = x1 + (int) (d * Math.cos (a)); 
		y2 = y1 + (int) (d * Math.sin (a));
		x3 = x1 + (int) (h * Math.cos ((a + 30 * Math.PI / 180)));	// coordinates of peak
		y3 = y1 + (int) (h * Math.sin ((a + 30 * Math.PI / 180)));
		x4 = x1 + (int) (2 * d * Math.cos (a));
		y4 = y1 + (int) (2 * d * Math.sin (a));

		g.setColor (Color.white);
		g.drawLine (x2, getHeight () - y2, x4, getHeight () - y4);	// Erase the middle

		koch (g, x1, y1, x2, y2, n - 1);	 // Recursive calls to replace line with new pattern
		koch (g, x2, y2, x3, y3, n - 1);
		koch (g, x3, y3, x4, y4, n - 1);
		koch (g, x4, y4, x5, y5, n - 1);
		koch (g, 50, 100, 350, 100, 2); 
		
		repaint();
	}

}