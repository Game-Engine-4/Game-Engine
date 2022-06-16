package Math;

/**
 * This is the Matrix4x4 class, it contains the definition of a 4x4 matrix, and associated functions to transform it.
 */
public class Matrix4x4 {
    private float[][] m;

    public Matrix4x4() {
        m = new float[4][4];
    }

    public Matrix4x4(float[][] m) {
        this.m = m;
    }

    /**
     * This function turns this Matrix4x4 into an identity matrix
     * @return Returns an identity matrix
     */
    public Matrix4x4 InitIdentity() {
        m[0][0] = 1;
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = 0;
        m[1][0] = 0;
        m[1][1] = 1;
        m[1][2] = 0;
        m[1][3] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = 1;
        m[2][3] = 0;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 1;

        return this;
    }

    /**
     * This function calculates and returns a translation Matrix4x4 with the given parameters
     * @param x 0 row 3 column element of the matrix
     * @param y 1 row 3 column element of the matrix
     * @param z 2 row 3 column of the matrix
     * @return Returns the translation Matrix4x4 with the given parameters
     */
    public Matrix4x4 InitTranslation(float x, float y, float z) {
        m[0][0] = 1;
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = x;
        m[1][0] = 0;
        m[1][1] = 1;
        m[1][2] = 0;
        m[1][3] = y;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = 1;
        m[2][3] = z;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 1;

        return this;
    }

    /**
     * This function calculates and returns a rotation matrix with the given parameters
     * @param x Parameter to calculate 11,12,21,22 elements of the first matrix
     * @param y Parameter to calculate 00,02,20,22 elements of the second matrix
     * @param z Parameter to calculate 00,01,10,11 elements of the third matrix
     * @return Returns the rotation Matrix4x4 calculated with the given parameters
     */
    public Matrix4x4 InitRotation(float x, float y, float z) {
        Matrix4x4 rx = new Matrix4x4();
        Matrix4x4 ry = new Matrix4x4();
        Matrix4x4 rz = new Matrix4x4();

        x = (float) Math.toRadians(x);
        y = (float) Math.toRadians(y);
        z = (float) Math.toRadians(z);

        rz.m[0][0] = (float) Math.cos(z);
        rz.m[0][1] = -(float) Math.sin(z);
        rz.m[0][2] = 0;
        rz.m[0][3] = 0;
        rz.m[1][0] = (float) Math.sin(z);
        rz.m[1][1] = (float) Math.cos(z);
        rz.m[1][2] = 0;
        rz.m[1][3] = 0;
        rz.m[2][0] = 0;
        rz.m[2][1] = 0;
        rz.m[2][2] = 1;
        rz.m[2][3] = 0;
        rz.m[3][0] = 0;
        rz.m[3][1] = 0;
        rz.m[3][2] = 0;
        rz.m[3][3] = 1;

        rx.m[0][0] = 1;
        rx.m[0][1] = 0;
        rx.m[0][2] = 0;
        rx.m[0][3] = 0;
        rx.m[1][0] = 0;
        rx.m[1][1] = (float) Math.cos(x);
        rx.m[1][2] = -(float) Math.sin(x);
        rx.m[1][3] = 0;
        rx.m[2][0] = 0;
        rx.m[2][1] = (float) Math.sin(x);
        rx.m[2][2] = (float) Math.cos(x);
        rx.m[2][3] = 0;
        rx.m[3][0] = 0;
        rx.m[3][1] = 0;
        rx.m[3][2] = 0;
        rx.m[3][3] = 1;

        ry.m[0][0] = (float) Math.cos(y);
        ry.m[0][1] = 0;
        ry.m[0][2] = (float) Math.sin(y);
        ry.m[0][3] = 0;
        ry.m[1][0] = 0;
        ry.m[1][1] = 1;
        ry.m[1][2] = 0;
        ry.m[1][3] = 0;
        ry.m[2][0] = -(float) Math.sin(y);
        ry.m[2][1] = 0;
        ry.m[2][2] = (float) Math.cos(y);
        ry.m[2][3] = 0;
        ry.m[3][0] = 0;
        ry.m[3][1] = 0;
        ry.m[3][2] = 0;
        ry.m[3][3] = 1;

        m = rz.Mul(ry.Mul(rx)).getM();

        return this;
    }

    /**
     * This function calculates and returns rotation matrix with the given parameters of the camera
     * @param forward The forward direction vector of the camera
     * @param up The upward direction vector of the camera
     * @return Returns rotation matrix
     */
    public Matrix4x4 InitRotation(Vector3f forward, Vector3f up) {
        Vector3f f = forward.normalize();

        Vector3f r = up.normalize();
        r = r.cross(f);

        Vector3f u = f.cross(r);

        return InitRotation(f, u, r);
    }

    /**
     * This function calculates and returns rotation matrix with the given parameters of the camera
     * @param forward The forward direction vector of the camera
     * @param up The upward direction vector of the camera
     * @param right The right direction vector of the camera
     * @return Returns rotation matrix
     */
    public Matrix4x4 InitRotation(Vector3f forward, Vector3f up, Vector3f right) {
        Vector3f f = forward;
        Vector3f r = right;
        Vector3f u = up;

        m[0][0] = r.getX();
        m[0][1] = r.getY();
        m[0][2] = r.getZ();
        m[0][3] = 0;
        m[1][0] = u.getX();
        m[1][1] = u.getY();
        m[1][2] = u.getZ();
        m[1][3] = 0;
        m[2][0] = f.getX();
        m[2][1] = f.getY();
        m[2][2] = f.getZ();
        m[2][3] = 0;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 1;

        return this;
    }

