package Inputs;

import org.lwjgl.glfw.*;
import render.Window;

/**
 * This is an Input class. Input class consist of Keyboard and Mouse inputs and there are several methods.
 * Some of which checks whether key or button is pressed,up or down. Some getters and so on...
 */
public class Input {
    private GLFWKeyCallback keyboard;
    private GLFWMouseButtonCallback mouseButtons;
    private GLFWCursorPosCallback cursorPos;
    private GLFWScrollCallback mouseScroll;
    private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private static double cursorX, cursorY;
    private static double scrollX, scrollY;
    private static int keyPressed;
    private static int buttonPressed;

    /**
     * This class implements receiving input from Keyboard and mouse
     */
    public Input() {

        /**
         *This is a function to invoke the Keyboard key and press it down
         * @param window   the window that received the event
         * @param key      the keyboard key that was pressed or released
         * @param scancode the platform-specific scancode of the key
         * @param action   the key action.
         * @param mods     bitfield describing which modifiers keys were held down
         */

        keyboard = new GLFWKeyCallback() {

            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                keys[key] = (action == GLFW.GLFW_PRESS);
                keyPressed = key;
            }
        };

        /**
         *This is a function to invoke the Mouse button and press it down
         * @param window the window that received the event
         * @param button the mouse button that was pressed or released
         * @param action the button action.
         * @param mods   bitfield describing which modifiers keys were held down
         */
        mouseButtons = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action == GLFW.GLFW_PRESS);
                buttonPressed = button;
            }
        };

        /**
         *This is a function to invoke the Mouse cursor and show it
         * @param window the window that received the event
         * @param xpos   the new cursor x-coordinate, relative to the left edge of the content area
         * @param ypos   the new cursor y-coordinate, relative to the top edge of the content area
         */

        cursorPos = new GLFWCursorPosCallback() {

            @Override
            public void invoke(long window, double xpos, double ypos) {
                cursorX = xpos;
                cursorY = ypos;
            }
        };

        /**
         *This is a function to invoke the Mouse Scroll button and scroll down or up
         * @param window  the window that received the event
         * @param xoffset the scroll offset along the x-axis
         * @param yoffset the scroll offset along the y-axis
         */

        mouseScroll = new GLFWScrollCallback() {

            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                scrollX += xoffset;
                scrollY += yoffset;
            }
        };
    }

    /**
     * This is isKeyDown function, which checks whether specific key is down or not
     *
     * @param key the key which maybe down
     * @return the key which is down
     */

    public static boolean isKeyDown(int key) {
        return keys[key];
    }

    /**
     * This is isKeyDown function, which checks whether specific key is down or not
     *
     * @param button the button which may be down
     * @return the button which is down
     */
    public static boolean isButtonDown(int button) {
        return buttons[button];
    }

    /**
     * This is isKeyPressed function, which checks whether specific key is pressed or not
     *
     * @param key the key which may be pressed
     * @return the key which is pressed
     */
    public static boolean isKeyPressed(int key) {
        boolean check = (keyPressed == key);
        if (check) keyPressed = -1;
        return check;
    }

    /**
     * This is isButtonPressed function, which checks whether specific button is pressed or not
     *
     * @param button the button which may be pressed
     * @return the button which is pressed
     */
    public static boolean isButtonPressed(int button) {
        boolean check = (buttonPressed == button);
        if (check) buttonPressed = -1;
        return check;
    }

    /**
     * This is isKeyUp function, which checks whether specific key is up or not
     *
     * @param key the key which maybe up
     * @return the key which is up
     */
    public static boolean isKeyUp(int key) {
        boolean check = (key != keyPressed);
        if (check) keyPressed = -1;
        return check;
    }

    /**
     * This is isButtonUp function, which checks whether specific button is up or not
     *
     * @param button the button which maybe up
     * @return the v which is up
     */
    public static boolean isButtonUp(int button) {
        boolean check = (button != keyPressed);
        if (check) keyPressed = -1;
        return check;
    }

    /**
     * This is a destroy function, which makes every button or key free if they are pressed or down
     */
    public void destroy() {
        keyboard.free();
        mouseButtons.free();
        cursorPos.free();
        mouseScroll.free();
    }

    /**
     * This is an update function, which updates the key or button that is pressed or down
     */
    public void update() {
        GLFW.glfwSetKeyCallback(Window.getWindow(), getKeyboardCallback());
        GLFW.glfwSetMouseButtonCallback(Window.getWindow(), getMouseButtonsCallback());
        GLFW.glfwSetCursorPosCallback(Window.getWindow(), getCursorPosCallback());
    }

    /**
     * This is a getter function, which return the keyboard keys
     *
     * @return Keyboard keys
     */
    public GLFWKeyCallback getKeyboardCallback() {
        return keyboard;
    }

    /**
     * This is a getter function, which return the Mouse buttons
     *
     * @return Mouse buttons
     */
    public GLFWMouseButtonCallback getMouseButtonsCallback() {
        return mouseButtons;
    }

    /**
     * This is a getter function, which returns the current position of cursor
     *
     * @return current position of cursor
     */
    public GLFWCursorPosCallback getCursorPosCallback() {
        return cursorPos;
    }

    /**
     * This is a getter function, which returns the current position of scroll
     *
     * @return current position of scroll
     */
    public GLFWScrollCallback getMouseScrollCallback() {
        return mouseScroll;
    }

    /**
     * This is a getter function, which returns the current X coordinate of cursor
     *
     * @return X coordinate of cursor
     */
    public static double getCursorX() {
        return cursorX;
    }

    /**
     * This is a getter function, which returns the current Y coordinate of cursor
     *
     * @return Y coordinate of cursor
     */
    public static double getCursorY() {
        return cursorY;
    }

    /**
     * This is a getter function, which returns the current X coordinate of scroll
     *
     * @return current X coordinate of scroll
     */
    public static double getScrollX() {
        return scrollX;
    }

    /**
     * This is a getter function, which returns the current Y coordinate of scroll
     *
     * @return current Y coordinate of scroll
     */
    public static double getScrollY() {
        return scrollY;
    }
}