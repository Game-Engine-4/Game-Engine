package MeshShader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

/**
 * Base class for representing a 3D geometric surface
 */
public class Mesh {
    private int vbo;
    private int size;
    private int ibo;

    /**
     * Constructor that is called by any Mesh implementation
     */
    public Mesh() {
        this.vbo = glGenBuffers();
        this.ibo = glGenBuffers();
        this.size = 0;
    }

    /**
     * Method which adds some data from vertices to add them at pointer 'vbo' - vertex buffer object
     * and data from indices to 'ibo' - index buffer object
     * @param vertices array of Vertex
     * @param indices array of indices that specifies which indexes are actually going to be drawn
     */
    public void addVertices(Vertex[] vertices, int[] indices) {
        this.size = indices.length;

        glBindBuffer(GL_ARRAY_BUFFER, this.vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    /**
     * Method to draw a Mesh using gl
     */
    public void draw() {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES,size, GL_UNSIGNED_INT,0);

        glDisableVertexAttribArray(0);
    }
}
