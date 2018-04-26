import java.util.ArrayList;

/**
 * @author Chris Estrada
 * this residential class is a sub class of building 
 * that has more specific features and methods 
 */
public class Residential extends Building {
	private int bathroom;
	private String type;
	private ArrayList<String> features;
	
	public Residential(String type, double price, int squareFt, int floor, int room, int bathroom, String location,
			String fileName) {
		super(price, squareFt, floor, room, location, fileName);
		this.type = type;
		this.bathroom = bathroom;
	}
	
	/**
	 * returns the array list features 
	 * @return features 
	 */
	public ArrayList<String> getFeatures(){
		return features;
	}
	
	/**
	 * gets the features details in string 
	 * @return details
	 */
	public String getFeaturesDetails(){
		String details = "Features Include ";
		for(String s : features){
			details += "\n" + s;
		}
		return details;
	}

	/**
	 * sets a new bathroom
	 * @param bathroom
	 */
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	/**
	 * sets a new type 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * returns the type
	 * @return type 
	 */
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

	/**
	 * prints a summary of all of the residential buildings features
	 */
	public void getDetails() {
		System.out.println(this.getType() + "\n Number of Floors: " + this.getFloor() + "\n Number of Bathrooms: "
				+ this.getBathroom() + "\n Number of Rooms: " + this.getRoom() + "\n Size of building: "
				+ this.getSquareFt() + "\n Price of Building: " + this.getPrice() + "\n Location: " + this.getLocation()
				+ "\n" + getFeaturesDetails());
	}

}
