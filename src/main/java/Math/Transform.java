package Math;

public class Transform {
    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;

    public Transform() {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }

    public Matrix4x4 getTransformation() {
        Matrix4x4 translationMatrix = new Matrix4x4().InitTranslation(translation.getX(), translation.getY(), translation.getZ());
        Matrix4x4 rotationMatrix = new Matrix4x4().InitRotation(rotation.getX(), rotation.getY(), rotation.getZ());
        Matrix4x4 scaleMatrix = new Matrix4x4().InitScale(scale.getX(), scale.getY(), scale.getZ());

        return translationMatrix.Mul(rotationMatrix.Mul(scaleMatrix));
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
}
