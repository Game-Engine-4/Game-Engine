package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

class Vector3fTest {
    Vector3f v1;
    Vector3f v2;

    @BeforeEach
    void init() {
        v1 = new Vector3f(1, 2, 3);
        v2 = new Vector3f(2, 4, 6);
    }

    @Test
    void distance() {
    }

    @Test
    void testAdd() {
        Vector3f v3 = new Vector3f(3, 6, 9);
        assertEquals(v3, Vector3f.add(v1, v2));
    }
    @Test
    void failedTestAdd() {
        Vector3f v3 = new Vector3f(3, 5, 9);
        assertEquals(v3, Vector3f.add(v1, v2));
    }

    @Test
    void testSub() {
        Vector3f v3 = new Vector3f(1, 2, 3);
        assertEquals(v3, Vector3f.sub(v2, v1));

    }
    @Test
    void failedTestSub() {
        Vector3f v3 = new Vector3f(0, 1, 2);
        assertEquals(v3, Vector3f.sub(v2, v1));
    }

    @Test
    void testMul() {
        Vector3f v3 = new Vector3f(2, 4, 6);
        assertEquals(v3, Vector3f.mul(v1, 2));

    }
    @Test
    void failedTestMul() {
        Vector3f v3 = new Vector3f(2, 4, 9);
        assertEquals(v3, Vector3f.mul(v1, 2));
    }

    @Test
    void testDiv() {
        Vector3f v3 = new Vector3f( 1, 2, 3);
        assertEquals(v3, Vector3f.div(v2, 2));
    }
    @Test
    void failedTestDiv() {
        Vector3f v3 = new Vector3f( 2, 4, 3);
        assertEquals(v3, Vector3f.div(v2, 2));
    }

    @Test
    void testDot(){
        Vector3f v3 = new Vector3f(2, 8, 18);
        assertEquals(v3, Vector3f.dot(v1,v2));
    }
    @Test
    void failedTestDot(){
        Vector3f v3 = new Vector3f(3f, 5f, 15f);
        assertEquals(v3, Vector3f.dot(v1,v2));
    }
    @Test
    void testNormalize() {
        Vector3f v3 = new Vector3f(1/3f, 2/3f, 1);
        assertEquals(v3, Vector3f.normalize(v1));
    }
    @Test
    void failedTestNormalize() {
        Vector3f v3 = new Vector3f(1/3, 2/3, 1/5);
        assertEquals(v3, Vector3f.normalize(v1));
    }
    @Test
    void testSetZero() {
        Vector3f v3 = new Vector3f(0,0,0);
        assertEquals(v3, Vector3f.setZero(v1));
    }
    @Test
    void failedTestSetZero() {
        Vector3f v3 = new Vector3f(0,1,0);
        assertEquals(v3, Vector3f.setZero(v1));
    }
    @Test
    void testLengthSquared() {
        Vector3f v3 = new Vector3f(1, 4, 9);
        assertEquals(v3, Vector3f.lengthSquared(v1));
    }
    @Test
    void failedTestLengthSquared() {
        Vector3f v3 = new Vector3f(1, 5, 9);
        assertEquals(v3, Vector3f.lengthSquared(v1));
    }
    @Test
    void testLength(){
        float l = 3;
        assertEquals(l, v1.length());
    }
    @Test
    void failedTestLength(){
        float l = 2;
        assertEquals(l, v1.length());
    }
    @Test
    void testCross() {
        Vector3f v3 = new Vector3f(0, 0, 0);
        assertEquals(v3, Vector3f.cross(v1, v2));
    }
    @Test
    void failedTestCross() {
        Vector3f v3 = new Vector3f(1, 1, 0);
        assertEquals(v3, Vector3f.cross(v1, v2));
    }

}