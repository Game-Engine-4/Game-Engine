package Vectors;

import org.joml.*;
import org.joml.Math;

public class Vector3 {
    public float x;
    public float y;
    public float z;

    public Vector3() {
    }

    public Vector3(float d) {
        //    the value of all three component
        this.x = d;
        this.y = d;
        this.z = d;
    }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 v) {
        //    Create a new vector with the same values as another
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public static float distanceSquared(Vector3 v1, Vector3 v2) {
        float x = v1.x - v2.x;
        float y = v1.y - v2.y;
        float z = v1.z - v2.z;
        return x*x + y*y + z*z;
    }

    public static float distance(Vector3 v1, Vector3 v2) {
        return (float)Math.sqrt(distanceSquared(v1, v2));
    }

    public Vector3 add(float dx, float dy, float dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
        return this;
    }

    public Vector3 add(final Vector3 v) {
        return this.add(v.x, v.y, v.z);
    }

    public Vector3 sub(final Vector3 v) {
        return this.sub(v.x, v.y, v.z);
    }

    public Vector3 sub(float dx, float dy, float dz) {
        this.x -= dx;
        this.y -= dy;
        this.z -= dz;
        return this;
    }

    public Vector3 mul(Vector3 v) {
        this.x = x * v.x;
        this.y = y * v.y;
        this.z = z * v.z;
        return this;
    }

    public Vector3 mul(Vector3 v, Vector3 dest) {
        dest.x = x * v.x;
        dest.y = y * v.y;
        dest.z = z * v.z;
        return dest;
    }

    public Vector3 div(Vector3 v) {
        this.x = this.x / v.x;
        this.y = this.y / v.y;
        this.z = this.z / v.z;
        return this;
    }

    public Vector3 div(Vector3 v, Vector3 dest) {
        dest.x = x / v.x;
        dest.y = y / v.y;
        dest.z = z / v.z;
        return dest;
    }

    public float dot(Vector3 v)
    {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vector3 normalize() {
        float l = this.length();
        if (l != 0)
        {
            this.x /= l;
            this.y /= l;
            this.z /= l;
        }
        return this;
    }

    public float angle(Vector3 v) {
        float dls = dot(v) / (this.length() * v.length());
        if (dls < -1.0f)
            dls = -1.0f;
        else if (dls > 1.0f)
            dls = 1.0f;
        return (float)Math.acos(dls);
    }

    public Vector3 setZero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    public Vector3 set(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    public Vector3 set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vector3 set(float[] array) {
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
        return this;
    }

    public float lengthSquared() {
        return (this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public float length() {
        return (float)Math.sqrt(this.lengthSquared());
    }

    public Vector3 cross(Vector3 v) {
        //    Calculates the vector cross product of this vector and the given vector
        float a = this.y * v.z - this.z * v.y;
        float b = this.z * v.x - this.x * v.z;
        float c = this.x * v.y - this.y * v.x;

        this.x = a;
        this.y = b;
        this.z = c;

        return this;
    }

    public static Vector3 cross(Vector3 a, Vector3 b) {
        //    Calculates the vector cross product of the two given vectors.
        return new Vector3(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    public Vector3 rotateX(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        this.y = k;
        this.z = t;
        return this;
    }

    public Vector3 rotateX(float angle, Vector3 dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = k;
        dest.z = t;
        return dest;
    }

    public Vector3 rotateY(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        this.x = k;
        this.z = t;
        return this;
    }

    public Vector3 rotateY(float angle, Vector3 dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k =  this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        dest.x = k;
        dest.y = this.y;
        dest.z = t;
        return dest;
    }

    public Vector3 rotateZ(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        this.x = k;
        this.y = t;
        return this;
    }

    public Vector3 rotateZ(float angle, Vector3 dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        dest.x = k;
        dest.y = t;
        dest.z = this.z;
        return dest;
    }

}

