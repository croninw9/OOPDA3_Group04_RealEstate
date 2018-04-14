import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
	private BuildingReader br;
	private double price;
	
	private String type;
	private int room;
	private int squareft;
	private int bathroomNum;
	private int floorsNum;
	private String locationNum;
	
	public Appraise() {
		super("Real Estate Project");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		br = new BuildingReader();
		price = 0;
		
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
		appraise.addActionListener(e -> appraiseHouse());
		list = new JButton("List");
		list.addActionListener(e -> {
			try {
				listHouse();
			} catch (IOException e1) {
			}
		});
		
		bPanel.add(appraise);
		bPanel.add(list);
	}
	
	public void appraiseHouse() {
		ArrayList<Building> buildings = br.getBuildings("buildings");
		type = houseType.getText().trim();
		room = Integer.parseInt(numRoom.getText());
		squareft = Integer.parseInt(squareFt.getText());
		bathroomNum = Integer.parseInt(bathroom.getText());;
		floorsNum = Integer.parseInt(floors.getText());;
		locationNum = location.getText().trim();
		
		price = buildings.stream()
			.filter(house -> type.equalsIgnoreCase(house.getType()))
			.filter(building -> room == building.getRoom())
			.filter(size -> ((squareft + 300) < size.getSquareFt()) && ((squareft - 300) < size.getSquareFt()))
			.filter(bath -> bath.getBathroom() == bathroomNum)
			.filter(fl -> fl.getFloor() == floorsNum)
			.filter(loc -> loc.getLocation().equals(locationNum))
			.collect(Collectors.averagingDouble(Building::getPrice));
		
	}
	
	public void listHouse() throws IOException {
		if(price != 0) {
			br.addBuilding("buildings.csv", new Building(type, price, squareft, floorsNum, room, bathroomNum, locationNum));
		}
	}
}
