package MeshShader;

import org.lwjgl.opengl.GL20;
import java.util.HashMap;
import Math.Matrix4x4;
import Math.Vector3f;
import static org.lwjgl.opengl.GL20.*;

/**
 * Abstract base class for programmable shader code, Shaders take the input from the previous pipeline stage
 * (e.g. vertex positions, colors, and rasterized pixels) and customize the output to the next stage.
 */
public class Shader {
    private int program;
    private HashMap<String, Integer> uniforms;

    /**
     * Class constructor that is called by any Shader implementation
     */
    public Shader() {
        this.program = GL20.glCreateProgram();
        uniforms = new HashMap<String, Integer>();

        if(this.program == 0){
            System.out.println("Shader creation failed");
            System.exit(1);
        }
    }
    /**
     * Method which installs a program object as part of current rendering state
     */
    public void bind() {
        GL20.glUseProgram(this.program);
    }

    /**
     * Method taking some string and make shader to start tracking of it
     * @param uniform name of uniform
     */
    public void addUniform(String uniform) {
        int uniformLocation = glGetUniformLocation(program, uniform);

        if(uniformLocation == 0xFFFFFFFF) {
            System.err.println("Error: Could not find uniform: " + uniform);
            new Exception().printStackTrace();
            System.exit(1);
        }

        uniforms.put(uniform, uniformLocation);
    }

    /**
     * Method which compiles a GLSL shader into binary data so that it can be used by a WebGLProgram.
     */
    public void compileShader() {
        GL20.glLinkProgram(program);
        if(GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == 0) {
            GL20.glGetProgramInfoLog(program, 1024);
            System.exit(1);
        }

        GL20.glValidateProgram(program);
        if(GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == 0) {
            GL20.glGetProgramInfoLog(program, 1024);
            System.exit(1);
        }
    }

    /**
     * Method which attaches a shader object to a program object
     * @param text String parameter to show path of shader
     * @param type Parameter to show shader type
     */
    public void addProgram(String text, int type) {
        int shader = GL20.glCreateShader(type);
        if(shader == 0){
            System.out.println("Shader creation failed!");
            System.exit(1);
        }
        GL20.glShaderSource(shader, text);
        GL20.glCompileShader(shader);
        if(GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0) {
            GL20.glGetShaderInfoLog(shader, 1024);
            System.exit(1);
        }
        GL20.glAttachShader(program, shader);
    }

    /**
     * Method to get current program
     * @return Integer, current rendering state
     */
    public int getProgram() {
        return program;
    }

    /**
     * Method to change value of uniform according to name and int value
     * @param uniformName Name of uniform
     * @param value Integer value to set to uniform
     */
    public void setUniformi(String uniformName, int value) {
        glUniform1i(uniforms.get(uniformName), value);
    }
    /**
     * Method to change value of uniform according to name and float value
     * @param uniformName Name of uniform
     * @param value Float value to set to uniform
     */
    public void setUniformf(String uniformName, float value) {
        glUniform1f(uniforms.get(uniformName), value);
    }
    /**
     * Method to change value of uniform according to name and vector - getting coordinates from it
     * @param uniformName Name of uniform
     * @param value 3-element vector
     */
    public void setUniform(String uniformName, Vector3f value) {
        glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());
    }
    /**
     * Method to change value of uniform according to name and matrix
     * @param uniformName Name of uniform
     * @param value Matrix used to get flipped buffer
     */
    public void setUniform(String uniformName, Matrix4x4 value) {
        glUniformMatrix4fv(uniforms.get(uniformName), true, Util.createFlippedBuffer(value));
    }
}