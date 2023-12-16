public class Song implements Comparable<Song> {

    private String title;
    private String artist;
    private String album;
    private String genre;
    private String releaseYear;
    private String duration;

    public Song(String title, String artist, String album, String genre, String releaseYear, String duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getDuration() {
        return duration;
    }

    // Implement Comparable interface based on title
    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }

    // Other getters and methods...

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
