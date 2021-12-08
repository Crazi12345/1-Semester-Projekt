package domain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class SchoolController extends SceneController{


    @FXML
    private Button west;

    public void initialize(){
        if(game.getPlayer().getEnergy()==0){
            disableButtons();
        }
    }
    public SchoolController() throws FileNotFoundException {
    }

    public void talkTeacher() throws FileNotFoundException {
        look("teacher");
    }

    public void disableButtons(){

        west.setDisable(true);

    }
}
