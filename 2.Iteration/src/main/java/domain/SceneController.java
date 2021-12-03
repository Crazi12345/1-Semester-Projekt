package domain;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SceneController extends Application {
    Stage stage;
    Scene scene;
    AnchorPane root;
    public static Game game = new Game();

    public static void main(String[] args) {
        launch();
    }

    private String getBatteryName(int energy){
        String filename = "target/classes/files/battery";
        if(energy>75){
            filename+="4";
        }
        else if (energy>50){
            filename+="3";
        }
        else if (energy>25){
            filename+="2";
        }
        else if (energy>0){
            filename+="1";
        }
        else if (energy==0){
            filename+="0";
        }
        filename+=".png";
        return(filename);
    }

    public void addInventoryMenu(AnchorPane root) {
        HBox inventorybox = new HBox();
        ImageView imageViewMarvin = new ImageView();
        ImageView imageViewFamily = new ImageView();
        int marvinEnergy = game.getPlayer().getEnergy();
        int familyEnergy = game.getPlayer().getFamilyEnergy();
        System.out.println(game.getPlayer().getEnergy());

        try {
            Image image = new Image(new FileInputStream(getBatteryName(marvinEnergy)));
            imageViewMarvin = new ImageView(image);
        }
        catch (FileNotFoundException e) {
            System.out.println("not found");
        }
        try {
            Image image = new Image(new FileInputStream(getBatteryName(familyEnergy)));
            imageViewFamily = new ImageView(image);
        }
        catch (FileNotFoundException e) {
            System.out.println("not found");
        }


        //inventorybox.setFill(Color.PINK);
        /*root.setBottomAnchor(imageViewMarvin, 10.0);
        root.setBottomAnchor(imageViewFamily, 10.0);*/
        //root.setBottomAnchor(inver)
        //root.set
        inventorybox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;");
        inventorybox.setMinHeight(100.0);
        root.setBottomAnchor(inventorybox, 0.0);
        root.setRightAnchor(inventorybox,0.0);
        root.setLeftAnchor(inventorybox,0.0);
        inventorybox.getChildren().addAll(imageViewMarvin,imageViewFamily);
        root.getChildren().add(inventorybox);
    }

    @Override
    public void start(Stage stage) throws Exception {

        game.goRoom(1);
        root = FXMLLoader.<AnchorPane>load(getClass().getResource("VillageCenter.fxml"));
        addInventoryMenu(root);
        //Parent root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        Text text = new Text();
        text.setText("ur mum");
        text.setX(50.0);
        text.setY(50.0);
        root.getChildren().add(text);

        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);
        stage.show();

    }

    @FXML
    AnchorPane windowpane;
    @FXML
    Text texti = new Text();

    @FXML
    public void initialize(){
        texti.setText("does this work?");

    }

    @FXML
    public void setSceneVillageCenter(ActionEvent event) throws IOException {
        game.goRoom(1);
        root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void setSceneAlley(ActionEvent event) throws IOException {
        game.goRoom(8);
        root = FXMLLoader.load(getClass().getResource("alley.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneSchool(ActionEvent event) throws IOException {
        game.goRoom(10);
        root = FXMLLoader.load(getClass().getResource("school.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneAbandonedHouse(ActionEvent event) throws IOException {
        game.goRoom(6);
        root = FXMLLoader.load(getClass().getResource("abandonedHouse.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefarmhouse(ActionEvent event) throws IOException {
        game.goRoom(2);
        root = FXMLLoader.load(getClass().getResource("farmhouse.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefield(ActionEvent event) throws IOException {
        game.goRoom(5);
        root = FXMLLoader.load(getClass().getResource("field.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneHome(ActionEvent event) throws IOException {
        game.goRoom(4);
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneTrashpile(ActionEvent event) throws IOException {
        game.goRoom(7);
        root = FXMLLoader.load(getClass().getResource("trashpile.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneWell(ActionEvent event) throws IOException {
        game.goRoom(9);
        root = FXMLLoader.load(getClass().getResource("well.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneMarket(ActionEvent event) throws IOException {
        game.goRoom(3);
        root = FXMLLoader.load(getClass().getResource("market.fxml"));
        addInventoryMenu(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void talk(String name){
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if(game.getCurrentRoom().getNPCsName(i)==name){
                game.talk(game.getNPCi(i));
            }
        }
    }
    @FXML
    public void look(String name){
        for (int i = 0; i < game.getCurrentRoom().getInanimateObjects().size(); i++) {
            if(game.getCurrentRoom().getInanimateObjectsName(i)==name){
                game.look(game.getInanimateObjectsI(i));
            }
        }
    }
}
