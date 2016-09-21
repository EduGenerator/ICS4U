package swing.assgns;

import javax.swing.*;
import javax.swing.border.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SandwichOrder extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4132746222751129938L;
	JRadioButton S, L;
	JCheckBox let, tom, mus, oni, chz, may;
	JLabel sum, chubs;
	JButton total;
	JButton ding;
	TitledBorder sS, f;
	ImageIcon chub;
	
	public SandwichOrder()
	{
		super ("Chubway Online Chub Order");
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(80, 70, 800, 450);
			JPanel panel = new JPanel ();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			//declare
			S = new JRadioButton ("Large");
			L = new JRadioButton ("Larger");
			sS = new TitledBorder(new LineBorder (Color.black), "Chub Size");
			f = new TitledBorder(new LineBorder (Color.black), "Fixings");
			sum = new JLabel ("Your Chubtotal is:");
			let = new JCheckBox ("Lettuce");
			tom = new JCheckBox ("Tomato");
			mus = new JCheckBox ("Mustard");
			oni = new JCheckBox ("Onions");
			chz = new JCheckBox ("Cheese");
			may = new JCheckBox ("Mayo");
			total = new JButton ("Confirm");
			ding = new JButton ("Cancel");
			chub = new ImageIcon("res/CHUBWAY.jpg");
			chubs = new JLabel (chub);
			
			ButtonGroup group = new ButtonGroup ();
			group.add(S);
			group.add(L);
			
			JPanel top = new JPanel(new FlowLayout());
			top.setBorder(sS);
			top.add(S);
			top.add(L);
			top.add(chubs);
			
			JPanel mid = new JPanel(new GridLayout());
			mid.setBorder(f);
			mid.add(let);
			mid.add(tom);
			mid.add(mus);
			mid.add(oni);
			mid.add(chz);
			mid.add(may);
			
			JPanel bot = new JPanel (new FlowLayout());
			bot.add(sum);
			bot.add(total);
			bot.add(ding);
			
			
			ding.addActionListener(this);
			total.addActionListener(this);
			
			S.addActionListener(this);
			L.addActionListener(this);
			let.addActionListener(this);
			tom.addActionListener(this);
			mus.addActionListener(this);
			oni.addActionListener(this);
			chz.addActionListener(this);
			may.addActionListener(this);
			
			panel.add(top);
			panel.add(mid);
			panel.add(bot);
			
			S.doClick();
			
			this.setContentPane (panel);
			//show the contents
			this.setVisible(true);
			
			
		}
	}
	public static void main(String args[])
	{
		new SandwichOrder();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() == ding)
		{
			this.dispose();
			System.out.println("DONE");
			System.exit (0);
		}
		else
		{
			double money = 0;
			if (S.isSelected()){
				money += 2.50;
			}
			else if (L.isSelected()){
				money += 4.00;
			}
			if (let.isSelected()){
				money += 0.10;
			}
			if (tom.isSelected()){
				money += 0.25;
			}
			if (oni.isSelected()){
				money += 0.10;
			}
			if (chz.isSelected()){
				money += 0.50;
			}
			sum.setText("Your Chubtotal is $" + money);
		}
		  if (e.getSource() == total) {
			  JOptionPane.showMessageDialog (null, "Order sent to Chubway LTD."); 
		 }
		
		
	}
}
