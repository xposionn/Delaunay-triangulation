package Algorithm;

import DataSheet.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelaunayTest {

    @Test
    public void isInCircle() {
        Point v1 = new Point(0,0);
        Point v2 = new Point(10,0);;
        Point v3 = new Point(0,10);;
        Point check = new Point(1,1);;
        assertTrue(Delaunay.isInCircle(v1,v2,v3,check));
    }
}