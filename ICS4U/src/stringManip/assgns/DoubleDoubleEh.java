package stringManip.assgns;

import javax.swing.JOptionPane;

public class DoubleDoubleEh {
	public static void main (String[] args)
	{
		String x = JOptionPane.showInputDialog ("Speech J-J-Jammer!");
		String y = "";
		 for(int i = 0; i < x.length();i++)
		 {
			 y += x.substring(i,i+1);
			 y += x.substring(i,i+1);
			
		}
		 System.out.println(y);
	}

}
