package domain;

import javafx.fxml.FXML;

public abstract class Controller {
    public static Game game = new Game();


    @FXML
    public void goNorth(){
        game.goRoom("north");
    }
    @FXML
    public void goSouth(){
        game.goRoom("south");
    }
    @FXML
    public void goEast(){
        game.goRoom("east");
    }
    @FXML
    public void goWest(){
        game.goRoom("west");
    }


}
