package memory;

import javax.swing.JButton;

public class Card extends JButton {

	private int val;
	public Card(){
		val = 0;
		
	}
	
	public int getValue(){
		return val;
	}
	
	public void setValue(int v){
		val = v;
	}
}
