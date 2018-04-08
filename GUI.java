import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JFrame
{
	private JPanel imagePanel;
	private JPanel buttonPanel;
	private JLabel image;
	private JButton next;
	private JButton previous;
	private JButton appraise;
	
	private JPanel textPanel;
	private JScrollPane textPane;
	private JTextArea summary;
	
	private static final int IMAGE_WIDTH = 1200;
	private static final int IMAGE_HEIGHT = 800;
	
	
	public GUI() 
	{
		super("Real Estate Project");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buildButtonPanel();
		buildTextPanel();
		setUp();
		add(imagePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.EAST);
		setVisible(true);
	}

	private void buildTextPanel() 
	{
		summary = new JTextArea();
        textPane = new JScrollPane(summary);
        textPanel = new JPanel();
        textPanel.add(textPane);
        setSummary();
        textPanel.setBackground(new Color(47, 79, 79));
	}

	private void setSummary()
	{
		summary.setText("");
		summary.append("Summary of House:"
				+ "\n Floors: 4"
				+ "\n Beds: 4"
				+ "\n Baths : 2.5 ");
		summary.setFont(new Font("Century", Font.BOLD, 16));
        summary.setForeground(new Color(102, 205, 170));
        summary.setBackground(new Color(47, 79, 79));
	}

	private void setUp() 
	{
		setResizable(true);
		setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		JPanel heading = new JPanel();
		JLabel title = new JLabel("House");
		heading.add(title);
        title.setFont(new Font("Century", Font.BOLD, 24));
        title.setForeground(new Color(102, 205, 170));
        heading.setBackground(new Color(47, 79, 79));
        this.getContentPane().add(heading, BorderLayout.NORTH);
		
		imagePanel = new DrawPanel();
		imagePanel.setBackground(Color.GRAY);
		this.getContentPane().add(imagePanel);
	}

	/**
	 * Sets up the button and makes it so that when the button is pressed, the animation starts
	 */
	private void buildButtonPanel() 
	{
		buttonPanel = new JPanel();

		previous = new JButton("Previous House");
		buttonPanel.add(previous);
		
		appraise = new JButton("Appraise House");
		buttonPanel.add(appraise);
		
		next = new JButton("Next House");
		buttonPanel.add(next);
		
		setFont();
		
		next.addActionListener(e -> nextImage());
		previous.addActionListener(e -> previousImage());
		appraise.addActionListener(e -> appriaseHouse());
	}

	private void setFont() 
	{
		previous.setBackground(new Color(47, 79, 79));
        previous.setForeground(new Color(102, 205, 170));
        previous.setFocusPainted(false);
        previous.setFont(new Font("Century", Font.BOLD, 18));
        
        appraise.setBackground(new Color(47, 79, 79));
        appraise.setForeground(new Color(102, 205, 170));
        appraise.setFocusPainted(false);
        appraise.setFont(new Font("Century", Font.BOLD, 18));
        
        next.setBackground(new Color(47, 79, 79));
        next.setForeground(new Color(102, 205, 170));
        next.setFocusPainted(false);
        next.setFont(new Font("Century", Font.BOLD, 18));
        
        buttonPanel.setBackground(new Color(47, 79, 79));
	}

	private Object appriaseHouse() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object previousImage() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object nextImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Inner class creates background image
	 * @author Will
	 *
	 */
	class DrawPanel extends JPanel
	{
		public DrawPanel()
		{
			setLayout(null);
		}
		
		public void paintComponent(Graphics g)
		{
			Image house = new ImageIcon("house.jpeg").getImage();
			image = new JLabel(new ImageIcon(house.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
			image.setBounds(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
			image.setLocation(0, 0);
			add(image);
		}
	}
	
}


