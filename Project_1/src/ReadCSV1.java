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
        } catch(CsvValidationException | IOException e){
        }
    }
}
