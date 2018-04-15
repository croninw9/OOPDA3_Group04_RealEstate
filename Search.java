import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	
	public Search()
	{
		buttonPanel2 = new JPanel();
		
		JButton search = new JButton("Search");
		search.addActionListener(a -> search());

		buttonPanel2.add(search);
		
		radioButtonPanel = new JPanel(new GridLayout());

	    RadioButton floor = new RadioButton("1 floor", "2 floors", "3 floors", "4 floors");
	    RadioButton bath = new RadioButton("1 bathroom", "2 bathroom", "3 bathroom", "4 bathroom");
	    RadioButton bed = new RadioButton("1 bedroom", "2 bedroom", "3 bedroom", "4 bedroom");
	    RadioButton type = new RadioButton("House", "Apartment", "Condo", "TownHouse");
	    RadioButton location = new RadioButton("New York", "Los Angeles", "Denver", "Tampa");
	    RadioButton size = new RadioButton("Between 0-800 sq ft", "Between 801-1400 sq ft", "Between 1401-2000", "Greater than 2000 sq ft");

	    
	    //Add groups
	    radioButtonPanel.setLayout(new GridLayout(2,6));
	    radioButtonPanel.add(floor.getJPanel(), BorderLayout.CENTER);
	    radioButtonPanel.add(bed.getJPanel(), BorderLayout.CENTER);
	    radioButtonPanel.add(bath.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(type.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(location.getJPanel(), BorderLayout.CENTER);		
	    radioButtonPanel.add(size.getJPanel(), BorderLayout.CENTER);	
	  
	}
	
	public JPanel bPanelReturn() {
		return buttonPanel2;
	}
	
	public JPanel radioButtonReturn() {
		return radioButtonPanel;
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
