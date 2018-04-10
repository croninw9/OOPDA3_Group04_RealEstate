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
	
	public Residential(String type, double sq)
	{
		super(type, sq);
	}
	
	public int getRoom()
	{
		return room;
	}
	
	// gets the bathrooms
	public int getBathroom()
	{
		return bathroom;
	}

	public void setRoom(int room) 
	{
		this.room = room;
	}
	
	public String toString()
	{
		return (super.toString());
	}
	
	
}
