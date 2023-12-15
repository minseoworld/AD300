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
    public int findSongYear(String trackName) {
        for (int row = 0; row < getYearCount(); row++) {
            for (int col = 0; col < getSongCount(row); col++) {
                if (trackName.equals(getSong(row, col).trackName())) {
                    return row;
                }
            }
        }
        return -1;
    }

    private void sortSongs() {
        for (int rowIndex = 0; rowIndex < getYearCount(); rowIndex++) {
            Arrays.sort(songs[rowIndex]);
        }
    }
}
