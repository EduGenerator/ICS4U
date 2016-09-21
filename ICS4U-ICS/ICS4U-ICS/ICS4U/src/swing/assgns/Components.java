package swing.assgns;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 

public class Components extends JFrame implements ActionListener, ItemListener, ListSelectionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8729389495038122575L;
	//decl. obj.
	JLabel label;
	JButton button1, button2;
	JTextField text;
	JRadioButton radio1, radio2;
	JCheckBox chkbox1, chkbox31;
	JList list;
	JComboBox combo;
	JPanel outer = new JPanel (new BorderLayout());
	JPanel content = new JPanel();
	
	
	
	public Components ()
	{
		super ("Components");
		//Set up the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);
		//create objs.
		JPanel content = new JPanel();
		label = new JLabel ("This is a label.exe", JLabel.CENTER);
		button1 = new JButton ("button1");
		button2 = new JButton ("button2");
		text = new JTextField (10);
		radio1 = new JRadioButton ("Radio Button1");
		radio2 = new JRadioButton ("Radio Button2");
		chkbox1 = new JCheckBox ("CheckBox1");
		chkbox31 = new JCheckBox ("CheckBox2");
		String[] listItems = {"Canada", "USA", "Homeland"};
		list = new JList (listItems);
		String[] comboItems = {"Bird", "cat", "dog", "rabbit", "komodo dragon"};
		combo = new JComboBox (comboItems);
		combo.setEditable(true);
		
		
		ButtonGroup group = new ButtonGroup ();
		group.add(radio1);
		group.add(radio2);
		
		//add contents
		outer.add(label, BorderLayout.NORTH);
		outer.add(content, BorderLayout.CENTER);
		
		content.add(button1);
		content.add(button2);
		content.add(text);
		content.add(radio1);
		content.add(radio2);
		content.add(chkbox1);
		content.add(chkbox31);
		content.add(list);
		content.add(combo);
		button1.addActionListener(this);
		button2.addActionListener(this);
		text.addActionListener(this);
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		chkbox1.addItemListener(this);
		chkbox31.addItemListener(this);
		list.addListSelectionListener(this);
		combo.addActionListener(this);
		
		
		this.setContentPane (outer);
		//show the contents
		this.setVisible(true);
	}
	
	public void  actionPerformed1 (ActionEvent e)
	{
		
		if (e.getSource () == button1)
		{
			label.setText("Button 1 was pressed");
		}
		else if (e.getSource () == button2)
		{
			label.setText("Button2 was pressed");
		}
		else if (e.getSource() == text)
		{
			label.setText("You typed: " +text.getText());
		}
		else if (e.getSource() == radio1)
		{
			label.setText("Radio Button 1 was pressed");
		}
		else if (e.getSource() == radio2)
		{
			label.setText("Radio button 2 was pressed");
		}
		else if (e.getSource() == combo)
		{
			label.setText("Combo Item #" + combo.getSelectedIndex() + ":" + combo.getSelectedItem());
		}
		
	}
	public void itemStateChanged (ItemEvent e)
	{
		Object source = e.getSource();
		
		if (source == chkbox1)
		{
			if (e.getStateChange () == ItemEvent.SELECTED)
			{
				label.setText("Checkbox1 was checked");
			}
			else
			{
				label.setText("Checkbox1 was unkekd");
			}
		}
		else if (source == chkbox31)
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				label.setText("Checkbox2 was checked");
			}
			else
			{
				label.setText("Checkbox2 was kekkled");
			}
		}
	}
	
	public void valueChanged (ListSelectionEvent e)
	{
		if (e.getSource() == list)
		{
			label.setText("List Item #" + list.getSelectedIndex() + ":" + list.getSelectedValue());
		}
	}
	public static void main (String[] args)
	{
		new Components ();
		//main method
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource () == button1)
		{
			label.setText("Button 1 was pressed");
		}
		else if (e.getSource () == button2)
		{
			label.setText("Button2 was pressed");
		}
		else if (e.getSource() == text)
		{
			label.setText("You typed: " +text.getText());
		}
		else if (e.getSource() == radio1)
		{
			label.setText("Radio Button 1 was pressed");
		}
		else if (e.getSource() == radio2)
		{
			label.setText("Radio button 2 was pressed");
		}
		else if (e.getSource() == combo)
		{
			label.setText("Combo Item #" + combo.getSelectedIndex() + ":" + combo.getSelectedItem());
		}
		
	}

	
}//components class
