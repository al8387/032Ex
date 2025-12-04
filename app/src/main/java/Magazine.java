public class Magazine extends LibraryItem implements Searchable, Displayable {
    private int issueNumber;
    private String editorName;

    public Magazine(String title, int yearPublished, int issueNumber, String editorName) {
        super(title, yearPublished);
        this.issueNumber = issueNumber;
        this.editorName = editorName;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getEditorName() {
        return editorName;
    }

    @Override
    public double calculateLateFee(int daysPastDue) {
        return daysPastDue * 2.0;
    }

    @Override
    public boolean matches(String query) {
        return getTitle().toLowerCase().contains(query.toLowerCase()) ||
                editorName.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public void displayFullDetails() {
        System.out.println(toString() +
            ", Issue: " + issueNumber +
            ", Editor: " + editorName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
