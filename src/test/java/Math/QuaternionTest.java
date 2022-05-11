package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

class QuaternionTest {
    Quaternion q1;
    Quaternion q2;

    @BeforeEach
    void init() {
        q1 = new Quaternion(1, 2, 3, 4);
        q2 = new Quaternion(2, 4, 6, 8);
    }

    @Test
    void testLength() {
        float l = 4;
        assertEquals(l, q1.length());
    }

    @Test
    void testNormalize() {
        Quaternion q3 = new Quaternion(1 / 4f, 2 / 4f, 3 / 4f, 1);
        assertEquals(q3, Quaternion.normalize(q1));
    }

    @Test
    void testConjugate() {
        Quaternion q3 = new Quaternion(1, -2, -3, -4);
        assertEquals(q3, Quaternion.conjugate(q1));

    }

    @Test
    void testMul() {
        Quaternion q3 = new Quaternion(8, 12, 36, -56);
        assertEquals(q3, Quaternion.mul(q1, q2));
    }
}