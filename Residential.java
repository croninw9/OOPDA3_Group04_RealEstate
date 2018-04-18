import java.util.ArrayList;

/**
 * @author Jared Evangelista
 *
 */
public class Residential extends Building {
	private int bathroom;
	private String type;
	private boolean pool;
	private boolean fireplace;
	private boolean garage;
	private boolean security;
	private boolean backyard;

	public Residential(String type, double price, int squareFt, int floor, int room, int bathroom, String location,
			String fileName, boolean pool, boolean fireplace, boolean garage, boolean security, boolean backyard) {
		super(price, squareFt, floor, room, location, fileName);
		this.type = type;
		this.bathroom = bathroom;
		this.pool = pool;
		this.fireplace = fireplace;
		this.garage = garage;
		this.security = security;
		this.backyard = backyard;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isFireplace() {
		return fireplace;
	}

	public void setFireplace(boolean fireplace) {
		this.fireplace = fireplace;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isSecurity() {
		return security;
	}

	public void setSecurity(boolean security) {
		this.security = security;
	}

	public boolean isBackyard() {
		return backyard;
	}

	public void setBackyard(boolean backyard) {
		this.backyard = backyard;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	// gets the bathrooms
	public int getBathroom() {
		return bathroom;
	}

	// toString method to print info of Residential
	public String toString() {
		return (super.toString());
	}

	public void getDetails() {
		System.out.println(this.getType() + "\n Number of Floors: " + this.getFloor() + "\n Number of Bathrooms: "
				+ this.getBathroom() + "\n Number of Rooms: " + this.getRoom() + "\n Size of building: "
				+ this.getSquareFt() + "\n Price of Building: " + this.getPrice() + "\n Location: " + this.getLocation()
				+ "\n Pool: " + isPool() + "\n Fireplace:  " + isFireplace() + "\n Garage: " + isGarage()
				+ "\n Security: " + isSecurity() + "\n Backyard: " + isBackyard());
	}

}
