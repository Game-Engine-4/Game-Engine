package Math;

public class Quaternion {

    private float x;
    private float y;
    private float z;
    private float w;

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }


    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Quaternion normalize() {

        float length = length();

        x /= length;
        y /= length;
        z /= length;
        w /= length;

        return this;
    }

    public static Quaternion normalize(Quaternion q) {
        float l = q.length();
        return new Quaternion(q.x / l, q.y / l, q.z / l, q.w / l);
    }

    public Quaternion conjugate() {
        return new Quaternion(-x, -y, -z, w);
    }

    public static Quaternion conjugate(Quaternion q) {
        return new Quaternion(-q.x, -q.y, -q.z, q.w);
    }


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

    public Quaternion mul(Vector3f r) {
        float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
        float x_ = w * r.getX() + y * r.getZ() - z * r.getY();
        float y_ = w * r.getY() + z * r.getX() - x * r.getZ();
        float z_ = w * r.getZ() + x * r.getY() - y * r.getX();

        return new Quaternion(x_, y_, z_, w_);
    }

    public boolean equals(Object v) {
        float epsilon = 0.0001f;
        if (v instanceof Quaternion) {
            return Math.abs(this.x - ((Quaternion) v).x) < epsilon && Math.abs(this.y - ((Quaternion) v).y) < epsilon
                    && Math.abs(this.z - ((Quaternion) v).z) < epsilon && Math.abs(this.w - ((Quaternion) v).w) < epsilon;
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}
