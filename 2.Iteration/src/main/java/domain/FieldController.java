package domain;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class FieldController extends SceneController {


    @FXML
    private Button west;

    public void initialize(){
        if(game.getPlayer().getEnergy()==0){
            disableButtons();
        }
    }
    public FieldController() throws FileNotFoundException {
    }

    public void lookStackofsticks() throws FileNotFoundException {
        look("stackofsticks");

    }
    public void disableButtons(){

        west.setDisable(true);

    }
}

