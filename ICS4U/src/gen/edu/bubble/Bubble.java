package gen.edu.bubble;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * Class Bubbles - a visual bubblesort demonstration
 * 
 * @author Mr. Wood 
 * @version 1.0
 * @modifier Jordan Cohen
 */
public class Bubble extends JApplet implements Runnable, KeyEventDispatcher
{
    // Number of values in the list:
    private final int NUM = 20;

    private int showGreen=0;

    private int showRed=0;
    
    private int delay=100;
    
    private boolean restart=false;

    private Image backbuffer;
    private Graphics bg;





    // List of random numbers
    private int list[] = new int [NUM];
    final int HEIGHT=500;
	final int WIDTH=500;


    public void init()
    {
        

    	this.setSize(WIDTH, HEIGHT);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
      
    	makeList();

    }
    public void showList (Graphics g)
    {
        int x;
        g.clearRect(0,0,WIDTH,HEIGHT);

        for (int i = 0 ; i < NUM ; i++)
        {
            x=list[i]*HEIGHT/100;
            if (i==showGreen)
            {
                g.setColor(Color.green);
            }  else if (i==showRed)
            {
                g.setColor(Color.red);
            } else
            {
                g.setColor(Color.blue);
            }
            
            
            g.fillRect(i*WIDTH/NUM,HEIGHT-x-1,WIDTH/NUM,x);
            g.setColor(Color.black);
            g.drawRect(i*WIDTH/NUM,HEIGHT-x-1,WIDTH/NUM,x);


        }
    }

    public void start()
    {
    	Thread th = new Thread (this);
        th.start ();

    }
    
    public void makeList ()
    {
        for (int i = 0 ; i < NUM ; i++)
        {
            list [i] = (int) (Math.random() * 100);
        }
    }


    public void paint(Graphics g)
    {
    	 backbuffer = createImage(WIDTH, HEIGHT);
         bg = backbuffer.getGraphics();

    	
    	showList(bg);
    	bg.setColor(Color.PINK);
        bg.drawString("Bubblesort demonstration", 20, 20);
        bg.drawString("Press 0-9 to change speed, space to restart", 20, 40);
        bg.drawString("9 for slowest speed, 1 for medium speed, and 0 for fastest speed", 20, 60);
        g.drawImage(backbuffer,0,0,this);


    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
        int i, j, temp;

		while (true)
        {
            for (j = 0 ; j < NUM - 1 ; j++)
            {
                for (i = 0 ; i < NUM - j- 1 ; i++)
                {
                	if (restart)
                    {
                        i=0;
                        j=0;
                        restart=false;
                    }

                	showGreen=i;
                    if (list [i] > list [i + 1])
                    {
                        // Highlight the value that is going to be swapped
                        showRed=i+1;
                    }
                    else
                    {
                        // Set to -1 so nothing highlights if no swap is taking place
                        showRed=-1;
                    }	

                    repaint();
                    try
                    {
                        Thread.sleep (delay);
                        
                    }
                    catch (InterruptedException e)
                    {
                        // do nothing
                    }
                    // Now actually do the swap
                    if (list [i] > list [i + 1])
                    {
                        temp = list [i];
                        list [i] = list [i + 1];
                        list [i + 1] = temp;
                    }
                }
            }
            repaint();
        }
	}
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
        if (e.getID()==KeyEvent.KEY_PRESSED) {
            int key=e.getKeyCode();
            if (key>48 && key<58)
            {
                delay=100*(key-48);
            } 
            else if (key==48)
            {
                delay=14;
            }
            else if (key==32)
            {
                makeList();
                restart=true;
            }


            return true;

        }
        return false;

		
	}
}
