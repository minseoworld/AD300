public class NSCMediaUtils {
    // Print details of a Book
    public static void printMediaDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("NSC Collection: " + book.isNSCCollection());
    }

    // Print details of a DVD
    public static void printMediaDetails(DVD dvd) {
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("NSC Collection: " + dvd.isNSCCollection());
        System.out.println("Duration: " + dvd.getDuration() + " minutes");
        System.out.println("Genre: " + dvd.getGenre());
    }

    // Print details of a Magazine
    public static void printMediaDetails(Magazine magazine) {
        System.out.println("Title: " + magazine.getTitle());
        System.out.println("NSC Collection: " + magazine.isNSCCollection());
        System.out.println("Issue Number: " + magazine.getIssueNumber());
        System.out.println("Month: " + magazine.getMonth());
    }
}