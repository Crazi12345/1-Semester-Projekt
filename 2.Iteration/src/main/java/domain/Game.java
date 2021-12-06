package domain;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private boolean trading = false;
    private NPC currentTrader;
    private Parser parser;
    private Room currentRoom;
    private  int currentLevel = 1;
    private static Player player = new Player("Marvin", new ArrayList<Item>());
    private Level levels = new Level(1);

    public Game() {
        startLevel();
        parser = new Parser();
    }


    public void startLevel() {
        switch (currentLevel) {
            case 1:
                player.levelStartEnergyPlayer();
                player.levelStartEnergyFamily();
                currentRoom = levels.createRooms();
                levels.setExits(currentLevel);
                break;
            case 2:
                System.out.println("Welcome to day 2");
                System.out.println(currentRoom.getLongDescription());
                levels.setExits(currentLevel);
                break;
            case 3:
                System.out.println("Welcome to day 3");
                System.out.println(currentRoom.getLongDescription());
                levels.setExits(currentLevel);
                break;
            case 4:
                System.out.println("Welcome to day 4");
                System.out.println(currentRoom.getLongDescription());
                levels.setExits(currentLevel);
                break;
            case 5:
                System.out.println("Welcome to day 5");
                System.out.println(currentRoom.getLongDescription());
                levels.setExits(currentLevel);
                break;
            default:
                System.out.println("You have completed the game, congratulations! Type 'quit' to end the game");
        }
    }

    public void endLevel() {
        if (currentRoom.getId() == 4) {
            currentLevel++;
            family();
            startLevel();
        } else {
            System.out.println("Sleeping here would surely get you robbed");
        }
    }

    public void family() {
        System.out.println("your family has " + player.getFamilyEnergy() + " energy");
    }


    public void eat(int i) {
            if (currentRoom.getId() == 4 && player.getInventory().get(i).getIsEatable()) {
                player.setEnergyFromItem(i);
                player.setFamilyEnergyFromItem(i);
                player.removeItem(player.getItem(i));
            }
            else if(player.getInventory().get(i).getIsEatable()){
                player.setEnergyFromItem(i);
                player.removeItem(player.getItem(i));

            }
        }

    public NPC getNPCi(int i){
        return getCurrentRoom().getNPCs().get(i);
    }
    public InanimateObjects getInanimateObjectsI(int i){
        return getCurrentRoom().getInanimateObjects().get(i);
    }

    public boolean questComplete(NPC npc) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if(player.getItem(i)== npc.getQuestItem()){
                return true;
            }
        }
        return false;
    }
    public void look(InanimateObjects object){
        if(object.getIsChecked()==false){
            player.addItem(object.getItem());
            object.setIsChecked(true);
            System.out.println(player.getInventory().toString());
        }

    }

    public ArrayList<Item> getInventory(){
        return player.getInventory();
    }

    public void addToInventory(Item item){
        player.addItem(item);
    }

    public void removeFromInventory(Item item){
            player.removeItem(item);
        }


    public void setCurrentTrader(NPC currentTrader) {
        this.currentTrader = currentTrader;
    }

    public NPC getCurrentTrader() {
        return currentTrader;
    }

    /*
    public void dialogue(NPC npc) {
        System.out.println(npc.getQuest());
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getItemName(i) == npc.getQuestItemName()) {
                trading = true;
                break;
            }
        }
    }

 */

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to The Adventures of Marvin!");
        System.out.println("Your job is to help Marvin get food for him and his family");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getInteractablesString());
    }


    private void energy() {
        System.out.println("You have " + player.getEnergy() + " energy left");
        System.out.println("Your family has " + player.getFamilyEnergy() + " energy left");
    }

    private void inventory() {
        if (player.getInventory().size() == 0) {
            System.out.println("Inventory is empty...");
        } else {
            String inventoryString = "You have: ";
            for (int i = 0; i < player.getInventory().size(); i++) {
                inventoryString += player.getItemEnergy(i);
                if (i != player.getInventory().size() - 1) {
                    inventoryString += ", ";
                }
            }
            System.out.println(inventoryString);
        }
    }

    public void yes() {
        player.removeItem(currentTrader.getQuestItem());
        player.addItem(currentTrader.getReward());
        currentTrader.setTrader(false);
    }

    public void no() {
        currentTrader.setTrader(false);
    }

    private void printHelp() {
        System.out.println("You Should help Marvin by getting some food");
        System.out.println("Maybe some people will help you");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Room> getRooms(){
        return levels.getRooms();
    }

    public Room getRoomByID(int id){
        for (int i = 0; i < getRooms().size(); i++) {
            if(id == getRooms().get(i).getId()){
                return getRooms().get(i);
            }
        }
        return null;
    }
    public Player getPlayer(){
        return player;
    }

    public void incrementCurrentLevel(){
        currentLevel++;
    }
    public void goRoom(int id) {
        player.setEnergy(-10);
        currentRoom = getRoomByID(id);
        System.out.println(currentRoom.getLongDescription());
        }

    public Level getLevels(){
        return  levels;
    }
}
