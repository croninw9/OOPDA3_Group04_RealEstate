
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.*;

public class RadioButton {
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	private JRadioButton button4;
	
	public RadioButton(String b1, String b2, String b3, String b4){
		
		button1 = new JRadioButton(b1);
		button1.setFont(new Font("Century", Font.BOLD, 18));
		button1.addItemListener(x -> stateChanged(x));
		
		button2 = new JRadioButton(b2);
		button2.setFont(new Font("Century", Font.BOLD, 18));
		button2.addItemListener(x -> stateChanged(x));
		
		button3 = new JRadioButton(b3);
		button3.setFont(new Font("Century", Font.BOLD, 18));
		button3.addItemListener(x -> stateChanged(x));
		
		button4 = new JRadioButton(b4);
		button4.setFont(new Font("Century", Font.BOLD, 18));
		button4.addItemListener(x -> stateChanged(x));

	}
	
	public JPanel getJPanel() {
		
		ButtonGroup bg = new ButtonGroup();
	    JPanel p = new JPanel();
	    p.setLayout(new GridLayout(4,1));
	    p.add(button4);
	    p.add(button3);
	    p.add(button2);
	    p.add(button1);
	    bg.add(button4);
	    bg.add(button3);
	    bg.add(button2);
	    bg.add(button1);
	    
	    return p;
	}
	
	public int stateChanged(ItemEvent e) 
	{
		int value = 0;
	    if (e.getStateChange() == ItemEvent.SELECTED) 
	    {
	        if(button4.isSelected())
	        {
	        	System.out.println("4");
	        	value = 4;
	        }
	        if(button3.isSelected())
	        {
	        	System.out.println("3");
	        	value = 3;
	        }
	        if(button2.isSelected())
	        {
	        	System.out.println("2");
	        	value = 2;
	        }

	        if(button1.isSelected())
	        {
	        	System.out.println("1");
	        	value = 1;
	        }
	    }
	    return value;
	}
}
