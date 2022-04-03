package Mesh;

import static org.lwjgl.opengles.GLES20.*;

public class Mesh {
    private int vbo;
    private int size;

    public Mesh() {
        this.vbo = glGenBuffers();
        this.size = 0;
    }

    public void addVertices(Vertex[] vertices){
        size = vertices.length * Vertex.SIZE;
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glDrawArrays(GL_TRIANGLES, 0, size);

        glDisableVertexAttribArray(0);
    }
}