package Matrix;


public class Matrix4x4 {

    private float[]  m;  // of 16

    /** Construct identity matrix. */
    public Matrix4x4() {
        initialize();
        setIdentity();
    }

    /** Construct with the specified element values. */
    public Matrix4x4(float[] m) {
        initialize();
        set (m);
    }

    /** Constrauct as a copy of the specified matrix.*/
    public Matrix4x4(Matrix4x4 matrix) {
        initialize();
        set (matrix);
    }

    /** with specified values. */
    public Matrix4x4 (float m00, float m01, float m02, float m03,
                      float m10, float m11, float m12, float m13,
                      float m20, float m21, float m22, float m23,
                      float m30, float m31, float m32, float m33)
    {
        initialize();
        set (m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33);
    }

    /** Set the value of this 4x4matrix according to the specified matrix */
    public void set(Matrix4x4 matrix) {
        System.arraycopy(matrix.m, 0, m, 0, 16);
    }

    /** Set the values of this 4x4 matrix. Array of 16 matrix elements, m00, m01, etc. */
    public void set(float[] ma) {
        System.arraycopy(ma, 0, m, 0, 16);
    }

    /** Set the values of this 4x4 matrix. */
    public void set(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33)
    {
        m[0]  = m00;
        m[1]  = m01;
        m[2]  = m02;
        m[3]  = m03;

        m[4]  = m10;
        m[5]  = m11;
        m[6]  = m12;
        m[7]  = m13;

        m[8]  = m20;
        m[9]  = m21;
        m[10] = m22;
        m[11] = m23;

        m[12] = m30;
        m[13] = m31;
        m[14] = m32;
        m[15] = m33;
    }

    /** Return the values of this 4x4 matrix. */
    public float[] get() {
        return m;
    }

    /** Initialize the matrix. */
    private void initialize() {
        m = new float[16];
    }

    public static Matrix4x4 identity() {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.setIdentity();
        return matrix;
    }

    /** Make an identity matrix out of this 4x4 matrix. */
    public void setIdentity() {
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                m[i*4 + j] = (float) (i == j ? 1.0 : 0.0);
    }

    /** Return matrix element [i,j]. */
    public float getElement(int i, int j) {
        return m[i*4 + j];
    }

    /** Set specified matrix element. */
    public void setElement(int i, int j, float value) {
        m[i*4 + j] = value;
    }

    /** Add the specified 4x4 matrix to this matrix. */
    public void add(Matrix4x4 matrix) {
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                m[i*4 + j] += matrix.m[i*4 + j];
    }

    /** Add two matrices and return the result matrix. */
    public static Matrix4x4 add(Matrix4x4 m1, Matrix4x4 m2) {
        Matrix4x4 m = new Matrix4x4 (m1);
        m.add (m2);
        return m;
    }

    /** Multiply matrix with the specified matrix */
    public void multiply(Matrix4x4 matrix) {
        Matrix4x4 product = new Matrix4x4();

        for (int i = 0; i < 16; i += 4) {
            for (int j = 0; j < 4; j++) {
                product.m[i + j] = 0.0F;
                for (int k = 0; k < 4; k++)
                    product.m[i + j] += m[i + k] * matrix.m[k*4 + j];
            }
        }

        set (product);
    }

    /** Multiply two matrices and return the result matrix. */
    public static Matrix4x4 multiply(Matrix4x4 m1, Matrix4x4 m2) {
        Matrix4x4 m = new Matrix4x4 (m1);
        m.multiply (m2);
        return m;
    }

    /** Create a string representation of this matrix. String representing this matrix. */
    public String toString()
    {
        StringBuilder string = new StringBuilder("");

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++)
                string.append(getElement(i, j)).append(" ");
            string.append('\n');
        }

        return string.toString();
    }
}