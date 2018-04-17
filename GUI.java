import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.util.ArrayList;

/**
 * 
 * @author Will
 *
 */
public class GUI extends JFrame
{
	private JPanel imagePanel;
	private JPanel buttonPanel;
	private JLabel image;
	private JButton next;
	private JButton previous;
	
	public Search search;
	public Appraise appraisal;
	
	private JPanel textPanel;
	private JScrollPane textPane;
	private JTextArea summary;
	private BuildingReader br;
	private ArrayList<Residential> res;
	private int count = 0;
	
	private static final int IMAGE_WIDTH = 1700;
	private static final int IMAGE_HEIGHT = 1000;
	
	private JMenuBar menubar;
	
	public GUI() 
	{
		super("Real Estate Project");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		search = new Search();
		appraisal = new Appraise();
		res = new ArrayList<>();
		br = new BuildingReader();
		res = br.getBuildings("buildings.csv");
		buildButtonPanel();
		//generateHome(getResident());
		buildTextPanel(getResident());
		buildMenuBar();
		imagePanel = new JPanel();
		generateHome(getResident());
		add(imagePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.EAST);
		setVisible(true);
	}
	
	private Residential getResident()
	{
		return res.get(count);
		//return residential object 
	}

	private void generateHome(Residential resident) 
	{
		ImageIcon imageIcon = new ImageIcon(resident.getFileName());
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel("", new ImageIcon(newimg), JLabel.CENTER);
        imagePanel.removeAll();
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.revalidate();
        imagePanel.repaint();
	}

	/**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void buildMenuBar()
    {
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        Font f = new Font("Century", Font.BOLD, 24);
        UIManager.put("Menu.font", f);
        
        JMenu spacer = new JMenu();

        //disable the spacer so that it doesn't behave
        //like a menu item
        spacer.setEnabled(false);

      	//Java components are weird. Set all three to
      	//guarantee that size is used
      	spacer.setMinimumSize(new Dimension(900, 1));
      	spacer.setPreferredSize(new Dimension(900, 1));
      	spacer.setMaximumSize(new Dimension(900, 1));

      	//add the spacer to your JMenuBar
      	menubar.add(spacer);
        
      	 //Creates the List Menu - brings back to main menu
        JMenu homeMenu = new JMenu("Home");
        homeMenu.addMenuListener(new Home());
        menubar.add(homeMenu);
      	
        menubar.add(new JMenu("			"));
        
        //create the Search menu - filters out different houses
        JMenu searchMenu = new JMenu("Search");
        searchMenu.addMenuListener(new SearchBar());
        menubar.add(searchMenu);
        
        menubar.add(new JMenu("			"));
        
        //Creates the Appraise menu - Appraises house
        JMenu appraiseMenu = new JMenu("Appraise");
        appraiseMenu.addMenuListener(new Appraisal());
        menubar.add(appraiseMenu);
    }
    
    /**
     * Builds the Text Panel
     */
	private void buildTextPanel(Residential resident) 
	{
		summary = new JTextArea();
        textPane = new JScrollPane(summary);
        textPanel = new JPanel();
        textPanel.add(textPane);
        setSummary(resident);
        textPanel.setBackground(new Color(47, 79, 79));
	}

	private void setSummary(Residential resident)
	{
		//FIX
		summary.setText("");
		summary.setSize(100, 800);
		summary.append("Summary of House:"
				+ resident.getDetails());
		summary.setFont(new Font("Century", Font.BOLD, 16));
        summary.setForeground(new Color(102, 205, 170));
        summary.setBackground(new Color(47, 79, 79));
	}

	/*private void setUp(Residential resident) 
	{
		setResizable(true);
		setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		imagePanel = new DrawPanel(resident);
		imagePanel.setBackground(Color.GRAY);
		this.getContentPane().add(imagePanel);
	}*/

	/**
	 * Sets up the button and makes it so that when the button is pressed, the animation starts
	 */
	private void buildButtonPanel() 
	{
		buttonPanel = new JPanel();

		previous = new JButton("Previous House");
		buttonPanel.add(previous);
		
		next = new JButton("Next House");
		buttonPanel.add(next);
		
		setFont();
		
		next.addActionListener(e -> nextImage());
		previous.addActionListener(e -> previousImage());
	}

