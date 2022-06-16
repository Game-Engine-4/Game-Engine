package MeshShader;

import Math.Vector3f;

/**
 * Class to represent Vertex, containing Vector
 */
public class Vertex {
    /**
     * Attribute for storing size of the vertices
     */
    public static final int SIZE = 3;
    private Vector3f pos;

    /**
     * Constructor creating vector with inital coordinates (0,0,0)
     */
    public Vertex(){
        pos = new Vector3f(0F, 0F, 0F);
    }

    /**
     * Constructor, creating a new vector with given vector
     * @param pos Vector3f
     */
    public Vertex(Vector3f pos) {
        this.pos=pos;
    }

    /**
     * Constructor, creating vector using coordinates of it
     * @param x1 - x coordinate of vector
     * @param y1 - y coordinate of vector
     * @param z1 - z coordinate of vector
     */
    public Vertex(float x1, float y1, float z1){
        pos = new Vector3f(x1, y1, z1);
    }

    /**
     * Gets the vector of the class
     * @return This current vector
     */
    public Vector3f getPos() {
        return pos;
    }

    /**
     * Changes the vector of the vertex using given vector
     * @param pos Given Vector3f
     */
    public void setPos(Vector3f pos) {
        this.pos = pos;
    }
}