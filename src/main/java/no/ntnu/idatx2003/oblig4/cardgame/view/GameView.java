package no.ntnu.idatx2003.oblig4.cardgame.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig4.cardgame.model.Hand;
import no.ntnu.idatx2003.oblig4.cardgame.controller.GameController;

/**
 * The game UI (View) component of the card game.
 * This class handles all the visual elements and user interactions of the game,
 * including displaying the current hand and game statistics.
 */
public class GameView {
    private final Stage stage;
    private final GameController controller;

    private final Label handLabel = new Label("Your Hand: ");
    private final TextField totalValueField = new TextField();
    private final TextField heartsField = new TextField();
    private final TextField queenOfSpadesField = new TextField();
    private final TextField flushField = new TextField();

    /**
     * Creates a new game view.
     *
     * @param stage the primary stage for this JavaFX application
     * @param controller the game controller that handles game logic
     */
    public GameView(Stage stage, GameController controller) {
        this.stage = stage;
        this.controller = controller;
        initializeUI();
    }

    /**
     * Initializes all UI components and sets up the layout.
     * Creates and configures:
     * - Title label
     * - Deal and Check buttons
     * - Display fields for hand information
     * - Layout configuration
     */
    private void initializeUI() {
        Label titleLabel = new Label("Card Game");

        Button dealButton = new Button("Deal Hand");
        dealButton.setOnAction(e -> dealHand());

        Button checkButton = new Button("Check Hand");
        checkButton.setOnAction(e -> checkHand());

        totalValueField.setEditable(false);
        heartsField.setEditable(false);
        queenOfSpadesField.setEditable(false);
        flushField.setEditable(false);


        VBox layout = new VBox(10, titleLabel, dealButton, checkButton, handLabel,
                new Label("Total Value:"), totalValueField,
                new Label("Hearts:"), heartsField,
                new Label("Queen of Spades:"), queenOfSpadesField,
                new Label("Flush:"), flushField);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 400, 400);
        stage.setTitle("Card Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the deal action when the Deal button is clicked.
     * - Deals a new hand through the controller
     * - Updates the hand display
     * - Clears all previous check results
     */
    private void dealHand() {
        controller.dealHand();
        Hand hand = controller.getCurrentHand();

        if (hand != null) {
            handLabel.setText("Your Hand: " + hand.getHandAsString());

            totalValueField.setText("");
            heartsField.setText("");
            queenOfSpadesField.setText("");
            flushField.setText("");
        }
    }

    /**
     * Handles the check action when the Check button is clicked.
     * If a hand exists, displays:
     * - Total value of cards
     * - Hearts in the hand
     * - Presence of queen of spades
     * - Whether hand contains a flush
     * If no hand exists, prompts user to deal first.
     */
    private void checkHand() {
        Hand hand = controller.getCurrentHand();

        if (hand == null) {
                return;
            }

            totalValueField.setText(String.valueOf(hand.getTotalValue()));
            heartsField.setText(hand.getHearts());

        if (hand.findQueenOfSpades()) {
            queenOfSpadesField.setText("Yes");
        } else {
            queenOfSpadesField.setText("No");
        }


        if (hand.hasFlush()) {
            flushField.setText("Yes");
        } else {
            flushField.setText("No");
        }
        }

}
