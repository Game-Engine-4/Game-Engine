package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    void testNormalize() {
        Quaternion q4 = new Quaternion(2f / 4f, 2f / 4f, 2f / 4f, 2f / 4f);
        assertEquals(q4, Quaternion.normalize(q3));
    }

    @Test
    void failedTestNormalize() {
        Quaternion q4 = new Quaternion(2f / 3f, 2f / 4f, 2f / 5f, 2f / 4f);
        assertNotEquals(q4, Quaternion.normalize(q3));
    }

    @Test
    void testConjugate() {
        Quaternion q3 = new Quaternion(1, -2, -3, -4);
        assertEquals(q3, Quaternion.conjugate(q1));
    }

    @Test
    void failedTestConjugate() {
        Quaternion q3 = new Quaternion(1, 2, -3, -4);
        assertNotEquals(q3, Quaternion.conjugate(q1));
    }

    @Test
    void testMul() {
        Quaternion q3 = new Quaternion(8, 12, 16, -56);
        assertEquals(q3, Quaternion.mul(q1, q2));
    }

    @Test
    void failedTestMul() {
        Quaternion q3 = new Quaternion(8, 12, 16, 56);
        assertNotEquals(q3, Quaternion.mul(q1, q2));
    }
}