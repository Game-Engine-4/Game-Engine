package MeshShader;

import org.lwjgl.opengl.GL20;

public class Shader {
    private int program;

    public Shader() {
        this.program = GL20.glCreateProgram();
        if(this.program == 0){
            System.out.println("Shader creation failed");
            System.exit(1);
        }
    }
    public void bind() {
        GL20.glUseProgram(this.program);
    }

//    public void addVertexShader(String text){
//        addProgram(text,GL20.GL_VERTEX_SHADER);
//    }

//    public void addGeometryShader(String text) {
//      addProgram(text, GL20.GL_GEOMETRY_SHADER);
//    }

//    public void addFragmentShader(String text){
//        addProgram(text,GL20.GL_FRAGMENT_SHADER);
//    }

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
}