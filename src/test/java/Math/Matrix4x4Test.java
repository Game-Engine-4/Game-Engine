package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class Matrix4x4Test {
    Matrix4x4 matrix1;
    Matrix4x4 matrix2;
    @BeforeEach
    void init(){
        matrix1 = new Matrix4x4(0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2);
        matrix2 = new Matrix4x4(0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1);
    }

    @Test
    void testSetIdentity() {
        Matrix4x4 matrix3 = new Matrix4x4(1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,01);
        matrix1.setIdentity();
        assertEquals(matrix3, matrix1);
    }

    @Test
    void testAdd() {
        Matrix4x4 matrix3 = new Matrix4x4(0,3,0,3,0,3,0,3,0,3,0,3,0,3,0,3);
        assertEquals(matrix3, Matrix4x4.add(matrix1,matrix2));
    }

    @Test
    void testMultiply() {
        Matrix4x4 matrix3 = new Matrix4x4(0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4);
        assertEquals(matrix3, Matrix4x4.multiply(matrix1, matrix2));
    }
}