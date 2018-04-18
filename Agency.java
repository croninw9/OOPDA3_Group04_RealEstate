import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * @author estradac3
 *
 */
public class Agency {
	private ArrayList<Residential> buildings;
	private BuildingReader br;

	public Agency() {
		br = new BuildingReader();
		buildings = br.getBuildings("buildings.csv");
	}
	
	public ArrayList<Residential> filter(int type, int room, int sqFt, int bathNum, int floorNum, int locNum, int price)
	{
		if(type != 0) {
			if(type == 1) {
				filterType("House");
			}
			else if(type == 2) {
				filterType("Apartment");
			}
			else if(type == 3){
				filterType("Condo");
			}
			else if(type == 4) {
				filterType("TownHouse");
			}
		}
		
		if(room != 0) {
			filterRoom(room);
		}
		if(sqFt != 0) {
			filterSize(sqFt);
		}
		if(bathNum != 0) {
			filterBathroom(bathNum);
		}
		if(floorNum != 0) {
			filterFloor(floorNum);
		}
		
		if(locNum != 0) {
			if(locNum == 1) {
				filterLocation("New York");
			}
			else if(locNum ==2) {
				filterLocation("Los Angeles");
			}
			else if(locNum == 3) {
				filterLocation("Denver");
			}
			else if(locNum == 4) {
				filterLocation("Tampa");
			}
			
			if(price != 0) 
			{
				if(price == 1) {
					filterPrice(249999);
				}
				else if(price ==2) {
					filterPrice(500000);
				}
				else if(price == 3) {
					filterPrice(999999);
				}
				else if(price == 4) {
					filterPrice(1000000);
				}
			}
		}
		return buildings;
	}
	
	public void filterType(String type){
		buildings = buildings.stream()
						.filter(res -> res.getType().equalsIgnoreCase(type))
						.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void filterRoom(int room){
		buildings = buildings.stream()
						.filter(res -> res.getRoom() == room)
						.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void filterSize(int sqFt) {
		buildings = buildings.stream()
				.filter(res -> (sqFt - 100) <= res.getSquareFt() && res.getSquareFt() <= (sqFt + 100))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void filterBathroom(int bath) {
		buildings = buildings.stream()
				.filter(res -> res.getBathroom() == bath)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void filterFloor(int floor) {
		buildings = buildings.stream()
				.filter(res -> res.getFloor() == floor)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void filterLocation(String Location) {
		buildings = buildings.stream()
				.filter(res -> res.getLocation().equalsIgnoreCase(Location))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void filterPrice(int price) {
		buildings = buildings.stream()
				.filter(res -> res.getPrice() == price)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
}