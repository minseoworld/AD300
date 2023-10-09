import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class boxTest {

    @Test
    @DisplayName("Test volume method")
    void volume() {
        box myBox = new box(5, 5, 5);
        double expectedVolume = 125.0;
    }

    @Test
    @DisplayName("Test addItem method")
    void addItem() {
        box myBox = new box(10, 10, 10);
        myBox.addItem("Item1");
        myBox.addItem("Item2");
    }

    @Test
    @DisplayName("Test removeItem method")
    void removeItem() {
        box myBox = new box(10, 10, 10);
        myBox.addItem("Item1");
        myBox.removeItem("Item1");
    }

    @Test
    @DisplayName("Test printItem method")
    void printItems() {
        box myBox = new box(10, 10, 10);
        myBox.addItem("Item1");
        myBox.removeItem("Item1");
    }
}