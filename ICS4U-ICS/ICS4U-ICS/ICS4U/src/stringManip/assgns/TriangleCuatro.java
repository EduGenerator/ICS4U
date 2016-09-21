package stringManip.assgns;

import javax.swing.JOptionPane;

public class TriangleCuatro {
	public static void main(String[] args){
		String w = JOptionPane.showInputDialog ("Fancy YouTube Comment Generator Mark IV");
		String s = "                                 ";
		if(w.length() > 0){
			int x = 1;
			int add = 1;
			do{
				System.out.print(s.substring(0,w.length() - x));
				System.out.print(w.substring(x - 1, x));
				if(x != 1){
					System.out.print(s.substring(0,x * 2 - 3));
					System.out.print(w.substring(x - 1, x));

				}
				System.out.println();
				x += add;
				if(x == w.length()){
					add = -add;
				}
				
			}while(x > 0);
		}	

	}

}
