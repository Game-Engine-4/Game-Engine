package Quaternion;

import Vectors.Vector3;

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

        x = x / length;
        y = y / length;
        z = z / length;
        w = w / length;

        return this;
    }

    public Quaternion conjugate() {
        return new Quaternion(x, -y, -z, -w);
    }

    public Quaternion mul(Quaternion a1, Quaternion a2) {
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
        final float X = a11 * a22 + a12 * a21 + a13 * a24 - a14 * a23;
        final float Y = a11 * a23 - a12 * a24 + a13 * a21 + a14 * a22;
        final float Z = a11 * a24 + a12 * a23 - a13 * a22 + a14 * a21;
        final float W = a11 * a21 - a12 * a22 - a13 * a23 - a14 * a24;

        return new Quaternion(X, Y, Z, W);

    }

    public Quaternion mul(Vector3 r) {
        float W = -x * r.getX() - y * r.getY() - z * r.getZ();
        float X =  w * r.getX() + y * r.getZ() - z * r.getY();
        float Y =  w * r.getY() + z * r.getX() - x * r.getZ();
        float Z =  w * r.getZ() + x * r.getY() - y * r.getX();

        return new Quaternion(X, Y, Z, W);
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
