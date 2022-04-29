package MeshShader;

import org.lwjgl.opengl.GL20;
import java.util.HashMap;
import Math.Matrix4x4;
import Math.Vector3f;
import static org.lwjgl.opengl.GL20.*;

public class Shader {
    private int program;
    private HashMap<String, Integer> uniforms;

    public Shader() {
        this.program = GL20.glCreateProgram();
        uniforms = new HashMap<String, Integer>();

        if(this.program == 0){
            System.out.println("Shader creation failed");
            System.exit(1);
        }
    }
    public void bind() {
        GL20.glUseProgram(this.program);
    }

    public void addUniform(String uniform) {
        int uniformLocation = glGetUniformLocation(program, uniform);

        if(uniformLocation == 0xFFFFFFFF) {
            System.err.println("Error: Could not find uniform: " + uniform);
            new Exception().printStackTrace();
            System.exit(1);
        }

        uniforms.put(uniform, uniformLocation);
    }

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

    public int getProgram() {
        return program;
    }

    public void setUniformi(String uniformName, int value) {
        glUniform1i(uniforms.get(uniformName), value);
    }

    public void setUniformf(String uniformName, float value) {
        glUniform1f(uniforms.get(uniformName), value);
    }

    public void setUniform(String uniformName, Vector3f value) {
        glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());
    }

    public void setUniform(String uniformName, Matrix4x4 value) {
        glUniformMatrix4fv(uniforms.get(uniformName), true, Util.createFlippedBuffer(value));
    }
}