import java.util.ArrayList;
/**
 * @author Jared Evangelista
 *
 */
public class Residential extends Building
{
	private int bathroom;
	private String type;
	
	public Residential(String type, double price, int squareFt, int floor, int room, int bathroom, String location, String fileName)
	{
		super(price, squareFt, floor, room, location, fileName);
		this.type = type;
		this.bathroom = bathroom;
	}
	
	public String getType() {
		return type;
	}
	
	// gets the bathrooms
	public int getBathroom()
	{
		return bathroom;
	}
	
	// toString method to print info of Residential
	public String toString()
	{
		return (super.toString());
	}
	
	public String getDetails() {
		return 				"\n Type: " + this.getType() + 
							"\n" +
							"\n Number of Floors: " + this.getFloor() +
							"\n" +
							"\n Number of Bathrooms: " + this.getBathroom() +
							"\n" +
							"\n Number of Rooms: " + this.getRoom() +
							"\n" +
							"\n Size of building: " + this.getSquareFt() + 
							"\n" +
							"\n Price of Building: " + this.getPrice() +
							"\n" +
							"\n Location: " + this.getLocation();
	}
	
	
}