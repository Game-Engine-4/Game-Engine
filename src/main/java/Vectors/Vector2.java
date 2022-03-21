package Vectors;

import org.joml.Math;

public class Vector2 {
    public float x;
    public float y;

    /** Contructs vector with x&y component of zero. */
    public Vector2() {
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 other) {
        this.set(other);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void setZero() {
        x = 0;
        y = 0;
    }

    public float length() {
        return Math.sqrt(x * x + y * y);
    }

    public float magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2 normalize() {
        float magnitude = magnitude();

        if(magnitude != 0) {
            this.x /= magnitude;
            this.y /= magnitude;
        }

        return this;
    }

    public Vector2 getNormalized() {
        float magnitude = magnitude();
        return new Vector2(x / magnitude, y / magnitude);
    }

    public static Vector2 toCartesian(float magnitude, float angle) {
        return new Vector2(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    public void rotateBy(float angle) {
        float cos = Math.cos(angle);
        float sin = Math.sin(angle);
        float rx = x * cos - y * sin;
        y = x * sin + y * cos;
        x = rx;
    }

    public Vector2 getRotatedBy(float angle) {
        float cos = Math.cos(angle);
        float sin = Math.sin(angle);
        return new Vector2(x * cos - y * sin, x * sin + y * cos);
    }

    public void rotateTo(float angle) {
        set(toCartesian(length(), angle));
    }

    public Vector2 getRotatedTo(float angle) {
        return toCartesian(length(), angle);
    }

    public float getAngle() {
        return Math.atan2(y, x);
    }

    public float dot(Vector2 v) {
        return (this.x * v.x + this.y * v.y);
    }

    public float dot(float vx, float vy) {
        return (this.x * vx + this.y * vy);
    }

    public static float dot(Vector2 v1, Vector2 v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public float cross(Vector2 v) {
        return (this.x * v.y - this.y * v.x);
    }

    public float cross(float vx, float vy) {
        return (this.x * vy - this.y * vx);
    }

    public static float cross(Vector2 v1, Vector2 v2) {
        return (v1.x * v2.y - v1.y * v2.x);
    }

    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;

        return this;
    }

    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Vector2 add(float amount) {
        this.x += amount;
        this.y += amount;

        return this;
    }

    public Vector2 sub(float amount) {
        this.x -= amount;
        this.y -= amount;

        return this;
    }

    public Vector2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;

        return this;
    }

    public Vector2 sub(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;

        return this;
    }

    public Vector2 mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;

        return this;
    }

    public Vector2 mul(Vector2 other) {
        this.x *= other.x;
        this.y *= other.y;

        return this;
    }

    public Vector2 div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;

        return this;
    }

    public Vector2 div(Vector2 other) {
        this.x /= this.x;
        this.y /= this.y;

        return this;
    }

    public float distance(Vector2 other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;

        return (float)Math.sqrt(distX*distX + distY*distY);
    }

    public float distance(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;

        return (float)Math.sqrt(distX*distX + distY*distY);
    }

    public float distSquared(Vector2 other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;

        return distX*distX + distY*distY;
    }

    public float distSquared(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;

        return distX*distX + distY*distY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
