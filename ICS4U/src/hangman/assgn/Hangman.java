package hangman.assgn;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Hangman extends Applet implements MouseListener, KeyListener {

	/** Maximum number of incorrect guesses. */
    final int maxTries = 5;

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

    Image hangImages[];
    
    final int hangmanWidth = 160;
    
    final int hangmanHeight = 160;

    /** Image displayed when user wins. */
    Image ding, wrong, idle, death;


    final int WIDTH=500;
    final int HEIGHT=500;

	public void init()
	{
		this.resize(WIDTH, HEIGHT);

        ding = getImage(getCodeBase(), "ding.gif");

        // load in hangman image sequence
        hangImages = new Image[maxTries];
        for (int i=0; i<maxTries; i++)
        {
            hangImages[i] = getImage(getCodeBase(), "ding"+(i+1)+".gif");
        }
	
        	idle = getImage(getCodeBase(), "idle.gif");
			ding = getImage(getCodeBase(), "letter_correct.gif");
			wrong = getImage(getCodeBase(), "letter_incorrect.gif");
			death = getImage(getCodeBase(), "game_over.gif");
			
			// initialize the buffers.
	        lettersWrong = 0;
	        wrongLetters = new char[maxTries];

	        secretWordLen = 0;
	        secretWord = new char[maxWordLen];

	        lettersCorrect = 0;
	        correct = new char[maxWordLen];
			addMouseListener(this);
	        addKeyListener(this);
	        this.setVisible(true);
	        repaint();
	        

	}
			/**
		     * Start the applet.
		     */
		    public void start()
		    {
		        requestFocus();
		        newGame();
		    }

			public void paint(Graphics g){
				// Size of the gallows base
		        int baseHeight = 10;
		        int baseWidth = 30;
		        int i, x, y;

		        // draw gallows pole
		        g.drawLine(baseWidth/2, 0, baseWidth/2, 2*hangmanHeight-baseHeight/2);
		        g.drawLine(baseWidth/2, 0, baseWidth+hangmanWidth/2, 0);

		        // draw gallows rope
		        g.drawLine(baseWidth+hangmanWidth/2, 0, baseWidth+hangmanWidth/2, hangmanHeight/3);

		        // draw gallows base
		        g.fillRect(0, 2*hangmanHeight-baseHeight, baseWidth, baseHeight);
			
		        
		        if (secretWordLen > 0)
		        {
		            // draw underlines for secret word
		            g.setColor (Color.black);
		             x = 0;
		             y = getSize ().height - 1;
		            for ( i = 0 ; i < secretWordLen ; i++)
		            {
		                g.drawLine (x, y, x + underlineWidth, y);
		                x += underlineWidth + 3;
		            }
		        }

				
				if (lettersCorrect == secretWordLen && lettersCorrect!=0)
		        {
		            // Draw winning image
		            g.drawImage (ding, 10, 50, this);
		        }
		        else if (lettersWrong > 0)
		        {
		            // draw hangman on gallows
		        	g.drawImage (wrong, 10, 50, this);
		            // draw list of wrong letters
		            
		             y = 20;
		            g.setColor(Color.red);
		            for ( i = 0; i<lettersWrong; i++)
		            {
		                g.drawChars(wrongLetters, i, 500,  y, i);
		               
		            }
		        }
		        else if (lettersWrong > maxTries)
		        {
		        	g.drawImage(death, 10, 50, this);
		        }
		        else {
		            g.drawImage (idle, 10, 50, null);
		        	
		        }
				repaint();

			}
		    /**
		     * Start a new game. Choose a new secret word & clear all the arrays
		     */
		    public void newGame()
		    {
		        // randomly pick secret word from the word list
		        String s=wordlist[(int)(Math.random()*wordlist.length)].toLowerCase();


		        
		        // Get length of word; chop it if too long.
		        secretWordLen = Math.min(s.length(), maxWordLen);
		        
		        // Store individual letters in character array
		        for (int i=0; i<secretWordLen; i++)
		        {
		            secretWord[i] = s.charAt(i);
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		

        // start new game if user has already won or lost.
        if (secretWordLen == lettersCorrect || lettersWrong == maxTries)
        {
            newGame();
            return;
        }

		boolean found = false;
        key = 0;
		// is letter in secret word? If so, add it to correct[].
        for (int i = 0 ; i < secretWordLen ; i++)
        {
            if (key == secretWord [i])
            {
                correct [i] = (char) key;
                lettersCorrect++;
                found = true;
                System.out.println("meme");
            }
        }
        if (!found)
        {
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
            
            found = false;

            if (lettersWrong < maxTries)
            {
                wrongLetters [lettersWrong] = (char) key;
                lettersWrong++;
            }
        }
        
        if (lettersWrong == maxTries)
        {
            // show the answer
            for (int i = 0 ; i < secretWordLen ; i++)
            {
                correct [i] = secretWord [i];
            }
        }

        repaint ();
        


		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (secretWordLen == lettersCorrect || lettersWrong == maxTries)
        {
            newGame ();
            repaint();
        }

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
        /*"tolerance",
        "mace",
        "rest in peace",
        "code",
        "death",
        "whiteout",*/
        "blizzard"
    };

}

