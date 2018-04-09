import java.util.ArrayList;

/**
 * @author estradac3
 * Creates a generic building with common features and other characteristics
 */
public class Building {

	boolean upForSale;
	boolean appraised;
	boolean sold;
	String type;
	double sq;
	ArrayList<String> features;
	double price;
	String location;
	
	public Building(boolean upForSale, String type, double sq, double price, String loacation) {
		super();
		this.upForSale = upForSale;
		this.type = type;
		this.sq = sq;
	    features = new ArrayList();
		this.price = price;
		appraised = false;
		sold = false;
		this.location = location;
	}

	/**
	 * @return upForSale
	 * gives a boolean if said building is up for sale or not
	 */
	public boolean isUpForSale() {
		return upForSale;
	}

	/**
	 * @return type
	 * gives a String return the specific type of building it is
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return sq
	 * gives the square foot-age of the property 
	 */
	public double getSq() {
		return sq;
	}

	/**
	 * @return features
	 * gives the details of the building 
	 */
	public ArrayList<String> getFeatures() {
		return features;
	}

	/**
	 * @return price
	 * gives a price for the building 
	 */
	public boolean getAppraised() {
		return appraised;
	}
	
	/**
	 * @return price
	 * gives a price for the building 
	 */
	public boolean getSold() {
		return sold;
	}
	
	/**
	 * @return price
	 * gives a price for the building 
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return location
	 * gives a price for the building 
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * @param a
	 * sets the appraised field
	 */
	public void setAppraised(boolean a){
		appraised = a;
	}
	
	/**
	 * @param a
	 * sets the sold field
	 */
	public void setSold(boolean a){
		sold = a;
	}
	
	/**
	 * @param f
	 * adds a string being a feature of the building 
	 */
	public void addFeature(String f){
		features.add(f);
	}

}
