package main;

import Inputs.Input;
import Test.Demo;
import render.Window;
import util.Time;

/**
 * This is the EngineCore class, this is the core of the engine, this class gets the engine running or stops it from running,
 * Renders and updates the window.
 */
public class EngineCore implements Runnable {
    private Thread loopthread;
    private boolean running = false;
    private boolean isRendered = false;
    private static final int width =1280;
    private static final int height = 660;
    private Time time = new Time();
    private static Window frame = new Window(EngineCore.width, EngineCore.height, "Game Engine");
    private Input input = new Input();
    private Game game;

    /**
     * This is a constructor for the EngineCore,
     * this function takes one parameter for the game interface
     * @param game This is the game interface
     */
    public EngineCore(Game game) {
        this.game = game;
    }

    /**
     * This is the function that creates a new thread, which is then used to run the engine
     */
    public void start() {
        if (!this.running) {
            this.running = true;
            this.loopthread = new Thread(this);
            this.loopthread.start();
        }
    }

    /**
     * This is the function that checks if the engine is stopped
     * @return Returns true if the engine is not running
     * @throws InterruptedException thrown when a thread is interrupted while it's waiting, sleeping, or otherwise occupied
     */
    public boolean stop() throws InterruptedException {
        this.running = false;
        this.loopthread = null;
        return true;
    }

    /**
     * This function gets the engine up and running
     */
    @Override
    public void run() {
        frame.init();
        game.init();
        this.time.setPreviousTime((double) System.nanoTime());
        float DeltaTime = 0;
        while (this.running) {

            if (frame.close()) {
                try {
                    this.stop();
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.time.setCurrentTime((double) System.nanoTime());
            this.time.setDeltaTime(this.time.calculateDeltaTime());
            DeltaTime += this.time.calculateDeltaTime();
            Double TempGameRate = this.time.GameRate * 1000000000;
            while (DeltaTime >= TempGameRate) {
                DeltaTime -= TempGameRate;
                update();
            }
            if (!isRendered) {
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.time.setPreviousTime(this.time.getCurrentTime());
        }
    }

    private void update() {
        this.input.update();
        this.frame.update();
        this.game.update();
        this.isRendered = false;
    }

    private void render() throws InterruptedException {
        clean();
        this.game.render();
        this.frame.render();
    }

    private void clean() {
        this.frame.cleanup();
    }

    /**
     * This function tells us if the engine is running
     * @return Returns boolean variable, which is true if the engine is running
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * This function reads inputs
     * @return Returns currently pressed key
     */
    public Input getInput() {
        return this.input;
    }

    /**
     * Just to run EngineCore
     * @param args Args The command line arguments.
     */
    public static void main(String[] args) {
        EngineCore engine = new EngineCore(new Demo());
        engine.start();
    }
}