package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.io.FileNotFoundException;

public class WellController extends SceneController {


    @FXML
    private Button south;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0) {
            disableButtons();
        }
    }

    public void lookBucket() throws FileNotFoundException {
        look("bucket");
    }

    public WellController() throws FileNotFoundException {
    }

    public void disableButtons() {
        south.setDisable(true);
    }
}
