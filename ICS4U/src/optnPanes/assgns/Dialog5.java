package optnPanes.assgns;

import javax.swing.JOptionPane;

public class Dialog5 {
	public static void main (String[] args)
    {
        // Simple Input dialog:
        String inputValue = JOptionPane.showInputDialog ("What is your grade point average?");
        // Simple Message dialog:
        
        double value; //= Integer.parseInt(inputValue);
        try{
        	value = Integer.parseInt(inputValue);
        }
        catch (NumberFormatException e){
        	value = 0;
        }
       if (value < 50) {
    	   JOptionPane.showMessageDialog (null, "AND YOU FAIL", "Yale Acceptance", JOptionPane.PLAIN_MESSAGE);
       }
       else 
       {
        JOptionPane.showMessageDialog (null, "Congradulations! You have been accepted to Yale!", "Yale Acceptance", JOptionPane.PLAIN_MESSAGE);
    }
}
}
