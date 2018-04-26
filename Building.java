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
	
	public Building(double price, int squareFt, int floor, int room, String location, String fileName) {
		this.price = price;
		this.squareFt = squareFt;
		this.floor = floor;
		this.room = room;
		this.location = location;
		this.fileName = fileName;
	}

	/**
	 * returns filename
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * sets fileName to fileName
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * returns floor
	 * @return floor
	 */
	public int getFloor() {
		return floor;
	}

	/**
	 * sets a new floor
	 * @param floor
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}

	/**
	 * returns price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * returns squareFt
	 * @return squareFt
	 */
	public int getSquareFt() {
		return squareFt;
	}

	/**
	 * returns room
	 * @return room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * return location
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * set new price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * set new squareFt
	 * @param squareFt
	 */
	public void setSquareFt(int squareFt) {
		this.squareFt = squareFt;
	}

	/**
	 * set new room
	 * @param room
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * set new location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
