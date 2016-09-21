package stringManip.assgns;

import javax.swing.JOptionPane;

public class TriangleDos {

	public static void main(String[] args){
		String w = JOptionPane.showInputDialog ("Fancy YouTube Comment Generator Mark II");
		if(w.length() > 0){

			int x = 1;
			int add = 1;
			do{
				System.out.println(w.substring(0, x));
				x += add;
				if(x == w.length()){
					add = -add;
				}
			}while(x > 0);
		}	

	}

}

