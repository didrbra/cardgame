package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to launch the JavaFX card game application.
 * This class initializes the game controller and view components,
 * setting up the MVC (Model-View-Controller) structure of the application.
 */
public class Main extends Application {

    /**
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set
     */
    @Override
    public void start(Stage primaryStage) {
        GameController controller = new GameController();
        new GameView(primaryStage, controller);
    }

    /**
     * The main entry point for the application.
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
