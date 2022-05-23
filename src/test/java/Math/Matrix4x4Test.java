package Math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class Matrix4x4Test {
    Matrix4x4 matrix1;
    Matrix4x4 matrix2;

    @BeforeEach
    void init() {
        matrix1 = new Matrix4x4(new float[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0}
        });
        matrix2 = new Matrix4x4(new float[][]{
                {2, 0, 2, 0},
                {2, 0, 2, 0},
                {2, 0, 2, 0},
                {2, 0, 2, 0}
        });
    }

    @Test
    void testInitIdentity() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
        matrix1.InitIdentity();
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitIdentity() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1}
        });
        matrix1.InitIdentity();
        assertNotEquals(matrix3, matrix1);
    }

    @Test
    void testInitTranslation() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
        matrix1.InitTranslation(0, 0, 0);
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitTranslation() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 1}
        });
        matrix1.InitTranslation(0, 0, 0);
        assertNotEquals(matrix3, matrix1);
    }

    @Test
    void testInitScale() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
        matrix1.InitScale(1, 1, 1);
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitScale() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 1}
        });
        matrix1.InitScale(1, 1, 1);
        assertNotEquals(matrix3, matrix1);
    }

    @Test
    void testInitPerspective() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {(float) (1f / 1.55740772), 0, 0, 0},
                {0, (float) (1f / 1.55740772), 0, 0},
                {0, 0, 0, 2f},
                {0, 0, 1f, 0}
        });
        matrix1.InitPerspective(2, 1, -2, 2);
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitPerspective() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {(float) (1f / 1.55240772), 0, 0, 0},
                {0, (float) (1f / 1.53740772), 0, 0},
                {0, 0, 0, 2f},
                {0, 0, 1f, 0}
        });
        matrix1.InitPerspective(2, 1, -2, 2);
        assertNotEquals(matrix3, matrix1);
    }

//    @Test
//    void testInitFloatRotation() {
//        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
//                { 9.997E-1f, -1.775E-2f, -1.714E-2f, 0.000E+0f},
//                {1.745E-2f, 9.997E-1f, -1.775E-2f, 0.000E+0f},
//                {1.745E-2f , 1.745E-2f, 9.997E-1f, 0.000E+0f},
//                {0.000E+0f, 0.000E+0f, 0.000E+0f, 1.000E+0f}
//        });
//        assertEquals(matrix3, matrix1.InitRotation(1, 1, 1));
//    }

    @Test
    void testRotation() {
        Vector3f f = new Vector3f(1, 1, 1);
        Vector3f u = new Vector3f(1, 1, 1);
        assertEquals(matrix1, matrix1.InitRotation(f, u));
    }

    @Test
    void testInitOrthographic() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, -3},
                {0, 1, 0, -3},
                {0, 0, -1, -3},
                {0, 0, 0, 1}
        });
        matrix1.InitOrthographic(2, 4, 2, 4, 2, 4);
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitOrthographic() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, -3},
                {0, 1, 0, -3},
                {0, 0, -1, 3},
                {0, 0, 0, 1}
        });
        matrix1.InitOrthographic(2, 4, 2, 4, 2, 4);
        assertNotEquals(matrix3, matrix1);
    }

    @Test
    void testInitRotation() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 2, 3, 0},
                {2, 3, 4, 0},
                {3, 4, 5, 0},
                {0, 0, 0, 1}
        });
        Vector3f r = new Vector3f(1, 2, 3);
        Vector3f u = new Vector3f(2, 3, 4);
        Vector3f f = new Vector3f(3, 4, 5);

        matrix1.InitRotation(f, u, r);
        assertEquals(matrix3, matrix1);
    }

    @Test
    void failedTestInitRotation() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 2, 3, 0},
                {2, 3, 4, 0},
                {3, 4, 5, 0},
                {0, 0, 1, 1}
        });
        Vector3f r = new Vector3f(1, 2, 3);
        Vector3f u = new Vector3f(2, 3, 4);
        Vector3f f = new Vector3f(3, 4, 5);

        matrix1.InitRotation(f, u, r);
        assertNotEquals(matrix3, matrix1);
    }

    @Test
    void testTransform() {
        Vector3f r = new Vector3f(1, 1, 1);
        Vector3f m1 = new Vector3f(2f, 2f, 2f);
        Vector3f m2 = new Vector3f(matrix1.Transform(r));
        assertEquals(m2, m1);
    }

    @Test
    void failedTestTransform() {
        Vector3f r = new Vector3f(1, 1, 1);
        Vector3f m1 = new Vector3f(21f, 2f, 2f);
        Vector3f m2 = new Vector3f(matrix1.Transform(r));
        assertNotEquals(m2, m1);
    }

    @Test
    void testMulMatrix() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {4, 0, 4, 0},
                {4, 0, 4, 0},
                {4, 0, 4, 0},
                {4, 0, 4, 0}
        });
        assertEquals(matrix3, matrix1.Mul(matrix2));
    }

    @Test
    void testGetM() {
        float[][] matrix3 = new float[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0}
        };
        assertArrayEquals(matrix3, matrix1.GetM());
    }

    @Test
    void testGet() {
        Assertions.assertEquals(0f, matrix1.Get(3, 3));
    }

    @Test
    void testSetMatrix() {
        Matrix4x4 matrix3 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 1},
                {0, 0, 1, 1}
        });
        matrix1.SetM(new float[][]{{1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 1},
                {0, 0, 1, 1}
        });
        assertEquals(matrix3, matrix1);
    }
}


