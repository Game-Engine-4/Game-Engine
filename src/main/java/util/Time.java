package util;

public class Time {
    private static double delta = 0.01f;
    final double fps = 60;
    double previousTime = (double) System.nanoTime();
    double currentTime =  (double) System.nanoTime();
    double deltaTime = 0.0;
    public final double GameRate = (double) 1.0 / this.fps;

    public double getCurrentTime() {
        return this.currentTime;
    }

    public double getPreviousTime() {
        return this.previousTime;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    public void setPreviousTime(double previousTime) {
        this.previousTime = previousTime;
    }

    public void setDeltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
    }

    public double getDeltaTime() {
        return this.deltaTime;
    }

    public static double getDelta() {
        return delta;
    }

    public double calculateDeltaTime() {
        return this.getCurrentTime() - this.getPreviousTime();
    }
}