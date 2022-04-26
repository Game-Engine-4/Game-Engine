package MeshShader;

import Math.Vector3f;

public class Vertex {
    public static final int SIZE = 3;
    private Vector3f pos;

    public Vertex(){
        pos = new Vector3f(0F, 0F, 0F);
    }

    public Vertex(Vector3f pos) {
        this.pos=pos;
    }

    public Vertex(float x1, float y1, float z1){
        pos = new Vector3f(x1, y1, z1);
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }
}