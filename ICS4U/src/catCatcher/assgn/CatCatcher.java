 package catCatcher.assgn;
 
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
 
 import javax.swing.*;
 

public class CatCatcher extends JFrame implements ActionListener, MouseListener, Runnable {
 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -5242118490851937165L;
	private ImageIcon w, homeworld;
	//private Timer wTime;
	private Timer wTime, gameTimer;
 	private JLabel wf, bkg;
    private Random random=new Random();
    int Score = 0;
    public String ScoreCount = "Score: " + Score;
    private HighScore highScorePanel;


    
 	
 	public CatCatcher()
 	{
 			w = new ImageIcon("res/Deanslist.png");
 			wf = new JLabel(w);
 			homeworld = new ImageIcon("res/Woodie'sHome.png");
 			bkg = new JLabel(homeworld);
 		    setContentPane(bkg); 
 		    getContentPane().setLayout(new FlowLayout());
 			//JPanel panel = new JPanel ();
 			add(wf);
 	        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("res/mouse.png").getImage(),new Point(0,0),"custom cursor"));

 			//panel.add(bkg);
 			
 			

 			
			
	        
 			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			this.setExtendedState(MAXIMIZED_BOTH);
 			this.setTitle("Woodie Catcher");
 			this.setVisible(true);
			//this.setContentPane (panel);
			
 			wTime=new Timer(1500,this);
 	        wTime.start();
 	        gameTimer=new Timer(10000,this); 
 	        gameTimer.start();
	       // gameTimer=new Timer(10000,this); 
 			
	        wf.addMouseListener(this);
 		}
 		
 	
 	public static void main(String args[])
	{
		new CatCatcher();
	}
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		// TODO Auto-generated method stub
			
        if (e.getSource()==wTime) {
        
            // Move the cat randomly, subtract width or height so it stays on the screen
           wf.setLocation(random.nextInt(getWidth()-wf.getWidth()), random.nextInt(getHeight()-wf.getHeight()));
        }
        else if (e.getSource()==gameTimer) {
        	wf.setVisible(false);
        	gameTimer.stop();
        	String name = JOptionPane.showInputDialog("Submit your name for Deans List");
        	
        	new HighScore(Score, this, name);
        	gameTimer.restart();
            wTime.restart();
            Score = 0;
            wf.setVisible(true);
           }


            
        	//JOptionPane.showMessageDialog(null,"test");

        //}
        
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		wTime=new Timer(1500,this);
        wTime.start();
       
		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
        actionPerformed(new ActionEvent(wTime,0,""));
        wTime.restart();
        Score++;
        Toolkit.getDefaultToolkit().beep();
        
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//After many trials and too many errors, Woodie Catcher and the HighScores class live happily ever after.
//Project completed Monday October 17th 2016
 
 
