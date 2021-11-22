package domain;

import javafx.fxml.FXML;

public class VillageCenterController extends Controller {
    public Game game = new Game();

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
