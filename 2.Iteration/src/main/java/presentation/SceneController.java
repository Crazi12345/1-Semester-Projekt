package presentation;

import domain.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SceneController extends Application {
    Stage stage;
    Scene scene;
    AnchorPane root;
    @FXML
    Image placeholder = new Image(new FileInputStream("src/main/resources/files/grey.png"));
    @FXML
    Text dialogueBox;
    @FXML
    Text tradeOffer;
    @FXML
    Button yes;
    @FXML
    Button no;
    public static Game game = new Game();
    @FXML
    ImageView slot1, slot2, slot3, slot4, slot5, slot6;
    @FXML
    Image currentImage;

    String currentImageURL;


    public SceneController() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
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

    public void addInventoryMenu(AnchorPane root) throws FileNotFoundException {
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

        inventorybox.setMinHeight(100.0);
        root.setBottomAnchor(inventorybox, 0.0);
        root.setLeftAnchor(inventorybox, 0.0);
        inventorybox.getChildren().addAll(imageViewMarvin, imageViewFamily);
        root.getChildren().add(inventorybox);

    }

    @Override
    public void start(Stage stage) throws Exception {

        root = FXMLLoader.<AnchorPane>load(getClass().getResource("startScreen.fxml"));
        stage.setResizable(false);
        stage.setTitle("Life in Congo");
        stage.getIcons().add(new Image("file:bread.png"));
        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);
        stage.show();
    }

    public void yes(ActionEvent event) {
        resetDialogue();
        game.yes();
    }

    public void no(ActionEvent event) {
        resetDialogue();
        game.no();
    }

    @FXML
    AnchorPane windowpane;
    @FXML
    Text texti = new Text();

    @FXML
    public void initialize() throws FileNotFoundException {

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
        loadInventory();

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
        loadInventory();

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
        loadInventory();

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
        loadInventory();

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
        loadInventory();

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
        loadInventory();

    }

    @FXML
    public void setSceneHome(ActionEvent event) throws IOException {
        game.goRoom(4);
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        loadInventory();
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
        loadInventory();

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
        loadInventory();

    }

    @FXML
    public void setSceneMarket(ActionEvent event) throws IOException {
        game.goRoom(3);
        root = FXMLLoader.load(getClass().getResource("market.fxml"));
        addInventoryMenu(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        loadInventory();
        stage.show();

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
    public void talk(String name) throws FileNotFoundException {
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if (game.getCurrentRoom().getNPCsName(i) == name) {
                game.setCurrentTrader(game.getCurrentRoom().getNPCs().get(i));
                dialogueBox.setText(game.getCurrentTrader().getQuest());
                if (game.questComplete(game.getCurrentTrader())) {
                    tradeOffer.setText(game.getCurrentTrader().getQuestComplete());
                    try {
                        yes.setDisable(false);
                        yes.setOpacity(1);
                        no.setDisable(false);
                        no.setOpacity(1);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        }
        loadInventory();
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
            switch (i) {
                case 0:
                    slot1.setImage(currentImage);
                    break;
                case 1:
                    slot2.setImage(currentImage);
                    break;
                case 2:
                    slot3.setImage(currentImage);
                    break;
                case 3:
                    slot4.setImage(currentImage);
                    break;
                case 4:
                    slot5.setImage(currentImage);
                    break;
                case 5:
                    slot6.setImage(currentImage);
                    break;
            }
        }
        System.out.println("inventory loaded");
    }

    public void lookBucket(MouseEvent mouseEvent) {
    }


    public void eatSlot1() throws FileNotFoundException, NullPointerException {
        if (game.getPlayer().getInventory().size() > 0) {
            game.eat(0);
            loadInventory();
            getBatteryName(game.getPlayer().getEnergy());
        }
    }

    public void eatSlot2() throws FileNotFoundException {
        if (game.getPlayer().getInventory().size() > 1) {
            game.eat(1);
            loadInventory();
            getBatteryName(game.getPlayer().getEnergy());
        }
    }

    public void eatSlot3() throws FileNotFoundException {
        if (game.getPlayer().getInventory().size() > 2) {
            game.eat(2);
            loadInventory();
            getBatteryName(game.getPlayer().getEnergy());
        }
    }

    public void eatSlot4() throws FileNotFoundException {
        if (game.getPlayer().getInventory().size() > 3) {
            game.eat(3);
            loadInventory();
            getBatteryName(game.getPlayer().getEnergy());
        }
    }

    public void eatSlot5() throws FileNotFoundException {
        if (game.getPlayer().getInventory().size() > 4) {
            game.eat(4);
            loadInventory();
            getBatteryName(game.getPlayer().getEnergy());

        }
    }

    public void eatSlot6() throws FileNotFoundException {
        if (game.getPlayer().getInventory().size() > 5) {
            game.eat(5);
            getBatteryName(game.getPlayer().getEnergy());
        }
    }

}