	private void setFont() 
	{
		previous.setBackground(new Color(47, 79, 79));
        previous.setForeground(new Color(102, 205, 170));
        previous.setFocusPainted(false);
        previous.setFont(new Font("Century", Font.BOLD, 18));
        
        next.setBackground(new Color(47, 79, 79));
        next.setForeground(new Color(102, 205, 170));
        next.setFocusPainted(false);
        next.setFont(new Font("Century", Font.BOLD, 18));
        
        buttonPanel.setBackground(new Color(47, 79, 79));
	}

	private void previousImage() 
	{
		if(count > 0) {
			count--;
		}
		setSummary(getResident());
		generateHome(getResident());
	}

	private void nextImage() 
	{
		if(count < res.size()-1) {
			count++;
		}
		setSummary(getResident());
		generateHome(getResident());
	}
	
	/**
	 * Inner class creates background image
	 * @author Will
	 *
	 */
	class DrawPanel extends JPanel
	{
		private Residential resident;
		public DrawPanel(Residential resident)
		{
			setLayout(null);
			this.resident = resident;
		}
		
		public void paintComponent(Graphics g)
		{
			ImageIcon imageIcon = new ImageIcon(resident.getFileName());
	        Image image = imageIcon.getImage();
	        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        JLabel imageLabel = new JLabel("", new ImageIcon(newimg), JLabel.CENTER);
	        imagePanel.add(imageLabel, BorderLayout.CENTER);
			
			/*Image house = new ImageIcon("house.jpeg").getImage();
			image = new JLabel(new ImageIcon(house.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
			image.setBounds(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
			image.setLocation(0, 0);
			add(image);*/
		}
	}
	
	public class SearchBar implements MenuListener
	{
		@Override
	    public void menuSelected(MenuEvent e) 
		{
			//remove all the previous panels
			remove(imagePanel);
			remove(buttonPanel);
			remove(textPanel);
			remove(appraisal.bPanelReturn());
			remove(appraisal.tPanelReturn());
			remove(appraisal.imagePanelReturn());
			setVisible(false);
			 
			add(search.radioButtonReturn(), BorderLayout.CENTER);
			add(search.bPanelReturn(), BorderLayout.SOUTH);
			setVisible(true);
	    }
		
		@Override
	    public void menuDeselected(MenuEvent e) 
	    {
	    	//System.out.println("menuDeselected");
	    }

	    @Override
	    public void menuCanceled(MenuEvent e) 
	    {
	        //System.out.println("menuCanceled");
	    }
	}

	public class Home implements MenuListener
    {
		//Search search = new Search();
		@Override
		public void menuSelected(MenuEvent e) 
		{
			remove(search.radioButtonReturn());
			remove(search.bPanelReturn());
			remove(appraisal.bPanelReturn());
			remove(appraisal.tPanelReturn());
			remove(appraisal.imagePanelReturn());
			setVisible(false);
	    	
	    	add(imagePanel, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);
			add(textPanel, BorderLayout.EAST);
			setVisible(true);			
		}
    	
		@Override
		public void menuCanceled(MenuEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuDeselected(MenuEvent e) 
		{
			// TODO Auto-generated method stub
			
		}    	
    }
	
	public class Appraisal implements MenuListener
    {
		//Search search = new Search();
		@Override
		public void menuSelected(MenuEvent e) 
		{
			remove(search.radioButtonReturn());
			remove(search.bPanelReturn());
	    	remove(imagePanel);
			remove(buttonPanel);
			remove(textPanel);
			setVisible(false);

			add(appraisal.bPanelReturn(), BorderLayout.SOUTH);
			add(appraisal.tPanelReturn(), BorderLayout.CENTER);
			add(appraisal.imagePanelReturn(), BorderLayout.EAST);
			setVisible(true);			
		}

		@Override
		public void menuCanceled(MenuEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuDeselected(MenuEvent e) 
		{
			// TODO Auto-generated method stub
			
		}    	
    }
}
