package Shader;

import static org.lwjgl.opengles.GLES20.*;
import static org.lwjgl.opengles.GLES32.GL_GEOMETRY_SHADER;

public class Shader {
    private int program;

    public Shader() {
        this.program = glCreateProgram();
        if(this.program != 0){
            System.out.println("Shader creation failed");
        }

    }
    public void bind() {
        glUseProgram(this.program);
    }

    public void addVertexShader(String text){
        addProgram(text,GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text) {
      addProgram(text,GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text){
        addProgram(text,GL_FRAGMENT_SHADER);
    }



    private void compileShader() {
        glLinkProgram(program);
        if(glGetProgrami(program, GL_LINK_STATUS) != 0) {
            glGetProgramInfoLog(program, 1024);
        }

        glValidateProgram(program);
        if(glGetProgrami(program, GL_VALIDATE_STATUS) != 0) {
                glGetProgramInfoLog(program, 1024);
        }
    }

    private void addProgram(String text, int type)
    {
        int shader = glCreateShader(type);
        if(shader == 0){
               System.out.println("Shader creation failed!");
        }

        glShaderSource(shader, text);
        glCompileShader(shader);
        if(glGetShaderi(shader, GL_COMPILE_STATUS) == 0) {
                glGetShaderInfoLog(shader, 1024);
        }
        // maybe need switch for later
        glAttachShader(program, shader);
    }
}
