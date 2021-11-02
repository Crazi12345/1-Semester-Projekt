import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class Game {
    private boolean trading = false;
    private NPC currentTrader;
    private Parser parser;
    private Room currentRoom;
    private int currentLevel = 5;
    private Player player = new Player("Marvin", new ArrayList<Item>());


    public Game() {
        startLevel();
        parser = new Parser();
    }


    public void startLevel() {
        Level dag_1 = new Level(1);
        Level dag_2 = new Level(2);
        Level dag_3 = new Level(3);
        Level dag_4 = new Level(4);
        Level dag_5 = new Level(5);
        switch (currentLevel) {
            case 1:
                player.levelStartEnergy();
                currentRoom = dag_1.createRooms();
                break;
            case 2:
                player.levelStartEnergy();
                currentRoom = dag_2.createRooms();
                System.out.println("Welcome to day 2");
                break;
            case 3:
                player.levelStartEnergy();
                currentRoom = dag_3.createRooms();
                System.out.println("Welcome to day 3");
                break;
            case 4:
                player.levelStartEnergy();
                currentRoom = dag_4.createRooms();
                System.out.println("Welcome to day 4");
                break;
            case 5:
                player.levelStartEnergy();
                currentRoom = dag_5.createRooms();
                System.out.println("Welcome to day 5");
                break;
            default:
                System.out.println("You have completed the game, congratulations! Type 'quit' to end the game");
        }
    }

    public void endLevel() {
        if(currentRoom.getId() == 4) {
            currentLevel++;
            family();
            startLevel();
        }
        else {
            System.out.println("Sleeping here would surely get you robbed");
        }
    }

    public void family(){
        System.out.println("your family has " + player.getFamilyEnergy() + " energy");
    }

    public void play() {
        printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    public void Eat(Command command) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().get(i).getIsEatable() &
                    player.getInventory().get(i).getName().equals(command.getSecondWord()) &
                    currentRoom.getId()==4){
                player.setEnergy(player.getInventory().get(i).getFoodEnergy()/2);
                player.setFamilyEnergy(player.getInventory().get(i).getFoodEnergy()/2);

                System.out.println("You and your family ate the " + player.getInventory().get(i).getName());
                //checks if you are at home, for item name and if item isEatable, you then split the energy
                //from the item between you and your family
                return;
            }
            else if (player.getInventory().get(i).getIsEatable() &
                    player.getInventory().get(i).getName().equals(command.getSecondWord())) {
                player.setEnergy(player.getInventory().get(i).getFoodEnergy());

                System.out.println("You ate the " + player.getInventory().get(i).getName());
                player.removeItem(player.getInventory().get(i));

                return;
                //checks for name and isEatable, if those are true, it adds the energy to the player and
                //removes the item
            }
        }
        System.out.println("I don't know what you mean");
    }

    public void Look(Command command) {
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjects().get(i).getName().equals(command.getSecondWord())) {
                System.out.println(currentRoom.getInanimateObjects().get(i).getLongDescription());
                if (currentRoom.getInanimateObjects().get(i).getIsChecked() == false) {
                    currentRoom.getInanimateObjects().get(i).setIsChecked(true);
                    player.addItem(currentRoom.getInanimateObjects().get(i).getItem());
                    System.out.println(currentRoom.getInanimateObjects().get(i).getItem().getName() + " is added to inventory");
                    currentRoom.getInanimateObjects().get(i).setIsChecked(true);
                    currentRoom.getInanimateObjects().remove(i);
                }
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if (currentRoom.getNPCs().get(i).getName().equals(command.getSecondWord())) {
                System.out.println(currentRoom.getNPCs().get(i).getLongDescription());
                return;
            }
        }
        System.out.println("I don't know what you mean");

    }


    public void Talk(Command command) {
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjects().get(i).getName().equals(command.getSecondWord())) {
                System.out.println("Doesn't seem very talkative...");
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if (currentRoom.getNPCs().get(i).getName().equals(command.getSecondWord())) {
                if (currentRoom.getNPCs().get(i).getTrader() == true) {
                    dialogue(currentRoom.getNPCs().get(i));
                    player.setEnergy(-5);
                    return;
                } else {
                    System.out.println("Pleasure doing business with you");
                    return;
                }

            }
            System.out.println("I don't know what you mean");

        }
    }

    public void dialogue(NPC npc) {
        System.out.println(npc.getQuest());
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().get(i).getName() == npc.getQuestItem().getName()) {
                System.out.println(npc.getQuestComplete());
                System.out.println("Do you want to give " + npc.getName() + " the " + npc.getQuestItem().getName() + "?");
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

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
// Calling other method in this class
        if (commandWord == CommandWord.UNKNOWN) {
            if (trading) {
                no();
            }
            System.out.println("I don't know what you mean...");

        }


        else if (commandWord == CommandWord.GO) {
            if (trading) {
                no();
            }
            else if (player.getEnergy() == 0) {
                System.out.println("You need to eat!");
            }
            else{
                goRoom(command);
                if(currentRoom.getId() == 4) {
                    System.out.println("Eating here will give food to your family");
                    System.out.println("You can sleep to get to the next day");
                    player.setFamilyEnergy(-2);
                    if(player.getFamilyEnergy() <= 0){
                        System.out.println("Your family, unfortunately, died. They were just too hungry");
                        wantToQuit = true;
                    }
                }
            }
        } else if (commandWord == CommandWord.TALK) {
            if (trading) {
                no();
            }
            Talk(command);
        }
        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.EAT) {
            if (trading) {
                no();
            }
            Eat(command);
        } else if (commandWord == CommandWord.INVENTORY) {
            if (trading) {
                no();
            }
            inventory();

        } else if (commandWord == CommandWord.LOOK) {
            if (trading) {
                no();
            }
            Look(command);

        } else if (commandWord == CommandWord.NO) {
            no();
        } else if (commandWord == CommandWord.YES) {
            yes();
        } else if (commandWord == CommandWord.ENERGY){
            energy();
        } else if (commandWord == CommandWord.SLEEP){
            endLevel();
        }
        return wantToQuit;
    }

    private void energy(){
        System.out.println("You have " + player.getEnergy() + " energy left");
        System.out.println("Your family has " + player.getFamilyEnergy() + " energy left");
    }

    private void inventory() {
        if (player.getInventory().size() == 0) {
            System.out.println("Inventory is empty...");
        } else {
            String inventoryString = "You have: ";
            for (int i = 0; i < player.getInventory().size(); i++) {
                inventoryString += player.getInventory().get(i).getName();
                if (i != player.getInventory().size() - 1) {
                    inventoryString += ", ";
                }
            }
            System.out.println(inventoryString);
        }
    }

    private void yes() {

        if (trading) {
            System.out.println(currentTrader.getQuestItem().getName() + " is removed from inventory");
            System.out.println(currentTrader.getReward().getName() + " is added to inventory");
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

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Can't go that way");
        } else {
            player.setEnergy(-10);
            currentRoom = nextRoom;
            System.out.println(" ");
            System.out.println(currentRoom.getLongDescription());
            System.out.println(currentRoom.getInteractablesString());

        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
