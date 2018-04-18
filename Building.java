import java.util.ArrayList;

/**
 * @author estradac3
 * Creates a generic building with common features and other characteristics
 */
public abstract class Building {

	private double price;
	private int squareFt;
	private int floor;
	private int room;
	private String location;
	private String fileName;
	private  boolean rented;
	
	public Building(double price, int squareFt, int floor, int room, String location, String fileName) {
		this.price = price;
		this.squareFt = squareFt;
		this.floor = floor;
		this.room = room;
		this.location = location;
		this.fileName = fileName;
		rented = false;
	}
	
	public boolean isRented() {
		return rented;
	}
	
	public void setRented() {
		rented = true;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
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

	public String getLocation() {
		return location;
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

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
