import java.util.ArrayList;
/**
 * @author Jared Evangelista
 *
 */
public class Residential extends Building
{
	private int room;
	private int bathroom;
	private String type;
	ArrayList<String>Features;
	
	public Residential(double price, int squareFt, int floor, int room, String location, String fileName)
	{
		super(price, squareFt, floor, room, location, fileName);
	}
	
	public String getType() {
		return type;
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
