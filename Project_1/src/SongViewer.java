import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.io.FileReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SongViewer extends JFrame{
    private JComboBox<String> yearComboBox;
    private JButton loadDataButton;
    private JButton prevButton;
    private JButton nextButton;
    private JTextArea songInfoTextArea;
    private JScrollPane yearScrollPane;

    private String[] years;
    private int selectedYearIndex = 0;

    public SongViewer(){
        setTitle("Song Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        yearComboBox = new JComboBox<>();
        loadDataButton = new JButton("Load Data");
        prevButton = new JButton("Prev");
        nextButton = new JButton("Next");
        songInfoTextArea = new JTextArea();


        DefaultListModel<String> yearListModel = new DefaultListModel<>();
        JList<String> yearList = new JList<>(yearListModel);
        yearScrollPane = new JScrollPane(yearList);
        yearScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Select Release Year: "));
        mainPanel.add(yearComboBox);
        mainPanel.add(loadDataButton);
        mainPanel.add(prevButton);
        mainPanel.add(nextButton);

        add(mainPanel, BorderLayout.NORTH);
        add(new JScrollPane(songInfoTextArea), BorderLayout.CENTER);
        add(yearScrollPane, BorderLayout.SOUTH);

        years = new String[0];

        loadDataButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loadData();
            }
        });

        prevButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                showPreviousYear();
            }
        });

        nextButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                showNextYear();
            }
        });
    }

    private void loadData(){
        songInfoTextArea.setText("");

        String selectedYear =(String) yearComboBox.getSelectedItem();
        if(selectedYear == null){
            JOptionPane.showMessageDialog(this, "Please select a year first");
            return;
        }

        try{
            CSVReader songReader = new CSVReader(new FileReader("spotify-2023.csv"));
            String[] songInfo;
            while ((songInfo = songReader.readNext()) != null){
                if (songInfo.length < 9){
                    continue;
                }

                String releaseYear = songInfo[3];
                if (releaseYear.equals(selectedYear)){
                    String trackName = songInfo[0];
                    String artists = songInfo[1];
                    String releaseDate = releaseYear + "-" + songInfo[4] + "-" + songInfo[5];
                    String totalStreams = songInfo[8];

                    songInfoTextArea.append("Track Name: " + trackName + "\n");
                    songInfoTextArea.append("Artist(s): " + artists + "\n");
                    songInfoTextArea.append("Release Date: " + releaseDate + "\n");
                    songInfoTextArea.append("Total Streams: " + totalStreams + "\n\n");

                }
            }
            songReader.close();
        } catch(CsvValidationException | IOException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading CSV file.");
        }
    }

    private void showPreviousYear(){
        if(selectedYearIndex > 0){
            selectedYearIndex--;
            updateSelectedYear();
        }
    }

    private void showNextYear(){
        if(selectedYearIndex < years.length - 1){
            selectedYearIndex++;
            updateSelectedYear();
        }
    }

    private void updateSelectedYear(){
        yearComboBox.setSelectedItem(years[selectedYearIndex]);
        yearScrollPane.getViewport().setViewPosition(new Point(0, selectedYearIndex * yearScrollPane.getVerticalScrollBar().getUnitIncrement()));
        loadData();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            SongViewer songViewer = new SongViewer();
            songViewer.setVisible(true);
        });
    }
}
