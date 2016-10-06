package catCatcher.assgn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class HighScore extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5038103834349788676L;
	public JLabel HS;
	public JButton re;
	int[] highScores = new int [10];
	String[] listItems= {"0","0","0","0","0","0","0","0","0","0"};
	
		public HighScore(){
		HS = new JLabel("Your Score Is");
		re = new JButton("Retry?");
		JList<String> scoreList= new JList<String>(listItems);
		scoreList.setFixedCellWidth(100);
		DefaultListCellRenderer renderer=(DefaultListCellRenderer)scoreList.getCellRenderer();
		        renderer.setHorizontalAlignment(JLabel.CENTER);

		add(HS, BorderLayout.NORTH);
		add(scoreList, BorderLayout.CENTER);
		add(re, BorderLayout.SOUTH);
		this.setBounds(200, 200, 200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	 void addScore(int newScore){
		HS.setText("Your Score :"+newScore);
		for (int i=0; i<10; i++) {
			if (newScore > highScores[i]){
				for (int j=9; j>i; j--)
                {
                    highScores[j] = highScores[j-1];
                }
                highScores[i] = newScore;
                break;

			}
				listItems[i]=Integer.toString(highScores[i]);
			}
		

			
		repaint();
		}
	
		
	
	public HighScore(int score){
		this();
		addScore(score);	
		
	}
	public static void main(String args[])
	{
		
		
		new HighScore();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==re) {
			setVisible(false);
		}
	}
}
