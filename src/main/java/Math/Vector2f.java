package Math;

import org.joml.Math;

/**
 * This is the Vector2f class, 2 element vector that is represented by x y coordinates,
 * this class contains all the necessary functions to work with Vector2f
 */
public class Vector2f {
    public float x;
    public float y;

    /**
     * Constructor for Vector2f with x&y component of zero.
     */
    public Vector2f() {
    }

    /**
     * Constructor for Vector2f with the specified xy coordinates.
     *
     * @param x parameter for the x coordinate
     * @param y parameter for the y coordinate
     */
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs and initializes a Vector2f from the specified Vector2f.
     *
     * @param other the Vector2f containing the xy coordinates
     */

    public Vector2f(Vector2f other) {
        this.set(other);
    }

    /**
     * This function sets x y parameters for this vector
     *
     * @param x This is the parameter for the x value
     * @param y This is the parameter for the y value
     * @return Returns this vector with new x y parameters
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This function sets x y for this vector according to vector v
     *
     * @param v This is the parameter for the vector
     * @return Returns this vector with new x y parameters
     */
    public void set(Vector2f v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * This function sets this vector's x y to 0
     *
     * @return Returns vector which was set to 0
     */
    public void setZero() {
        x = 0;
        y = 0;
    }

    /**
     * This function sets vector v's x y to 0
     *
     * @param v This is the parameter for the vector
     * @return Returns vector v which was set to 0
     */
    public static Vector2f setZero(Vector2f v) {
        return new Vector2f(0, 0);
    }

    /**
     * This is the function that returns length of the vector
     *
     * @return returns length of the vector
     */
    public float length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * This is the function that returns magnitude of the vector
     *
     * @return returns magnitude of the vector
     */
    public float magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * This is the function that returns magnitude of the vector
     *
     * @param v this is the parameter for the vector
     * @return returns magnitude of the vector
     */
    public static float magnitude(Vector2f v) {
        return Math.sqrt(v.x * v.x + v.y * v.y);
    }

    /**
     * This function normalizes this vector in place.
     *
     * @return Returns this vector
     */
    public Vector2f normalize() {
        float magnitude = magnitude();
        if (magnitude != 0) {
            this.x /= magnitude;
            this.y /= magnitude;
        }

        return this;
    }

    /**
     * This function normalizes vector v
     *
     * @param v The parameter for the vector
     * @return Returns vector v normalized
     */
    public static Vector2f normalize(Vector2f v) {
        return new Vector2f(v.x / (Math.sqrt(v.x * v.x + v.y * v.y)), v.y / Math.sqrt(v.x * v.x + v.y * v.y));
    }

    /**
     * This function normalizes vector v
     *
     * @return normalized vector
     */
    public Vector2f getNormalized() {
        float magnitude = magnitude();
        return new Vector2f(x / magnitude, y / magnitude);
    }

    /**
     * This function makes vector to cartesian by some magnitude and  angle
     *
     * @param magnitude this is a parameter for the mangitude
     * @param angle     this is a parameter for the angle
     * @return the result of cartesian
     */
    public static Vector2f toCartesian(float magnitude, float angle) {
        return new Vector2f(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    /**
     * This function rotates this vector by some angle
     *
     * @param angle This is the parameter for the angle
     */
    public void rotateBy(float angle) {
        float cos = Math.cos(angle);
        float sin = Math.sin(angle);
        float rx = x * cos - y * sin;
        y = x * sin + y * cos;
        x = rx;
    }

    /**
     * This function rotates this vector by some angle
     *
     * @param angle This is the parameter for the angle
     * @return Returns this vector rotated
     */
    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float) (x * cos - y * sin), (float) (x * sin + y * cos));
    }

    /**
     * This function get rotates this vector by some angle
     *
     * @param angle This is the parameter for the angle
     * @return Returns get rotated vector by some angle
     */
    public Vector2f getRotatedBy(float angle) {
        float cos = Math.cos(angle);
        float sin = Math.sin(angle);
        return new Vector2f(x * cos - y * sin, x * sin + y * cos);
    }

