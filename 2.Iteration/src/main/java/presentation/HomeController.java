package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public class HomeController extends SceneController {
    @FXML
    private Button sleep;
    @FXML
    private Button north;
    @FXML
    private Button south;
    @FXML
    private Button east;
    @FXML
    private Button sleepWin;
    @FXML
    Hyperlink link;

    public HomeController() throws FileNotFoundException {

    }


    public void initialize() throws FileNotFoundException {

        try {
            loadInventory();
            if (game.getCurrentLevel() == 5) {
                sleepWin.setVisible(true);
                sleep.setVisible(false);
            } else {
                sleep.setVisible(true);
                sleepWin.setVisible(false);
            }

            if (game.getCurrentRoom().getExit("north") == null) {
                north.setVisible(false);
            } else {
                north.setVisible(true);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        if (game.getPlayer().getEnergy() == 0 || game.getPlayer().getFamilyEnergy() == 0) {
            disableButtons();
        }
    }

    @FXML
    private void onSleepClick(ActionEvent event) throws IOException {
        System.out.println("Slept like a baby");
        game.incrementCurrentLevel();
        game.startLevel();

        sleep.setDisable(true);
        switch (game.getCurrentLevel()) {
            case 1:
                dialogueBox.setText("Welcome to day 1");
                break;
            case 2:
                dialogueBox.setText("Welcome to day 2");
                break;
            case 3:
                dialogueBox.setText("Welcome to day 3");
                break;
            case 4:
                dialogueBox.setText("Welcome to day 4");
                break;
            case 5:
                dialogueBox.setText("Welcome to day 5");
                break;
        }
    }

    @FXML
    public void setWinScreen(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("winScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void openWebPage() throws Exception {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.verdensmaalene.dk/maal/2"));
    }

    @FXML
    public void disableButtons() {
        try {
            north.setDisable(true);
            east.setDisable(true);
            south.setDisable(true);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

}
