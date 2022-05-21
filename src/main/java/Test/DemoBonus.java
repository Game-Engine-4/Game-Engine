package Test;

import MeshShader.*;
import main.Game;
import Inputs.Input;
import util.Time;
import util.Utils;
import Math.Transform;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class DemoBonus implements Game {
    private Mesh m;
    private Shader sh;
    private Transform tr;

    public DemoBonus() {
    }

    public void init() {

        m = new Mesh();
        sh = new Shader();

        MeshLoader myLoader = new OBJMeshLoader();

        try {
            m = myLoader.loadMesh("res/Boat.obj");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            tr = new Transform();

            sh.addProgram(Utils.loadResource("res/shaders/v1vsb.glsl"), GL_VERTEX_SHADER);
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

        //this.tr.setTranslation(sinTemp, 0, 0);
        this.tr.setRotation(0, sinTemp * 180, 0);
        this.tr.setScale(0.1f, 0.1f, 0.1f);
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        sh.setUniform("transform", tr.getTransformation());
        m.draw();
    }
}