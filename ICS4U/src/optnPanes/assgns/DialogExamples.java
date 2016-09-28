package optnPanes.assgns;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DialogExamples extends JDialog implements Accessible
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7993349387747062915L;

	public static void main (String[] args)
    {
        // Simple Input dialog:
        String inputValue = JOptionPane.showInputDialog ("Please enter something:");
        // Simple Message dialog:
        JOptionPane.showMessageDialog (null, "Your said: " + inputValue);

        // Confirm dialog with Yes and No buttons:
        int choice = JOptionPane.showConfirmDialog (null, "Choose one", "choose one", JOptionPane.YES_NO_OPTION);
        // Message dialog with title and icon: (ERROR icon and WARNING icon)
        if (choice == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog (null, "You selected YES", "alert", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog (null, "You selected NO", "alert", JOptionPane.WARNING_MESSAGE);

        // Confirm dialog with Yes, No and Cancel buttons and INFORMATION icon:
        choice = JOptionPane.showConfirmDialog (null, "Please choose one", "information", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        // Message dialogs with different icons: INFORMATION, QUESTION and PLAIN (no icon)
        if (choice == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog (null, "You selected YES", "Response", JOptionPane.INFORMATION_MESSAGE);
        else if (choice == JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog (null, "You selected NO", "Response", JOptionPane.QUESTION_MESSAGE);
        else
            JOptionPane.showMessageDialog (null, "You selected Cancel", "Response", JOptionPane.PLAIN_MESSAGE);

        // Option dialog with user-defined buttons: (default value is the first in the list -- index 0)
        Object[] options = {"One", "Two"};
        choice = JOptionPane.showOptionDialog (null, "How many?", "Important", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options [0]);
        if (choice == 0)
            JOptionPane.showMessageDialog (null, "You selected One");
        else
            JOptionPane.showMessageDialog (null, "You selected Two");

        // Input dialog with a pulldown menu: (default value is the third in the list -- index 2)
        Object[] possibleValues = {"First", "Second", "Third"};
        Object selectedValue = JOptionPane.showInputDialog (null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues [2]);
        if (selectedValue == possibleValues [0])
            JOptionPane.showMessageDialog (null, "You selected First");
        else if (selectedValue == possibleValues [1])
            JOptionPane.showMessageDialog (null, "You selected Second");
        else
            JOptionPane.showMessageDialog (null, "You selected Third");

        // Option dialog with radio buttons and a regular button (needed to continue from the dialog)
        JRadioButton radio1 = new JRadioButton ("Choice 1");
        JRadioButton radio2 = new JRadioButton ("Choice 2", true);
        ButtonGroup group = new ButtonGroup ();
        group.add (radio1);
        group.add (radio2);
        Object[] newOptions = {radio1, radio2, "Done"};
        JOptionPane.showOptionDialog (null, "Choose one", "Input", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, newOptions, newOptions [2]);
        if (radio1.isSelected ())
            JOptionPane.showMessageDialog (null, "You selected Choice 1");
        if (radio2.isSelected ())
            JOptionPane.showMessageDialog (null, "You selected Choice 2");

        // Option dialog with checkboxes and a regular button (needed to continue from the dialog)
        JCheckBox chkbox1 = new JCheckBox ("Ketchup");
        JCheckBox chkbox2 = new JCheckBox ("Mustard");
        JCheckBox chkbox3 = new JCheckBox ("Relish");
        Object[] moreOptions = {chkbox1, chkbox2, chkbox3, "Done"};
        JOptionPane.showOptionDialog (null, "Choose one", "Input", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, moreOptions, moreOptions [3]);
        String toppings = "";
        if (chkbox1.isSelected ())
            toppings = toppings+" Ketchup";
        if (chkbox2.isSelected ())
            toppings = toppings+" Mustard";
        if (chkbox3.isSelected ())
            toppings = toppings+" Relish";
        JOptionPane.showMessageDialog (null, "Toppings chosen: "+toppings);

    } // main method
} // Dialogs class


