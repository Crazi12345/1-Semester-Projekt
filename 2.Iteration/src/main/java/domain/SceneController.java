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
    public static Game game = new Game();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        game.goRoom(1);
        Parent root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);
        stage.show();
    }
    @FXML
    public void setSceneVillageCenter(ActionEvent event) throws IOException {
        game.goRoom(1);
        root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneAlley(ActionEvent event) throws IOException {
        game.goRoom(8);
        root = FXMLLoader.load(getClass().getResource("alley.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneSchool(ActionEvent event) throws IOException {
        game.goRoom(10);
        root = FXMLLoader.load(getClass().getResource("school.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneAbandonedHouse(ActionEvent event) throws IOException {
        game.goRoom(6);
        root = FXMLLoader.load(getClass().getResource("abandonedHouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefarmhouse(ActionEvent event) throws IOException {
        game.goRoom(2);
        root = FXMLLoader.load(getClass().getResource("farmhouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefield(ActionEvent event) throws IOException {
        game.goRoom(5);
        root = FXMLLoader.load(getClass().getResource("field.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneHome(ActionEvent event) throws IOException {
        game.goRoom(4);
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneTrashpile(ActionEvent event) throws IOException {
        game.goRoom(7);
        root = FXMLLoader.load(getClass().getResource("trashpile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneWell(ActionEvent event) throws IOException {
        game.goRoom(9);
        root = FXMLLoader.load(getClass().getResource("well.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneMarket(ActionEvent event) throws IOException {
        game.goRoom(3);
        root = FXMLLoader.load(getClass().getResource("market.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
