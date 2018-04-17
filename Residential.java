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
	
	
}
