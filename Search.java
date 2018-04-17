
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.*;


/**
 * 
 * @author William Cronin and Timothy Duong
 *
 */
public class Search 
{
	private JPanel buttonPanel2;
	private JPanel radioButtonPanel;
	private RadioButton floor;
	private RadioButton bath;
	private RadioButton bed;
	private RadioButton type;
	private RadioButton location;
	private RadioButton size;
	private RadioButton price;

	public Search()
	{
		buttonPanel2 = new JPanel();
		
		JButton search = new JButton("Search");
		search.addActionListener(a -> pressSearch());

		buttonPanel2.add(search);
		
		radioButtonPanel = new JPanel(new GridLayout());
		radioButtonPanel.setBackground(new Color(47, 79, 79));

	    floor = new RadioButton("Dont Care", "1 floor", "2 floors", "3 floors", "4 floors");
	    bath = new RadioButton( "Dont Care", "1 bathroom", "2 bathroom", "3 bathroom", "4 bathroom");
	    bed = new RadioButton("Dont Care", "1 bedroom", "2 bedroom", "3 bedroom", "4 bedroom");
	    type = new RadioButton("Dont Care", "House", "Apartment", "Condo", "TownHouse");
	    location = new RadioButton("Dont Care", "New York", "Los Angeles", "Denver", "Tampa");
	    size = new RadioButton("Dont Care", "Greater than 2000 sq ft", "Between 1401 to 2000", "Between 801 to 1400 sq ft", "Between 0 to 800 sq ft");
	    price = new RadioButton("Dont Care", ">$1,000,000", "Between $500,000 to $999,999", "Between $250,000 to $499,999", "<$249,999");
	    
	    //Add groups
	    radioButtonPanel.setLayout(new GridLayout(1,6));
	    radioButtonPanel.add(floor.getJPanel(), BorderLayout.CENTER);
	    radioButtonPanel.add(bed.getJPanel(), BorderLayout.CENTER);
	    radioButtonPanel.add(bath.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(type.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(location.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(size.getJPanel(), BorderLayout.CENTER);	
	    radioButtonPanel.add(price.getJPanel(), BorderLayout.CENTER);
	  
	}
	
	public JPanel bPanelReturn() 
	{
		return buttonPanel2;
	}
	
	public JPanel radioButtonReturn() 
	{
		return radioButtonPanel;
	}
	

	/**
	 * @param a 
	 * 
	 */
    public void pressSearch() 
    {
    	Agency a1 = new Agency();
    	a1.filter(type.getValue(), 0, size.getValue(), bath.getValue(), floor.getValue(), location.getValue(), price.getValue());
    	//public ArrayList<Residential> filter(int type, int room, int sqFt, int bathNum, int floorNum, int locNum, int price)
	}

	
}