package Inputs;

import org.lwjgl.glfw.GLFW;
import render.Window;

import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {

    private static Keyboard instance;
    private boolean keyPressed[] = new boolean[350];
    private boolean keyBeginPress[] = new boolean[350];
    private boolean keyDown[] = new boolean[350];
    private boolean keyUp[] = new boolean[350];

    private Keyboard() {

    }

    public static void endFrame() {
        Arrays.fill(get().keyBeginPress, false);
    }

    public static Keyboard get() {
        if (Keyboard.instance == null) {
            Keyboard.instance = new Keyboard();
        }
        return Keyboard.instance;
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS) {
            if (key == GLFW_KEY_DOWN) {
                get().keyDown[key] = true;
            }
            if (key == GLFW_KEY_UP) {
                get().keyUp[key] = true;
            }
            get().keyPressed[key] = true;
            get().keyBeginPress[key] = true;

        } else if (action == GLFW_RELEASE) {
            get().keyDown[key] = false;
            get().keyUp[key] = false;
            get().keyPressed[key] = false;
            get().keyBeginPress[key] = false;
        }
        if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE)
            GLFW.glfwSetWindowShouldClose(window, true);
    }

    public static boolean isKeyPressed(int keyCode) {
        return get().keyPressed[keyCode];
    }

    public static boolean keyBeginPress(int keyCode) {
        return get().keyBeginPress[keyCode];
    }

    public static boolean isKeyDown(int keyCode) {
        return get().keyDown[keyCode];
    }

    public static boolean isKeyUp(int keyCode) {
        return get().keyUp[keyCode];
    }

    public static void updateKey() {
        glfwSetKeyCallback(Window.getWindow(), Keyboard::keyCallback);
    }

}
