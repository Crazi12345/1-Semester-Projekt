package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class TrashpileController extends SceneController {


    @FXML
    private Button east;

    public void initialize() throws FileNotFoundException {
        loadInventory();
    }

    public TrashpileController() throws FileNotFoundException {
    }

    public void talkHomelessman() throws FileNotFoundException {
        talk("homelessman");

    }

    public void disableButtons() {

        east.setDisable(true);

    }

}
