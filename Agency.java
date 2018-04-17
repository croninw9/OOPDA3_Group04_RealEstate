import java.util.ArrayList;
import java.util.stream.DoubleStream;

/**
 * @author estradac3
 *
 */
public class Agency {
	private ArrayList<Building> buildings;
	private ArrayList<Building> filteredB;

	public Agency() {
		buildings = new ArrayList<>();
	}
	
	/**
	 * filters for the filter menu option  
	 * @param type
	 * @param room
	 * @param maxSq
	 * @param minSq
	 * @param bathNum
	 * @param floorNum
	 * @param locationString
	 */
	public void filter(String type, int room, int maxSq, int minSq, int priceMax, int priceMin, int bathNum, int floorNum, String locationString){
		buildings.stream()
			.filter(house -> type.equalsIgnoreCase(house.getType()))
			.filter(building -> room == building.getRoom())
			.filter(size -> size.getSquareFt() > minSq && size.getSquareFt() <= maxSq)
			.filter(price -> price.getPrice() > priceMin && price.getPrice() <= priceMax)
			.filter(bath -> bath.getBathroom() == bathNum)
			.filter(floor -> floor.getFloor() == floorNum)
			.filter(location -> location.getLocation() == locationString)
			.forEach(building -> filteredB.add(building));
	}
	
	/**
	 * filters and returns the array list of buildings/building that 
	 * fit the parameters of the search
	 * @param type
	 * @param room
	 * @param maxSq
	 * @param minSq
	 * @param bathNum
	 * @param floorNum
	 * @param locationString
	 * @return
	 */
	public ArrayList<Building> getFilteredHouses(String type, int room, int maxSq, int minSq,int priceMax, int priceMin, int bathNum, int floorNum, String locationString){
		filter(type, room, maxSq, minSq, priceMax, priceMin, bathNum, floorNum, locationString);
		return filteredB;
	}
	
	public void addBuilding(Building b){
		buildings.add(b);
	}
	
	public String getBuildings(String address){
		String x = null;
		 for(Building b : buildings){
			 if(b.getLocation() == address){
				 x = b.getDetails();
			 }
		 }
		 return x;
	}
	
	public String getType(String type) {
		return buildings.stream()
				.filter(building -> building.getType() == type)
				.map(building -> building.getType())
				.toString();
	}
	
	public double getPrice(double max, double min){
		return buildings.stream()
				.filter(building -> building.getPrice() > min && building.getPrice() <= max)
				.map(building -> building.getPrice())
				//.mapToDouble(building -> building.getPrice());
				.reduce((double) 0, (runningSum, count) -> runningSum + count);
	}
	
	public int getSquareFt(String location) {
		return buildings.stream()
				.filter(building -> building.getLocation() == location)
				.map(building -> building.getSquareFt())
				.reduce(0, (runningSum, count) -> runningSum + count);
	}
	
	public void getFloors(int floors) {
		buildings.stream()
				.filter(building -> building.getFloor() == floors)
				.forEach(building -> filteredB.add(building));
	}
	
	public int getRooms(String location) {
		return buildings.stream()
				.filter(building -> building.getLocation() == location)
				.map(building -> building.getRoom())
				.reduce(0, (runningSum, count) -> runningSum + count);
	}
	
	public int getBathroom(String location) {
		return buildings.stream()
				.filter(building -> building.getLocation() == location)
				.map(building -> building.getBathroom())
				.reduce(0, (runningSum, count) -> runningSum + count);
	}

}
