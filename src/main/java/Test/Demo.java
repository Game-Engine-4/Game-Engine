package Test;

import MeshShader.*;
import main.Game;
import Inputs.Input;
import render.Camera;
import util.Time;
import util.Utils;
import Math.Transform;

import java.awt.*;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Demo implements Game {
    private Camera camera;
    private Mesh m;
    private Shader sh;
    private Transform tr;

    public Demo() {
    }

    public void init() {

        m = new Mesh();
        sh = new Shader();
        camera = Camera.getInstance();


        MeshLoader myLoader = new OBJMeshLoader();

        try {
            m = myLoader.loadMesh("res/Cube.obj");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

//            Transform.setProjection(70f, Window.WIDTH, Window.HEIGHT, 0.1f, 1000);
//            Transform.setCamera(camera);
            tr = new Transform();
            Transform.setProjection(70f, Window.WIDTH, Window.HEIGHT, 0.1f, 1000);
            Transform.setCamera(camera);
            sh.addProgram(Utils.loadResource("res/shaders/v1vs.glsl"), GL_VERTEX_SHADER);
            sh.addProgram(Utils.loadResource("res/shaders/v1fs.glsl"), GL_FRAGMENT_SHADER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sh.compileShader();

        sh.addUniform("transform");
    }

    public void input() {
        camera.input();
    }

    float temp = 0.0f;
    float temp2 = 0.0f;
    float temp3 = 1.0f;

    @Override
    public void update() {
        System.out.println("update");
        System.out.println(Input.getCursorX() + " " + Input.getCursorY());

        temp += Time.getDelta();

        float sinTemp = (float)Math.sin(temp);
        float sinTemp2 = (float)Math.sin(temp2);
        float sinTemp3 = (float)Math.sin(temp3);
        camera.input();
        if(Input.isKeyPressed(65)) {
            temp2 -= Time.getDelta();
        } else if(Input.isKeyPressed(68)) {
            temp2 += Time.getDelta();
        } else if (Input.isKeyPressed(32)) {
            temp3 += 3*Time.getDelta();
        }

        //this.tr.setScale(sinTemp3/2, sinTemp3/2, sinTemp3/2);
        this.tr.setTranslation(sinTemp2, 0, 5);
        this.tr.setRotation(0, sinTemp * 180, 0);
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        sh.setUniform("transform", tr.getProjectedTransformation());
        m.draw();
    }
}