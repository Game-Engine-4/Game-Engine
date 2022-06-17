package util;

/**
 * This class implements all utility functions that are related to time, like calulating, masuring and so on.
 */
public class Time {
    private static double delta = 0.01f;
    final double fps = 60;
    double previousTime = (double) System.nanoTime();
    double currentTime = (double) System.nanoTime();
    double deltaTime = 0.0;

    /**
     * How many frames a monitor can refresh every second.
     */
    public final double GameRate = (double) 1.0 / this.fps;

    /**
     * Getter, returns the current time of drawn
     *
     * @return the time the current time of drawn
     */
    public double getCurrentTime() {
        return this.currentTime;
    }

    /**
     * Getter, returns the time the previous time of drawn
     *
     * @return the time the previous time of drawn
     */
    public double getPreviousTime() {
        return this.previousTime;
    }

    /**
     * Setter, set the current time of drawn
     *
     * @param currentTime the parameter of the current time of drawn
     */
    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Setter, set the previous time of drawn
     *
     * @param previousTime the parameter of the previous time of drawn
     */
    public void setPreviousTime(double previousTime) {
        this.previousTime = previousTime;
    }

    /**
     * Setter, set the elapsed time since the last frame was drawn
     *
     * @param deltaTime the parameter of delta time when last frame was drawn
     */
    public void setDeltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
    }

    /**
     * Getter, returns the elapsed time since the last frame was drawn
     *
     * @return the elapsed time since the last frame was drawn
     */
    public static double getDelta() {
        return delta;
    }

    /**
     * This function calculates the difference between current and previous time
     *
     * @return returns the difference between current and previous time
     */
    public double calculateDeltaTime() {
        return this.getCurrentTime() - this.getPreviousTime();
    }
}