package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class AbandonedHouseController extends SceneController {


    @FXML
    private Button west;
    @FXML
    private Button south;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0 || game.getPlayer().getFamilyEnergy() == 0) {
            disableButtons();
        }
    }

    public AbandonedHouseController() throws FileNotFoundException {
    }

    public void disableButtons() {

        west.setDisable(true);
        south.setDisable(true);
    }
}
