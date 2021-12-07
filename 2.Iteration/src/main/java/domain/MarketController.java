package domain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class MarketController extends SceneController{
    public MarketController() throws FileNotFoundException {
    }

    public void talkBaker() throws FileNotFoundException {
        talk("baker");


        }
        public void talkShopper() throws FileNotFoundException {
        talk("shopper");
        }
    }


