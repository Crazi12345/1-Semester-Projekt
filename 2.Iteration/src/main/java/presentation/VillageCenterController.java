package presentation;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VillageCenterController extends SceneController {

    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Button south;
    @FXML
    private ImageView poster;

    public VillageCenterController() throws FileNotFoundException {
    }


    public void talkSteve() throws FileNotFoundException {
        talk("steve");
    }

    public void lookBarrel() throws FileNotFoundException {
        look("barrel");

    }
    public void initialize() throws FileNotFoundException {
        loadInventory();
        if (game.getSeenPoster()) {
            poster.imageProperty().set(null);
        }
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

        if (game.getPlayer().getEnergy() == 0 || game.getPlayer().getFamilyEnergy() == 0) {
            disableButtons();
        }

    }


    public void rulesAlert() {
        Stage rulesWindow = new Stage();
        rulesWindow.initModality(Modality.APPLICATION_MODAL);
        rulesWindow.setTitle("Rules");

        Label rules = new Label();
        rules.setText("The Rules are simple, help marvin get food\n" +
                "You can do that by collecting food or help people\n" +
                "You can eat food by clicking on it in your inventory\n" +
                "interact with the characters and items on screen by clicking\n" +
                "You gain energy by eating and lose it by walking                            \n" +
                "If you or your familys energy is depleted you will die\n" +
                "If you eat at your food at your home, you will feed your family as well      \n" +
                "There are 5 days to get through, you can sleep to start a new day\n" +
                "and maybe there will be new places to explore\n" +

                "               \n\r\r\r\r");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(rules);

        Scene scene = new Scene(layout);
        rulesWindow.setScene(scene);
        rulesWindow.show();

    }

    public void lookPoster() throws FileNotFoundException {
        look("poster");
        poster.imageProperty().set(null);
        game.setSeenPoster(true);
    }

    public void disableButtons() {
        north.setDisable(true);
        east.setDisable(true);
        west.setDisable(true);
        south.setDisable(true);
    }

}