package Math;

import org.joml.Math;

/**
 * This is the Vector3f class, 3 element vector that is represented by x y z coordinates,
 * this class contains all the necessary functions to work with Vector3f
 */
public class Vector3f {
    private float x;
    private float y;
    private float z;

    public Vector3f() {
    }

    public Vector3f(float d) {
        this.x = d;
        this.y = d;
        this.z = d;
    }

    /**
     * Constructor for Vector3f with the specified xyz coordinates.
     * @param x parameter for the x coordinate
     * @param y parameter for the y coordinate
     * @param z parameter for the z coordinate
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs and initializes a Vector3f from the specified Vector3f.
     * @param v the Vector3f containing the x y z coordinates
     */
    public Vector3f(Vector3f v) {
        //    Create a new vector with the same values as another
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    /**
     * This is the function that returns length of the vector
     * @return returns length
     */
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Computes the dot product of this vector and vector r.
     * @param r This is the parameter for the other vector
     * @return Returns the dot product
     */
    public float dot(Vector3f r) {
        return x * r.getX() + y * r.getY() + z * r.getZ();
    }

    /**
     * Computes the dot product of vector v1 and vector v2.
     * @param v2 This is parameter for the second vector
     * @param v1 This is parameter for the first vector
     * @return Returns the dot product
     */
    public static float dot(Vector3f v2, Vector3f v1) {
        return (v1.x * v2.x + v1.y * v2.y + v1.z * v2.z);
    }

    /**
     * Returns the angle between this vector and the vector parameter.
     * @param v This is the parameter for the Vector
     * @return Returns the angle between the vectors
     */
    public float angle(Vector3f v) {
        float dls = dot(v) / (this.length() * v.length());
        if (dls < -1.0f)
            dls = -1.0f;
        else if (dls > 1.0f)
            dls = 1.0f;
        return (float) Math.acos(dls);
    }

    /**
     * This function calculates the cross product of this vector and vector r
     * @param r This is the parameter for the vector
     * @return Returns the cross product
     */
    public Vector3f cross(Vector3f r) {
        float x_ = y * r.getZ() - z * r.getY();
        float y_ = z * r.getX() - x * r.getZ();
        float z_ = x * r.getY() - y * r.getX();

        return new Vector3f(x_, y_, z_);
    }

    /**
     * This function calculates the cross product of vector a and vector b
     * @param a This is the parameter for the vector a
     * @param b This is the parameter for the vector b
     * @return Returns the cross product
     */
    public static Vector3f cross(Vector3f a, Vector3f b) {
        //    Calculates the vector cross product of the two given vectors.
        return new Vector3f(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    /**
     * This function calculates the squared distance between two vectors
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns teh squared distance
     */
    public static float distanceSquared(Vector3f v1, Vector3f v2) {
        float x = v1.x - v2.x;
        float y = v1.y - v2.y;
        float z = v1.z - v2.z;
        return x * x + y * y + z * z;
    }

    /**
     * This function calculates the distance between two vectors
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns the distance between two vectors
     */
    public static float distance(Vector3f v1, Vector3f v2) {
        return (float) Math.sqrt(distanceSquared(v1, v2));
    }

    /**
     * This function adds two vectors
     * @param v1 This is the parameter for the vector v1
     * @param v2 This is the parameter for the vector v2
     * @return Returns product of the addition
     */
    public static Vector3f add(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    /**
     * This function increments x y z coordinates of the vector
     * @param dx This is the parameter for the amount that we want to add to x
     * @param dy This is the parameter for the amount that we want to add to y
     * @param dz This is the parameter for the amount that we want to add to z
     * @return Returns the vector after incrementing x y z
     */
    public Vector3f add(float dx, float dy, float dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
        return this;
    }

    /**
     * This function subtracts x y z coordinates of the vector
     * @param dx This is the parameter for the amount that we want to subtract from x
     * @param dy This is the parameter for the amount that we want to subtract from y
     * @param dz This is the parameter for the amount that we want to subtract from z
     * @return Returns the vector after subtraction from x y z
     */
    public Vector3f sub(float dx, float dy, float dz) {
        this.x -= dx;
        this.y -= dy;
        this.z -= dz;
        return this;
    }

    /**
     * This function subtracts one vector from another
     * @param v1 This is the parameter for vector v1
     * @param v2 This is the parameter for vector v2
     * @return Returns the product of subtraction
     */
    public static Vector3f sub(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    /**
     * This function multiplies vector by some float
     * @param v This is the parameter for the vector
     * @param sc This is the amount the vector will be multiplied by
     * @return Returns the product of multiplication
     */
    public static Vector3f mul(Vector3f v, float sc) {
        return new Vector3f(v.x * sc, v.y * sc, v.z * sc);
    }

    /**
     * This function multiplies two vectors
     * @param v This is the parameter for vector one
     * @param dest This is the parameter for vector two
     * @return Returns the product of multiplication
     */
    public Vector3f mul(Vector3f v, Vector3f dest) {
        dest.x = x * v.x;
        dest.y = y * v.y;
        dest.z = z * v.z;
        return dest;
    }


    /**
     * This function divides two vectors
     * @param v This is the parameter for vector that will divide
     * @param dest This is the parameter for the vector that will be divided
     * @return Returns the product of division
     */
    public Vector3f div(Vector3f v, Vector3f dest) {
        dest.x = x / v.x;
        dest.y = y / v.y;
        dest.z = z / v.z;
        return dest;
    }

    /**
     * This function divides vector by some float
     * @param v This is the parameter for vector
     * @param sc This is the parameter for the amount that the vector will be divided by
     * @return Returns the product of division
     */
    public static Vector3f div(Vector3f v, float sc) {
        return new Vector3f(v.x / sc, v.y / sc, v.z / sc);
    }

    /**
     * This function normalizes this vector in place.
     * @return Returns this vector
     */
    public Vector3f normalize() {
        float length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    /**
     * This function normalizes vector v
     * @param v The parameter for the vector
     * @return Returns vector v normalized
     */
    public static Vector3f normalize(Vector3f v) {
        float l = v.length();
        return new Vector3f(v.x / l, v.y / l, v.z / l);
    }

    /**
     * This function rotates this vector by some angle on the specified axis
     * @param angle This is the parameter for the angle
     * @param axis This is the parameter for the axis of rotation
     * @return Returns this vector rotated
     */
    public Vector3f rotate(float angle, Vector3f axis) {

        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle / 2));
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle / 2));

        float rX = axis.getX() * sinHalfAngle;
        float rY = axis.getY() * sinHalfAngle;
        float rZ = axis.getZ() * sinHalfAngle;
        float rW = cosHalfAngle;

        Quaternion rotation = new Quaternion(rX, rY, rZ, rW);
        Quaternion conjugate = rotation.conjugate();

        Quaternion w = rotation.mul(this).mul(conjugate);

        x = w.getX();
        y = w.getY();
        z = w.getZ();

        return this;
    }

    /**
     * This function sets this vector's x y z to 0
     * @return Returns vector which was set to 0
     */
    public Vector3f setZero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    /**
     * This function sets vector v's x y z to 0
     * @param v This is the parameter for the vector
     * @return Returns vector v which was set to 0
     */
    public static Vector3f setZero(Vector3f v) {
        return new Vector3f(0, 0, 0);
    }

    /**
     * This function sets x y z for this vector according to vector v
     * @param v This is the parameter for the vector
     * @return Returns this vector with new x y z parameters
     */
    public Vector3f set(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    /**
     * This function sets x y z parameters for this vector
     * @param x This is the parameter for the x value
     * @param y This is the parameter for the y value
     * @param z This is the parameter for the z value
     * @return Returns this vector with new x y z parameters
     */
    public Vector3f set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * This function sets x y z parameters for this vector according to the passed array
     * @param array This is the parameter for the array that will determine x y z
     * @return Returns this vector with new x y z parameters
     */
    public Vector3f set(float[] array) {
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
        return this;
    }

    /**
     * This is the function that rotates this vector on the X axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @return Returns rotated vector
     */
    public Vector3f rotateX(float angle) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        this.y = k;
        this.z = t;
        return this;
    }

    /**
     * This is the function that rotates passed vector on the X axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @param dest This is the parameter for the vector
     * @return Returns rotated vector
     */
    public Vector3f rotateX(float angle, Vector3f dest) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.y * cos - this.z * sin;
        float t = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = k;
        dest.z = t;
        return dest;
    }

    /**
     * This is the function that rotates this vector on the Y axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @return Returns rotated vector
     */
    public Vector3f rotateY(float angle) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        this.x = k;
        this.z = t;
        return this;
    }

