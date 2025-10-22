import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in); 
    private LocationManager manager; 
    private LinkedListStructure list; 
 
    // Constructor connects all other modules 
    public Menu(LocationManager manager, LinkedListStructure list) { 
        this.manager = manager; 
        this.list = list; 
    } 
 
    // Start the menu system 
    public void start() { 
        int choice; 
        do { 
            System.out.println("\n--- Smart City Route Planner ---"); 
            System.out.println("1. Add a new location"); 
            System.out.println("2. Remove a location"); 
            System.out.println("3. Add a road between locations"); 
            System.out.println("4. Remove a road"); 
            System.out.println("5. Display all connections"); 
            System.out.println("6. Display all locations"); 
            System.out.println("7. Exit"); 
            System.out.print("Enter your choice: "); 
 
            // Handle invalid input 
            while (!sc.hasNextInt()) { 
                System.out.println("Please enter a valid number."); 
                sc.next(); 
            } 
 
            choice = sc.nextInt(); 
            sc.nextLine(); // clear the input buffer 
 
            switch (choice) { 
                case 1 -> { 
                    System.out.print("Enter location name: "); 
                    String loc = sc.nextLine().trim(); 
                    if (!loc.isEmpty()) { 
                        manager.addLocation(loc); 
                        list.insert(loc); 
                    } else { 
                        System.out.println("Location name cannot be empty."); 
                    } 
                } 
                case 2 -> {
                    System.out.print("Enter location name to remove: ");
                    String loc = sc.nextLine().trim();
                    if (!loc.isEmpty()) {
                        manager.removeLocation(loc);
                        list.remove(loc); 
                    } else {
                        System.out.println("Location name cannot be empty.");
                    }
                }

                case 3 -> { 
                    System.out.print("Enter first location: "); 
                    String from = sc.nextLine().trim(); 
                    System.out.print("Enter second location: "); 
                    String to = sc.nextLine().trim(); 
                    if (!from.isEmpty() && !to.isEmpty()) manager.addRoad(from, to); 
                } 
                case 4 -> { 
                    System.out.print("Enter first location: "); 
                    String from = sc.nextLine().trim(); 
                    System.out.print("Enter second location: "); 
                    String to = sc.nextLine().trim(); 
                    if (!from.isEmpty() && !to.isEmpty()) manager.removeRoad(from, to); 
                } 
                case 5 -> manager.displayConnections(); 
                case 6 -> list.display(); 
                case 7 -> System.out.println("Exiting program... Goodbye!"); 
                default -> System.out.println("Invalid choice, please try again."); 
            } 
 
        } while (choice != 7); 
    } 
}
