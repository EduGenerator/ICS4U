package stringManip.assgns;

import javax.swing.JOptionPane;

public class TriangleTres {
	public static void main(String[] args){
		String w = JOptionPane.showInputDialog ("Fancy YouTube Comment Generator Mark III");
		String s = "                                                                ";
		if(w.length() > 0){
			int x = 1;
			int add = 1;
			do{
				System.out.print(s.substring(0, x - 1));
				System.out.println(w.substring(x-1, x));
				x += add;
				if(x == w.length()){
					add = -add;
				}
			}while(x > 0);
		}	

	}

}
