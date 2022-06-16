package Math;

import render.Camera;

/**
 * Transform class provides factory methods for the simple transformations - rotating,
 * scaling, and translation. It allows to get the transformation matrix elements for any transform.
 */
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

    /**
     * Constructor that initializes the position and rotation to zeros and scales to one
     */
    public Transform() {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }

    /**
     * Get our transformation, and then it's going to pass it through whatever our projection is
     * @return Whatever that edge translation is. (Transformation + Projection)
     */
    public Matrix4x4 getProjectedTransformation() {
        Matrix4x4 transformationMatrix = getTransformation();
        Matrix4x4 projectionMatrix = new Matrix4x4().InitProjection(fov, width, height, zNear, zFar);
        Matrix4x4 cameraRotation = new Matrix4x4().InitCamera(camera.getForward(), camera.getUp());
        Matrix4x4 cameraTranslation = new Matrix4x4().InitTranslation(-camera.getPos().getX(), -camera.getPos().getY(), -camera.getPos().getZ());

        return projectionMatrix.Mul(cameraRotation.Mul(cameraTranslation.Mul(transformationMatrix)));
    }

    /**
     * The function, which returns the transformation matrix of the transform.
     * By multiplying the translation, rotation and scale matrix's
     * @return The transformation matrix of the transform
     */
    public Matrix4x4 getTransformation() {
        Matrix4x4 translationMatrix = new Matrix4x4().InitTranslation(translation.getX(), translation.getY(), translation.getZ());
        Matrix4x4 rotationMatrix = new Matrix4x4().InitRotation(rotation.getX(), rotation.getY(), rotation.getZ());
        Matrix4x4 scaleMatrix = new Matrix4x4().InitScale(scale.getX(), scale.getY(), scale.getZ());

        return translationMatrix.Mul(rotationMatrix.Mul(scaleMatrix));
    }

    /**
     * Setter function, which sets the desired parameters to the camera
     * @param fov - Field of view, some angle away from our face (camera)
     * @param width - Screen width
     * @param height - Screen height
     * @param zNear How near something can be from us (camera)
     * @param zFar - How near something can be from us (camera)
     */
    public static void setProjection(float fov, float width, float height, float zNear, float zFar) {
        Transform.fov = fov;
        Transform.width = width;
        Transform.height = height;
        Transform.zNear = zNear;
        Transform.zFar = zFar;
    }

    /**
     * Getter function, which returns the translation
     * @return - Current translation
     */
    public Vector3f getTranslation() {
        return translation;
    }

    /**
     * Setter function, which sets a translation operation to this transform
     * @param translation - Translation vector (x,y,z)
     */
    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    /**
     * Setter function, which sets a translation operation to this transform
     * @param x - translation (x axis)
     * @param y - translation (y axis)
     * @param z - translation (z axis)
     */
    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

    /**
     * Getter function, which returns the rotation vector of the transform
     * @return The 3 float rotation vector of the transform
     */
    public Vector3f getRotation() {
        return rotation;
    }

    /**
     * Setter function, which sets the rotation of the transform from a Vector3f vector
     * @param rotation Desired rotation vector
     */
    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    /**
     * Setter function, which sets the rotation of the transform from a 3 float vector
     * @param x Desired rotation value
     * @param y Desired rotation value
     * @param z Desired rotation value
     */
    public void setRotation(float x, float y, float z) {
        this.rotation = new Vector3f(x, y, z);
    }

    /**
     * Getter function, which returns the scale vector of the transform
     * @return The 3 float scale vector of the transform
     */
    public Vector3f getScale() {
        return scale;
    }

    /**
     * Setter function, which sets the scale value of the vector
     * @param scale - The desired scale value to be set
     */
    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    /**
     * Setter function, which sets the scale value by floats
     * @param x - The desired first float value to be set
     * @param y - The desired second float value to be set
     * @param z - The desired third float value to be set
     */
    public void setScale(float x, float y, float z) {
        this.scale = new Vector3f(x, y, z);
    }

    /**
     * Getter function, which returns the camera
     * @return The current camera
     */
    public static Camera getCamera() {
        return camera;
    }

    /**
     * Setter function, which sets the camera to transformation
     * @param camera - The desired value of the camera to be set
     */
    public static void setCamera(Camera camera) {
        Transform.camera = camera;
    }
}