package optnPanes.assgns;

import javax.swing.JOptionPane;

public class Dialog2 {
	public static void main (String[] args)
    {
        // Simple Input dialog:
        String inputValue = JOptionPane.showInputDialog ("The Count demands a number!");
        // Simple Message dialog:
        int value; //= Integer.parseInt(inputValue);
        try{
        	value = Integer.parseInt(inputValue);
        }
        catch (NumberFormatException e){
        	value = 0;
        }
        int x = value*value;
        JOptionPane.showMessageDialog (null, "IT IS " + x);
    }
}
