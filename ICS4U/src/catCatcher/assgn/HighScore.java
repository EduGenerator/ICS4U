package catCatcher.assgn;

import javax.swing.*;

import swing.assgns.FontStyle;

public class HighScore extends JFrame{
	
	public JLabel HS;
	
	int[] highScores = new int [10];
	String[] listItems= {"0","0","0","0","0","0","0","0","0","0"};
	
		public HighScore(){
		HS = new JLabel("Your Score Is");
		JList<String> scoreList= new JList<String>(listItems);
		scoreList.setFixedCellWidth(100);
		DefaultListCellRenderer renderer=(DefaultListCellRenderer)scoreList.getCellRenderer();
		        renderer.setHorizontalAlignment(JLabel.CENTER);

		add(HS);
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
				repaint();
			}
		

			
		}
	
		
	
	public HighScore(int score){
		this();
		HS.setText("Your Score :"+score);	
		
	}
	public static void main(String args[])
	{
		
		
		new HighScore();
		
		
	}
}
