package domain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AlleyController extends SceneController {

    @FXML
    private Button north;
    public void initialize(){
        if(game.getPlayer().getEnergy()==0){
            disableButtons();
        }
    }

    public AlleyController() throws FileNotFoundException {
    }

    public void lookFootball() throws FileNotFoundException {
        look("football");
}
    public void disableButtons(){
        north.setDisable(true);

    }

}