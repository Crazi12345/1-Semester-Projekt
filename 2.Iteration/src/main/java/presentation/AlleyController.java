package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;;
import java.io.FileNotFoundException;

public class AlleyController extends SceneController {
    @FXML
    private Button north;
    @FXML
    private ImageView Football;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getSeenFootball()){
            Football.imageProperty().set(null);
        }
        if (game.getPlayer().getEnergy() == 0) {
            disableButtons();
        }
    }

    public AlleyController() throws FileNotFoundException {
    }

    public void lookFootball() throws FileNotFoundException {
        look("football");
        Football.imageProperty().set(null);
        game.setSeenFootball(true);
    }

    public void disableButtons() {
        north.setDisable(true);

    }

}