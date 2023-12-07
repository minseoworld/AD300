import java.util.Objects;
/**
 * @author Minseo
 * Represents a song with various attributes.
 */
public record Song(
        String trackName,
        String artistName,
        String releasedYear,
        String releasedMonth,
        String releasedDay,
        String totalNumberOfStreamsOnSpotify) implements Comparable<Song>{
    public Song{
        Objects.requireNonNull(trackName, "Track name cannot be null");
        Objects.requireNonNull(artistName, "Artist name cannot be null");
        Objects.requireNonNull(releasedYear, "Released year cannot be null");
        Objects.requireNonNull(releasedMonth, "Released month cannot be null");
        Objects.requireNonNull(releasedDay, "Released day cannot be null");
        Objects.requireNonNull(totalNumberOfStreamsOnSpotify, "Total streams cannot be null");

        validateDateComponents(releasedYear, releasedMonth, releasedDay);
    }

    private void validateDateComponents(String year, String month, String day){
        if (!isValidDate(year, month, day)){
            throw new IllegalArgumentException("Invalid date components");
        }
    }

    private boolean isValidDate(String year, String month, String day){
        return true;
    }

    /**
     * Compares two songs based on track name.
     * @param song the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Song song){
        return this.trackName().compareTo(song.trackName());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(trackName, song.trackName) &&
                Objects.equals(artistName, song.artistName) &&
                Objects.equals(releasedYear, song.releasedYear) &&
                Objects.equals(releasedMonth, song.releasedMonth) &&
                Objects.equals(releasedDay, song.releasedDay) &&
                Objects.equals(totalNumberOfStreamsOnSpotify, song.totalNumberOfStreamsOnSpotify);
    }

    @Override
    public int hashCode(){
        return Objects.hash(trackName, artistName, releasedYear, releasedMonth, releasedDay, totalNumberOfStreamsOnSpotify);
    }
}



