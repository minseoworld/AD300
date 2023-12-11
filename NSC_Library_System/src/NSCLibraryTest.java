import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NSCLibraryTest {

    @Test
    public void testBookContainer() {
        NSCLibraryMediaContainer<Book> bookContainer = new NSCLibraryMediaContainer<>();
        Book book1 = new Book("Book 1", "Author 1", "ISBN 1", true);
        bookContainer.add(book1);

        assertEquals("Book 1", book1.getTitle());
    }

    @Test
    public void testDVDContainer() {
        NSCLibraryMediaContainer<DVD> dvdContainer = new NSCLibraryMediaContainer<>();
        DVD dvd1 = new DVD("DVD 1", 100, "Action", false);
        dvdContainer.add(dvd1);

        assertEquals("DVD 1", dvd1.getTitle());
        assertEquals(100, dvd1.getDuration());
    }

    @Test
    public void testMagazineContainer() {
        NSCLibraryMediaContainer<Magazine> magazineContainer = new NSCLibraryMediaContainer<>();
        Magazine magazine1 = new Magazine("Magazine 1", 1, "May", true);
        magazineContainer.add(magazine1);

        assertEquals("Magazine 1", magazine1.getTitle());
        assertEquals(1, magazine1.getIssueNumber());
    }
}