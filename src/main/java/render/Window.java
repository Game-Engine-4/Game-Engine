package render;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import util.Time;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private static long windowID;
    private static Window window = null;
    private int width, height;
    private String title;
    public void createWindow(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
        init();
        loop();

    }

    public void loop(){
        float startTime = Time.getTime();
        float endTime = Time.getTime();

        while(!glfwWindowShouldClose(windowID)){
            glfwPollEvents();
            glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(windowID);
        }
        endTime = Time.getTime();
        float dt = endTime - startTime;
        startTime = endTime;
    }

    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit()){
            throw new IllegalStateException("unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
        windowID = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (windowID == NULL){
            throw new IllegalStateException("failed to create GLFW window");
        }
        glfwMakeContextCurrent(windowID);
        glfwSwapInterval(1);
        glfwShowWindow(windowID);
        GL.createCapabilities();
    }

    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }

    public void updateWindow() {
        glfwSwapBuffers(windowID);
        glfwPollEvents();
        glfwSwapInterval(1);
    }

    public static void closeWindow() {
        glfwDestroyWindow(windowID);
        glfwTerminate();
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(windowID);
    }
}