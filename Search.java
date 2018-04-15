import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author Will
 *
 */
public class Search 
{
	private JPanel buttonPanel2;
	private JPanel radioButtonPanel;
	
	private JRadioButton floorButton4;
	private JRadioButton floorButton3;
	private JRadioButton floorButton2;
	private JRadioButton floorButton1;
	private JRadioButton bedButton4;
	private JRadioButton bedButton3;
	private JRadioButton bedButton2;
	private JRadioButton bedButton1;
	
	private int floorNum = 0;
	
	public Search()
	{
		

		buttonPanel2 = new JPanel();
		
		JButton search = new JButton("Search");
		search.addActionListener(a -> search());

		buttonPanel2.add(search);
		
		radioButtonPanel = new JPanel(new GridLayout(4,7));

		
		//Buttons for number of floors
	    floorButton4 = new JRadioButton("4+ Floors");
		floorButton4.setFont(new Font("Century", Font.BOLD, 18));
		floorButton4.addItemListener(x -> floorStateChanged(x));
		
		floorButton3 = new JRadioButton("3 Floors");
		floorButton3.setFont(new Font("Century", Font.BOLD, 18));
		floorButton3.addItemListener(x -> floorStateChanged(x));
	    
	    floorButton2 = new JRadioButton("2 Floors");
		floorButton2.setFont(new Font("Century", Font.BOLD, 18));
		floorButton2.addItemListener(x -> floorStateChanged(x));
	    
	    floorButton1 = new JRadioButton("1 Floor");
		floorButton1.setFont(new Font("Century", Font.BOLD, 18));
		floorButton1.addItemListener(x -> floorStateChanged(x));
	    
	    //Buttons for number of bedrooms
	    bedButton4 = new JRadioButton("4+ Beds");
		bedButton4.setFont(new Font("Century", Font.BOLD, 18));
		floorButton4.addItemListener(y -> bedStateChanged(y));
		
		bedButton3 = new JRadioButton("3 Beds");
		bedButton3.setFont(new Font("Century", Font.BOLD, 18));
		floorButton4.addItemListener(y -> bedStateChanged(y));
	    
	    bedButton2 = new JRadioButton("2 Beds");
		bedButton2.setFont(new Font("Century", Font.BOLD, 18));
		floorButton4.addItemListener(y -> bedStateChanged(y));
	    
	    bedButton1 = new JRadioButton("1 Bed");
		bedButton1.setFont(new Font("Century", Font.BOLD, 18));
		floorButton4.addItemListener(y -> bedStateChanged(y));
	    
	    //Buttons for number of bathrooms
	    JRadioButton bathButton4 = new JRadioButton("4+ Bathrooms");
		bathButton4.setFont(new Font("Century", Font.BOLD, 18));
	    bathButton4.setSelected(true);
	    
	    JRadioButton bathButton3 = new JRadioButton("3 Bathrooms");
		bathButton3.setFont(new Font("Century", Font.BOLD, 18));
	    bathButton3.setSelected(true);
	    
	    JRadioButton bathButton2 = new JRadioButton("2 Bathrooms");
		bathButton2.setFont(new Font("Century", Font.BOLD, 18));
	    bathButton2.setSelected(true);
	    
	    JRadioButton bathButton1 = new JRadioButton("1 Bathrooms");
		bathButton1.setFont(new Font("Century", Font.BOLD, 18));
	    bathButton1.setSelected(true);
	    
	    //Buttons for number of bathrooms
	    JRadioButton housetypeButton4 = new JRadioButton("4+ Bathrooms");
		bathButton4.setFont(new Font("Century", Font.BOLD, 18));
	    bathButton4.setSelected(true);
	    
	    //Group the radio buttons.
	    ButtonGroup floor = new ButtonGroup();
	    floor.add(floorButton4);
	    floor.add(floorButton3);
	    floor.add(floorButton2);
	    floor.add(floorButton1);
	
	    ButtonGroup bed = new ButtonGroup();
	    bed.add(bedButton4);
	    bed.add(bedButton3);
	    bed.add(bedButton2);
	    bed.add(bedButton1);
	    
	    ButtonGroup bath = new ButtonGroup();
	    bath.add(bathButton4);
	    bath.add(bathButton3);
	    bath.add(bathButton2);
	    bath.add(bathButton1);
	    
	    //Action Listeners
	    
	    
	    //Add groups
	    radioButtonPanel.add(floorButton4, BorderLayout.WEST);
	    radioButtonPanel.add(floorButton3, BorderLayout.WEST);
	    radioButtonPanel.add(floorButton2, BorderLayout.WEST);
	    radioButtonPanel.add(floorButton1, BorderLayout.WEST);
	    
	    radioButtonPanel.add(bedButton4, BorderLayout.CENTER);
	    radioButtonPanel.add(bedButton3, BorderLayout.CENTER);
	    radioButtonPanel.add(bedButton2, BorderLayout.CENTER);
	    radioButtonPanel.add(bedButton1, BorderLayout.CENTER);
	    
	    radioButtonPanel.add(bathButton4, BorderLayout.EAST);
	    radioButtonPanel.add(bathButton3, BorderLayout.EAST);
	    radioButtonPanel.add(bathButton2, BorderLayout.EAST);
	    radioButtonPanel.add(bathButton1, BorderLayout.EAST);		
	}
	
	public JPanel bPanelReturn() {
		return buttonPanel2;
	}
	
	public JPanel radioButtonReturn() {
		return radioButtonPanel;
	}
	
	/**
	 * Checks if 4 floors was selected 
	 * @param e the press of the floor 4 radio button
	 * @return 4
	 */
	public int floorStateChanged(ItemEvent e) 
	{
		int value = 0;
	    if (e.getStateChange() == ItemEvent.SELECTED) 
	    {
	        if(floorButton4.isSelected())
	        {
	        	System.out.println("4");
	        	value = 4;
	        }
	        if(floorButton3.isSelected())
	        {
	        	System.out.println("3");
	        	value = 3;
	        }
	        if(floorButton2.isSelected())
	        {
	        	System.out.println("2");
	        	value = 2;
	        }

	        if(floorButton1.isSelected())
	        {
	        	System.out.println("1");
	        	value = 1;
	        }
	    }
	    return value;
	}

	
	/**
	 * Checks which number of beds was selected 
	 * @param e the press of the radio button
	 * @return the number of beds
	 */
	public int bedStateChanged(ItemEvent e) 
	{
		int value = 0;
	    if (e.getStateChange() == ItemEvent.SELECTED) 
	    {
	        if(bedButton4.isSelected())
	        {
	        	System.out.println("4");
	        	value = 4;
	        }
	        if(bedButton3.isSelected())
	        {
	        	System.out.println("3");
	        	value = 3;
	        }
	        if(bedButton2.isSelected())
	        {
	        	System.out.println("2");
	        	value = 2;
	        }
	        if(bedButton1.isSelected())
	        {
	        	System.out.println("1");
	        	value = 1;
	        }
	    }
	    return value;
	}
	/**
	 * @param a 
	 * 
	 */
    private void search() 
    {
    	//filters out houses that don't meat criteria and adds the imagePanel back
	}

	
}
