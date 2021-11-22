package domain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public abstract class Controller {
    public static Game game = new Game();
@FXML
Label textb;
Button west;
Button east;

    @FXML
    public void goNorth() throws IOException {
        game.goRoom("north");
        textb.setText(game.getCurrentRoom().getLongDescription());

    }
    @FXML
    public void goSouth() throws IOException {
        game.goRoom("south");

        textb.setText(game.getCurrentRoom().getLongDescription());

    }
    @FXML
    public void goEast() throws IOException {
        game.goRoom("east");

        textb.setText(game.getCurrentRoom().getLongDescription());
        if (game.getCurrentRoom().getLongDescription() != null) {
            textb.setText(game.getCurrentRoom().getLongDescription());
        } else {
            textb.setText("Dumbass thats a wall");
        }
    }
    @FXML
    public void goWest() throws IOException {
        game.goRoom("west");
        west.setVisible(false);
        if(game.getCurrentRoom().getLongDescription()!=null){
        textb.setText(game.getCurrentRoom().getLongDescription());

        }
        else {
            west.setVisible(false);
        }
    }


}
