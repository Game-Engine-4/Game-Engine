package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Vector3fTest {
    Vector3f v1;
    Vector3f v2;
    Vector3f v3;

    @BeforeEach
    void init() {
        v1 = new Vector3f(1, 2, 3);
        v2 = new Vector3f(2, 4, 6);
        v3 = new Vector3f(2, 4, 4);
    }

    @Test
    void testAdd() {
        Vector3f v3 = new Vector3f(3, 6, 9);
        assertEquals(v3, Vector3f.add(v1, v2));
    }
    @Test
    void failedTestAdd() {
        Vector3f v3 = new Vector3f(3, 5, 9);
        assertNotEquals(v3, Vector3f.add(v1, v2));
    }

    @Test
    void testSub() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, Vector3f.sub(v2, v1));

    }
    @Test
    void failedTestSub() {
        Vector3f v3 = new Vector3f(0, 1, 2);
        assertNotEquals(v3, Vector3f.sub(v2, v1));
    }

    @Test
    void testMul() {
        Vector3f v3 = new Vector3f(2, 4, 6);
        assertEquals(v3, Vector3f.mul(v1, 2));

    }
    @Test
    void failedTestMul() {
        Vector3f v3 = new Vector3f(2, 4, 9);
        assertNotEquals(v3, Vector3f.mul(v1, 2));
    }

    @Test
    void testDiv() {
        Vector3f v3 = new Vector3f( 1, 2, 3);
        assertEquals(v3, Vector3f.div(v2, 2));
    }
    @Test
    void failedTestDiv() {
        Vector3f v3 = new Vector3f( 2, 4, 3);
        assertNotEquals(v3, Vector3f.div(v2, 2));
    }

    @Test
    void testDot(){
        assertEquals(28f, Vector3f.dot(v1,v2));
    }
    @Test
    void failedTestDot(){
        assertNotEquals(33f, Vector3f.dot(v1,v2));
    }
    @Test
    void testNormalize() {
        Vector3f v4 = new Vector3f(2/6f, 4/6f, 4/6f);
        assertEquals(v4, Vector3f.normalize(v3));
    }
    @Test
    void failedTestNormalize() {
        Vector3f v4 = new Vector3f(1/6f, 3/6f, 4/6f);
        assertNotEquals(v4, Vector3f.normalize(v3));
    }
    @Test
    void testSetZero() {
        Vector3f v3 = new Vector3f(0f,0f,0f);
        assertEquals(v3, Vector3f.setZero(v1));
    }
    @Test
    void failedTestSetZero() {
        Vector3f v3 = new Vector3f(0,1,0);
        assertNotEquals(v3, Vector3f.setZero(v1));
    }
    @Test
    void testLengthSquared() {
        assertEquals(14f, Vector3f.lengthSquared(v1));
    }
    @Test
    void failedTestLengthSquared() {
        Vector3f v3 = new Vector3f(1, 5, 9);
        assertNotEquals(v3, Vector3f.lengthSquared(v1));
    }
    @Test
    void testLength(){
        assertEquals(6f, v3.length());
    }
    @Test
    void failedTestLength(){
        float l = 2;
        assertNotEquals(l, v1.length());
    }
    @Test
    void testCross() {
        Vector3f v3 = new Vector3f(0, 0, 0);
        assertEquals(v3, Vector3f.cross(v1, v2));
    }
    @Test
    void failedTestCross() {
        Vector3f v3 = new Vector3f(1, 1, 0);
        assertNotEquals(v3, Vector3f.cross(v1, v2));
    }

}