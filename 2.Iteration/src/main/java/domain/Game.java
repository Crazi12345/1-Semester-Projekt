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
    private int currentLevel = 1;
    private Player player = new Player("Marvin", new ArrayList<Item>());
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


    public void Eat(Command command) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getItem(i).getIsEatable() &
                    player.getItemName(i).equals(command.getSecondWord()) &
                    currentRoom.getId() == 4) {
                player.setEnergyFromItem(i);
                player.setFamilyEnergyFromItem(i);
                System.out.println(player.familyEatString(i));
                player.removeItem(player.getItem(i));

                //checks if you are at home, for item name and if item isEatable, you then split the energy
                //from the item between you and your family
                return;
            } else if (player.getItem(i).getIsEatable() &
                    player.getItemName(i).equals(command.getSecondWord())) {
                player.setEnergyFromItem(i);
                System.out.println(player.eatString(i));
                player.removeItem(player.getItem(i));

                return;
                //checks for name and isEatable, if those are true, it adds the energy to the player and
                //removes the item
            }
        }
        System.out.println("I don't know what you mean");
    }

    public NPC getNPCi(int i){
        return getCurrentRoom().getNPCs().get(i);
    }
    public InanimateObjects getInanimateObjectsI(int i){
        return getCurrentRoom().getInanimateObjects().get(i);
    }

    public void talk(NPC npc) {
                if (npc.getTrader() == true) {
                    dialogue(npc);
                    player.setEnergy(-5);
                    return;
                } else {
                    System.out.println("Pleasure doing business with you");
                    return;
                }
    }
    public void look(InanimateObjects object){
        if(object.getIsChecked()==false){
            player.addItem(object.getItem());
            object.setIsChecked(true);
            System.out.println(player.getInventory().toString());
        }

    }


    public void dialogue(NPC npc) {
        System.out.println(npc.getQuest());
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getItemName(i) == npc.getQuestItemName()) {
                System.out.println(npc.getQuestComplete());
                System.out.println(npc.answerQuest());
                trading = true;
                currentTrader = npc;
                break;
            }
        }
    }

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

    private void yes() {
        if (trading) {
            System.out.println(currentTrader.getQuestItemName() + " is removed from inventory");
            System.out.println(currentTrader.getRewardName() + " is added to inventory");
            player.removeItem(currentTrader.getQuestItem());
            player.addItem(currentTrader.getReward());
            trading = false;
            currentTrader.setTrader(false);
        } else {
            System.out.println("That doesn't make sense");
        }
    }

    private void no() {
        if (trading) {
            System.out.println("You decline the trade");
            trading = false;
        } else {
            System.out.println("That doesn't make sense");
        }
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

    public void goRoom(int id) {
        player.setEnergy(-10);
        currentRoom = getRoomByID(id);
        System.out.println(currentRoom.getLongDescription());
        }
}
