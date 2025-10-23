import java.util.*; 
 
public class Graph { 
    private Map<String, List<String>> adjList = new HashMap<>(); 
 
    // Add a location  
    public void addLocation(String location) { 
        if (!adjList.containsKey(location)) { 
            adjList.put(location, new ArrayList<>()); 
            System.out.println("Location added: " + location); 
        } else { 
            System.out.println("Location already exists."); 
        } 
    } 
 
    // Remove a location and all connecting roads 
    public void removeLocation(String location) { 
        if (adjList.containsKey(location)) { 
            adjList.remove(location); 
            for (List<String> connections : adjList.values()) { 
                connections.remove(location); 
            } 
            System.out.println("Location removed: " + location); 
        } else { 
            System.out.println("Location not found."); 
        } 
    } 
 
    // Add a road between two locations 
    public void addRoad(String from, String to) { 
        if (adjList.containsKey(from) && adjList.containsKey(to)) { 
            if (!adjList.get(from).contains(to)) { 
                adjList.get(from).add(to); 
                adjList.get(to).add(from); 
                System.out.println("Road added between " + from + " and " + to); 
            } else { 
                System.out.println("Road already exists between these locations."); 
            } 
        } else { 
            System.out.println("One or both locations do not exist."); 
        } 
    } 
 
    // Remove an existing road 
    public void removeRoad(String from, String to) { 
        if (adjList.containsKey(from) && adjList.get(from).contains(to)) { 
            adjList.get(from).remove(to); 
            adjList.get(to).remove(from); 
            System.out.println("Road removed between " + from + " and " + to); 
        } else { 
            System.out.println("Road not found between the given locations."); 
        } 
    } 
 
    // Display all locations and their connections 
    public void displayConnections() { 
        System.out.println("\n--- City Connections ---"); 
        for (String location : adjList.keySet()) { 
            System.out.println(location + " -> " + adjList.get(location)); 
        } 
    } 
}
