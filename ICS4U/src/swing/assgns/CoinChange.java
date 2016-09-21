package swing.assgns;

import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CoinChange extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8541796868517402289L;
	JTextField cents;
	JLabel qt;
	JLabel dm;
	JLabel nk;
	JLabel pn;
	JLabel question;
	JButton ding, dunzo;
	ImageIcon money;
	JLabel muns;
	
	
	public CoinChange()
	{
		super ("Coin Change");
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(80, 70, 800, 450);
			JPanel panel = new JPanel ();
			panel.setLayout (new BorderLayout());
			
			question = new JLabel ("Please enter the amount in cents");
			cents = new JTextField (30);
			qt = new JLabel ("Quarters:");
			dm = new JLabel ("Dimes:");
			nk = new JLabel ("Nickels:");
			pn = new JLabel ("Pennies:");
			ding = new JButton ("GO!!");
			money = new ImageIcon("res/75135-Breaking-Bad-money-bed-Huell-5-pJrx.jpeg");
			muns = new JLabel (money);
			dunzo = new JButton ("Dunzo");
			
			JPanel north = new JPanel(new FlowLayout());
			north.add(question);
			north.add(cents);
			
			JPanel west = new JPanel ();
			west.setLayout(new BoxLayout (west, BoxLayout.Y_AXIS));
			west.add(qt);
			west.add(dm);
			west.add(nk);
			west.add(pn);
			
			JPanel east = new JPanel();
			east.setLayout(new BoxLayout (east, BoxLayout.Y_AXIS));
			east.add(muns);
			
			JPanel south = new JPanel (new FlowLayout ());
			south.setLayout(new BoxLayout (south, BoxLayout.Y_AXIS));
			south.add(ding);
			south.add(dunzo);
			
			panel.add(north, BorderLayout.NORTH);
			panel.add(west, BorderLayout.WEST);
			panel.add(east, BorderLayout.EAST);
			panel.add(south, BorderLayout.SOUTH);
			
			cents.addActionListener(this);
			ding.addActionListener(this); 
			dunzo.addActionListener(this);
			
			this.setContentPane (panel);
			//show the contents
			this.setVisible(true);
		}
	}
	
	public static void main(String args[])
	{
		new CoinChange();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ding)
		{
			int a = Integer.parseInt(cents.getText());
			int q = a / 25;
			a = a - q * 25;
			int d = a / 10;
			a = a - d * 10;
			int n = a / 5;
			a = a - n * 5;
			int p = a;
			nk.setText("Nickels : " + n);
			qt.setText("Quarters :" + q);
			dm.setText("Dimes :" + d);
			pn.setText("Pennies :" + p);
			
		}
		else if (e.getSource() == dunzo)
		{
			this.dispose();
			System.out.println("DONE");
			System.exit (0);
		}
		
	}
	}

