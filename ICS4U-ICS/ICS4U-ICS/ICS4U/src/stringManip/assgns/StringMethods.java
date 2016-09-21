package stringManip.assgns;

import javax.swing.*;

public class StringMethods {
	public static void main (String[] args)
	{
		String word = JOptionPane.showInputDialog("Enter a word");
		int len = word.length ();
		for (int i = 0; i < len; i++)
		{
			System.out.print(word.substring(i, i+1));
			System.out.print("");
		}
		System.out.println();
	}
}
