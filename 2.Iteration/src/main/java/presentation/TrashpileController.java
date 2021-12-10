package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class TrashpileController extends SceneController {

    @FXML
    private ImageView dog;

    @FXML
    private Button east;

    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getSeenDog()){
            dog.imageProperty().set(null);
        }
    }

    public TrashpileController() throws FileNotFoundException {
    }

    public void lookDog() throws FileNotFoundException {
        look("dog");
        dog.imageProperty().set(null);
        game.setSeenDog(true);
    }

    public void talkHomelessman() throws FileNotFoundException {
        talk("homeless-man");

    }

    public void disableButtons() {

        east.setDisable(true);

    }

}
