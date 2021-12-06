package domain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.HashMap;

public class SceneController extends Application {
    Stage stage;
    Scene scene;
    AnchorPane root;
    @FXML
    Text dialogueBox;
    @FXML
    Text tradeOffer;
    @FXML
    Button yes = new Button();
    @FXML
    Button no = new Button();
    public static Game game = new Game();
    @FXML
    ImageView slot1, slot2, slot3, slot4, slot5, slot6;

    @FXML
    Image currentImage;

    String currentImageURL;

    Image placeholder = new Image(new FileInputStream("src/main/resources/files/grey.png"));

    public SceneController() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch();
    }

    private String getBatteryName(int energy) {
        String filename = "target/classes/files/battery";
        if (energy > 75) {
            filename += "4";
        } else if (energy > 50) {
            filename += "3";
        } else if (energy > 25) {
            filename += "2";
        } else if (energy > 0) {

            filename += "1";
        } else if (energy == 0) {
            filename += "0";
        }
        filename += ".png";

        return (filename);
    }

    public void addInventoryMenu(AnchorPane root) {
        ImageView imageViewMarvin = new ImageView();
        HBox inventorybox = new HBox();
        ImageView imageViewFamily = new ImageView();
        int marvinEnergy = game.getPlayer().getEnergy();
        System.out.println(game.getPlayer().getEnergy());
        int familyEnergy = game.getPlayer().getFamilyEnergy();


        try {
            Image image = new Image(new FileInputStream(getBatteryName(marvinEnergy)));
            imageViewMarvin = new ImageView(image);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
        try {

            Image image = new Image(new FileInputStream(getBatteryName(familyEnergy)));
            imageViewFamily = new ImageView(image);
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }


        inventorybox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;");
        inventorybox.setMinHeight(100.0);
        root.setBottomAnchor(inventorybox, 0.0);
        root.setLeftAnchor(inventorybox, 0.0);
        root.setRightAnchor(inventorybox, 0.0);
        inventorybox.getChildren().addAll(imageViewMarvin, imageViewFamily);
        root.getChildren().add(inventorybox);
    }

    @Override
    public void start(Stage stage) throws Exception {

        game.goRoom(1);
        root = FXMLLoader.<AnchorPane>load(getClass().getResource("VillageCenter.fxml"));
        addInventoryMenu(root);
        //Parent root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));

        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);

        stage.show();

    }

    public void yes() {
        game.yes();
        resetDialogue();
    }

    public void no() {
        game.no();
        resetDialogue();
    }

    @FXML
    AnchorPane windowpane;
    @FXML
    Text texti = new Text();

    @FXML
    public void initialize() {
        texti.setText("does this work?");

    }

    @FXML
    public void setSceneVillageCenter(ActionEvent event) throws IOException {
        game.goRoom(1);
        root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();


    }


    @FXML
    public void setSceneAlley(ActionEvent event) throws IOException {
        game.goRoom(8);
        root = FXMLLoader.load(getClass().getResource("alley.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSceneSchool(ActionEvent event) throws IOException {
        game.goRoom(10);
        root = FXMLLoader.load(getClass().getResource("school.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSceneAbandonedHouse(ActionEvent event) throws IOException {
        game.goRoom(6);
        root = FXMLLoader.load(getClass().getResource("abandonedHouse.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setScenefarmhouse(ActionEvent event) throws IOException {
        game.goRoom(2);
        root = FXMLLoader.load(getClass().getResource("farmhouse.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setScenefield(ActionEvent event) throws IOException {
        game.goRoom(5);
        root = FXMLLoader.load(getClass().getResource("field.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSceneHome(ActionEvent event) throws IOException {
        game.goRoom(4);
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSceneTrashpile(ActionEvent event) throws IOException {
        game.goRoom(7);
        root = FXMLLoader.load(getClass().getResource("trashpile.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSceneWell(ActionEvent event) throws IOException {
        game.goRoom(9);
        root = FXMLLoader.load(getClass().getResource("well.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void setSceneMarket(ActionEvent event) throws IOException {
        game.goRoom(3);
        root = FXMLLoader.load(getClass().getResource("market.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void talk(String name) {
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if (game.getCurrentRoom().getNPCsName(i) == name) {
                if (game.questComplete(game.getNPCi(i))) {
                    tradeOffer.setText(game.getNPCi(i).getQuestComplete());
                }
            }
        }
    }

    @FXML
    public void look(String name) throws FileNotFoundException {
        for (int i = 0; i < game.getCurrentRoom().getInanimateObjects().size(); i++) {
            if (game.getCurrentRoom().getInanimateObjectsName(i) == name) {
                game.look(game.getInanimateObjectsI(i));
                break;
            }
        }
        loadInventory();
    }

    @FXML
    public void showDialogue(String name) {
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if (game.getNPCi(i).getName() == name && game.getNPCi(i).getTrader()) {
                game.setCurrentTrader(game.getNPCi(i));
                dialogueBox.setText(game.getCurrentTrader().getQuest());
                for (int j = 0; j < game.getInventory().size(); j++) {
                    if (game.getInventory().get(i) == game.getCurrentTrader().getQuestItem()) {
                        yes.setDisable(false);
                        yes.setOpacity(1);
                        no.setDisable(false);
                        no.setOpacity(1);
                        break;
                    }
                }
                break;
            } else {
                dialogueBox.setText(game.getCurrentTrader().getQuestComplete());
                break;
            }
        }
    }

    @FXML
    public void resetDialogue() {
        dialogueBox.setText(" ");
        yes.setDisable(true);
        yes.setOpacity(0);
        no.setDisable(true);
        no.setOpacity(0);
    }

    @FXML
    public void loadInventory() throws FileNotFoundException {

        slot1.setImage(placeholder);
        slot2.setImage(placeholder);
        slot3.setImage(placeholder);
        slot4.setImage(placeholder);
        slot5.setImage(placeholder);
        slot6.setImage(placeholder);
        for (int i = 0; i < game.getInventory().size(); i++) {
            currentImageURL = game.getInventory().get(i).getFileName();
            currentImage = new Image((new FileInputStream(currentImageURL)));
                switch (i){
                    case 0: slot1.setImage(currentImage);
                        break;
                    case 1: slot2.setImage(currentImage);
                        break;
                    case 2: slot3.setImage(currentImage);
                        break;
                    case 3: slot4.setImage(currentImage);
                        break;
                    case 4: slot5.setImage(currentImage);
                        break;
                    case 5: slot6.setImage(currentImage);
                        break;
                }
            }
        }

    public void eatSlot1(){
        game.eat(0);
    }
    public void eatSlot2(){
        game.eat(1);
    }
    public void eatSlot3(){
        game.eat(2);
    }
    public void eatSlot4(){
        game.eat(3);
    }
    public void eatSlot5(){
        game.eat(4);
    }
    public void eatSlot6(){
        game.eat(5);
    }

    }




