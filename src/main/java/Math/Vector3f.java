package Math;

import org.joml.Math;

public class Vector3f {

    private float x;
    private float y;
    private float z;

    public Vector3f() {
    }

    public Vector3f(float d) {
        //    the value of all three component
        this.x = d;
        this.y = d;
        this.z = d;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(Vector3f v) {
        //    Create a new vector with the same values as another
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public static float distanceSquared(Vector3f v1, Vector3f v2) {
        float x = v1.x - v2.x;
        float y = v1.y - v2.y;
        float z = v1.z - v2.z;
        return x * x + y * y + z * z;
    }

    public static float distance(Vector3f v1, Vector3f v2) {
        return Math.sqrt(distanceSquared(v1, v2));
    }

    public static Vector3f add(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static Vector3f sub(Vector3f v2, Vector3f v1) {
        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public Vector3f add(float dx, float dy, float dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
        return this;
    }

    public Vector3f add(final Vector3f v) {
        return this.add(v.x, v.y, v.z);
    }

    public Vector3f sub(final Vector3f v) {
        return this.sub(v.x, v.y, v.z);
    }

    public Vector3f sub(float dx, float dy, float dz) {
        this.x -= dx;
        this.y -= dy;
        this.z -= dz;
        return this;
    }

    public Vector3f mul(Vector3f v) {
        this.x = x * v.x;
        this.y = y * v.y;
        this.z = z * v.z;
        return this;
    }

    public static Vector3f mul(Vector3f v, float sc) {
        return new Vector3f(v.x * sc, v.y * sc, v.z * sc);
    }

    public Vector3f mul(Vector3f v, Vector3f dest) {
        dest.x = x * v.x;
        dest.y = y * v.y;
        dest.z = z * v.z;
        return dest;
    }

    public Vector3f div(Vector3f v) {
        this.x = this.x / v.x;
        this.y = this.y / v.y;
        this.z = this.z / v.z;
        return this;
    }

    public Vector3f div(Vector3f v, Vector3f dest) {
        dest.x = x / v.x;
        dest.y = y / v.y;
        dest.z = z / v.z;
        return dest;
    }
    public static Vector3f div(Vector3f v, float sc) {
        return new Vector3f(v.x / sc, v.y / sc, v.z / sc);
    }


    public float dot(Vector3f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public static Vector3f dot(Vector3f v2, Vector3f v1) {
        return new Vector3f(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
    }

    public Vector3f normalize() {
        float l = this.length();
        if (l != 0) {
            this.x /= l;
            this.y /= l;
            this.z /= l;
        }
        return this;
    }
    public static Vector3f normalize(Vector3f v) {
        float l = v.length();
        return new Vector3f(v.x / l, v.y / l, v.z / l);
    }

    public float angle(Vector3f v) {
        float dls = dot(v) / (this.length() * v.length());
        if (dls < -1.0f)
            dls = -1.0f;
        else if (dls > 1.0f)
            dls = 1.0f;
        return Math.acos(dls);
    }

    public Vector3f setZero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }
    public static Vector3f setZero(Vector3f v) {
        return new Vector3f(0,0,0);
    }

    public Vector3f set(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    public Vector3f set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vector3f set(float[] array) {
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
        return this;
    }

    public float lengthSquared() {
        return (this.x * this.x + this.y * this.y + this.z * this.z);
    }
    public static Vector3f lengthSquared(Vector3f v) {
        return new Vector3f(v.x * v.x, v.y * v.y, v.z * v.z);
    }

    public float length() {
        return Math.sqrt(this.lengthSquared());
    }

    public Vector3f cross(Vector3f v) {
        //    Calculates the vector cross product of this vector and the given vector
        float a = this.y * v.z - this.z * v.y;
        float b = this.z * v.x - this.x * v.z;
        float c = this.x * v.y - this.y * v.x;

        this.x = a;
        this.y = b;
        this.z = c;

        return this;
    }

    public static Vector3f cross(Vector3f a, Vector3f b) {
        //    Calculates the vector cross product of the two given vectors.
        return new Vector3f(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    public Vector3f rotateX(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        this.y = k;
        this.z = t;
        return this;
    }

    public Vector3f rotateX(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = k;
        dest.z = t;
        return dest;
    }

    public Vector3f rotateY(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        this.x = k;
        this.z = t;
        return this;
    }

    public Vector3f rotateY(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        dest.x = k;
        dest.y = this.y;
        dest.z = t;
        return dest;
    }

    public Vector3f rotateZ(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        this.x = k;
        this.y = t;
        return this;
    }

    public Vector3f rotateZ(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        dest.x = k;
        dest.y = t;
        dest.z = this.z;
        return dest;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

}


