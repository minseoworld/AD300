import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV1{

    public static void main(String[] args){
        try{
           CSVReader songReader = new CSVReader(new FileReader("spotify-2023.csv"));
           for(int i = 0; i < 3; i++){
               for(int j = 0;  j < 3; j++){
                   String[] songInfo = songReader.readNext();
                   System.out.println(songInfo[2]);
               }
           }
        }catch(CsvValidationException | IOException e){
        }
    }
}

//ReadCSV1; Time Complexity: O(m * n)
//Reading the song information from the CSV file takes time proportional to the number of rows and columns in the file.
//ReadCSV1; Space Complexity: O(1)
//Printing details for a fixed number of songs from a fixed number of columns also takes a specific amount of time.
//Printing Song Information; Time Complexity: O(m * n)
//The code doesn't use much memory as it reads and processes the CSV file row by row, storing information for the current song being processed.
