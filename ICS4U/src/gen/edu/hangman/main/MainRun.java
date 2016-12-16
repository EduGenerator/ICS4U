package gen.edu.hangman.main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JOptionPane;


public class MainRun extends Applet implements MouseListener, KeyListener {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9126745081691322544L;
	final int HEIGHT=500;
	final int WIDTH=500;
	
	/*
	 * Hello! It's Jordan! Unfortunately, I have no clue how to make the images display on Mac. My code for
	 * displaying images has now been checked by both Ewan and Dylan, and even myself. It should work.
	 * It does not. I have officially given up on this, because I need to focus on my culminating with Dylan.
	 * Sorry for letting you down,
	 * -Jordan
	 */
	
	/** Maximum number of incorrect guesses. */
    final int maxTries = 5;

    /** Sequence of images for hangman on the gallows. */
    Image hangImages[];
    final int hangmanWidth = 160;
    final int hangmanHeight = 160;

    /** Image displayed when user wins. */
    Image winImage;
    Image ded;

    /** Current number of incorrect guesses. */
    int lettersWrong = 0;

    /** Number of correct letters in 'correct'. */
    int lettersCorrect = 0;

    /** Maximum allowed length of a secret word. */
    final int maxWordLen = 20;
	
    /** Length of the secret word. */
    int secretWordLen;
	
    /** Array containing the letters in the secret word. */
    char secretWord[];
	
    /** Array containing the incorrectly guessed letters. */
    char wrongLetters[];
	
    /** Array containing the correctly guessed letters. */
    char correct[];

    /** Width of the underlines for the secret word */
    final int underlineWidth = 10;

     JOptionPane Dialog;
	private String word;
     
	public void init()
	{ 
		validate();
		// load in winning image
        winImage = getImage(getCodeBase(), "res"+File.separator+"win.gif");
        ded = getImage(getCodeBase(), "res"+File.separator+"death.gif");
        // load in hangman image sequence
        hangImages = new Image[maxTries];
        for (int i=0; i<maxTries; i++)
        {
            hangImages[i] = getImage(getCodeBase(), "res"+File.separator+(i+1)+".gif");
            System.out.println("res/h"+(i+1)+".gif");
        }

        // initialize the buffers.
        lettersWrong = 0;
        wrongLetters = new char[maxTries];

        secretWordLen = 0;
        secretWord = new char[maxWordLen];

        lettersCorrect = 0;
        correct = new char[maxWordLen];

		addMouseListener(this);
        addKeyListener(this);

        this.setSize(WIDTH, HEIGHT);
        
      

		
	}
	
	public void paint(Graphics g)
	{

        // Size of the gallows base
        int baseHeight = 10;
        int baseWidth = 30;
        int i, x, y;
        
        g.drawString(""+lettersWrong, 200, 20);

        // draw gallows pole
        g.drawLine(baseWidth/2, 0, baseWidth/2, 2*hangmanHeight-baseHeight/2);
        g.drawLine(baseWidth/2, 0, baseWidth+hangmanWidth/2, 0);

        // draw gallows rope
        g.drawLine(baseWidth+hangmanWidth/2, 0, baseWidth+hangmanWidth/2, hangmanHeight/3);

        // draw gallows base
        g.fillRect(0, 2*hangmanHeight-baseHeight, baseWidth, baseHeight);
        
        // draw list of wrong letters
        x = hangmanWidth + baseWidth;
        y = 10;
        g.setColor(Color.red);
        for (i=0; i<lettersWrong; i++)
        {
            g.drawChars(wrongLetters, i, 1, x, y);
            x += underlineWidth + 3;
        }

        
        if (secretWordLen > 0)
        {
            // draw underlines for secret word
            g.setColor (Color.black);
            x = 0;
            y = getSize ().height - 1;
            for (i = 0 ; i < secretWordLen ; i++)
            {
                g.drawLine (x, y, x + underlineWidth, y);
                x += underlineWidth + 3;
            }
        }
     // draw known letters in secret word
        x = 1;
        y = getSize().height - 3;
        g.setColor(Color.blue);
        for (i=0; i<secretWordLen; i++)
        {
            if (correct[i] != 0)
            {
                g.drawChars(correct, i, 1, x, y);
            }
            x += underlineWidth + 3;
        }
        if (lettersCorrect == secretWordLen && lettersCorrect!=0)
        {
            // Draw winning image
            g.drawImage (winImage, 10, 50, this);
            
        }
        if (lettersWrong > 5){
        	g.drawImage(ded, 10, 50, this);
        }

        else if (lettersWrong > 0)
        {
            // draw hangman on gallows
            g.drawImage (hangImages[lettersWrong-1], baseWidth, hangmanHeight/3, this);
            System.out.println("I am trying to drawing");
        } else {
            System.out.print("help");

        }

    } // paint method

	   /**
     * Start the applet.
     */
    public void start()
    {
        requestFocus();
        newGame();
    }

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	
		char key = e.getKeyChar();
		// start new game if user has already won or lost.
        if (secretWordLen == lettersCorrect) 
        {
        	JOptionPane.showMessageDialog(null, "you have won, cool cool");
            newGame();
            return;
        }
        else if (lettersWrong == maxTries){
        	JOptionPane.showMessageDialog(null, "You have lost. The word was "+word);
        	newGame();
        	return;
        }
        // check if valid letter; return if not
        if (!Character.isLetter(key))
        {
            return;
        }

        // Convert characters from uppercase to lowercase
        key = Character.toLowerCase(key);

        // check if already guessed and correct
        for (int i=0; i<secretWordLen; i++)
        {
            if (key == correct[i])
            {
                return;
            }
        }
        // check if already guessed and wrong
        for (int i=0; i<maxTries; i++)
        {
            if (key == wrongLetters[i])
            {
                return;
            }
        }        

        
        boolean found = false;
        // is letter in secret word? If so, add it to correct[].
        for (int i = 0 ; i < secretWordLen ; i++)
        {
            if (key == secretWord [i])
            {
                correct [i] = (char) key;
                lettersCorrect++;
                found = true;
            }
        }
       
        if (!found)
        {
            if (lettersWrong < maxTries)
            {
                wrongLetters [lettersWrong] = (char) key;
                lettersWrong++;
                if (lettersWrong == maxTries)
                {
                    // show the answer
                    for (int i = 0 ; i < secretWordLen ; i++)
                    {
                        correct [i] = secretWord [i];
                    }
                }
            }
        }

        repaint();
	}
	/**
     * Start a new game. Choose a new secret word & clear all the arrays
     */
    public void newGame()
    {
    	// randomly pick secret word from the word list
         word = wordlist[(int)(Math.random()*wordlist.length)].toLowerCase();

        
        // Get length of word; chop it if too long.
        secretWordLen = Math.min(word.length(), maxWordLen);
        
        // Store individual letters in character array
        for (int i=0; i<secretWordLen; i++)
        {
            secretWord[i] = word.charAt(i);
        }

        // clear correct letters array
        for (int i=0; i<maxWordLen; i++)
        {
            correct[i] = 0;
        }
        lettersCorrect = 0;
        
        // clear wrong letters array
        for (int i=0; i<maxTries; i++)
        {
            wrongLetters[i] = 0;
        }
        lettersWrong = 0;

        repaint();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
        if (secretWordLen == lettersCorrect || lettersWrong == maxTries)
        {
            newGame ();
        }

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
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
	
	/* This is the word list. */
    String wordlist[] =
    {
        "razor",
        "scooter",
        "code",
        "peripheral",
        "bitmap",
        "annoyance",
        "with",
        "image"
    };

	
}
	 
