package main;

/**
 * When someone creates to create game,this interface will be used to pass
 * init, render, adn update functions to the engine
 */
public interface Game {

    /**
     * Initialize an object after its creation
     */
    void init();

    /**
     * Updates window
     */
    void update();

    /**
     * Renders the window
     */
    void render();

}