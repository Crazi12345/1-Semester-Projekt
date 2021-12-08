package domain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.controlsfx.control.action.Action;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeController extends SceneController {
    @FXML
    private Button sleep;
    @FXML
    private Button north;

    public HomeController() throws FileNotFoundException {

    }



    public void initialize() {
        if (game.getCurrentRoom().getExit("north") == null) {
            north.setVisible(false);
        } else {
            north.setVisible(true);
        }
    }
@FXML
    private void onSleepClick(ActionEvent event)throws IOException {
    System.out.println("Slept like a baby");
    game.incrementCurrentLevel();
    game.startLevel();
    sleep.setDisable(true);
}

}
