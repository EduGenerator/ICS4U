package optnPanes.assgns;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialog6 extends JOptionPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4575193823919441748L;
	public static void main(String[] args){
		new Dialog6();
	}
	public Dialog6(){
		super("Assignment Number Six"); 
		
		JTextField input1 = new JTextField(9);
		JTextField input2 = new JTextField(9);

		Object[] newOptions = {input1,input2,"Let's Go!"};
		
		JOptionPane.showOptionDialog (null, "Please input your values", "Number Crunching Time!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, newOptions, newOptions [2]);
		try{
			double a = Double.parseDouble(input1.getText());
			double b = Double.parseDouble(input2.getText());
			if(a == b){
				JOptionPane.showMessageDialog (null, "Equality for all!" + "("+a+")" , "Praise!", JOptionPane.PLAIN_MESSAGE);

			}
			else{
			double x = (a > b) ? a : b; 
			JOptionPane.showMessageDialog (null, "This number is bigger than the other number!  "+x , "Results", JOptionPane.PLAIN_MESSAGE);
			}
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog (null, "New Class, Old Tricks, eh?", "How Could You", JOptionPane.PLAIN_MESSAGE);
		}
	}

}


