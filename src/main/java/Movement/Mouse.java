package Movement;

import render.Window;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse {
    private static Mouse instance;
    private double scrollX, scrollY;
    private double xPos, yPos, lastX, lastY;
    private boolean mouseButtonPressed[] = new boolean[5];
    private boolean isDragging;

    private Mouse() {
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
    }

    public static Mouse get() {
        if (instance == null) {
            Mouse.instance = new Mouse();
        }
        return Mouse.instance;
    }

    public static void mousePosCallBack(long window, double xpos, double ypos) {
        get().lastX = get().xPos;
        get().lastY = get().yPos;
        get().xPos = xpos;
        get().yPos = ypos;
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }

    public static void mouseButtonCallBack(long window, int button, int action, int mods) {
        if (action == GLFW_PRESS) {
            if (button < get().mouseButtonPressed.length) {
                get().mouseButtonPressed[button] = true;

            }
        } else if (action == GLFW_RELEASE) {
            if (button < get().mouseButtonPressed.length) {

                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void mouseScrollCall(long window, double xOffset, double yOffset) {
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    public static void endFrame() {
        get().scrollY = 0;
        get().scrollX = 0;
        get().lastY = get().yPos;
        get().lastX = get().xPos;
    }

    public static float getX() {
        return (float) get().xPos;
    }

    public static float getY() {
        return (float) get().yPos;
    }

    public static float getDx() {
        return (float) (get().lastX - get().xPos);
    }

    public static float getDy() {
        return (float) (get().lastY - get().yPos);
    }

    public static float getScrollX() {
        return (float) (get().scrollX);
    }

    public static float getScrollY() {
        return (float) (get().scrollY);
    }

    public static boolean isDragging() {
        return get().isDragging;
    }

    public static boolean mouseButtonDown(int button) {
        if (button < get().mouseButtonPressed.length) {
            return get().mouseButtonPressed[button];
        } else {
            return false;
        }
    }

    public static void updateMouse() {
        glfwSetCursorPosCallback(Window.getWindow(), Mouse::mousePosCallBack);
        glfwSetMouseButtonCallback(Window.getWindow(), Mouse::mouseButtonCallBack);
        glfwSetScrollCallback(Window.getWindow(), Mouse::mouseScrollCall);
    }
}