package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

class QuaternionTest {
    Quaternion q1;
    Quaternion q2;
    Quaternion q3;

    @BeforeEach
    void init() {
        q1 = new Quaternion(1, 2, 3, 4);
        q2 = new Quaternion(2, 4, 6, 8);
        q3 = new Quaternion(2, 2, 2, 2);
    }

    @Test
    void testLength() {
        assertEquals((float) 4, q3.length());
    }

    @Test
    void failedTestLength() {
        assertNotEquals(5f, q3.length());
    }

    @Test
    void testNonStaticNormalize() {
        Quaternion q4 = new Quaternion(2f / 4f, 2f / 4f, 2f / 4f, 2f / 4f);
        q3.normalize();
        assertEquals(q4, q3);
    }

    @Test
    void failedTestNonStaticNormalize() {
        Quaternion q4 = new Quaternion(2f / 3f, 2f / 4f, 2f / 5f, 2f / 4f);
        q3.normalize();
        assertNotEquals(q4, q3);
    }

    @Test
    void testStaticNormalize() {
        Quaternion q4 = new Quaternion(2f / 4f, 2f / 4f, 2f / 4f, 2f / 4f);
        assertEquals(q4, Quaternion.normalize(q3));
    }

    @Test
    void failedTestStaticNormalize() {
        Quaternion q4 = new Quaternion(2f / 3f, 2f / 4f, 2f / 5f, 2f / 4f);
        assertNotEquals(q4, Quaternion.normalize(q3));
    }

    @Test
    void testNonStaticConjugate() {
        Quaternion q3 = new Quaternion(-1, -2, -3, 4);
        assertEquals(q3.conjugate(), q1);
    }

    @Test
    void failedTestNonStaticConjugate() {
        Quaternion q3 = new Quaternion(1, 2, -3, -4);
        q3.conjugate();
        assertNotEquals(q3, q1);
    }

    @Test
    void testStaticConjugate() {
        Quaternion q3 = new Quaternion(-1, -2, -3, 4);
        assertEquals(q3, Quaternion.conjugate(q1));
    }

    @Test
    void failedTestStaticConjugate() {
        Quaternion q3 = new Quaternion(1, 2, -3, -4);
        assertNotEquals(q3, Quaternion.conjugate(q1));
    }

    @Test
    void testStaticMul() {
        Quaternion q3 = new Quaternion(16, 32, 48, 4);
        assertEquals(q3, q1.mul(q2));
    }

    @Test
    void tesMul() {
        Quaternion q3 = new Quaternion(16, 32, 48, 4);
        assertEquals(q3, Quaternion.mul(q1, q2));
    }

    @Test
    void failedTestStaticMul() {
        Quaternion q3 = new Quaternion(8, 12, 16, 56);
        assertNotEquals(q3, Quaternion.mul(q1, q2));
    }

    @Test
    void testVectorMul() {
        Quaternion q3 = new Quaternion(3, 6, 3, -6);
        assertEquals(q3, q1.mul(new Vector3f(1, 1, 1)));
    }

    @Test
    void failedTestVectorMul() {
        Quaternion q3 = new Quaternion(3, 6, 3, 6);
        assertNotEquals(q3, q1.mul(new Vector3f(1, 1, 1)));
    }

    @Test
    void testSetX() {
        q1.setX(3);
        assertTrue(q1.getX() == 3);
    }

    @Test
    void testSetY() {
        q1.setY(3);
        assertTrue(q1.getY() == 3);
    }

    @Test
    void testSetZ() {
        q1.setZ(3);
        assertTrue(q1.getZ() == 3);
    }

    @Test
    void testSetW() {
        q1.setW(3);
        assertTrue(q1.getW() == 3);
    }

}