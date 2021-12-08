package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.SceneController;

import java.io.FileNotFoundException;

public class MarketController extends SceneController {

    @FXML
    private Button north;
    @FXML
    private Button east;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getPlayer().getEnergy() == 0) {
            disableButtons();
        }
    }

    public MarketController() throws FileNotFoundException {
    }

    public void talkBaker() throws FileNotFoundException {
        talk("baker");


    }

    public void talkShopper() throws FileNotFoundException {
        talk("shopper");
    }

    public void disableButtons() {
        north.setDisable(true);
        east.setDisable(true);

    }
}


