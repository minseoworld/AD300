import java.util.Arrays;

public class SongManager implements SongManagerInterface{
    private Song[][] songsByYear;
    private String[] releaseYears;

    public SongManager(){
        releaseYears = getDistinctYears();
        songsByYear = new Song[releaseYears.length][];

        for(int i = 0; i < releaseYears.length; i++){
            songsByYear[i] = getSongsForYear(releaseYears[i]);
            Arrays.sort(songsByYear[i]);
        }
    }

    private String[] getDistinctYears(){
        return new String[0];
    }

    private Song[] getSongsForYear(String year){
        return new Song[0];
    }

    @Override
    public int getYearCount(){
        return releaseYears.length;
    }

    @Override
    public int getSongCount(int yearIndex){
        return songsByYear[yearIndex].length;
    }

    @Override
    public int getSongCount(){
        int totalCount = 0;
        for (Song[] yearSongs : songsByYear){
            totalCount += yearSongs.length;
        }
        return totalCount;
    }

    @Override
    public String getYearName(int yearIndex){
        return releaseYears[yearIndex];
    }

    @Override
    public int getSongCount(String year){
        int yearIndex = Arrays.asList(releaseYears).indexOf(year);
        if (yearIndex >= 0){
            return songsByYear[yearIndex].length;
        }
        return 0;
    }

    @Override
    public Song getSong(int yearIndex, int songIndex){
        return songsByYear[yearIndex][songIndex];
    }

    @Override
    public Song[] getSongs(int yearIndex){
        return Arrays.copyOf(songsByYear[yearIndex], songsByYear[yearIndex].length);
    }

    @Override
    public int findSongYear(String trackName){
        for (int yearIndex = 0; yearIndex < releaseYears.length; yearIndex++) {
            for (int songIndex = 0; songIndex < songsByYear[yearIndex].length; songIndex++) {
                if (songsByYear[yearIndex][songIndex].trackName().equals(trackName)) {
                    return yearIndex;
                }
            }
        }
        return -1;
    }
}
