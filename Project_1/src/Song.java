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
    public Song {
        if (trackName == null ||
            artistName == null ||
            releasedYear == null ||
            releasedMonth == null ||
            releasedDay == null ||
            totalNumberOfStreamsOnSpotify == null){
            throw new NullPointerException("Parameter values cannot be null.");
    }
        if (!isValidDate(releasedYear, releasedMonth,releasedDay)){
            throw new IllegalArgumentException("Invalid date.");
        }
    }

    /**
     * Compares two songs based on track name.
     * @param song the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Song song) {
        return this.trackName().compareTo(song.trackName());
    }

    private boolean isValidDate(String year, String month, String day){
        return true;
    }
}



