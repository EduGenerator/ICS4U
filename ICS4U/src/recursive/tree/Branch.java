package recursive.tree;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Branch extends Applet implements ActionListener {
	static TextField text = new TextField (10);
	
	public void init(){
		this.setSize(1280, 720);
		this.add(text);
		text.addActionListener(this);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		int n;
		try {
			n = Integer.parseInt(text.getText());

			}
			catch ( NumberFormatException e ) {
				n = 0;
			}
		branch(g, getWidth()/2, getHeight(), 50, 90, 10, n);
	}
	public void branch(Graphics g, int x, int y, int length, int angle, int angleChange, int num)
	{
		int x2= (int) (x-length*Math.cos(angle*Math.PI/180));
		int y2= (int) (y-length*Math.sin(angle*Math.PI/180));
		g.drawLine(x, y, x2, y2);
		
		if (num > 0) {
		
		branch(g, x2, y2, length, angle+angleChange, angleChange, num-1);
		branch(g, x2, y2, length, angle-angleChange, angleChange, num-1);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
