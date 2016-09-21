package optnPanes.assgns;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Dialog4 extends JOptionPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -221165193839406185L;
	public static void main(String[] args){
		new Dialog4();
	}
	public Dialog4(){
		super("Assignment Number Four");
		
        JRadioButton cF = new JRadioButton ("ºC to ºF",true);
        JRadioButton fC = new JRadioButton ("ºF to ºC");
        JTextField input = new JTextField(10);
        
        ButtonGroup group = new ButtonGroup ();
        group.add (cF);
        group.add (fC);
        
        Object[] newOptions = {input, cF, fC, "Let's Go!"};
       
        
        double a = 0;
        double x = 0;
        JOptionPane.showOptionDialog (null, "How cold is it? And how cold is it in American?", "Temperature Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, newOptions, newOptions [2]);
        try{
        	a = Double.parseDouble(input.getText());
        	if (cF.isSelected ())
            	x = a*9/5+32;
            if (fC.isSelected ()){
            	x = (a-32)*5/9;
            }
            JOptionPane.showMessageDialog (null, "Converted! : " + x, "Response", JOptionPane.PLAIN_MESSAGE);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog (null, "Playing games, are we?", "Response", JOptionPane.PLAIN_MESSAGE);
        }
        
		
	}
	
}