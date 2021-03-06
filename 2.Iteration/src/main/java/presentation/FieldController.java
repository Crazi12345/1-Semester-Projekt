package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class FieldController extends SceneController {


    @FXML
    private Button west;


    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0 || game.getPlayer().getFamilyEnergy() == 0) {
            disableButtons();
        }
    }

    public FieldController() throws FileNotFoundException {
    }

    public void lookStackofsticks() throws FileNotFoundException {
        look("stack-of-sticks");

    }

    public void disableButtons() {

        west.setDisable(true);

    }
}

