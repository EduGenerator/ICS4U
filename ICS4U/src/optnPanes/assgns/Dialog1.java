package optnPanes.assgns;

import javax.swing.JOptionPane;

public class Dialog1 {
	public static void main (String[] args)
    {
        String inputValue = JOptionPane.showInputDialog ("What Handle Do You Go By, my [genderneuteral pronoun]?");
        JOptionPane.showMessageDialog (null, "Have a magniflorious day, " + inputValue);
    }
}
