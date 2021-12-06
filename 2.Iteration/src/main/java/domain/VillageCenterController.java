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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VillageCenterController extends SceneController {

    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Button south;

    public VillageCenterController() throws FileNotFoundException {
    }

    public void talkSteve(){
        talk("steve");
        dialogueSteve();
    }

    public void lookBarrel() throws FileNotFoundException {
        look("barrel");

    }
        public void initialize () {
            if (game.getCurrentRoom().getExit("north") == null) {
                north.setVisible(false);
            } else {
                north.setVisible(true);
            }
            if (game.getCurrentRoom().getExit("east") == null) {
                east.setVisible(false);
            } else {
                east.setVisible(true);
            }
            if (game.getCurrentRoom().getExit("west") == null) {
                west.setVisible(false);
            } else {
                west.setVisible(true);
            }
            if (game.getCurrentRoom().getExit("south") == null) {
                south.setVisible(false);
            } else {
                south.setVisible(true);
            }
        }

     /*   public void talkSteve () {

            for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
                if (game.getCurrentRoom().getNPCsName(i) == "steve") {
                    talk(game.getCurrentRoom().getNPCs().get(i).getName());
                }
            }
        }*/
            public void rulesAlert(){
                Stage rulesWindow = new Stage();
                rulesWindow.initModality(Modality.APPLICATION_MODAL);
                rulesWindow.setTitle("Rules");

                Label rules = new Label();
                rules.setText("The Rules are simple, help marvin get food\n"+
                        "You can do that by collecting food or help people\n"+
                        "You can eat food by clicking on it in your inventory\n" +
                        "You gain energy by eating and lose it by walking                                           \n\r\r\r\r");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(rules);

                Scene scene = new Scene(layout);
                rulesWindow.setScene(scene);
                rulesWindow.show();

            }

            public void lookPoster() throws FileNotFoundException {
                look("poster");
            }

            @FXML
            public void dialogueSteve() {
                showDialogue("steve");
            }

    }