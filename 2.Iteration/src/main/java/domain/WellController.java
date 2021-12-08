package domain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class WellController extends SceneController{


    @FXML
    private Button south;
    public void initialize(){
        if(game.getPlayer().getEnergy()==0){
            disableButtons();
        }
    }


    public WellController() throws FileNotFoundException {
    }
    public void disableButtons(){
        south.setDisable(true);
    }

    public void talkAbena() throws FileNotFoundException{
        talk("abena");
    }
    public void lookWell() throws FileNotFoundException {
        look("well");
    }

}