    /**
     * This is the function that rotates passed vector on the Y axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @param dest This is the parameter for the vector
     * @return Returns rotated vector
     */
    public Vector3f rotateY(float angle, Vector3f dest) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos + this.z * sin;
        float t = -this.x * sin + this.z * cos;
        dest.x = k;
        dest.y = this.y;
        dest.z = t;
        return dest;
    }

    /**
     * This is the function that rotates this vector on the Z axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @return Returns rotated vector
     */
    public Vector3f rotateZ(float angle) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        this.x = k;
        this.y = t;
        return this;
    }

    /**
     * This is the function that rotates passed vector on the Z axis by some angle
     * @param angle This is the parameter for the angle of rotation
     * @param dest This is the parameter for the vector
     * @return Returns rotated vector
     */
    public Vector3f rotateZ(float angle, Vector3f dest) {
        float sin = (float) Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float k = this.x * cos - this.y * sin;
        float t = this.x * sin + this.y * cos;
        dest.x = k;
        dest.y = t;
        dest.z = this.z;
        return dest;
    }

    /**
     * This function checks if this vector equals passed Object
     * @param v This is the parameter of the Object that we want to compare with this vector
     * @return Returns true if this vector equals passed Object, false if not
     */
    @Override
    public boolean equals(Object v) {
        float epsilon = 0.00001f;
        if (v instanceof Vector3f) {
            return Math.abs(this.x - ((Vector3f) v).x) < epsilon && Math.abs(this.y - ((Vector3f) v).y) < epsilon
                    && Math.abs(this.z - ((Vector3f) v).z) < epsilon;
        }
        return false;
    }

    /**
     * This function calculates squared length of this vector
     * @return Returns squared length
     */
    public float lengthSquared() {
        return (this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     * This function calculates squared length of passed vector
     * @param v This is the parameter fot the vector
     * @return Returns squared length
     */
    public static float lengthSquared(Vector3f v) {
        return (v.x * v.x + v.y * v.y + v.z * v.z);
    }

    /**
     * This function adds passed vector to this vector
     * @param r This is the parameter for vector
     * @return Returns product of addition
     */
    public Vector3f add(Vector3f r) {
        return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
    }

    /**
     * This function increment the components of this vector by the given value.
     * @param r This is the parameter for the amount that needs to be added
     * @return Returns product of addition
     */
    public Vector3f add(float r) {
        return new Vector3f(x + r, y + r, z + r);
    }

    /**
     * This function subtracts passed vector from this vector
     * @param r This is the parameter for the vector that needs to be subtracted from this vector
     * @return Returns product of subtraction
     */
    public Vector3f sub(Vector3f r) {
        return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
    }

    /**
     * This function subtracts the given value from the components of this vector.
     * @param r This is the parameter for the amount that needs to be subtracted
     * @return Returns product of subtraction
     */
    public Vector3f sub(float r) {
        return new Vector3f(x - r, y - r, z - r);
    }

    /**
     * This function multiplies this vector's component-wise by another vector.
     * @param r This is the parameter for the vector to multiply by
     * @return Returns product of multiplication
     */
    public Vector3f mul(Vector3f r) {
        return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
    }

    /**
     * This function multiplies all components of this vector by the passed value.
     * @param r This is the parameter for the value of multiplication
     * @return Returns product of multiplication
     */
    public Vector3f mul(float r) {
        return new Vector3f(x * r, y * r, z * r);
    }

    /**
     * This function divides this vector's component-wise by another vector.
     * @param r This is the parameter for the vector to divide by
     * @return Returns product of division
     */
    public Vector3f div(Vector3f r) {
        return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
    }

    /**
     * This function divides all components of this vector by the passed value.
     * @param r This is the parameter for the value of division
     * @return Returns product of division
     */
    public Vector3f div(float r) {
        return new Vector3f(x / r, y / r, z / r);
    }

    /**
     * This function gives us x coordinate of this vector
     * @return Returns x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * This function sets x coordinate for this vector
     * @param x This is the parameter fot x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * This function gives us y coordinate of this vector
     * @return Returns y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * This function sets y coordinate for this vector
     * @param y This is the parameter fot y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * This function gives us z coordinate of this vector
     * @return Returns z coordinate
     */
    public float getZ() {
        return z;
    }

    /**
     * This function sets z coordinate for this vector
     * @param z This is the parameter fot z coordinate
     */
    public void setZ(float z) {
        this.z = z;
    }
}