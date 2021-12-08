package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.SceneController;

import java.io.FileNotFoundException;

public class FarmHouseController extends SceneController {


    @FXML
    private Button east;
    @FXML
    private Button west;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0) {
            disableButtons();
        }
    }

    public FarmHouseController() throws FileNotFoundException {
    }

    public void talkFarmer() throws FileNotFoundException {
        talk("farmer");
    }

    public void disableButtons() {
        west.setDisable(true);
        east.setDisable(true);

    }
}
