package swing.assgns;

import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class FontStyle extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1290299808585225807L;
	JLabel fs;
	JButton b;
	JButton i;
	JButton bi;
	JButton r;
	JButton ding;
	
	public FontStyle()
	{
		super ("FontStyle");
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(80, 70, 200, 200);
			JPanel panel = new JPanel ();
			
			fs = new JLabel("FONT STYLE", JLabel.CENTER);
			b = new JButton("Bold");
			i = new JButton("Italic");
			bi = new JButton("Bold and Italic");
			r = new JButton ("Regular");
			ding = new JButton("Dunzo");
			fs.setFont (new Font ("Titillium", 27, 27));
			
			panel.add(fs);
			panel.add(b);
			panel.add(i);
			panel.add(bi);
			panel.add(r);
			panel.add(ding);
			
			b.addActionListener(this);
			i.addActionListener(this);
			bi.addActionListener(this);
			r.addActionListener(this);
			ding.addActionListener(this);
			
			this.setContentPane(panel);
			this.setVisible(true);
		}
	}
	public static void main(String args[])
	{
		new FontStyle();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource () == b)
		{
			fs.setFont (new Font ("Titillium", Font.BOLD, 27));
			
		}
		else if (e.getSource() == i)
		{
			fs.setFont (new Font ("Titillium", Font.ITALIC, 27));
		}
		else if (e.getSource() == bi)
		{
			fs.setFont (new Font ("Titillium", Font.BOLD | Font.ITALIC, 27));
		}
		else if (e.getSource() == r)
		{
			fs.setFont (new Font ("Titillium", 27, 27));
		}
		else if (e.getSource() == ding)
		{
			this.dispose();
			System.out.println("DONE");
			System.exit (0);
		}
		
	}
}