package Test;

import main.Game;
import Inputs.Input;
import MeshShader.Mesh;
import MeshShader.Shader;
import MeshShader.Vertex;
import util.Time;
import util.Utils;
import Math.Vector3f;
import Math.Transform;

import java.io.IOException;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Demo implements Game {
    private Mesh m;
    private Shader sh;
    private Transform tr;

    public Demo() {
    }

    public void init() {
        m = new Mesh();
        sh = new Shader();

        m.addVertices(new Vertex[]{new Vertex(new Vector3f(-1, -1, 0)),
                                   new Vertex(new Vector3f(0, 1, 0)),
                                   new Vertex(new Vector3f(1, -1, 0))});

        try {
            tr = new Transform();

            sh.addProgram(Utils.loadResource("res/shaders/v1vs.glsl"), GL_VERTEX_SHADER);
            sh.addProgram(Utils.loadResource("res/shaders/v1fs.glsl"), GL_FRAGMENT_SHADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh.compileShader();

        sh.addUniform("transform");
    }

    public void input() {
    }

    float temp = 0.0f;

    @Override
    public void update() {
        System.out.println("update");
        System.out.println(Input.getCursorX() + " " + Input.getCursorY());

        temp += Time.getDelta();

        float sinTemp = (float)Math.sin(temp);

        this.tr.setTranslation(sinTemp, 0, 0);
        this.tr.setRotation(0, 0, sinTemp * 180);
          this.tr.setScale(sinTemp, sinTemp, sinTemp);
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        sh.setUniform("transform", tr.getTransformation());
        m.draw();
    }
}