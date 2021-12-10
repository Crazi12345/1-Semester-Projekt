package domain;

import java.util.ArrayList;

public class Game {
    private boolean trading = false;
    private NPC currentTrader;
    private Room currentRoom;
    private int currentLevel = 1;
    private static Player player = new Player("Marvin", new ArrayList<Item>());
    private Level levels = new Level(1);
    private boolean seenFootball;
    private boolean seenDog;
    private boolean seenSC;
    private boolean seenPoster;


    public Game() {
        startLevel();
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

    public void family() {
        System.out.println("your family has " + player.getFamilyEnergy() + " energy");
    }


    public void eat(int i) {
        if (currentRoom.getId() == 4 && player.getInventory().get(i).getIsEatable()) {
            player.setEnergyFromItem(i);
            player.setFamilyEnergyFromItem(i);
            player.removeItem(player.getItem(i));
        } else if (player.getInventory().get(i).getIsEatable()) {
            player.setEnergyFromItem(i);
            player.removeItem(player.getItem(i));
        }
    }

    public NPC getNPCi(int i) {
        return getCurrentRoom().getNPCs().get(i);
    }

    public InanimateObjects getInanimateObjectsI(int i) {
        return getCurrentRoom().getInanimateObjects().get(i);
    }

    public boolean questComplete(NPC npc) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getItem(i) == npc.getQuestItem()) {
                return true;
            }
        }
        return false;
    }

    public void look(InanimateObjects object) {
        if (object.getIsChecked() == false) {
            player.addItem(object.getItem());
            object.setIsChecked(true);
            System.out.println(player.getInventory().toString());
        }

    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public void addToInventory(Item item) {
        player.addItem(item);
    }

    public void removeFromInventory(Item item) {
        player.removeItem(item);
    }


    public void setCurrentTrader(NPC currentTrader) {
        this.currentTrader = currentTrader;
    }

    public NPC getCurrentTrader() {
        return currentTrader;
    }


    public void yes() {
        player.removeItem(currentTrader.getQuestItem());
        player.addItem(currentTrader.getReward());
        currentTrader.setTrader(false);
    }

    public void no() {
        currentTrader.setTrader(false);
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public ArrayList<Room> getRooms() {
        return levels.getRooms();
    }

    public Room getRoomByID(int id) {
        for (int i = 0; i < getRooms().size(); i++) {
            if (id == getRooms().get(i).getId()) {
                return getRooms().get(i);
            }
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public void incrementCurrentLevel() {
        currentLevel++;
    }

    public void goRoom(int id) {
        player.setFamilyEnergy(-6);
        player.setEnergy(-4);
        currentRoom = getRoomByID(id);
        System.out.println(currentRoom.getLongDescription());
    }

    public Level getLevels() {
        return levels;
    }


    public boolean getSeenFootball() {
        return seenFootball;
    }

    public boolean setSeenFootball(boolean seen) {
        return seenFootball = seen;
    }
    public boolean getSeenDog() {
        return seenDog;
    }

    public boolean setSeenDog(boolean seen) {
        return seenDog = seen;
    }
    public boolean getSeenSC() {
        return seenSC;
    }

    public boolean setSeenSC(boolean seen) {
        return seenSC = seen;
    }

    public boolean getSeenPoster() {
        return seenPoster;
    }

    public boolean setSeenPoster(boolean seen) {
        return seenPoster = seen;
    }
}
