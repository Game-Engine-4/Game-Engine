package Math;

import render.Camera;

public class Transform {
    private static Camera camera;
    private static float zNear;
    private static float zFar;
    private static float width;
    private static float height;
    private static float fov;
    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;

    public Transform() {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }
    public Matrix4x4 getProjectedTransformation()
    {
        Matrix4x4 transformationMatrix = getTransformation();
        Matrix4x4 projectionMatrix = new Matrix4x4().InitProjection(fov, width, height, zNear, zFar);
        Matrix4x4 cameraRotation = new Matrix4x4().InitCamera(camera.getForward(), camera.getUp());
        Matrix4x4 cameraTranslation = new Matrix4x4().InitTranslation(-camera.getPos().getX(), -camera.getPos().getY(), -camera.getPos().getZ());

        return projectionMatrix.Mul(cameraRotation.Mul(cameraTranslation.Mul(transformationMatrix)));
    }

    public Matrix4x4 getTransformation() {
        Matrix4x4 translationMatrix = new Matrix4x4().InitTranslation(translation.getX(), translation.getY(), translation.getZ());
        Matrix4x4 rotationMatrix = new Matrix4x4().InitRotation(rotation.getX(), rotation.getY(), rotation.getZ());
        Matrix4x4 scaleMatrix = new Matrix4x4().InitScale(scale.getX(), scale.getY(), scale.getZ());

        return translationMatrix.Mul(rotationMatrix.Mul(scaleMatrix));
    }
    public static void setProjection(float fov, float width, float height, float zNear, float zFar)
    {
        Transform.fov = fov;
        Transform.width = width;
        Transform.height = height;
        Transform.zNear = zNear;
        Transform.zFar = zFar;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public void setRotation(float x, float y, float z) {
        this.rotation = new Vector3f(x, y, z);
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setScale(float x, float y, float z) {
        this.scale = new Vector3f(x, y, z);
    }
    public static Camera getCamera()
    {
        return camera;
    }

    public static void setCamera(Camera camera)
    {
        Transform.camera = camera;
    }
}
