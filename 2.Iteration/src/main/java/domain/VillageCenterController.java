package domain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class VillageCenterController extends SceneController {

@FXML
    private Label textb = new Label();
    @FXML
    private void initialize() {

        textb.setText("I would like to not die");
    }
}