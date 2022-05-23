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
    void testStaticMagnitude() {
        assertEquals((float) Math.sqrt(20), Vector2f.magnitude(v2));
    }

    @Test
    void testNonStaticMagnitude() {
        assertEquals((float) Math.sqrt(20), v2.magnitude());
    }

    @Test
    void failedTestNonStaticMagnitude() {
        assertNotEquals((float) Math.sqrt(22), v2.magnitude());
    }


    @Test
    void failedTestStaticMagnitude() {
        assertNotEquals(24, Vector2f.magnitude(v2));
    }

    @Test
    void testNonStaticNormalize() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(5)), (float) (2 / Math.sqrt(5)));
        assertEquals(v3, v1.normalize());
    }

    @Test
    void failedTestNonStaticNormalize() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(6)), (float) (2 / Math.sqrt(5)));
        assertNotEquals(v3, v1.normalize());
    }

    @Test
    void testStaticNormalize() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(5)), (float) (2 / Math.sqrt(5)));
        assertEquals(v3, Vector2f.normalize(v1));
    }

    @Test
    void failedTestStaticNormalize() {
        Vector2f v3 = new Vector2f(1 / 3f, 1 / 3f);
        assertNotEquals(v3, Vector2f.normalize(v1));
    }

    @Test
    void testGetNormalized() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(5)), (float) (2 / Math.sqrt(5)));
        assertEquals(v3, v1.getNormalized());
    }

    @Test
    void failedTestGetNormalized() {
        Vector2f v3 = new Vector2f((float) (1 / Math.sqrt(6)), (float) (2 / Math.sqrt(5)));
        assertNotEquals(v3, v1.getNormalized());
    }

    @Test
    void testToCartesian() {
        Vector2f v3 = new Vector2f(-0.41614684f, 0.90929743f);
        assertEquals(v3, v1.toCartesian(1, 2));
    }

    @Test
    void testRotate() {
        Vector2f v3 = new Vector2f(0.9649429f, 2.0171478f);
        assertEquals(v3, v1.rotate(1));
    }

    @Test
    void testGetRotatedBy() {
        Vector2f v3 = new Vector2f(-1.1426396f, 1.9220755f);
        assertEquals(v3, v1.getRotatedBy(1));
    }

    @Test
    void testGetRotatedTo() {
        Vector2f v3 = new Vector2f(1.2081527f, 1.8815863f);
        assertEquals(v3, v1.getRotatedTo(1));
    }

    @Test
    void getAngle() {
        assertEquals(v1.getAngle(), 1.1071488f);
    }

    @Test
    void testFloatDot() {
        assertEquals(14f, v1.dot(4, 5));
    }

    @Test
    void testNonStaticDot() {
        assertEquals(10f, v1.dot(v2));
    }

    @Test
    void testStaticDot() {
        assertEquals(10f, Vector2f.dot(v1, v2));
    }

    @Test
    void failedStaticTestDot() {
        assertNotEquals(9f, Vector2f.dot(v1, v2));
    }

    @Test
    void testFloatCross() {
        assertEquals(-3f, v1.cross(4, 5));
    }

    @Test
    void testNonStaticCross() {
        assertEquals(0f, v1.cross(v2));
    }

    @Test
    void testStaticCross() {
        assertEquals(0f, Vector2f.cross(v1, v2));
    }

    @Test
    void failedStaticTestCross() {
        assertNotEquals(1f, Vector2f.cross(v1, v2));
    }

    @Test
    void testStaticAdd() {
        Vector2f v3 = new Vector2f(3, 6);
        assertEquals(v3, Vector2f.add(v1, v2));
    }

    @Test
    void testNonStaticAdd() {
        Vector2f v3 = new Vector2f(3, 6);
        assertEquals(v3, v1.add(v2));
    }

    @Test
    void testFloatAdd() {
        Vector2f v3 = new Vector2f(3, 6);
        assertEquals(v3, v1.add(2, 4));
    }

    @Test
    void testAdd() {
        Vector2f v3 = new Vector2f(3, 4);
        assertEquals(v3, v1.add(2));
    }

    @Test
    void failedTestAdd() {
        Vector2f v3 = new Vector2f(2, 6);
        assertNotEquals(v3, Vector2f.add(v1, v2));
    }

    @Test
    void testSub() {
        Vector2f v3 = new Vector2f(1, 3);
        assertEquals(v3, v2.sub(1));
    }

    @Test
    void testFloatSub() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, v2.sub(1, 2));
    }

    @Test
    void testNonStaticSub() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, v2.sub(v1));
    }

    @Test
    void testStaticSub() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, Vector2f.sub(v2, v1));
    }

    @Test
    void failedStaticTestSub() {
        Vector2f v3 = new Vector2f(1, 1);
        assertNotEquals(v3, Vector2f.sub(v2, v1));
    }

    @Test
    void testNonStaticMul() {
        Vector2f v3 = new Vector2f(2, 8);
        assertEquals(v3, v1.mul(v2));
    }

    @Test
    void testMul() {
        Vector2f v3 = new Vector2f(2, 4);
        assertEquals(v3, v1.mul(2));
    }

    @Test
    void testStaticMul() {
        Vector2f v3 = new Vector2f(2, 4);
        assertEquals(v3, Vector2f.mul(v1, 2));
    }

    @Test
    void failedTestStaticMul() {
        Vector2f v3 = new Vector2f(1, 4);
        assertNotEquals(v3, Vector2f.mul(v1, 2));
    }

    @Test
    void testDivScalar() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, v2.div(2));
    }

    @Test
    void testNonStaticDiv() {
        Vector2f v3 = new Vector2f(1, 1);
        assertEquals(v3, v2.div(v1));
    }

    @Test
    void testStaticDiv() {
        Vector2f v3 = new Vector2f(1, 2);
        assertEquals(v3, Vector2f.div(v2, 2));
    }

    @Test
    void failedTestStaticDiv() {
        Vector2f v3 = new Vector2f(1, 6);
        assertNotEquals(v3, Vector2f.div(v2, 2));
    }

    @Test
    void testNonStaticDistance() {
        assertEquals((float) Math.sqrt(5), v1.distance(v2));
    }

    @Test
    void testFloatDistance() {
        assertEquals((float) Math.sqrt(5), v1.distance(2, 4));
    }


    @Test
    void testStaticDistance() {
        assertEquals((float) Math.sqrt(5), Vector2f.distance(v1, v2));
    }

    @Test
    void failedTestStaticDistance() {
        assertNotEquals((float) Math.sqrt(9), Vector2f.distance(v1, v2));
    }

    @Test
    void testNonStaticDistSquared() {
        assertEquals(5f, v1.distSquared(v2));
    }

    @Test
    void testFloatDistSquared() {
        assertEquals(5f, v1.distSquared(2, 4));
    }

    @Test
    void testStaticDistSquared() {
        assertEquals(5f, Vector2f.distSquared(v1, v2));
    }


    @Test
    void failedTestStaticDistSquared() {
        assertNotEquals(Math.sqrt(5), Vector2f.distSquared(v1, v2));
    }
}