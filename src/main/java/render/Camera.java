package render;
import Inputs.Input;
import Math.Vector3f;
import util.Time;

public class Camera
{
    public static final Vector3f yAxis = new Vector3f(0,1,0);

    private Vector3f pos;
    private Vector3f forward;
    private Vector3f up;

    public Camera()
    {
        this(new Vector3f(0,0,0), new Vector3f(0,0,1), new Vector3f(0,1,0));
    }

    public Camera(Vector3f pos, Vector3f forward, Vector3f up)
    {
        this.pos = pos;
        this.forward = forward;
        this.up = up;

        up.normalize();
        forward.normalize();
    }

    public void input()
    {

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

        if(Input.isKeyPressed(73))
            rotateX(-rotAmt);
        if(Input.isKeyPressed(75))
            rotateX(rotAmt);
        if(Input.isKeyPressed(74))
            rotateY(-rotAmt);
        if(Input.isKeyPressed(76))
            rotateY(rotAmt);
    }

    public void move(Vector3f dir, float amt)
    {
        pos = pos.add(dir.mul(amt));
    }

    public void rotateY(float angle)
    {
        Vector3f Haxis = yAxis.cross(forward);
        Haxis.normalize();

        forward.rotate(angle, yAxis);
        forward.normalize();

        up = forward.cross(Haxis);
        up.normalize();
    }

    public void rotateX(float angle)
    {
        Vector3f Haxis = yAxis.cross(forward);
        Haxis.normalize();

        forward.rotate(angle, Haxis);
        forward.normalize();

        up = forward.cross(Haxis);
        up.normalize();
    }

    public Vector3f getLeft()
    {
        Vector3f left = forward.cross(up);
        left.normalize();
        return left;
    }

    public Vector3f getRight()
    {
        Vector3f right = up.cross(forward);
        right.normalize();
        return right;
    }

    public Vector3f getPos()
    {
        return pos;
    }

    public void setPos(Vector3f pos)
    {
        this.pos = pos;
    }

    public Vector3f getForward()
    {
        return forward;
    }

    public void setForward(Vector3f forward)
    {
        this.forward = forward;
    }

    public Vector3f getUp()
    {
        return up;
    }

    public void setUp(Vector3f up)
    {
        this.up = up;
    }
}