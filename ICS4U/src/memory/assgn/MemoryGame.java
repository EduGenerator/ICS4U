package memory.assgn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MemoryGame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1496700805016792959L;
	private final int SIZE = 4;
	private Card[] card = new Card [SIZE * SIZE];
	int ckd = 1;		//ckd: checked
	int y = 0;  		//y for yes, a.k.a pairs
	int n = 0;			//n for no, a.k.a fails
	Card firstCard;
	boolean ded = false;
	
	

	public static void main(String[] args){
		new MemoryGame();
		//JFrame frame;
	}
	public MemoryGame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(SIZE,SIZE));
		setVisible(true);
		setSize(1280, 720);
		int indx;
		for (int r = 0 ; r < SIZE ; r++)
		{
			for (int c = 0 ; c < SIZE ; c++)
			{
				indx = r * SIZE + c;
				card [indx] = new Card ();
				card[indx].addActionListener(this);
				add(card[indx]);
			}
		}
		for (int i = 1 ; i <= SIZE * SIZE / 2 ; i++)
		{
			for (int j = 0 ; j < 2 ; j++)
			{
				do
				{
					indx = (int) (Math.random () * SIZE * SIZE);
				}
				while (card [indx].getValue () != 0);
				card [indx].setValue (i);
			}
		}


	}
	//public void actionPerformed(ActionEvent e, Timer timer) {
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(ded)
		{
			return;
		}
		
		if(e.getSource().getClass() == Card.class){
			Card c = (Card)e.getSource();
			if(c.getFound()){
				return;
			}
			if (ckd == 1)
			{
				clearCards();
				firstCard = c;
			}
			else if (ckd == 2)
			{
				if(c == firstCard){
					return;
				}
				if(firstCard.getValue() == c.getValue()){
					y++;
					firstCard.setBackground(Color.GREEN);
					c.setBackground(Color.GREEN);
					firstCard.found();
					c.found();
					
				}
				else{
					n++;
				}
				ckd = 0;
			}
			c.setText(c.getValue() + "");
			ckd++;
			if(n > 8 || y == SIZE*SIZE / 2){
				ded = true;
						}
		}
	}
	public void clearCards(){
		for(int i = 0; i < card.length;i++){
			if(!card[i].getFound()){
				card[i].setText("");
			}
		}
	}
	public void showCards(){
		for(int i = 0; i < card.length;i++){
			card[i].setText(card[i].getValue() + " ");
		}
	}
	}
	
