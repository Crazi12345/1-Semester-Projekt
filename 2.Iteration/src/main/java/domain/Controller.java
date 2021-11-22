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

public abstract class Controller {
    public static Game game = new Game();
    @FXML
    public void goNorth() throws IOException {
        game.goRoom("north");
    }
    @FXML
    public void goSouth() throws IOException {
        game.goRoom("south");
    }
    @FXML
    public void goEast() throws IOException {
        game.goRoom("east");
    }
    @FXML
    public void goWest() throws IOException {
        game.goRoom("west");
    }


}
