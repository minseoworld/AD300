public class Main {
    public static void main(String[] args) {
        // Create an instance of SongManager
        SongManager songManager = new SongManager();

        // Create an instance of SongViewer, passing the SongManager as a parameter
        SongViewer songViewer = new SongViewer(songManager);
    }
}
