public class Main {
    public static void main(String[] args) { 
        // Initialize all modules 
        Graph graph = new Graph(); 
        LocationManager manager = new LocationManager(graph); 
        LinkedListStructure list = new LinkedListStructure(); 
 
        // Launch the menu system 
        Menu menu = new Menu(manager, list); 
        menu.start(); 
    }
}
