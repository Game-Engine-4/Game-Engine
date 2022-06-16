package render;
import Inputs.Input;
import Math.Vector3f;
import util.Time;

/**
 *  This is the camera class, this class creates a single instance of the camera,
 *  handles inputs, and according to the inputs moves or rotates the camera.
 */
public class Camera {

    /**
     * This is a parameter that is used to specify the Y axis
     */
    public static final Vector3f yAxis = new Vector3f(0,1,0);
    private Vector3f pos;
    private Vector3f forward;
    private Vector3f up;
    private static Camera instance;

    private Camera() {
        this(new Vector3f(0,0,0), new Vector3f(0,0,1), new Vector3f(0,1,0));
    }

    private Camera(Vector3f pos, Vector3f forward, Vector3f up) {
        this.pos = pos;
        this.forward = forward;
        this.up = up;

        up.normalize();
        forward.normalize();
    }

    /**
     * This function creates the one and only instance of the camera
     * @return Returns instance, which is instance of the camera class
     */
    public static Camera getInstance(){
        if(instance == null){
            instance = new Camera();
        }
        return instance;
    }

    /**
     * This function handles inputs, and moves the camera according to the specified input
     */
    public void input() {

        float movAmt = (float)(10 * Time.getDelta());
        float rotAmt = (float)(100 * Time.getDelta());

        if(Input.isKeyPressed(87))
            move(getForward(), movAmt);
        if(Input.isKeyPressed(83))
            move(getForward(), -movAmt);
        if(Input.isKeyPressed(65))
            move(getLeft(), movAmt);
        if(Input.isKeyPressed(68))
            move(getRight(), movAmt);
        if(Input.isKeyPressed(69))
            move(getUp(), movAmt);
        if(Input.isKeyPressed(81))
            move(getUp(), -movAmt);

        if(Input.isKeyPressed(73))
            rotateX(-rotAmt);
        if(Input.isKeyPressed(75))
            rotateX(rotAmt);
        if(Input.isKeyPressed(74))
            rotateY(-rotAmt);
        if(Input.isKeyPressed(76))
            rotateY(rotAmt);
    }

    /**
     * This is a move functions, this function moves the camera to a given direction,
     * This function takes two parameters for direction and amount.
     * @param dir This is a parameter that specifies the direction of the movement
     * @param amt This is a parameter that specifies the amount of the movement
     */
    public void move(Vector3f dir, float amt) {
        pos = pos.add(dir.mul(amt));
    }

    /**
     * This is a Rotation function that rotates the camera on the Y axis,
     * this function takes one parameter for the angle.
     * @param angle This is a parameter that specifies the angle of rotation
     */
    public void rotateY(float angle) {
        Vector3f Haxis = yAxis.cross(forward);
        Haxis.normalize();

        forward.rotate(angle, yAxis);
        forward.normalize();

        up = forward.cross(Haxis);
        up.normalize();
    }

    /**
     * This is a Rotation function that rotates the camera on the X axis,
     * this function takes one parameter for the angle.
     * @param angle This is a parameter that specifies the angle of rotation
     */
    public void rotateX(float angle) {
        Vector3f Haxis = yAxis.cross(forward);
        Haxis.normalize();

        forward.rotate(angle, Haxis);
        forward.normalize();

        up = forward.cross(Haxis);
        up.normalize();
    }

    /**
     * This function gives us the left direction of the camera in relation to the current position
     * @return Returns left, which is left direction of the camera
     */
    public Vector3f getLeft() {
        Vector3f left = forward.cross(up);
        left.normalize();
        return left;
    }

    /**
     * This function gives us the right direction of the camera in relation to the current position
     * @return Returns right, which is right direction of the camera
     */
    public Vector3f getRight() {
        Vector3f right = up.cross(forward);
        right.normalize();
        return right;
    }

    /**
     * This is a function to get the current position of the camera.
     * @return Returns pos, which is current position of the camera
     */
    public Vector3f getPos() {
        return pos;
    }

    /**
     * This function sets camera to a position,
     * this function takes one parameter for position
     * @param pos This is a parameter that specifies the position that we want to set the camera to
     */
    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    /**
     * This function gives us the forward direction of the camera in relation to the current position
     * @return Returns forward, which is forward direction of the camera
     */
    public Vector3f getForward() {
        return forward;
    }

    /**
     * This function can set the forward direction of the camera,
     * this function takes one parameter for the direction
     * @param forward This is a parameter that specifies the forward direction
     */
    public void setForward(Vector3f forward) {
        this.forward = forward;
    }

    /**
     * This function gives us the upward direction of the camera
     * @return Returns up, which is upward direction of the camera
     */
    public Vector3f getUp() {
        return up;
    }

    /**
     * This function sets the upward direction of the camera
     * @param up This parameter specifies the upward direction
     */
    public void setUp(Vector3f up) {
        this.up = up;
    }
}