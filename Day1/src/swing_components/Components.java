package swing_components;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Components extends JFrame
{
	public Components()
	{
		super ("Components");
		
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);
		
		this.setVisible(true);
	}
	
	public static void main (String[] args)
	{
		new Components ();
		
	} //main method
}//Components class
