package optnPanes.assgns;

import javax.swing.JOptionPane;

public class Dialog3 {
	public static void main (String[] args)
    {
        // Simple Input dialog:
        String inputValue = JOptionPane.showInputDialog ("What is the price of your dream car?");
        // Simple Message dialog:
        
        double value; //= Integer.parseInt(inputValue);
        try{
        	value = Integer.parseInt(inputValue);
        }
        catch (NumberFormatException e){
        	value = 0;
        }
        double x = value * 0.13;
        double b = x + value;
        JOptionPane.showMessageDialog (null, "That'll be $" + b);
    }
}
