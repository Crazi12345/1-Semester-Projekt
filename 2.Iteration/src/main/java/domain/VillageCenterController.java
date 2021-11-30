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
    }

    public void lookPoster(){
        look("poster");
    }
}