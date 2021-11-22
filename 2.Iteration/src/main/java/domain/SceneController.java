package domain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController extends Application {
    Stage stage;
    Scene scene;
    Parent root;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);
        stage.show();
    }

    @FXML
    public void setSceneVillageCenter(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneAlley(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("alley.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneSchool(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("school.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
