import java.util.*;

public class LibraryManager {
    public static void main(String[] args) {
        Map<UUID, LibraryItem> inventory = new HashMap<>();
        Book b1 = new Book("Harry potter", 1997, "Rowling", 350);
        Book b2 = new Book("The state of Israel", 2000, "Author a", 200);
        Book b3 = new Book("how to code in java", 2009, "Robert", 450);
        Magazine m1 = new Magazine("Tech and computes", 2023, 12, "John");
        Magazine m2 = new Magazine("Science", 2024, 7, "Daniel");

        inventory.put(b1.getItemId(), b1);
        inventory.put(b2.getItemId(), b2);
        inventory.put(b3.getItemId(), b3);
        inventory.put(m1.getItemId(), m1);
        inventory.put(m2.getItemId(), m2);

        UUID savedId = b1.getItemId();
        LibraryItem found = inventory.get(savedId);
        System.out.println(found);

        UUID fakeId = UUID.randomUUID();
        LibraryItem notFound = inventory.get(fakeId);
        if (notFound == null) {
            System.out.println("Item not found for UUID: " + fakeId);
        }
        b1.borrow();
        m1.borrow();
        for (LibraryItem item : inventory.values()) {
            if (item.isBorrowed()) {
                double fee = item.calculateLateFee(10);
                System.out.println("Late fee for " + item.getTitle() + ": " + fee);
            }
        }
        String search = "Harry potter";
        for (LibraryItem item : inventory.values()) {
            if (item instanceof Searchable) {
                Searchable s = (Searchable) item;
                if (s.matches(search)) {
                    System.out.println("Match found: " + item);
                }
            }
        }
    }
}
