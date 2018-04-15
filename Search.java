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
	private JRadioButton bathButton4;
	private JRadioButton bathButton3;
	private JRadioButton bathButton2;
	private JRadioButton bathButton1;
	
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
		bedButton4.addItemListener(y -> bedStateChanged(y));
		
		bedButton3 = new JRadioButton("3 Beds");
		bedButton3.setFont(new Font("Century", Font.BOLD, 18));
		bedButton3.addItemListener(y -> bedStateChanged(y));
	    
	    bedButton2 = new JRadioButton("2 Beds");
		bedButton2.setFont(new Font("Century", Font.BOLD, 18));
		bedButton2.addItemListener(y -> bedStateChanged(y));
	    
	    bedButton1 = new JRadioButton("1 Bed");
		bedButton1.setFont(new Font("Century", Font.BOLD, 18));
		bedButton1.addItemListener(y -> bedStateChanged(y));
	    
	    //Buttons for number of bathrooms
	    bathButton4 = new JRadioButton("4+ Bathrooms");
		bathButton4.setFont(new Font("Century", Font.BOLD, 18));
		bathButton4.addItemListener(z -> bathStateChanged(z));
	    
	    bathButton3 = new JRadioButton("3 Bathrooms");
		bathButton3.setFont(new Font("Century", Font.BOLD, 18));
		bathButton3.addItemListener(z -> bathStateChanged(z));
	    
	    bathButton2 = new JRadioButton("2 Bathrooms");
		bathButton2.setFont(new Font("Century", Font.BOLD, 18));
		bathButton2.addItemListener(z -> bathStateChanged(z));
	    
	    bathButton1 = new JRadioButton("1 Bathrooms");
		bathButton1.setFont(new Font("Century", Font.BOLD, 18));
		bathButton1.addItemListener(z -> bathStateChanged(z));
	    
	    //Group the radio buttons.
	    ButtonGroup floor = new ButtonGroup();
	    JPanel pFloor = new JPanel();
	    pFloor.setLayout(new GridLayout(4,1));
	    pFloor.add(floorButton4);
	    pFloor.add(floorButton3);
	    pFloor.add(floorButton2);
	    pFloor.add(floorButton1);
	    floor.add(floorButton4);
	    floor.add(floorButton3);
	    floor.add(floorButton2);
	    floor.add(floorButton1);
	
	    ButtonGroup bed = new ButtonGroup();
	    JPanel pBed = new JPanel();
	    pBed.setLayout(new GridLayout(4,1));
	    pBed.add(bedButton4);
	    pBed.add(bedButton3);
	    pBed.add(bedButton2);
	    pBed.add(bedButton1);
	    bed.add(bedButton4);
	    bed.add(bedButton3);
	    bed.add(bedButton2);
	    bed.add(bedButton1);
	    
	    ButtonGroup bath = new ButtonGroup();
	    JPanel pBath = new JPanel();
	    pBath.setLayout(new GridLayout(4,1));
	    pBath.add(bathButton4);
	    pBath.add(bathButton3);
	    pBath.add(bathButton2);
	    pBath.add(bathButton1);
	    bath.add(bathButton4);
	    bath.add(bathButton3);
	    bath.add(bathButton2);
	    bath.add(bathButton1);
	    
	    //Action Listeners
	    
	    
	    //Add groups
	    radioButtonPanel.setLayout(new GridLayout(1,3));
	    radioButtonPanel.add(pFloor, BorderLayout.WEST);
	    radioButtonPanel.add(pBed, BorderLayout.CENTER);
	    radioButtonPanel.add(pBath, BorderLayout.EAST);		
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
	
	public int bathStateChanged(ItemEvent e) 
	{
		int value = 0;
	    if (e.getStateChange() == ItemEvent.SELECTED) 
	    {
	        if(bathButton4.isSelected())
	        {
	        	System.out.println("4");
	        	value = 4;
	        }
	        if(bathButton3.isSelected())
	        {
	        	System.out.println("3");
	        	value = 3;
	        }
	        if(bathButton2.isSelected())
	        {
	        	System.out.println("2");
	        	value = 2;
	        }
	        if(bathButton1.isSelected())
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
