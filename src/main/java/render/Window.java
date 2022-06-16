package render;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.opengl.GL20.*;

/**
 * This is the window class, this class initializes and handles the window.
 */
public class Window {
    private final int width;
    private final int height;
    private final String title;
    private static long window;
    private final GLFWImage.Buffer icon;

    /**
     * This is the default constructor for the window, which takes in three parameters
     * @param width This parameter specifies the width of the window
     * @param height This parameter specifies the height of the window
     * @param title This parameter specifies the title of the window
     */
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = null;
    }

    /**
     * This is the alternative constructor for the window, which takes in four parameters
     * @param width This parameter specifies the width of the window
     * @param height This parameter specifies the height of the window
     * @param title This parameter specifies the title of the window
     * @param icon This is the parameter for the icon of the window
     */
    public Window(int width, int height, String title, GLFWImage.Buffer icon) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = icon;
    }

    /**
     * This is the init function, which initializes the window
     */
    public void init() {
        if (!glfwInit()) {
            throw new RuntimeException("core.Window could not be initialised");
        }

        // Configurations for the core.Window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUSED, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        if (window == 0) {
            throw new RuntimeException("core.Window could not be created");
        }

        if (getIcon() != null) {
            glfwSetWindowIcon(window, getIcon());
        }

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        if (vidMode == null) {
            throw new RuntimeException("GLFWVidMode is null.");
        }

        glfwSetWindowPos(window, (vidMode.width() - getWidth()) / 2, (vidMode.height() - getHeight()) / 2);

        glfwMakeContextCurrent(window);

        glfwSwapInterval(1);

        glfwShowWindow(window);

        GL.createCapabilities();
    }

    /**
     * This is the render function, which swaps buffers
     */
    public void render() {
        glfwSwapBuffers(window);
    }

    /**
     * This is the update function
     */
    public void update() {
        glfwPollEvents();
    }

    /**
     * This is the cleanup function, it cleans up the window
     */
    public void cleanup() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    /**
     * This function closes the window
     * @return Returns true if the window should close
     */
    public boolean close() {
        boolean shouldClose = glfwWindowShouldClose(window);
        if (shouldClose) {
            cleanup();
        }
        return shouldClose;
    }

    /**
     * This function gives us the width of the window
     * @return Returns width
     */
    public int getWidth() {
        return width;
    }

    /**
     * This function gives us the height of the window
     * @return Returns height
     */
    public int getHeight() {
        return height;
    }

    /**
     * This function gives us the title of the window
     * @return Returns the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This function gives us the icon of the window
     * @return Returns the icon
     */
    public GLFWImage.Buffer getIcon() {
        return icon;
    }

    /**
     * This function gives us the window
     * @return Returns the window
     */
    public static long getWindow() {
        return window;
    }
}