import java.util.ArrayList;

/**
 * @author estradac3
 * Creates a generic building with common features and other characteristics
 */
public class Building {

	private String type;
	private double price;
	private int squareFt;
	private int floor;
	private int room;
	private int bathroom;
	private String location;
	
	public Building(String type, double price, int squareFt, int floor, int room, int bathroom, String location) {
		this.type = type;
		this.price = price;
		this.squareFt = squareFt;
		this.floor = floor;
		this.room = room;
		this.bathroom = bathroom;
		this.location = location;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public int getSquareFt() {
		return squareFt;
	}

	public int getRoom() {
		return room;
	}

	public int getBathroom() {
		return bathroom;
	}

	public String getLocation() {
		return location;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSquareFt(int squareFt) {
		this.squareFt = squareFt;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDetails(){
		return "Type: " + type + "\n" + "Price: " +price + "\n" + 
				"Square Feet: " + squareFt + "\n" + "Floors: " + floor +  "\n" + 
				"Room: " + room + "\n" + "Bathrooms: " + bathroom +
				"\n" + "Location: " + location;
	}
	
	
}

