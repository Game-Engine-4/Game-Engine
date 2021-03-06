//type vertex
#version 330

layout (location = 0) in vec3 position;

out vec4 color;

uniform mat4 transform;

void main()
{
    color = vec4(0.0, 1.0, 0.5, 1.0);
    gl_Position = transform * vec4(position, 1.0);
}