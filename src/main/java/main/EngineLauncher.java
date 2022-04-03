package main;

import render.Window;
import util.Const;

public class EngineLauncher {
    private static Window window;
    private static EngineCore engine;

    public static void main(String[] args) {

        window = new Window(Const.TITLE, 1600, 900, false);
        engine = new EngineCore();

        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Window getWindow() {
        return window;
    }
}
