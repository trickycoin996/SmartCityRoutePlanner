public class LocationManager {
    private Graph graph; 
 
    // Constructor: receive the Graph instance 
    public LocationManager(Graph graph) { 
        this.graph = graph; 
    } 
 
    // Add a new location 
    public void addLocation(String name) { 
        if (name == null || name.trim().isEmpty()) { 
            System.out.println("Invalid location name."); 
            return; 
        } 
        graph.addLocation(name); 
    } 
 
    // Remove a location 
    public void removeLocation(String name) { 
        if (name == null || name.trim().isEmpty()) { 
            System.out.println("Invalid location name."); 
            return; 
        } 
        graph.removeLocation(name); 
    } 
 
    // Add a road between two existing locations 
    public void addRoad(String from, String to) { 
        if (from.equals(to)) { 
            System.out.println("A road cannot connect a location to itself."); 
            return; 
        } 
        graph.addRoad(from, to); 
    } 
 
    // Remove a road between two locations 
    public void removeRoad(String from, String to) { 
        graph.removeRoad(from, to); 
    } 
 
    // Display all current connections 
    public void displayConnections() { 
        graph.displayConnections(); 
    } 
}
