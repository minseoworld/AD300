import java.util.ArrayList;

public class NSCLibraryMediaContainer<T> {
    private ArrayList<T> mediaList = new ArrayList<>();

    // Add media to the container
    public void add(T media) {
        mediaList.add(media);
    }

    // Remove media from the container
    public void remove(T media) {
        mediaList.remove(media);
    }

    // Display details of each media in the container
    public void display() {
        for (T media : mediaList) {
            if (media instanceof Book) {
                NSCMediaUtils.printMediaDetails((Book) media);
            } else if (media instanceof DVD) {
                NSCMediaUtils.printMediaDetails((DVD) media);
            } else if (media instanceof Magazine) {
                NSCMediaUtils.printMediaDetails((Magazine) media);
            }
        }
    }
}