    /**
     * This function calculates and returns a scale matrix with the given parameters
     * @param x 0 row 0 column element of the matrix
     * @param y 1 row 1 column element of the matrix
     * @param z 2 row 2 column element of the matrix
     * @return Returns a Matrix4x4 with x,y,z,1 on the main diagonal
     */
    public Matrix4x4 InitScale(float x, float y, float z) {
        m[0][0] = x;
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = 0;
        m[1][0] = 0;
        m[1][1] = y;
        m[1][2] = 0;
        m[1][3] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = z;
        m[2][3] = 0;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 1;

        return this;
    }

    /**
     * This function calculates and returns the perspective matrix for given parameters
     * @param fov the field of view
     * @param aspectRatio the aspect ratio
     * @param zFar the maximum view distance
     * @param zNear the minimum view distance
     * @return Returns the perspective Matrix4x4 for given parameters
     */
    public Matrix4x4 InitPerspective(float fov, float aspectRatio, float zNear, float zFar) {
        float tanHalfFOV = (float) Math.tan(fov / 2);
        float zRange = zNear - zFar;

        m[0][0] = 1.0f / (tanHalfFOV * aspectRatio);
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = 0;
        m[1][0] = 0;
        m[1][1] = 1.0f / tanHalfFOV;
        m[1][2] = 0;
        m[1][3] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = (-zNear - zFar) / zRange;
        m[2][3] = 2 * zFar * zNear / zRange;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 1;
        m[3][3] = 0;

        return this;
    }

    /**
     * This function calculates and returns the projection matrix for given parameters of a camera
     * @param fov The field of view
     * @param width The parameter for width
     * @param height The parameter for height
     * @param zFar The maximum view distance
     * @param zNear The minimum view distance
     * @return Returns the projection Matrix4x4 for given parameters of a camera
     */
    public Matrix4x4 InitProjection(float fov, float width, float height, float zNear, float zFar) {
        float ar = width / height;
        float tanHalfFOV = (float) Math.tan((fov / 2));
        float zRange = zNear - zFar;

        m[0][0] = 1.0f / (tanHalfFOV * ar);
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = 0;
        m[1][0] = 0;
        m[1][1] = 1.0f / tanHalfFOV;
        m[1][2] = 0;
        m[1][3] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = (-zNear - zFar) / zRange;
        m[2][3] = 2 * zFar * zNear / zRange;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 1;
        m[3][3] = 0;

        return this;
    }

    /**
     * This function calculates and returns camera matrix for given parameters of camera
     * @param forward The forward direction vector of the camera
     * @param up The upward direction vector of the camera
     * @return Returns the camera matrix
     */
    public Matrix4x4 InitCamera(Vector3f forward, Vector3f up) {
        Vector3f f = forward;
        f.normalize();

        Vector3f r = up;
        r.normalize();
        r = r.cross(f);

        Vector3f u = f.cross(r);

        m[0][0] = r.getX();
        m[0][1] = r.getY();
        m[0][2] = r.getZ();
        m[0][3] = 0;
        m[1][0] = u.getX();
        m[1][1] = u.getY();
        m[1][2] = u.getZ();
        m[1][3] = 0;
        m[2][0] = f.getX();
        m[2][1] = f.getY();
        m[2][2] = f.getZ();
        m[2][3] = 0;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 1;

        return this;
    }

    /**
     * This function multiplies the current Matrix4x4 with a second Matrix4x4
     * @param r The Matrix4x4 to multiply by
     * @return Returns the product of the multiplication
     */
    public Matrix4x4 Mul(Matrix4x4 r) {
        Matrix4x4 res = new Matrix4x4();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res.Set(i, j, m[i][0] * r.Get(0, j) +
                        m[i][1] * r.Get(1, j) +
                        m[i][2] * r.Get(2, j) +
                        m[i][3] * r.Get(3, j));
            }
        }

        return res;
    }

    /**
     * This function compares the current Matrix4x4 with another object, returns true if they are equal, false otherwise
     * @param obj the object to compare to
     * @return Returns true if the object is a Matrix4x4 and the value are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        float epsilon = 0.000001f;
        if (obj instanceof Matrix4x4) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Math.abs(this.Get(i, j) - ((Matrix4x4) obj).Get(i, j)) > epsilon) {
                        if (!((((Matrix4x4) obj).Get(i, j) == -0f && this.Get(i, j) == 0f) || ((Matrix4x4) obj).Get(i, j) == 0f && this.Get(i, j) == -0f)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * This function creates new matrix with same attributes
     * @return Returns matrix
     */
    public float[][] GetM() {
        float[][] res = new float[4][4];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                res[i][j] = m[i][j];

        return res;
    }

    /**
     * This function returns specific elements of the matrix
     * @param x The x coordinate
     * @param y The y coordinate
     * @return Returns the element on the specified coordinates
     */
    public float Get(int x, int y) {
        return m[x][y];
    }

    /**
     * This function sets matrix
     * @param m This is the matrix that we want to set
     */
    public void SetM(float[][] m) {
        this.m = m;
    }

    /**
     * This function returns the matrix attribbute
     * @return
     */
    public float[][] getM() {
        return m;
    }

    /**
     * This function assigns specified value to the specified element of the matrix
     * @param x The x coordinate
     * @param y The y coordinate
     * @param value The value that needs to be assigned
     */
    public void Set(int x, int y, float value) {
        m[x][y] = value;
    }
}
