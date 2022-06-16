package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector3fTest {
    Vector3f v1;
    Vector3f v2;

    @BeforeEach
    void init() {
        v1 = new Vector3f(1, 2, 3);
        v2 = new Vector3f(2, 4, 6);
    }

    @Test
    void testConstructor() {
        assertEquals(new Vector3f(0, 0, 0), new Vector3f());
    }

    @Test
    void testConstructorVector() {
        assertEquals(new Vector3f(1f, 2f, 3f), new Vector3f(v1));
    }

    @Test
    void testConstructorScalar() {
        assertEquals(new Vector3f(3f, 3f, 3f), new Vector3f(3));
    }

    @Test
    void testDistanceSquared() {
        assertEquals(14f, Vector3f.distanceSquared(v2, v1));
    }

    @Test
    void testDistance() {
        assertEquals((float) Math.sqrt(14), Vector3f.distance(v2, v1));
    }

    @Test
    void testStaticAdd() {
        Vector3f v3 = new Vector3f(3, 6, 9);
        assertEquals(v3, Vector3f.add(v1, v2));
    }

    @Test
    void testNonStaticAdd() {
        Vector3f v3 = new Vector3f(3, 6, 9);
        assertEquals(v3, v1.add(v2));
    }

    @Test
    void testScalarAdd() {
        Vector3f v3 = new Vector3f(11, 12, 13);
        assertEquals(v3, v1.add(10));
    }

    @Test
    void testAdd() {
        Vector3f v3 = new Vector3f(3, 6, 9);
        assertEquals(v3, v1.add(2, 4, 6));
    }

    @Test
    void failedNonStaticTestAdd() {
        Vector3f v3 = new Vector3f(3, 5, 9);
        assertNotEquals(v3, Vector3f.add(v1, v2));
    }

    @Test
    void testStaticSub() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, Vector3f.sub(v2, v1));
    }

    @Test
    void testNonStaticSub() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, v2.sub(v1));
    }

    @Test
    void testScalarSub() {
        Vector3f v3 = new Vector3f(0, 1, 2);
        assertEquals(v3, v1.sub(1));
    }

    @Test
    void testSub() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, v2.sub(1, 2, 3));
    }

    @Test
    void failedTestSub() {
        Vector3f v3 = new Vector3f(0, 1, 2);
        assertNotEquals(v3, Vector3f.sub(v2, v1));
    }

    @Test
    void testStaticMul() {
        Vector3f v3 = new Vector3f(2, 4, 6);
        assertEquals(v3, Vector3f.mul(v1, 2));
    }

    @Test
    void testNonStaticMul() {
        Vector3f v3 = new Vector3f(2, 8, 18);
        assertEquals(v3, v1.mul(v2));
    }

    @Test
    void testScalarMul() {
        Vector3f v3 = new Vector3f(10, 20, 30);
        assertEquals(v3, v1.mul(10));
    }

    @Test
    void testMul() {
        Vector3f v3 = new Vector3f(1, 1, 1);
        Vector3f v4 = new Vector3f(2, 8, 18);
        assertEquals(v4, v1.mul(v2, v3));
    }

    @Test
    void failedTestMul() {
        Vector3f v3 = new Vector3f(2, 4, 9);
        assertNotEquals(v3, Vector3f.mul(v1, 2));
    }

    @Test
    void testStaticDiv() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, Vector3f.div(v2, 2));
    }

    @Test
    void testNonStaticDiv() {
        Vector3f v3 = new Vector3f(2, 2, 2);
        assertEquals(v3, v2.div(v1));
    }

    @Test
    void testScalarDiv() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, v1.div(1));
    }

    @Test
    void testDiv() {
        Vector3f v3 = new Vector3f(1, 1, 1);
        Vector3f v4 = new Vector3f(2, 2, 2);
        assertEquals(v4, v2.div(v1, v3));
    }

    @Test
    void failedTestDiv() {
        Vector3f v3 = new Vector3f(2, 4, 3);
        assertNotEquals(v3, Vector3f.div(v2, 2));
    }

    @Test
    void testNonStaticDot() {
        assertEquals(28f, v1.dot(v2));
    }

    @Test
    void testStaticDot() {
        assertEquals(28f, Vector3f.dot(v1, v2));
    }

    @Test
    void failedTestDot() {
        assertNotEquals(33f, Vector3f.dot(v1, v2));
    }

    @Test
    void testStaticNormalize() {
        Vector3f v3 = new Vector3f(2 / 6f, 4 / 6f, 4 / 6f);
        assertEquals(v3, Vector3f.normalize(v3));
    }

    @Test
    void testNonStaticNormalize() {
        Vector3f v3 = new Vector3f(2 / 6f, 4 / 6f, 4 / 6f);
        assertEquals(v3, v3.normalize());
    }

    @Test
    void failedTestNormalize() {
        Vector3f v3 = new Vector3f(1 / 6f, 3 / 6f, 4 / 6f);
        assertNotEquals(v3, Vector3f.normalize(v3));
    }

    @Test
    void testAngle() {
        Vector3f v3 = new Vector3f(1, 1, 1);
        assertEquals(0.38759667f, v1.angle(v3));
    }

    @Test
    void testStaticSetZero() {
        Vector3f v3 = new Vector3f(0f, 0f, 0f);
        assertEquals(v3, Vector3f.setZero(v1));
    }

    @Test
    void testNonStaticSetZero() {
        Vector3f v3 = new Vector3f(0f, 0f, 0f);
        assertEquals(v3, v1.setZero());
    }

    @Test
    void failedTestSetZero() {
        Vector3f v3 = new Vector3f(0, 1, 0);
        assertNotEquals(v3, Vector3f.setZero(v1));
    }

    @Test
    void testNonStaticSet() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, v2.set(v1));
    }

    @Test
    void testSet() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, v2.set(1, 2, 3));
    }

    @Test
    void testSetArr() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        float[] array = {1, 2, 3};
        assertEquals(v3, v2.set(array));
    }

    @Test
    void testLengthSquared() {
        assertEquals(14f, Vector3f.lengthSquared(v1));
    }

    @Test
    void testNonStaticLengthSquared() {
        assertEquals(14f, v1.lengthSquared());
    }

    @Test
    void failedTestLengthSquared() {
        assertNotEquals(15f, Vector3f.lengthSquared(v1));
    }

    @Test
    void testLength1() {
        assertEquals(3.7416575f, v1.length());
    }

    @Test
    void testLength2() {
        assertEquals(7.483315f, v2.length());
    }

    @Test
    void failedTestLength() {
        assertNotEquals((float) Math.sqrt(13), v1.length());
    }

    @Test
    void testStaticCross() {
        Vector3f v3 = new Vector3f(0, 0, 0);
        assertEquals(v3, Vector3f.cross(v1, v2));
    }

    @Test
    void testNonStaticCross() {
        Vector3f v3 = new Vector3f(0, 0, 0);
        assertEquals(v3, v1.cross(v2));
    }

    @Test
    void failedTestCross() {
        Vector3f v3 = new Vector3f(1, 1, 0);
        assertNotEquals(v3, Vector3f.cross(v1, v2));
    }

    @Test
    void testRotateX() {
        Vector3f v3 = new Vector3f(1, -1.443808343f, 3.303848887f);
        assertEquals(v3, v1.rotateX(1));
    }

    @Test
    void testDestRotateX() {
        Vector3f v3 = new Vector3f(1, -1.443808343f, 3.303848887f);
        Vector3f v4 = new Vector3f(1, 1, 1);
        assertEquals(v3, v1.rotateX(1, v4));
    }

    @Test
    void testRotateY() {
        Vector3f v3 = new Vector3f(3.06471526f, 2, 0.7794359328f);
        assertEquals(v3, v1.rotateY(1));
    }

    @Test
    void testDestRotateY() {
        Vector3f v3 = new Vector3f(3.06471526f, 2, 0.7794359328f);
        Vector3f v4 = new Vector3f(1, 1, 1);
        assertEquals(v3, v1.rotateY(1, v4));
    }

    @Test
    void testRotateZ() {
        Vector3f v3 = new Vector3f(-1.142639664f, 1.922075597f, 3);
        assertEquals(v3, v1.rotateZ(1));
    }

    @Test
    void testDestRotateZ() {
        Vector3f v3 = new Vector3f(-1.142639664f, 1.922075597f, 3);
        Vector3f v4 = new Vector3f(1, 1, 1);
        assertEquals(v3, v1.rotateZ(1, v4));
    }

    @Test
    void testSetX() {
        v1.setX(13);
        assertTrue(v1.getX() == 13);
    }

    @Test
    void testSetY() {
        v1.setY(13);
        assertTrue(v1.getY() == 13);
    }

    @Test
    void testSetZ() {
        v1.setZ(13);
        assertTrue(v1.getZ() == 13);
    }
}