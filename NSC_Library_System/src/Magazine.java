public class Magazine {
    private String title;
    private int issueNumber;
    private String month;
    private boolean NSCCollection;

    // Constructor
    public Magazine(String title, int issueNumber, String month, boolean NSCCollection) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.month = month;
        this.NSCCollection = NSCCollection;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for NSCCollection
    public boolean isNSCCollection() {
        return NSCCollection;
    }

    // Getter for issueNumber
    public int getIssueNumber() {
        return issueNumber;
    }

    // Getter for month
    public String getMonth() {
        return month;
    }
}