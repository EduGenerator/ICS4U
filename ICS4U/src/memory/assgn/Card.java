package memory.assgn;


import javax.swing.JButton;

public class Card extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7903425003852524078L;
	private int val;
	private boolean found = false;

	public Card(){
		val = 0;
	}
	public boolean getFound(){
		return found;
	}
	public void found(){
		found = true;
	}
	public int getValue(){
		return val;
	}

	public void setValue(int v){
		val = v;
	}


}
