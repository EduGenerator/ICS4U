package memory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/*
 * work in progress
 */

public class Memory extends JFrame implements ActionListener {
	private final int SIZE = 4;
	private Card[] card = new Card [SIZE * SIZE];
	
	public Memory(){
		setLayout(new GridLayout());
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
