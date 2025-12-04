public class Book extends LibraryItem implements Searchable, Displayable {
    private String author;
    private int numOfPages;
    public Book(String title, int yearPublished, String author, int numOfPages) {
        super(title, yearPublished);
        this.author = author;
        this.numOfPages = numOfPages;
    }
    public String getAuthor() {
        return author;
    }
    public int getNumOfPages() {
        return numOfPages;
    }
    @Override
    public double calculateLateFee(int daysPastDue) {
        return daysPastDue * 0.5;
    }
    @Override
    public boolean matches(String query) {
        return getTitle().toLowerCase().contains(query.toLowerCase()) ||
                author.toLowerCase().contains(query.toLowerCase());
    }
    @Override
    public void displayFullDetails() {
        System.out.println(toString() +
            ", Author: " + author +
            ", Pages: " + numOfPages);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
