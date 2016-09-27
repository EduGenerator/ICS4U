package catCatcher.assgn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CatCatcher extends JFrame implements ActionListener {
	
	private ImageIcon w;
	private Timer wTime;
	private JLabel wf;
	
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
			
			this.setContentPane (panel);
			wTime=new Timer(1500,this);
	        wTime.start();
			
		}
		
	}
	public static void main(String[] args){
		new CatCatcher();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
	}

}
