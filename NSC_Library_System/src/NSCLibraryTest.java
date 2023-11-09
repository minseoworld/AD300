import java.util.ArrayList;

class Book{
    private String title;
    private String author;
    private String ISBN;
    private boolean NSCCollection;

    public Book(String title, String author, String ISBN, boolean NSCCollection){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.NSCCollection = NSCCollection;
    }

    public String getTitle(){
        return title;
    }

    public boolean isNSCCollection(){
        return NSCCollection;
    }
}

class DVD{
    private String title;
    private int duration;
    private String genre;
    private boolean NSCCollection;

    public DVD(String title, int duration, String genre, boolean NSCCollection){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.NSCCollection = NSCCollection;
    }

    public String getTitle(){
        return title;
    }

    public boolean isNSCCollection(){
        return NSCCollection;
    }
}

class Magazine{
    private String title;
    private int issueNumber;
    private String month;
    private boolean NSCCollection;

    public Magazine(String title, int issueNumber, String month, boolean NSCCollection){
        this.title = title;
        this.issueNumber = issueNumber;
        this.month = month;
        this.NSCCollection = NSCCollection;
    }

    public String getTitle(){
        return title;
    }

    public boolean isNSCCollection(){
        return NSCCollection;
    }
}

class NSCLibraryMediaContainer<T>{
    private ArrayList<T> mediaList = new ArrayList<>();

    public void add(T media){
        mediaList.add(media);
    }

    public void remove(T media){
        mediaList.remove(media);
    }

    public void display(){
        for(T media : mediaList){
            if(media instanceof Book){
                NSCMediaUtils.printMediaDetails((Book) media);
            }else if(media instanceof DVD){
                NSCMediaUtils.printMediaDetails((DVD) media);
            }else if(media instanceof Magazine){
                NSCMediaUtils.printMediaDetails((Magazine) media);
            }
        }
    }
}

class NSCMediaUtils{
    public static void printMediaDetails(Book book){
        System.out.println("Title: " + book.getTitle());
        System.out.println("NSC Collection: " + book.isNSCCollection());
    }
    public static void printMediaDetails(DVD dvd){
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("NSC Collection: " + dvd.isNSCCollection());
    }
    public static void printMediaDetails(Magazine magazine){
        System.out.println("Title: " + magazine.getTitle());
        System.out.println("NSC Collection: " + magazine.isNSCCollection());
    }
}

public class NSCLibraryTest{
    public static void main(String[] args){
        NSCLibraryMediaContainer<Book> bookContainer = new NSCLibraryMediaContainer<>();
        Book book1 = new Book("Book 1", "Author 1", "ISBN 1", true);
        bookContainer.add(book1);

        NSCLibraryMediaContainer<DVD> dvdContainer = new NSCLibraryMediaContainer<>();
        DVD dvd1 = new DVD("DVD 1", 100, "Action", false);
        dvdContainer.add(dvd1);

        NSCLibraryMediaContainer<Magazine> magazineContainer = new NSCLibraryMediaContainer<>();
        Magazine magazine1 = new Magazine("Magazine 1", 1, "May", true);
        magazineContainer.add(magazine1);

        System.out.println("Books: ");
        bookContainer.display();

        System.out.println("DVDs: ");
        dvdContainer.display();

        System.out.println("Magazines: ");
        magazineContainer.display();
    }
}