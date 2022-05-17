package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class Vector2fTest {
    Vector2f v1;
    Vector2f v2;


    @BeforeEach
    void init() {
        v1 = new Vector2f(1, 2);
        v2 = new Vector2f(2, 4);

    }


    @Test
    void testSetZero() {
        Vector2f v3 = new Vector2f(0, 0);
        assertEquals(v3, Vector2f.setZero(v1));
    }

    @Test
    void failedTestSetZero() {
        Vector2f v3 = new Vector2f(0, 1);
        assertNotEquals(v3, Vector2f.setZero(v1));
    }

    @Test
    void testLength() {
        assertEquals((float) Math.sqrt(5), v1.length());
    }

    @Test
    void failedTestLength() {
        assertNotEquals(8f, v1.length());
    }

    @Test
    void testMagnitude() {
        assertEquals((float) Math.sqrt(20), Vector2f.magnitude(v2));
    }

    @Test
    void failedTestMagnitude() {
        assertNotEquals(24, Vector2f.magnitude(v2));
    }

    @Test
    void testNormalize() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(5)), (float) (2 / Math.sqrt(5)));
        assertEquals(v3, Vector2f.normalize(v1));
    }

    @Test
    void failedTestNormalize() {
        Vector2f v3 = new Vector2f(1 / 3f, 1 / 3f);
        assertNotEquals(v3, Vector2f.normalize(v1));
    }

    @Test
    void testDot() {
        assertEquals(10f, Vector2f.dot(v1, v2));
    }

    @Test
    void failedTestDot() {
        assertNotEquals(9f, Vector2f.dot(v1, v2));
    }

    @Test
    void testCross() {
        assertEquals(0f, Vector2f.cross(v1, v2));
    }

    @Test
    void failedTestCross() {
        assertNotEquals(1f, Vector2f.cross(v1, v2));
    }

    @Test
    void testAdd() {
        Vector2f v3 = new Vector2f(3, 6);
        assertEquals(v3, Vector2f.add(v1, v2));
    }

    @Test
    void failedTestAdd() {
        Vector2f v3 = new Vector2f(2, 6);
        assertNotEquals(v3, Vector2f.add(v1, v2));
    }

    @Test
    void testSub() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, Vector2f.sub(v2, v1));
    }

    @Test
    void failedTestSub() {
        Vector2f v3 = new Vector2f(1, 1);
        assertNotEquals(v3, Vector2f.sub(v2, v1));
    }

    @Test
    void testMul() {
        Vector2f v3 = new Vector2f(2, 4);
        assertEquals(v3, Vector2f.mul(v1, 2));
    }

    @Test
    void failedTestMul() {
        Vector2f v3 = new Vector2f(1, 4);
        assertNotEquals(v3, Vector2f.mul(v1, 2));
    }

    @Test
    void testDiv() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, Vector2f.div(v2, 2));
    }

    @Test
    void failedTestDiv() {
        Vector2f v3 = new Vector2f(1, 6);
        assertNotEquals(v3, Vector2f.div(v2, 2));
    }

    @Test
    void testDistance() {
        assertEquals((float) Math.sqrt(5), Vector2f.distance(v1, v2));
    }

    @Test
    void failedTestDistance() {
        assertNotEquals((float) Math.sqrt(9), Vector2f.distance(v1, v2));
    }

    @Test
    void testDistSquared() {
        assertEquals(5f, Vector2f.distSquared(v1, v2));

    }

    @Test
    void failedTestDistSquared() {
        assertNotEquals(Math.sqrt(5), Vector2f.distSquared(v1, v2));

    }
}