    public void rotateTo(float angle) {
        set(toCartesian(length(), angle));
    }

    /**
     * This function get rotates to the vector by some angle
     *
     * @param angle This is the parameter for the angle
     * @return Returns get rotated to vector by some angle
     */
    public Vector2f getRotatedTo(float angle) {
        return toCartesian(length(), angle);
    }

    /**
     * This is a getter function to get some angle
     *
     * @return the angle
     */
    public float getAngle() {
        return Math.atan2(y, x);
    }

    /**
     * Computes the dot product of this vector and vector v.
     *
     * @param v This is the parameter for the other vector
     * @return Returns the dot product
     */

    public float dot(Vector2f v) {
        return (this.x * v.x + this.y * v.y);
    }

    /**
     * This function calculates the dot product of the vectors' x and y coordinates
     *
     * @param vx This is the parameter for the vector x coordinate
     * @param vy This is the parameter for the vector y coordinate
     * @return Returns the dot product
     */

    public float dot(float vx, float vy) {
        return (this.x * vx + this.y * vy);
    }

    /**
     * Computes the dot product of vector v1 and vector v2.
     *
     * @param v2 This is parameter for the second vector
     * @param v1 This is parameter for the first vector
     * @return Returns the dot product
     */
    public static float dot(Vector2f v1, Vector2f v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    /**
     * This function calculates the cross product of this vector and vector v
     *
     * @param v This is the parameter for the vector
     * @return Returns the cross product
     */
    public float cross(Vector2f v) {
        return (this.x * v.y - this.y * v.x);
    }

    /**
     * This function calculates the cross product of the vectors' x and y coordinates
     *
     * @param vx This is the parameter for the vector x coordinate
     * @param vy This is the parameter for the vector y coordinate
     * @return Returns the cross product
     */
    public float cross(float vx, float vy) {
        return (this.x * vy - this.y * vx);
    }

    /**
     * This function calculates the cross product of vector a and vector b
     *
     * @param v1 This is the parameter for the vector a
     * @param v2 This is the parameter for the vector b
     * @return Returns the cross product
     */
    public static float cross(Vector2f v1, Vector2f v2) {
        return (v1.x * v2.y - v1.y * v2.x);
    }

    /**
     * This function adds passed vector to this vector
     *
     * @param other This is the parameter for vector
     * @return Returns product of addition
     */
    public Vector2f add(Vector2f other) {
        this.x += other.x;
        this.y += other.y;

        return this;
    }

    /**
     * This function increments x y coordinates of the vector
     *
     * @param x This is the parameter for the amount that we want to add to x
     * @param y This is the parameter for the amount that we want to add to y
     * @return Returns the vector after incrementing x y
     */
    public Vector2f add(float x, float y) {
        this.x += x;
        this.y += y;

        return this;
    }

    /**
     * This function increment the components of this vector by the given value.
     *
     * @param amount This is the parameter for the amount that needs to be added
     * @return Returns product of addition
     */
    public Vector2f add(float amount) {
        this.x += amount;
        this.y += amount;

        return this;
    }

    /**
     * This function adds two vectors
     *
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns product of the addition
     */
    public static Vector2f add(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * This function subtracts the given value from the components of this vector.
     *
     * @param amount This is the parameter for the amount that needs to be subtracted
     * @return Returns product of subtraction
     */
    public Vector2f sub(float amount) {
        this.x -= amount;
        this.y -= amount;

        return this;
    }

    /**
     * This function subtracts x y  coordinates of the vector
     *
     * @param x This is the parameter for the amount that we want to subtract from x
     * @param y This is the parameter for the amount that we want to subtract from y
     * @return Returns the vector after subtraction from x y
     */
    public Vector2f sub(float x, float y) {
        this.x -= x;
        this.y -= y;

        return this;
    }

    /**
     * This function subtracts passed vector from this vector
     *
     * @param other This is the parameter for the vector that needs to be subtracted from this vector
     * @return Returns product of subtraction
     */
    public Vector2f sub(Vector2f other) {
        this.x -= other.x;
        this.y -= other.y;

        return this;
    }

    /**
     * This function subtracts one vector from another
     *
     * @param v1 This is the parameter for vector v1
     * @param v2 This is the parameter for vector v2
     * @return Returns the product of subtraction
     */
    public static Vector2f sub(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * This function multiplies all components of this vector by the passed value.
     *
     * @param scalar This is the parameter for the value of multiplication
     * @return Returns product of multiplication
     */
    public Vector2f mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;

        return this;
    }

    /**
     * This function multiplies two vectors
     *
     * @param other This is the parameter for vector one
     * @return Returns the product of multiplication
     */
    public Vector2f mul(Vector2f other) {
        this.x *= other.x;
        this.y *= other.y;

        return this;
    }

    /**
     * This function multiplies vector by some float
     *
     * @param v  This is the parameter for the vector
     * @param sc This is the amount the vector will be multiplied by
     * @return Returns the product of multiplication
     */
    public static Vector2f mul(Vector2f v, float sc) {
        return new Vector2f(v.x * sc, v.y * sc);
    }

    /**
     * This function divides all components of this vector by the passed value.
     *
     * @param scalar This is the parameter for the value of division
     * @return Returns product of division
     */
    public Vector2f div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;

        return this;
    }

    /**
     * This function divides two vectors
     *
     * @param other This is the parameter for vector that will divide
     * @return Returns the product of division
     */
    public Vector2f div(Vector2f other) {
        this.x /= this.x;
        this.y /= this.y;

        return this;
    }

    /**
     * This function divides vector by some float
     *
     * @param v  This is the parameter for vector
     * @param sc This is the parameter for the amount that the vector will be divided by
     * @return Returns the product of division
     */
    public static Vector2f div(Vector2f v, float sc) {
        return new Vector2f(v.x / sc, v.y / sc);
    }

    /**
     * This function calculates the distance between two vectors
     *
     * @param other the first vector parameter
     * @return returns the  distance
     */
    public float distance(Vector2f other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;

        return (float) Math.sqrt(distX * distX + distY * distY);
    }

    /**
     * This function calculates the distance between two vectors
     *
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns the distance between two vectors
     */
    public static float distance(Vector2f v1, Vector2f v2) {
        float distX = v1.x - v2.x;
        float distY = v1.y - v2.y;

        return (float) Math.sqrt(distX * distX + distY * distY);
    }

    /**
     * This function calculates the  distance between two vectors' coordinates
     *
     * @param x the first vector's x coordinate
     * @param y the first vector's y coordinate
     * @return returns the  distance
     */
    public float distance(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;

        return (float) Math.sqrt(distX * distX + distY * distY);
    }

    /**
     * This function calculates the squared distance between two vectors
     *
     * @param other the first vector parameter
     * @return returns the squared distance
     */
    public float distSquared(Vector2f other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;

        return distX * distX + distY * distY;
    }

    /**
     * This function calculates the squared distance between two vectors' coordinates
     *
     * @param x the first vector's x coordinate
     * @param y the first vector's y coordinate
     * @return returns the squared distance
     */
    public float distSquared(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;

        return distX * distX + distY * distY;
    }

    /**
     * This function calculates the squared distance between two vectors
     *
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns the squared distance
     */
    public static float distSquared(Vector2f v1, Vector2f v2) {
        float distX = v1.x - v2.x;
        float distY = v1.y - v2.y;

        return distX * distX + distY * distY;
    }

    /**
     * This function checks if this vector equals passed Object
     *
     * @param v This is the parameter of the Object that we want to compare with this vector
     * @return Returns true if this vector equals passed Object, false if not
     */
    @Override
    public boolean equals(Object v) {
        float epsilon = 0.00001f;
        if (v instanceof Vector2f) {
            return Math.abs(this.x - ((Vector2f) v).x) < epsilon && Math.abs(this.y - ((Vector2f) v).y) < epsilon;
        }
        return false;
    }

    /**
     * This function cast x and y into strings
     *
     * @return x and y into strings
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
