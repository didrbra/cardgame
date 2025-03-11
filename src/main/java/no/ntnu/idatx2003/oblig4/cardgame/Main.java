package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to launch the JavaFX application.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameController controller = new GameController();
        new GameView(primaryStage, controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
