import java.util.Objects;

/**
 * Represents a song with various attributes.
 * Modified to align with the structure of code B.
 *
 * @author Minseo
 */
public record Song(
        String trackName,
        String artistName,
        String releasedYear,
        String releasedMonth,
        String releasedDay,
        String totalNumberOfStreamsOnSpotify) implements Comparable<Song> {

    public Song {
        Objects.requireNonNull(trackName, "Track name cannot be null");
        Objects.requireNonNull(artistName, "Artist name cannot be null");
        Objects.requireNonNull(releasedYear, "Released year cannot be null");
        Objects.requireNonNull(releasedMonth, "Released month cannot be null");
        Objects.requireNonNull(releasedDay, "Released day cannot be null");
        Objects.requireNonNull(totalNumberOfStreamsOnSpotify, "Total streams cannot be null");

        validateDateComponents(releasedYear, releasedMonth, releasedDay);
    }

    private void validateDateComponents(String year, String month, String day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date components");
        }
    }

    private boolean isValidDate(String year, String month, String day) {
        return true;
    }

    @Override
    public int compareTo(Song song) {
        return this.trackName().compareTo(song.trackName());
    }

    @Override
    public String toString() {
        return String.format("track name = %s, artist = %s, release year = %s, release month = %s, release day = %s, streams = %s",
                trackName, artistName, releasedYear, releasedMonth, releasedDay, totalNumberOfStreamsOnSpotify);
    }
}
