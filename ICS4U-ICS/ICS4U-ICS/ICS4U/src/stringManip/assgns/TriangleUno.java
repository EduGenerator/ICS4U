package stringManip.assgns;

import javax.swing.*;

public class TriangleUno {
	public static void main(String[] args){
		String x = JOptionPane.showInputDialog ("Fancy YouTube Comment Generator");
		if(x.length() > 0){

			for(int i = 1; i < x.length() + 1;i++){
				System.out.println(x.substring(0,i));
			}
		}
	}


}
