package test.java;

import main.java.Geometry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeometryTest {
    @Test
    public void testTriangle() {
        assertEquals(10.0, Geometry.areaTriangle(4, 5), 0.001);
    }
    @Test
    public void testRectangle() {
        assertEquals(20.0, Geometry.areaRectangle(4, 5), 0.001);
    }
    @Test
    public void testSquare() {
        assertEquals(16.0, Geometry.areaSquare(4), 0.001);
    }
    @Test
    public void testRhombus() {
        assertEquals(10.0, Geometry.areaRhombus(4, 5), 0.001);
    }
}
