public class LinkedListStructure {
     private class Node { 
        String data; 
        Node next; 
 
        Node(String data) { 
            this.data = data; 
            this.next = null; 
        } 
    } 
 
    private Node head; 
 
    // Insert new location at the end of the list 
    public void insert(String location) { 
        if (location == null || location.trim().isEmpty()) { 
            System.out.println("Invalid location name."); 
            return; 
        } 
 
        // Prevent duplicates 
        if (contains(location)) { 
            System.out.println("Location already exists in the list."); 
            return; 
        } 
 
        Node newNode = new Node(location); 
        if (head == null) { 
            head = newNode; 
        } else { 
            Node current = head; 
            while (current.next != null) current = current.next; 
            current.next = newNode; 
        } 
        System.out.println("Added location to list: " + location); 
    } 

    // Remove a location from the linked list
    public void remove(String location) {
        if (head == null) {
            System.out.println("No locations to remove.");
            return;
        }

        // If head node is to be removed
        if (head.data.equalsIgnoreCase(location)) {
            head = head.next;
            System.out.println("Removed from list: " + location);
            return;
        }

        // Search and remove node
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equalsIgnoreCase(location)) {
                current.next = current.next.next;
                System.out.println("Removed from list: " + location);
                return;
            }
            current = current.next;
        }

        System.out.println("Location not found in list.");
}

    // Check if a location already exists in the list 
    private boolean contains(String location) { 
        Node current = head; 
        while (current != null) { 
            if (current.data.equalsIgnoreCase(location)) 
                return true; 
            current = current.next; 
        } 
        return false; 
    } 
 
    // Display all stored locations 
    public void display() { 
        if (head == null) { 
            System.out.println("No locations added yet."); 
            return; 
        } 
 
        System.out.println("\n--- All Locations ---"); 
        Node current = head; 
        while (current != null) { 
            System.out.print(current.data + " -> "); 
            current = current.next; 
        } 
        System.out.println("null"); 
    } 
} 

