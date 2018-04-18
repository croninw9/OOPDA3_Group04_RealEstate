
/**
 * @author Jared Evangelista
 *
 */
public class Commerial extends Building{

	String company;
	
	public Commerial(String type, int price, int squareFt, int floor, int room, int bathroom, String location, String fileName, String company)
	{
		super(price, squareFt, floor, room, location, fileName);
		this.company = company;
	}
	
	public String getCompany()
	{
		return company;
	}
}
