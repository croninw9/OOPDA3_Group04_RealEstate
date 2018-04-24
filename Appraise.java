import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.*;

public class Appraise{
	private JTextField houseType;
	private JTextField numRoom;
	private JTextField squareFt;
	private JTextField bathroom;
	private JTextField floors;
	private JTextField location;
	private JButton appraise;
	private JButton list;
	private JPanel tPanel;
	private JPanel t2Panel;
	private JPanel bPanel;
	private BuildingReader br;
	private double price;
	
	private String type;
	private int room;
	private int squareft;
	private int bathroomNum;
	private int floorsNum;
	private String locationNum;
	
	private OpenImage openImage; 

	private ArrayList<Residential> buildings;
	private ArrayList<Residential> oldBuildings;
	
	public Appraise() 
	{
		br = new BuildingReader();
		buildings = br.getBuildings("buildings.csv");
		openImage = new OpenImage();
		price = 0;
		
		setUpTextField();
		setUpButtonPanel();
	}
	
	public void setUpTextField() {
		houseType = new JTextField(30);
		numRoom = new JTextField(30);
		squareFt = new JTextField(30);
		bathroom = new JTextField(30);
		floors = new JTextField(30);
		location = new JTextField(30);
		
		tPanel = new JPanel(new BorderLayout());
		t2Panel = new JPanel();
		JPanel north = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel houseP = new JPanel();
		JPanel roomP = new JPanel();
		JPanel squareFtP = new JPanel();
		JPanel bathroomP = new JPanel();
		JPanel floorsP = new JPanel();
		JPanel locationP = new JPanel();
	
		JLabel label1 = new JLabel("Enter House Type:               "); 
		label1.setFont(new Font("Century", Font.BOLD, 20)); 
		label1.setForeground(new Color(102, 205, 170)); 
		houseP.add(label1); 
		
		JLabel label2 = new JLabel("Enter amount of rooms:        "); 
		label2.setFont(new Font("Century", Font.BOLD, 20)); 
		label2.setForeground(new Color(102, 205, 170)); 
		roomP.add(label2); 
		
		JLabel label3 = new JLabel("Enter amount of square feet:"); 
		label3.setFont(new Font("Century", Font.BOLD, 20)); 
		label3.setForeground(new Color(102, 205, 170)); 
		squareFtP.add(label3); 
		
		JLabel label4 = new JLabel("Enter number of bathrooms: "); 
		label4.setFont(new Font("Century", Font.BOLD, 20));
		label4.setForeground(new Color(102, 205, 170)); 
		bathroomP.add(label4); 
		
		JLabel label5 = new JLabel("Enter amount of Floors:       "); 
		label5.setFont(new Font("Century", Font.BOLD, 20)); 
		label5.setForeground(new Color(102, 205, 170));
		floorsP.add(label5);
		
		JLabel label6 = new JLabel("Enter location:                    ");
		label6.setFont(new Font("Century", Font.BOLD, 20));
		label6.setForeground(new Color(102, 205, 170));
		locationP.add(label6);
		
		//houseP.add(new JLabel("Enter House Type: "));
		//roomP.add(new JLabel("Enter number of rooms:"));
		//squareFtP.add(new JLabel("Enter square feet:"));
		//bathroomP.add(new JLabel("Enter number of bathrooms:"));
		//floorsP.add(new JLabel("Enter number of floors:"));
		//locationP.add(new JLabel("Enter location (Town, State):"));
		
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

		houseP.setBackground(new Color(47, 79, 79));
		roomP.setBackground(new Color(47, 79, 79));
		squareFtP.setBackground(new Color(47, 79, 79));
		bathroomP.setBackground(new Color(47, 79, 79));
		floorsP.setBackground(new Color(47, 79, 79));
		locationP.setBackground(new Color(47, 79, 79));

		tPanel.add(north, BorderLayout.NORTH);
		tPanel.add(center, BorderLayout.CENTER);
		t2Panel.setBackground(new Color(47, 79, 79));
		t2Panel.add(tPanel);
	}
	
