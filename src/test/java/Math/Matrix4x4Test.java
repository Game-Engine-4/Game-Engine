package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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
}