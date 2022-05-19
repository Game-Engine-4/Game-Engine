package Math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

}


