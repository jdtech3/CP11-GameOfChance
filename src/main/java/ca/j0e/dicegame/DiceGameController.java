package ca.j0e.dicegame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class DiceGameController {
    Random rand = new Random();
    int money = 50;

    // --- FXML elements ---

    @FXML
    private Label moneyLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label firstDice;

    @FXML
    private Label secondDice;

    @FXML
    private Button highButton;

    @FXML
    private Button lowButton;

    @FXML
    private Button playButton;

    // --- Helper methods ---

    private String rollStr() {
        int roll = rand.nextInt(6) + 1;

        return Integer.toString(roll);
    }

    private int getFirstDice() {
        return Integer.parseInt(firstDice.getText());
    }

    private int getSecondDice() {
        return Integer.parseInt(secondDice.getText());
    }

    private void updateMoney() {
        moneyLabel.setText(String.format("Money: $%d", money));
    }

    private void checkBankrupt() {
        if (money <= 0) {
            statusLabel.setText("Oops, you lost all your money!");
            playButton.setDisable(true);
            highButton.setDisable(true);
            lowButton.setDisable(true);
        }
    }

    // --- Event handlers ---

    @FXML
    protected void onPlayButtonClick() {
        firstDice.setText(rollStr());
        secondDice.setText("0");

        statusLabel.setText("High or Low?");

        playButton.setDisable(true);
        highButton.setDisable(false);
        lowButton.setDisable(false);
    }

    @FXML
    protected void onHighButtonClick() {
        secondDice.setText(rollStr());

        if (getSecondDice() > getFirstDice()) {
            money += 10;
            updateMoney();
            statusLabel.setText("Win! +$10");
        }
        else {
            money -= 10;
            updateMoney();
            statusLabel.setText("Lose. -$10");
        }

        playButton.setDisable(false);
        highButton.setDisable(true);
        lowButton.setDisable(true);

        checkBankrupt();
    }

    @FXML
    protected void onLowButtonClick() {
        secondDice.setText(rollStr());

        if (getSecondDice() < getFirstDice()) {
            money += 10;
            updateMoney();
            statusLabel.setText("Win! +$10");
        }
        else {
            money -= 10;
            updateMoney();
            statusLabel.setText("Lose. -$10");
        }

        playButton.setDisable(false);
        highButton.setDisable(true);
        lowButton.setDisable(true);

        checkBankrupt();
    }
}
