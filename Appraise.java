import java.awt.BorderLayout;

import javax.swing.*;

public class Appraise extends JFrame{
	private JTextField houseType;
	private JTextField numRoom;
	private JTextField squareFt;
	private JTextField bathroom;
	private JTextField floors;
	private JTextField location;
	private JButton appraise;
	private JButton list;
	private JPanel tPanel;
	private JPanel bPanel;
	
	public Appraise() {
		super("Real Estate Project");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUpTextField();
		setUpButtonPanel();
		
		add(tPanel, BorderLayout.CENTER);
		add(bPanel, BorderLayout.SOUTH);
		
		pack();
		this.setVisible(true);
	}
	
	public void setUpTextField() {
		houseType = new JTextField(20);
		numRoom = new JTextField(20);
		squareFt = new JTextField(20);
		bathroom = new JTextField(20);
		floors = new JTextField(20);
		location = new JTextField(20);
		
		tPanel = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel houseP = new JPanel();
		JPanel roomP = new JPanel();
		JPanel squareFtP = new JPanel();
		JPanel bathroomP = new JPanel();
		JPanel floorsP = new JPanel();
		JPanel locationP = new JPanel();
		
		houseP.add(new JLabel("Enter House Type: "));
		roomP.add(new JLabel("Enter number of rooms:"));
		squareFtP.add(new JLabel("Enter square feet:"));
		bathroomP.add(new JLabel("Enter number of bathrooms:"));
		floorsP.add(new JLabel("Enter number of floors:"));
		locationP.add(new JLabel("Enter location (Town, State):"));
		
		houseP.add(houseType);
		roomP.add(numRoom);
		squareFtP.add(squareFt);
		bathroomP.add(bathroom);
		floorsP.add(floors);
		locationP.add(location);
		
		north.add(houseP, BorderLayout.NORTH);
		north.add(roomP, BorderLayout.CENTER);
		north.add(squareFtP, BorderLayout.SOUTH);
		
		center.add(bathroomP, BorderLayout.NORTH);
		center.add(floorsP, BorderLayout.CENTER);
		center.add(locationP, BorderLayout.SOUTH);
		
		
		tPanel.add(north, BorderLayout.NORTH);
		tPanel.add(center, BorderLayout.CENTER);
	}
	
	public void setUpButtonPanel() {
		bPanel = new JPanel();
		appraise = new JButton("Appraise");
		list = new JButton("List");
		
		bPanel.add(appraise);
		bPanel.add(list);
	}
	
	public void appraiseHouse() {
		
	}
	
	public void listHouse() {
		
	}
}
