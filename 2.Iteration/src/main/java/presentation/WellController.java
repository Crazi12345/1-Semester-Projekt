package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


import java.io.File;
import java.io.FileNotFoundException;

public class WellController extends SceneController {
    @FXML
    private ImageView scarecrow;
    @FXML
    private Button south;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getSeenSC()) {
            scarecrow.imageProperty().set(null);
        }
        if (game.getPlayer().getEnergy() == 0 || game.getPlayer().getFamilyEnergy() == 0) {
            disableButtons();
        }
    }

    public void lookWell() throws FileNotFoundException {
        look("well");
        scarecrow.imageProperty().set(null);
        game.setSeenSC(true);
    }

    public void talkAbena() throws FileNotFoundException {
        talk("abena");
    }

    public WellController() throws FileNotFoundException {
    }

    public void disableButtons() {
        south.setDisable(true);
    }
}
