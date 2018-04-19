import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuildingReader {
	// How many fields are expected.
    private static final int NUMBER_OF_FIELDS = 8;
    // Index values for the fields in each record.
    private static final int TYPE = 0,
                             PRICE = 1,
                             SIZE = 2,
                             FLOOR = 3,
                             ROOMNUMBER = 4,
    						 BATHROOMNUMBER = 5,
    						 LOCATION = 6,
    						 IMAGEFILE = 7;
    						
 public BuildingReader()
    {
    }
	
/**
  * Takes a long string of all features and puts them into an array
  * @param feature
  * @return features
  */
 public ArrayList<String> getFeatures(String feature){
	 ArrayList<String> features = new ArrayList<String>();
	 String[] parts = feature.split(" ");
	 for(String s : parts){
		 features.add(s);
	 }
	 return features;
	 
 }
 
 /**
  * puts an array of strings into a long string
  * @param features
  * @return
  */
 public String buildFeatures(ArrayList<String>features){
	 String allBuild = null;
	 for(String s : features){
		 allBuild += s + " ";
	 }
	 	return allBuild;
 }
    
    /**
     * Read sightings in CSV format from the given file.
     * Return an ArrayList of Sighting objects created from
     * the information in the file.
     * 
     * @param filename The file to be read - should be in CSV format.
     * @return A list of Sightings.
     */
    public ArrayList<Residential> getBuildings(String filename)
    {
        // Create a Sighting from a CSV input line.
        Function<String, Residential> createBuilding = 
            record -> {
                           String[] parts = record.split(",");
                           if(parts.length == NUMBER_OF_FIELDS) {
                               try {
                                   String type = parts[TYPE].trim();
                                   double price = Double.parseDouble(parts[PRICE].trim());
                                   int size = Integer.parseInt(parts[SIZE].trim());
                                   int floor = Integer.parseInt(parts[FLOOR].trim());
                                   int room = Integer.parseInt(parts[ROOMNUMBER].trim());
                                   int bathroom = Integer.parseInt(parts[BATHROOMNUMBER].trim());
                                   String location = parts[LOCATION].trim();
                                   String imageFile = parts[IMAGEFILE].trim();
                                   return new Residential(type, price, size, floor, room, bathroom, location, imageFile);
                               }
                               catch(NumberFormatException e) {
                                   System.out.println("Building record has a malformed integer: " + record);
                                   return null;
                               }
                           }
                           else {
                               System.out.println("Building record has the wrong number of fields: " + record);
                               return null;
                           }
                       };
        ArrayList<Residential> buildings;
        try {
            buildings = Files.lines(Paths.get(filename))
                             .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                             .map(createBuilding)
                             .filter(building -> building != null)
                             .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
            buildings = new ArrayList<>();
        }
        return buildings;
    }
    
    public void addBuilding(String fileName, Residential building) throws IOException {
    	FileWriter pw = new FileWriter(fileName, true);
        StringBuilder sb = new StringBuilder();
        
        sb.append(building.getType());
        sb.append(',');
        sb.append(building.getPrice());
        sb.append(',');
        sb.append(building.getSquareFt());
        sb.append(',');
        sb.append(building.getFloor());
        sb.append(',');
        sb.append(building.getRoom());
        sb.append(',');
        sb.append(building.getBathroom());
        sb.append(',');
        sb.append(building.getLocation());
        sb.append(',');
        sb.append(building.getFileName());

        pw.write(sb.toString() + "\n");
        pw.close();
        System.out.println("done!");

    						    }
}
