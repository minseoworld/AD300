import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    JFrame j = new JFrame("Box GUI");

    private Box box;
    private JLabel lengthLabel, widthLabel, heightLabel;
    private JTextField lengthTextField, widthTextField, heightTextField;
    private JButton calculateVolumeButton, calculateSurfaceAreaButton, displayBoxDetailsButton;

    public GUI(){
        box = new Box();

        //java swing
        setTitle("Box GUI");
        setBounds(100,100,100,100);
        setSize(500, 300);
        setLayout(null);
        setVisible(true);

        //task 1
        lengthLabel = new JLabel("Length:");
        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");

        lengthTextField = new JTextField();
        widthTextField = new JTextField();
        heightTextField = new JTextField();

        calculateVolumeButton = new JButton("Calculate Volume");
        calculateSurfaceAreaButton = new JButton("Calculate Surface Area");
        displayBoxDetailsButton = new JButton("Display Box Details");

        //task 2
        setLayout(new GridLayout(3,3));
        add(lengthLabel);
        add(widthLabel);
        add(heightLabel);

        add(lengthTextField);
        add(widthTextField);
        add(heightTextField);

        add(calculateVolumeButton);
        add(calculateSurfaceAreaButton);
        add(displayBoxDetailsButton);

        //task 3
        calculateVolumeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    double length = Double.parseDouble(lengthTextField.getText());
                    double width = Double.parseDouble(widthTextField.getText());
                    double height = Double.parseDouble(heightTextField.getText());
                    box.setDimensions(length, width, height);
                    double volume = box.calculateVolume();
                    JOptionPane.showMessageDialog(j, "Volume: " + volume);
            }
        });

        calculateSurfaceAreaButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    double length = Double.parseDouble(lengthTextField.getText());
                    double width = Double.parseDouble(widthTextField.getText());
                    double height = Double.parseDouble(heightTextField.getText());
                    box.setDimensions(length, width, height);
                    double surfaceArea = box.calculateSurfaceArea();
                    JOptionPane.showMessageDialog(j, "Surface Area: " + surfaceArea);
            }
        });

        displayBoxDetailsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double length = Double.parseDouble(lengthTextField.getText());
                double width = Double.parseDouble(widthTextField.getText());
                double height = Double.parseDouble(heightTextField.getText());
                box.setDimensions(length, width, height);
                JOptionPane.showMessageDialog(j, "Length: " + box.getLength() + " " + "Width: " + box.getWidth() + " " + "Height: " + box.getHeight());
            }
        });
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GUI();
            }
        });
    }
}
