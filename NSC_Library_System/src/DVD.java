public class DVD {
    private String title;
    private int duration;
    private String genre;
    private boolean NSCCollection;

    // Constructor
    public DVD(String title, int duration, String genre, boolean NSCCollection) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
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

    // Getter for duration
    public int getDuration() {
        return duration;
    }

    // Getter for genre
    public String getGenre() {
        return genre;
    }
}