package main;

import render.Window;

public class MainApp {
    public static void main(String[] args) {
        Window window = new Window();
        window.createWindow(1280, 720, "Test Window");

        while (!window.shouldClose()) {
            window.updateWindow();
        }
        window.closeWindow();
    }
}
