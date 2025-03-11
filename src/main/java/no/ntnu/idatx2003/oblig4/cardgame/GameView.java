package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The game UI (View).
 */
public class GameView {
    private final Stage stage;
    private final GameController controller;

    private final Label handLabel = new Label("Your Hand: ");
    private final TextField totalValueField = new TextField();
    private final TextField heartsField = new TextField();
    private final TextField queenOfSpadesField = new TextField();
    private final TextField flushField = new TextField();

    public GameView(Stage stage, GameController controller) {
        this.stage = stage;
        this.controller = controller;
        initializeUI();
    }

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

    private void checkHand() {
        Hand hand = controller.getCurrentHand();

        if (hand == null) {
                return;
            }

            totalValueField.setText(String.valueOf(hand.getTotalValue()));
            heartsField.setText(hand.getHearts());
            queenOfSpadesField.setText(hand.findQueenOfSpades() ? "Yes" : "No");
            flushField.setText(hand.hasFlush() ? "Yes" : "No");
        }

}
