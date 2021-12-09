package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


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

    public void lookScarecrow() throws FileNotFoundException {
        look("scarecrow");
    }

    public WellController() throws FileNotFoundException {
    }

    public void disableButtons() {
        south.setDisable(true);
    }
}
