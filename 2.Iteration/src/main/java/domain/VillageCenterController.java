package domain;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VillageCenterController extends Controller {

@FXML
    private Label textb = new Label();
    @FXML
    private void initialize() {

        textb.setText("I would like to not die");
    }
}