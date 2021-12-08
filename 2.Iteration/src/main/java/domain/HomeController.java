package domain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeController extends SceneController {
    @FXML
    private Button sleep;
    @FXML
    private Button north;
    @FXML
    private Button south;
    @FXML
    private Button east;

    @FXML
    private Button sleepWin;

    public HomeController() throws FileNotFoundException {

    }



    public void initialize() {
        try{
        if(game.getCurrentLevel() == 5){
            sleepWin.setVisible(true);
            sleep.setVisible(false);
        }
        else{
            sleep.setVisible(true);
            sleepWin.setVisible(false);
        }

        if (game.getCurrentRoom().getExit("north") == null) {
            north.setVisible(false);
        } else {
            north.setVisible(true);
        }}
          catch (NullPointerException e){
            System.out.println(e);
        }
        if(game.getPlayer().getEnergy()==0){
        disableButtons();
        }
    }
@FXML
    private void onSleepClick(ActionEvent event)throws IOException {
    System.out.println("Slept like a baby");
    game.incrementCurrentLevel();
    game.startLevel();
    if(game.getCurrentLevel() == 5){
        sleepWin.setVisible(true);
        sleep.setVisible(false);
    }
    sleep.setDisable(true);
}
@FXML
    public void setWinScreen(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("winScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

 @FXML
 public void disableButtons(){
        north.setDisable(true);
     east.setDisable(true);
     south.setDisable(true);
 }

}
