import org.junit.Test;
import static org.junit.Assert.*;

public class BoxTest{

    @Test
    public void testCalculateVolume(){
        Box box = new Box(2.0, 2.0, 2.0);
        double expectedVolume = 2.0 * 2.0 * 2.0;
        assertEquals(expectedVolume, box.calculateVolume(), 0.0001);
    }

    @Test
    public void testCalculateSurfaceArea(){
        Box box = new Box(2.0, 2.0, 2.0);
        double expectedSurfaceArea = 2 * (2.0 * 2.0 + 2.0 * 2.0 + 2.0 * 2.0);
        assertEquals(expectedSurfaceArea, box.calculateSurfaceArea(), 0.0001);
    }

}
