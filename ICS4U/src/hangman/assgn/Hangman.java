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

	Image ding, wrong, idle, death;
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



	public void init()
	{
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

	}
			public void paint(Graphics g){
		        if (secretWordLen > 0)
		        {
		            // draw underlines for secret word
		            g.setColor (Color.black);
		            int x = 0;
		            int y = getSize ().height - 1;
		            for (int i = 0 ; i < secretWordLen ; i++)
		            {
		                g.drawLine (x, y, x + underlineWidth, y);
		                x += underlineWidth + 3;
		            }
		        }

				if (lettersWrong > 0)
		        {
		            // draw hangman on gallows
		            g.drawImage (idle, lettersCorrect, lettersCorrect, null);
		        }

			}
		    /**
		     * Start a new game. Choose a new secret word & clear all the arrays
		     */
		    public void newGame()
		    {
		        // secret word
		        String s = "mystery";
		        
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
        
        // check if valid letter; return if not
        if (!Character.isLetter(key))
        {
            return;
        }

        // Convert characters from uppercase to lowercase
        key = Character.toLowerCase(key);
        
        lettersWrong++;
        repaint();

		
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
	public static void main(String args[])
	{
		new Hangman();
	}
}
