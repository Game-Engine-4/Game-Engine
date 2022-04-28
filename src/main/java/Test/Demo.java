package Test;

import main.Game;
import Inputs.Input;
import MeshShader.Mesh;
import MeshShader.Shader;
import MeshShader.Vertex;
import util.Utils;

import java.io.IOException;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Demo implements Game {
    private Mesh m;
    private Shader sh;

    public Demo() {

    }

    public void init() {
        m = new Mesh();
        m.addVertices(new Vertex[]{ new Vertex(4.1f, 3.2f, 3.3f), new Vertex(2f, 3f, 2.4f), new Vertex() });

        sh = new Shader();
        try {
            sh.addProgram(Utils.loadResource("src/main/resources/shaders/v1/myVShader.glsl"), GL_VERTEX_SHADER);
            sh.addProgram(Utils.loadResource("src/main/resources/shaders/v1/myFShader.glsl"), GL_FRAGMENT_SHADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh.compileShader();
    }

    public void input() {

    }

    @Override
    public void update() {
        System.out.println("update");
        System.out.println(Input.getCursorX() + " " + Input.getCursorY());
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        m.draw();
    }

}