	public void setUpButtonPanel() {
		bPanel = new JPanel();
		appraise = new JButton("Appraise");
		appraise.addActionListener(e -> checkAppraise());
		list = new JButton("List");
		list.addActionListener(e -> {
			try {
				listHouse();
			} catch (IOException e1) {
			}
		});
		
		
		JButton imageSelect = new JButton("Select Image");
		imageSelect.addActionListener(e -> openImage.openImage());
		
		appraise.setBackground(new Color(47, 79, 79));
        appraise.setForeground(new Color(102, 205, 170));
        appraise.setFocusPainted(false);
        appraise.setFont(new Font("Century", Font.BOLD, 18));
        
        list.setBackground(new Color(47, 79, 79));
        list.setForeground(new Color(102, 205, 170));
        list.setFocusPainted(false);
        list.setFont(new Font("Century", Font.BOLD, 18));
        
        imageSelect.setBackground(new Color(47, 79, 79));
        imageSelect.setForeground(new Color(102, 205, 170));
        imageSelect.setFocusPainted(false);
        imageSelect.setFont(new Font("Century", Font.BOLD, 18));
        
        bPanel.setBackground(new Color(47, 79, 79));
		
		bPanel.add(appraise);
		bPanel.add(list);
		bPanel.add(imageSelect);
	}
	
	public void checkAppraise() {
		String error = "";
		if(houseType.getText().equals("")) {
			error += "Please add a Type of House \n";
		}
		if(numRoom.getText().equals("")) {
			error += "Please add Number of Rooms \n";
		}
		if(squareFt.getText().equals("")) {
			error += "Please add Size of Resident \n";
		}
		if(bathroom.getText().equals("")) {
			error += "Please add Size of Resident \n";
		}
		if(floors.getText().equals("")) {
			error += "Please add Size of Resident \n";
		}
		if(location.getText().equals("")) {
			error += "Please add Size of Resident \n";
		}
		
		if(error.equals("")) {
			appraiseHouse();
		}
		else {
			JOptionPane.showMessageDialog(null, error, "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void appraiseHouse() {
		
		type = houseType.getText().trim();
		room = Integer.parseInt(numRoom.getText());
		squareft = Integer.parseInt(squareFt.getText());
		bathroomNum = Integer.parseInt(bathroom.getText());;
		floorsNum = Integer.parseInt(floors.getText());;
		locationNum = location.getText().trim();
		
		DecimalFormat df = new DecimalFormat("#.00"); 
		price = ((avgType() + avgRoom() + avgSize() + avgBath() + avgFloor() + avgLocation())/6);
		JOptionPane.showMessageDialog(null, ("The value of the House is : $" + df.format(price)));
		System.out.println(price);
		System.out.println(type + room + squareft + bathroomNum + floorsNum + locationNum);
		
	}
	
	public void listHouse() throws IOException {
		if(price != 0) {
			br.addBuilding("buildings.csv", new Residential(type, price, squareft, floorsNum, room, bathroomNum, locationNum, openImage.getFileName()));
			JOptionPane.showMessageDialog(null, "Congratulations! You've successfully listed the Residence");
			buildings = br.getBuildings("buildings.csv");
		}
		else {
			JOptionPane.showMessageDialog(null, "Appraise the House before Listing", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private double avgType(ArrayList<Residential> build) {
		return build.stream()
				.filter(house -> type.equalsIgnoreCase(house.getType()))
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	
	private double avgRoom(ArrayList<Residential> build) {
		return build.stream()
				.filter(building -> room == building.getRoom())
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	private double avgSize(ArrayList<Residential> build) {
		return build.stream()
				.filter(size -> ((squareft + 300) < size.getSquareFt()) && ((squareft - 300) < size.getSquareFt()))
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	private double avgBath(ArrayList<Residential> build) {
		return build.stream()
				.filter(bath -> bath.getBathroom() == bathroomNum)
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	private double avgFloor(ArrayList<Residential> build) {
		return build.stream()
				.filter(fl -> fl.getFloor() == floorsNum)
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	private double avgLocation(ArrayList<Residential> build) {
		return build.stream()
				.filter(loc -> loc.getLocation().equals(locationNum))
				.collect(Collectors.averagingDouble(Building::getPrice));
	}
	
	public JPanel bPanelReturn()
	{
		return bPanel;
	}
	
	public JPanel tPanelReturn()
	{
		return t2Panel;
	}
	
	public JPanel imagePanelReturn() 
	{
		return openImage.getPanel();
	}
	
	public ArrayList<Residential> getAppraise()
	{
		return buildings;
	}
}
