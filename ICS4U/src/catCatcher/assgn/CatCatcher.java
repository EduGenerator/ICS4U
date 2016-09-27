package catCatcher.assgn;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

public class CatCatcher extends JFrame implements ActionListener, MouseListener, Runnable {
	
	private ImageIcon w;
	private Timer wTime, gameTimer;
	private JLabel wf;
    private Random random=new Random();
    
	
	public CatCatcher()
	{
		super ("Cat Catcher");
		{
			w = new ImageIcon("res/Deanslist.png");
			wf = new JLabel(w);
			JPanel panel = new JPanel ();
			panel.add(wf);
	        
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setTitle("WoodieCatcher");
			this.setVisible(true);
			String score;
			
			this.setContentPane (panel);
			wTime=new Timer(1500,this);
	        wTime.start();
	        gameTimer=new Timer(10000,this); 
			
	        wf.addMouseListener(this);
		}
		
	}
	public static void main(String[] args){
		new CatCatcher();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if (e.getSource()==wTime) {
        }
            // Move the cat randomly, subtract width or height so it stays on the screen
            wf.setLocation(random.nextInt(getWidth()-wf.getWidth()), random.nextInt(getHeight()-wf.getHeight()));

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		wTime=new Timer(1500,this);
        wTime.start();
        gameTimer=new Timer(10000,this); 
		String score = null;
		JOptionPane.showMessageDialog(null,"Your score is "+score);
        System.exit(0);

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
        Toolkit.getDefaultToolkit().beep();
        int score = +1;

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
