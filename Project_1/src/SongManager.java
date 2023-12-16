import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SongManager implements SongManagerInterface {

    private final Song[][] songs;
    private final String[] releaseYears;

    public SongManager() {
        String yearsCountPath = "count-by-release-year.csv";
        String spotifySongsPath = "spotify-2023.csv";

        try {
            CSVReader countByReleaseCSV = new CSVReader(new FileReader(yearsCountPath));
            CSVReader spotify = new CSVReader(new FileReader(spotifySongsPath));

            int yearCount = Integer.parseInt(countByReleaseCSV.readNext()[0]);
            countByReleaseCSV.readNext();
            songs = new Song[yearCount][];
            releaseYears = new String[yearCount];

            for (int yearIndex = 0; yearIndex < yearCount; yearIndex++) {
                String[] yearsLine = countByReleaseCSV.readNext();
                releaseYears[yearIndex] = yearsLine[0];
                songs[yearIndex] = new Song[Integer.parseInt(yearsLine[1])];
            }

            for (int row = 0; row < yearCount; row++) {
                for (int col = 0; col < songs[row].length; col++) {
                    String[] songLine = spotify.readNext();
                    songs[row][col] = new Song(songLine[0], songLine[1], songLine[3], songLine[4], songLine[5], songLine[8]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        sortSongs();
    }

    @Override
    public int getYearCount() {
        return releaseYears.length;
    }

    @Override
    public int getSongCount(int yearIndex) {
        if (yearIndex < 0 || yearIndex >= songs.length) {
            throw new IllegalArgumentException("Invalid year index");
        }
        return songs[yearIndex].length;
    }

    @Override
    public int getSongCount() {
        int totalCount = 0;
        for (int i = 0; i < songs.length; i++) {
            totalCount += songs[i].length;
        }
        return totalCount;
    }

    @Override
    public String getYearName(int yearIndex) {
        if (yearIndex < 0 || yearIndex >= releaseYears.length) {
            throw new IllegalArgumentException("Invalid year index");
        }
        return releaseYears[yearIndex];
    }

    @Override
    public Song getSong(int yearIndex, int songIndex) {
        if (yearIndex < 0 || yearIndex >= songs.length || songIndex < 0 || songIndex >= songs[yearIndex].length) {
            throw new IllegalArgumentException("Invalid indices");
        }
        return songs[yearIndex][songIndex];
    }

    @Override
    public int getSongCount(String year) {
        for (int i = 0; i < releaseYears.length; i++) {
            if (releaseYears[i].equals(year)) {
                return songs[i].length;
            }
        }
        return 0;
    }

    @Override
    public Song[] getSongs(int yearIndex) {
        if (yearIndex < 0 || yearIndex >= songs.length) {
            throw new IllegalArgumentException("Invalid year index");
        }
        return songs[yearIndex];
    }

    private void sortSongs() {
        for (int rowIndex = 0; rowIndex < getYearCount(); rowIndex++) {
            Arrays.sort(songs[rowIndex]);
        }
    }
}
