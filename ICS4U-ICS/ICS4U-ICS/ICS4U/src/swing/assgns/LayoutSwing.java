package swing.assgns;

import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class LayoutSwing extends JFrame implements ActionListener, ItemListener
 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1227604391649453115L;
	JTextField txtA;
	JTextField txtB;
	JLabel answer;
	JLabel sideA;
	JLabel sideB;
	JButton Calculate;
	JButton Done;
	JPanel outer = new JPanel (new BorderLayout());
	
	
	public void init()
	{
		
		}
			
		//double a = Double.parseDouble (txtA.getText());
		//double b = Double.parseDouble (txtB.getText());
	//}
	
	public LayoutSwing()
	{
		super ("LayoutSwing");
		//Window Creation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(80, 70, 400, 400);
		//objects
		JPanel panel = new JPanel();
		panel.setLayout (new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		txtA = new JTextField (10);
		txtB = new JTextField (10);
		sideA = new JLabel ("Please enter length of side a");
		sideB = new JLabel ("Please enter length of side b");
		answer = new JLabel ("Ready?", JLabel.HORIZONTAL);
		Calculate = new JButton ("Calculate");
		Done = new JButton ("Done");
		
		JPanel line = new JPanel(new FlowLayout());
		line.add(sideA);
		line.add(txtA);
		panel.add(line);
		
		line = new JPanel(new FlowLayout());
		line.add(sideB);
		line.add(txtB);
		panel.add(line);
		
		line = new JPanel(new FlowLayout());
		line.add(answer);
		panel.add(line);
		
		line = new JPanel(new FlowLayout());
		line.add(Calculate);
		line.add(Done);
		panel.add(line);
		
		//outer.add(answer, BorderLayout.NORTH);
		
		txtA.addActionListener(this);
		txtB.addActionListener(this);
		Calculate.addActionListener(this);
		Done.addActionListener(this);
		
		this.setContentPane (panel);
		//show the contents
		this.setVisible(true);
	}
	
	//public void actionPerformed1 (ActionEvent e)
	//{
		//if (e.getSource() == Done)
		//{
			//this.dispose();
			//System.exit (0);
		//}
	//}
	
	

	

	public static void main(String args[])
	{
		new LayoutSwing();
	}
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == Calculate)
		{
			double a; {
				try
				{
				    a = Double.parseDouble (txtA.getText());
				}
				catch (NumberFormatException ex)
				{
				    a = 0;		// just make it zero for simplicity
				}
				}

				double b; {
				try
				{
				    b = Double.parseDouble (txtB.getText());
				}
				catch (NumberFormatException ex)
				{
				    b = 0;		// just make it zero for simplicity
				}
			double c=Math.sqrt(a*a+b*b);
			answer.setText("The Hypotenuse of this triangle is:" +c);
		}
		}
				else if (e.getSource() == Done)
		{
			this.dispose();
			System.out.println("DONE");
			System.exit (0);
			
		}
		
		
	}
	}
	