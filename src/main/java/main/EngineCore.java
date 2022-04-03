package main;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import render.Window;
import util.Const;

import java.sql.SQLOutput;

public class EngineCore{
    public static final long NANOSECOND = 1000000000L;
    public static final float FRAMERATE = 1000;
    private int fps;
    private static float frametime = 1.0f / FRAMERATE;

    private boolean isRunning;

    private Window window;
    private GLFWErrorCallback errorCallback;

    private Game game;

    public EngineCore(Game game){
        this.game = game;
    }

    private void init() throws Exception{
        GLFW.glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
        window = EngineLauncher.getWindow();
        window.init();
    }

    public void start() throws Exception{
        if(isRunning)
            return;
        init();
        run();
    }

    public void run(){
        this.isRunning = true;
        int frames = 0;
        long frameCounter = 0;
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        while (isRunning){
            boolean render = false;
            long startTime = System.nanoTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double) NANOSECOND;
            frameCounter += passedTime;

            input();

            while (unprocessedTime > frametime){
                render = true;
                unprocessedTime -= frametime;

                if(window.shouldClose())
                    stop();

                if(frameCounter >= NANOSECOND){
                    setFps(frames);
                    System.out.println("FPS: " + getFps());
                    // window.setTitle(Const.TITLE + getFps());
                    frames = 0;
                    frameCounter = 0;
                }

            }
            if(render){
                update();
                render();
                frames++;
            }
        }
        cleanup();
    }

    private void stop(){
        if(!isRunning)
            return;
        isRunning = false;
    }

    private void input(){

    }

    public void render(){
        game.render();
    }

    public void update(){
        game.update();
        window.update();
    }

    private void cleanup(){
        window.cleanup();
        errorCallback.free();
        GLFW.glfwTerminate();
    }

    public int getFps() {
        return fps;
    }

    private void setFps(int fps){
        this.fps = fps;
    }
}
