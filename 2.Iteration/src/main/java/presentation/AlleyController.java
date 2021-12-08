package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.SceneController;

import java.io.FileNotFoundException;

public class AlleyController extends SceneController {

    @FXML
    private Button north;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0) {
            disableButtons();
        }
    }

    public AlleyController() throws FileNotFoundException {
    }

    public void lookFootball() throws FileNotFoundException {
        look("football");
    }

    public void disableButtons() {
        north.setDisable(true);

    }

}