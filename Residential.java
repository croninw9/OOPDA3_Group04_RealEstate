import java.util.ArrayList;
/**
 * @author Jared Evangelista
 *
 */
public class Residential extends Building
{
	int room;
	int bathroom;
	ArrayList<String>Features;
	
	public Residential(boolean upForSale, String type, double sq, double price, String loacation)
	{
		super();
	}
	
	//gets room and returns room
	public int getRoom()
	{
		return room;
	}
	
	// gets the bathrooms
	public int getBathroom()
	{
		return bathroom;
	}
	
	// sets room
	public void setRoom(int room) 
	{
		this.room = room;
	}
	
	// toString method to print info of Residential
	public String toString()
	{
		return (super.toString());
	}
	
	
}
