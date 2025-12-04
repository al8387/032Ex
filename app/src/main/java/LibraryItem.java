import java.util.UUID;
public abstract class LibraryItem {
    private final UUID itemId;
    private String title;
    private int yearPublished;
    private boolean isBorrowed = false;
    public LibraryItem(String title, int yearPublished) {
        this.itemId = UUID.randomUUID();
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
        }
    }

    public void returnItem() {
        isBorrowed = false;
    }

    public abstract double calculateLateFee(int daysPastDue);

    @Override
    public String toString() {
        return "ID: " + itemId + ", Title: " + title + ", Year: " + yearPublished + ", Borrowed: " + isBorrowed;
    }
}
