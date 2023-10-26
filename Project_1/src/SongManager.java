import java.util.Arrays;

public class SongManager implements SongManagerInterface{
    private Song[][] songsByYear;
    private String[] releaseYears;

    public SongManager(){
        // Read data from files, create arrays, fill arrays with data, and sort each year's songs by track name
        // Implementation needed
    }

    @Override
    public int getYearCount() {
        // Implementation needed
        return releaseYears.length;
    }

    @Override
    public int getSongCount(int yearIndex) {
        // Implementation needed
        return songsByYear[yearIndex].length;
    }

    @Override
    public int getSongCount() {
        int totalCount = 0;
        for (Song[] yearSongs : songsByYear){
            totalCount += yearSongs.length;
        }
        return totalCount;
    }

    @Override
    public String getYearName(int yearIndex) {
        return releaseYears[yearIndex];
    }

    @Override
    public int getSongCount(String year) {
        int yearIndex = Arrays.asList(releaseYears).indexOf(year);
        if (yearIndex >= 0){
            return songsByYear[yearIndex].length;
        }
        return 0;
    }

    @Override
    public Song getSong(int yearIndex, int songIndex) {
        return songsByYear[yearIndex][songIndex];
    }

    @Override
    public Song[] getSongs(int yearIndex) {
        return Arrays.copyOf(songsByYear[yearIndex], songsByYear[yearIndex].length);
    }

    @Override
    public int findSongYear(String trackName) {
        for (int yearIndex = 0; yearIndex < releaseYears.length; yearIndex++) {
            for (int songIndex = 0; songIndex < songsByYear[yearIndex].length; songIndex++) {
                if (songsByYear[yearIndex][songIndex].trackName().equals(trackName)) {
                    return yearIndex;
                }
            }
        }
        return -1; // Song not found
    }
}
