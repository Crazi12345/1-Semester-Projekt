package domain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.spec.ECField;
import java.util.HashMap;

public class SceneController extends Application {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    Text dialogueBox;
    @FXML
    Text tradeOffer;
    @FXML
    Button yes = new Button();
    @FXML
    Button no = new Button();
    public static Game game = new Game();

    public SceneController(){
    }

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        game.goRoom(1);
        Parent root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        Scene villageCenter = new Scene(root);
        stage.setScene(villageCenter);

        stage.show();

    }
    public void yes(){
        game.yes();
        resetDialogue();
    }
    public void no(){
        game.no();
        resetDialogue();
    }
    @FXML
    public void setSceneVillageCenter(ActionEvent event) throws IOException {
        game.goRoom(1);
        root = FXMLLoader.load(getClass().getResource("VillageCenter.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();



    }
    @FXML
    public void setSceneAlley(ActionEvent event) throws IOException {
        game.goRoom(8);
        root = FXMLLoader.load(getClass().getResource("alley.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneSchool(ActionEvent event) throws IOException {
        game.goRoom(10);
        root = FXMLLoader.load(getClass().getResource("school.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneAbandonedHouse(ActionEvent event) throws IOException {
        game.goRoom(6);
        root = FXMLLoader.load(getClass().getResource("abandonedHouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefarmhouse(ActionEvent event) throws IOException {
        game.goRoom(2);
        root = FXMLLoader.load(getClass().getResource("farmhouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setScenefield(ActionEvent event) throws IOException {
        game.goRoom(5);
        root = FXMLLoader.load(getClass().getResource("field.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneHome(ActionEvent event) throws IOException {
        game.goRoom(4);
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneTrashpile(ActionEvent event) throws IOException {
        game.goRoom(7);
        root = FXMLLoader.load(getClass().getResource("trashpile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setSceneWell(ActionEvent event) throws IOException {
        game.goRoom(9);
        root = FXMLLoader.load(getClass().getResource("well.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void setSceneMarket(ActionEvent event) throws IOException {
        game.goRoom(3);
        root = FXMLLoader.load(getClass().getResource("market.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void talk(String name){
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if(game.getCurrentRoom().getNPCsName(i)==name){
                if(game.questComplete(game.getNPCi(i))) {
                    tradeOffer.setText(game.getNPCi(i).getQuestComplete());
                }
            }
        }
    }
    @FXML
    public void look(String name){
        for (int i = 0; i < game.getCurrentRoom().getInanimateObjects().size(); i++) {
            if(game.getCurrentRoom().getInanimateObjectsName(i)==name){
                game.look(game.getInanimateObjectsI(i));
                return;
            }
        }
    }
    @FXML
    public void showDialogue(String name){
        for (int i = 0; i < game.getCurrentRoom().getNPCs().size(); i++) {
            if(game.getNPCi(i).getName()==name && game.getNPCi(i).getTrader()){
                game.setCurrentTrader(game.getNPCi(i));
                dialogueBox.setText(game.getCurrentTrader().getQuest());
                for (int j = 0; j < game.getInventory().size(); j++) {
                    if(game.getInventory().get(i)==game.getCurrentTrader().getQuestItem()){
                        yes.setDisable(false);
                        yes.setOpacity(1);
                        no.setDisable(false);
                        no.setOpacity(1);
                        break;
                    }
                }
                break;
            }
            else{
                dialogueBox.setText(game.getCurrentTrader().getQuestComplete());
                break;
            }
        }
    }

    @FXML
    public void resetDialogue(){
        dialogueBox.setText(" ");
        yes.setDisable(true);
        yes.setOpacity(0);
        no.setDisable(true);
        no.setOpacity(0);
    }


    public void lookBucket(MouseEvent mouseEvent) {
    }
}
