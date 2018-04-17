
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.*;

public class RadioButton 
{
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	private JRadioButton button4;
	private JRadioButton button0;
	private int value = 0;
	
	public RadioButton(String b0, String b1, String b2, String b3, String b4)
	{
		
		button1 = new JRadioButton(b1);
		button1.setFont(new Font("Century", Font.BOLD, 18));
		button1.setBackground(new Color(47, 79, 79));
		button1.setForeground(new Color(102, 205, 170));
		button1.addItemListener(x -> stateChanged(x));
		
		button2 = new JRadioButton(b2);
		button2.setFont(new Font("Century", Font.BOLD, 18));
		button2.setBackground(new Color(47, 79, 79));
		button2.setForeground(new Color(102, 205, 170));
		button2.addItemListener(x -> stateChanged(x));
		
		button3 = new JRadioButton(b3);
		button3.setFont(new Font("Century", Font.BOLD, 18));
		button3.setBackground(new Color(47, 79, 79));
		button3.setForeground(new Color(102, 205, 170));
		button3.addItemListener(x -> stateChanged(x));
		
		button4 = new JRadioButton(b4);
		button4.setFont(new Font("Century", Font.BOLD, 18));
		button4.setBackground(new Color(47, 79, 79));
		button4.setForeground(new Color(102, 205, 170));
		button4.addItemListener(x -> stateChanged(x));
		
		button0 = new JRadioButton(b0);
		button0.setFont(new Font("Century", Font.BOLD, 18));
		button0.setBackground(new Color(47, 79, 79));
		button0.setForeground(new Color(102, 205, 170));
		button0.addItemListener(x -> stateChanged(x));

	}
	
	public JPanel getJPanel() {
		
		ButtonGroup bg = new ButtonGroup();
	    JPanel p = new JPanel();
	    p.setLayout(new GridLayout(5,1));
	    p.add(button4);
	    p.add(button3);
	    p.add(button2);
	    p.add(button1);
	    p.add(button0);
	    bg.add(button4);
	    bg.add(button3);
	    bg.add(button2);
	    bg.add(button1);
	    bg.add(button0);
	    
	    return p;
	}
	
	public void stateChanged(ItemEvent e) 
	{
	    if (e.getStateChange() == ItemEvent.SELECTED) 
	    {
	        if(button4.isSelected())
	        {
	        	//System.out.println("4");
	        	value = 4;
	        }
	        if(button3.isSelected())
	        {
	        	//System.out.println("3");
	        	value = 3;
	        }
	        if(button2.isSelected())
	        {
	        	//System.out.println("2");
	        	value = 2;
	        }

	        if(button1.isSelected())
	        {
	        	//System.out.println("1");
	        	value = 1;
	        }
	    	if(button0.isSelected())
	        {
	        	//System.out.println("0");
	        	value = 0;
	        }
	    }
	}
	
	public int getValue()
	{
		return value;
	}
}