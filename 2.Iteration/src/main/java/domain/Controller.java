package domain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class Controller {
    public static Game game = new Game();
@FXML
Label textb;
Button west;
Button east;

    @FXML
    public void goNorth(){
        game.goRoom("north");
        textb.setText(game.getCurrentRoom().getLongDescription());

    }
    @FXML
    public void goSouth(){
        game.goRoom("south");

        textb.setText(game.getCurrentRoom().getLongDescription());

    }
    @FXML
    public void goEast() {
        game.goRoom("east");

        textb.setText(game.getCurrentRoom().getLongDescription());
        if (game.getCurrentRoom().getLongDescription() != null) {
            textb.setText(game.getCurrentRoom().getLongDescription());
        } else {
            textb.setText("Dumbass thats a wall");
        }
    }
    @FXML
    public void goWest(){
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
