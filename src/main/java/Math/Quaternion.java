package Math;

/**
 * Quaternions extends a rotation in three dimensions and operations on them
 */
public class Quaternion {
    private float x;
    private float y;
    private float z;
    private float w;

    /**
     * Constructor instantiates a new Quaternion object from the given list of parameters
     * @param x - The x value of the quaternion
     * @param y - The y value of the quaternion
     * @param z - The z value of the quaternion
     * @param w - The w value of the quaternion
     */
    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * This function returns the length of this vector
     * @return The length of this vector
     */
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    /**
     * This function computes the normalized quaternion
     * @return A normalized quaternion.
     */
    public Quaternion normalize() {

        float length = length();

        x /= length;
        y /= length;
        z /= length;
        w /= length;

        return this;
    }

    /**
     * This function sets the value of this quaternion to the normalized value of quaternion q
     * @param q - The quaternion to be normalized
     * @return The normalized quaternion
     */
    public static Quaternion normalize(Quaternion q) {
        float l = q.length();
        return new Quaternion(q.x / l, q.y / l, q.z / l, q.w / l);
    }

    /**
     * This function conjugates this quaternion [-x, -y, -z, w]
     * @return The conjugated quaternion
     */
    public Quaternion conjugate() {
        return new Quaternion(-x, -y, -z, w);
    }

    /**
     * This function sets the value of this quaternion to the conjugate of quaternion q
     * @param q - The source vector
     * @return The conjugated quaternion
     */
    public static Quaternion conjugate(Quaternion q) {
        return new Quaternion(-q.x, -q.y, -q.z, q.w);
    }

    /**
     * This function returns the Hamilton product of the instance by a quaternion
     * @param r - Quaternion
     * @return The product of this instance with r, in that order
     */
    public Quaternion mul(Quaternion r) {
        final float a11 = r.getX();
        final float a12 = r.getY();
        final float a13 = r.getZ();
        final float a14 = r.getW();

        final float W = w * a14 - x * a11 - y * a12 - z * a13;
        final float X = x * a14 + w * a11 + y * a13 - z * a12;
        final float Y = y * a14 + w * a12 + z * a11 - x * a13;
        final float Z = z * a14 + w * a13 + x * a12 - y * a11;

        return new Quaternion(X, Y, Z, W);
    }

    /**
     * This function calculates the Hamilton product of two quaternions
     * @param a1 - First quaternion
     * @param a2 - Second quaternion
     * @return The product a1 and a2, in that order
     */
    public static Quaternion mul(Quaternion a1, Quaternion a2) {
        // Components of the first quaternion.
        final float a11 = a1.getX();
        final float a12 = a1.getY();
        final float a13 = a1.getZ();
        final float a14 = a1.getW();

        // Components of the second quaternion.
        final float a21 = a2.getX();
        final float a22 = a2.getY();
        final float a23 = a2.getZ();
        final float a24 = a2.getW();

        //Component of the product
        final float W = a24 * a14 - a21 * a11 - a22 * a12 - a23 * a13;
        final float X = a21 * a14 + a24 * a11 + a22 * a13 - a23 * a12;
        final float Y = a22 * a14 + a24 * a12 + a23 * a11 - a21 * a13;
        final float Z = a23 * a14 + a24 * a13 + a21 * a12 - a22 * a11;

        return new Quaternion(X, Y, Z, W);
    }

    /**
     * This function multiplies this quaternion by a parameter vector
     * @param r - The vector to multiply this quaternion by
     * @return The vector to multiply this quaternion by
     */
    public Quaternion mul(Vector3f r) {
        float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
        float x_ = w * r.getX() + y * r.getZ() - z * r.getY();
        float y_ = w * r.getY() + z * r.getX() - x * r.getZ();
        float z_ = w * r.getZ() + x * r.getY() - y * r.getX();

        return new Quaternion(x_, y_, z_, w_);
    }

    /**
     * Function that compares the current quaternion to the object, returns true if the object is an instance of a quaternion and values are equal
     * @param v - The object to compare for equality
     * @return True if this quaternion and the provided quaternion have roughly the same x, y, z and w values
     */
    public boolean equals(Object v) {
        float epsilon = 0.0001f;
        if (v instanceof Quaternion) {
            return Math.abs(this.x - ((Quaternion) v).x) < epsilon && Math.abs(this.y - ((Quaternion) v).y) < epsilon
                    && Math.abs(this.z - ((Quaternion) v).z) < epsilon && Math.abs(this.w - ((Quaternion) v).w) < epsilon;
        }
        return false;
    }

    /**
     * Getter function, which returns the first vector value of the quaternion
     * @return the first vector value of the Quaternion
     */
    public float getX() {
        return x;
    }

    /**
     * Setter function, which sets the first vector value of the quaternion
     * @param x - the desired first vector value to be set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Getter function, which returns the second vector value of the quaternion
     * @return the second vector value of the quaternion
     */
    public float getY() {
        return y;
    }

    /**
     * Setter function, which sets the second vector value of the quaternion
     * @param y - the desired second vector value to be set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Getter function, which returns the second vector value of the quaternion
     * @return the third vector value of the quaternion
     */
    public float getZ() {
        return z;
    }

    /**
     * Setter function, which sets the third vector value of the quaternion
     * @param z - the desired third vector value to be set
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * Getter function, which gets the scalar value of the quaternion
     * @return the scalar value
     */
    public float getW() {
        return w;
    }

    /**
     * Setter function, which sets the scalar value of the quaternion
     * @param w - the desired scalar value to be set
     */
    public void setW(float w) {
        this.w = w;
    }
}
