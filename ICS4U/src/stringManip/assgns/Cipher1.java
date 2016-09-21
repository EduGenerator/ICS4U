package stringManip.assgns;

import javax.swing.JOptionPane;

public class Cipher1 {
	public static void main (String[] args)
	{
		String x = JOptionPane.showInputDialog ("Ceasar Me This!");
		x = x.toUpperCase();
		String n = "";
		for(int i = 0; i < x.length();i++){
			int a = (int) x.charAt(i);
			System.out.println((char) a);

			if(a == 90){
				a = 65;
			}
			else{
				a++;

			}
			char b = (char) a;
			n += b;
		}

		System.out.println(n);

	}

}

