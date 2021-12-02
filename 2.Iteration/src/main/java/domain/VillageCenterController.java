package domain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class VillageCenterController extends SceneController {
    public void talkSteve(){
        talk("steve");
    }

    public void lookBarrel(){
        look("barrel");
    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Button south;

    public void initialize() {
        if(game.getCurrentRoom().getExit("north")==null){
            north.setVisible(false);
        }
        else{
            north.setVisible(true);
        }
        if(game.getCurrentRoom().getExit("east")==null){
            east.setVisible(false);
        }
        else{
            east.setVisible(true);
        }
        if(game.getCurrentRoom().getExit("west")==null){
            west.setVisible(false);
        }
        else{
            west.setVisible(true);
        }
        if(game.getCurrentRoom().getExit("south")==null){
            south.setVisible(false);
        }
        else{
            south.setVisible(true);
        }
    }
public void talkSteve(){

    for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
        if(game.getCurrentRoom().getNPCsName(i)=="steve"){
            talk(game.getCurrentRoom().getNPCs().get(i).getName());
        }
    }

    public void lookPoster(){
        look("poster");
    }
}