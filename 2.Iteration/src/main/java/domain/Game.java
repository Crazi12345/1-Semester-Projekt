package domain;
import java.util.ArrayList;

public class Game {
    private boolean trading = false;
    private NPC currentTrader;
    private Parser parser;
    private Room currentRoom;
    private int currentLevel = 1;
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
                player.levelStartEnergyPlayer();
                player.levelStartEnergyFamily();
                currentRoom = dag_1.createRooms();
                break;
            case 2:
                currentRoom = dag_2.createRooms();
                System.out.println("Welcome to day 2");
                System.out.println(currentRoom.getLongDescription());
                break;
            case 3:
                currentRoom = dag_3.createRooms();
                System.out.println("Welcome to day 3");
                System.out.println(currentRoom.getLongDescription());
                break;
            case 4:
                currentRoom = dag_4.createRooms();
                System.out.println("Welcome to day 4");
                System.out.println(currentRoom.getLongDescription());
                break;
            case 5:
                currentRoom = dag_5.createRooms();
                System.out.println("Welcome to day 5");
                System.out.println(currentRoom.getLongDescription());
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

    public void Look(Command command) {
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjectsName(i).equals(command.getSecondWord())) {
                System.out.println(currentRoom.getInanimateObjectsLongDescription(i));
                try {
                   if (currentRoom.getInanimateObjectsIsChecked(i) == false) {
                       currentRoom.setInanimateObjectsIsChecked(i,true);
                       player.addItem(currentRoom.getInanimateObjectsItem(i));
                       System.out.println(currentRoom.getInanimateObjectsString(i));
                   }
               }
               catch (NullPointerException e){

               }
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if (currentRoom.getNPCsName(i).equals(command.getSecondWord())) {
                System.out.println(currentRoom.getNPCsLongDescription(i));
                return;
            }
        }
            System.out.println("I don't know what you mean");

    }


    public void Talk(Command command) {
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjectsName(i).equals(command.getSecondWord())) {
                System.out.println("Doesn't seem very talkative...");
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if (currentRoom.getNPCsName(i).equals(command.getSecondWord())) {
                if (currentRoom.getNPCsTrader(i) == true) {
                    dialogue(currentRoom.getNPCs().get(i));
                    player.setEnergy(-5);
                    return;
                } else {
                    System.out.println("Pleasure doing business with you");
                    return;
                }
            }
        }
        System.out.println("I don't know what you mean");
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

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
// Calling other method in this class
        if (commandWord == CommandWord.UNKNOWN) {
            if (trading) {
                no();
            }
            System.out.println("I don't know what you mean...");

        } else if (commandWord == CommandWord.GO) {
            if (trading) {
                no();
            } else if (player.getEnergy() == 0) {
                System.out.println("You need to eat!");
            } else {
                goRoom(command);
                if (currentRoom.getId() == 4) {
                    System.out.println("Eating here will give food to your family");
                    System.out.println("You can sleep to get to the next day");
                    player.setFamilyEnergy(-2);
                    if (player.getFamilyEnergy() <= 0) {
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
        } else if (commandWord == CommandWord.ENERGY) {
            energy();
        } else if (commandWord == CommandWord.SLEEP) {
            endLevel();
        }
        return wantToQuit;
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
