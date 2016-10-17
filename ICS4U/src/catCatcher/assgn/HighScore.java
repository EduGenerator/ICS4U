package catCatcher.assgn;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
//After many trials and too many errors, Woodie Catcher and the HighScores class live happily ever after.
//Project completed Monday October 17th 2016


public class HighScore extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5038103834349788676L;
	public JLabel HS;
	public JButton re;
	int[] highScores = new int [10];
	String[] listItems= {"0","0","0","0","0","0","0","0","0","0"};
	JList<String> scoreList;
    String[] names=new String[10];
    String[][] tableData = {{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""},{"0", ""}};


	
	public HighScore(int newScore, Frame owner, String name){
		super(owner, "HighScore", true);
		
		String[] columnNames = {"Score", "Name"};
	    JTable scoreTable = new JTable(tableData, columnNames);

		HS = new JLabel("Your Score Is");
		re = new JButton("Retry?");
		readScores();
		addScore(newScore, name);
		saveScores();
		
		scoreList= new JList<String>(listItems);
		scoreList.setFixedCellWidth(100);
		DefaultListCellRenderer renderer=(DefaultListCellRenderer)scoreList.getCellRenderer();
		        renderer.setHorizontalAlignment(JLabel.CENTER);

		add(HS, BorderLayout.NORTH);
		add(scoreList, BorderLayout.CENTER);
		add(re, BorderLayout.SOUTH);
		re.addActionListener(this);
		this.setBounds(200, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	void addScore(int newScore, String name){
		HS.setText("Your Score :"+newScore);
		for (int i=0; i<10; i++) {
			if (newScore > highScores[i]){
				for (int j=9; j>i; j--)
                {
                    highScores[j] = highScores[j-1];
                    names[j] = names[j-1];

                }
                highScores[i] = newScore;
                names[i] = name;
                break;

			}
			else if (newScore > highScores[i]){
				this.dispose();
			}
		} 
			for (int i=0; i<10; i++) {
				listItems[i]=highScores[i]+"   "+names[i];
				tableData[i][0]=Integer.toString(highScores[i]);
				tableData[i][1]=names[i];

			}
		

			
		repaint();
		}
	
	void saveScores(){
		try {
            PrintWriter out= new PrintWriter("scores.txt");
          
            for (int i=0; i<highScores.length ; i++)
            {
            	 out.println(highScores[i]);
            	 out.println(names[i]);
  	           
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Cannot open file.");
        }
	}
	 void readScores(){
		 try {
	            BufferedReader in=new BufferedReader(new FileReader("scores.txt"));
	           	for (int i=0; i<10; i++)
	            {
	               
	           		highScores[i] = Integer.parseInt(in.readLine());           // Read a line
	           		names[i] = in.readLine();
	            }
	            in.close();
	        } catch (IOException e) {
	            System.out.println("Cannot open file.");
	        }

	 }
	
		
	
	//public HighScore(int score){
		//this(score, null);
		//addScore(score);	
		
//	}
	public HighScore() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		
		
		new HighScore();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==re) {
			this.dispose();
		}
	}
	public void UpdateScore(int score, String name) {
		// TODO Auto-generated method stub
		HS.setText("Your Score is "+score);
		int[] integerScoreList = new int[10];
		for (int i=0;i<10;i++){
			integerScoreList[i] = Integer.parseInt(listItems[i]);
		
	}
	for (int i=0; i<10;){
		if (score > integerScoreList[i]){
			for (int j=9; j>i; j--){
				listItems[j] = listItems[j-1];				
				}
			}
			listItems[i] = Integer.toString(score);
			break;
		}
	}
	}
//After many trials and too many errors, Woodie Catcher and the HighScores class live happily ever after.
//Project completed Monday October 17th 2016
