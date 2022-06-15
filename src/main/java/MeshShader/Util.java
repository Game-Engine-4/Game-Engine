package MeshShader;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import Math.Matrix4x4;

/**
 * Helper class for Mesh which provides float/int buffers for array of vertex and array of indices
 */
public class Util {
    /**
     * Helper method for 'createFlippedBuffer' creating float buffer according to size
     * @param size size of array of vertices
     * @return float buffer
     */
    public static FloatBuffer createFloatBuffer(int size){
        return BufferUtils.createFloatBuffer(size);
    }

    /**
     * Helper method for creating int buffer
     * @param size size of array of indices
     * @return int buffer
     */
    public static IntBuffer createIntBuffer(int size) {
        return BufferUtils.createIntBuffer(size);
    }

    /**
     * Method taking array of indices to put into right format
     * @param val array of indices
     * @return flipped int buffer
     */
    public static IntBuffer createFlippedBuffer(int[] val) {
        IntBuffer buffer = createIntBuffer(val.length);
        buffer.put(val);
        buffer.flip();
        return buffer;
    }

    /**
     * Method taking array of vertex to put it into right format, flipping all the data into correct positions
     * @param vertices array of Vertex
     * @return
     */
    public static FloatBuffer createFlippedBuffer(Vertex[] vertices){

            FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);

            for(int i = 0; i < vertices.length; i++) {
                buffer.put(vertices[i].getPos().getX());
                buffer.put(vertices[i].getPos().getY());
                buffer.put(vertices[i].getPos().getZ());
            }

            buffer.flip();

            return buffer;
    }

    /**
     * Method creating flipped buffer according to given matrix
     * @param value matrix containing data used to set uniform
     * @return flipped float buffer of given matrix
     */
    public static FloatBuffer createFlippedBuffer(Matrix4x4 value) {
        FloatBuffer buffer = createFloatBuffer(4 * 4);

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                buffer.put(value.Get(i, j));

        buffer.flip();

        return buffer;
    }
}
