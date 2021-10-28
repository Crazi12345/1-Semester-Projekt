import java.util.ArrayList;

public class Game
{
    private boolean trading = false;
    private NPC currentTrader;
    private Parser parser;
    private Room currentRoom;
    private Player player = new Player("Marvin",  new ArrayList<Item>());


    public Game() 
    {
        createLevels();
        parser = new Parser();
    }


    public void createLevels(){
        Level dag_1 = new Level(1,null);
        Level dag_2 = new Level(2,null);
        Level dag_3 = new Level(3,null);
        Level dag_4 = new Level(4,null);
        Level dag_5 = new Level(5,null);
        currentRoom = dag_1.createRooms();
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    public void Eat(Command command){
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().get(i).getIsEatable() &
            player.getInventory().get(i).getName().equals(command.getSecondWord())){
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

    public void Look(Command command){
       for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjects().get(i).getName().equals(command.getSecondWord())){
                    System.out.println(currentRoom.getInanimateObjects().get(i).getLongDescription());
                    if (currentRoom.getInanimateObjects().get(i).getIsChecked() == false){
                        currentRoom.getInanimateObjects().get(i).setIsChecked(true);
                        player.addItem(currentRoom.getInanimateObjects().get(i).getItem());
                        System.out.println(currentRoom.getInanimateObjects().get(i).getItem().getName() + " is added to inventory");
                        currentRoom.getInanimateObjects().get(i).setIsChecked(true);
                    }
                    return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if(currentRoom.getNPCs().get(i).getName().equals(command.getSecondWord())){
                System.out.println(currentRoom.getNPCs().get(i).getLongDescription());
                return;
            }
        }
        System.out.println("I don't know what you mean");

    }



    public void Talk(Command command){
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjects().get(i).getName().equals(command.getSecondWord())){
                System.out.println("Doesn't seem very talkative...");
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if(currentRoom.getNPCs().get(i).getName().equals(command.getSecondWord())){
                if (currentRoom.getNPCs().get(i).getTrader() == true) {
                    dialogue(currentRoom.getNPCs().get(i));
                    return;
                }
                else{
                    System.out.println("Pleasure doing business with you");
                    return;
                }
            }
            System.out.println("I don't know what you mean");

        }
        }

    public void dialogue(NPC npc){
        System.out.println(npc.getQuest());
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().get(i).getName() == npc.getQuestItem().getName()){
                System.out.println(npc.getQuestComplete());
                System.out.println("Do you want to give " + npc.getName() + " the " + npc.getQuestItem().getName() + "?");
                trading = true;
                currentTrader = npc;
                break;
            }
        }
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to The Adventures of Marvin!");
        System.out.println("Your job is to help Marvin get food for him and his family");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getInteractablesString());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
// Calling other method in this class
        if(commandWord == CommandWord.UNKNOWN) {
            if(trading) {
                no();
            }
            System.out.println("I don't know what you mean...");

        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            if(trading) {
                no();
            }
                goRoom(command);

        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.EAT){
            if(trading) {
                no();
            }
                Eat(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
            if(trading) {
                no();
            }
            inventory();

        }
        else if (commandWord == CommandWord.LOOK){
            if(trading) {
                no();
            }
                Look(command);

        }
        else if(commandWord == CommandWord.TALK){
            if(trading) {
                no();
            }
                Talk(command);

        }
        else if (commandWord == CommandWord.NO){
            no();
        }
        else if (commandWord == CommandWord.YES){
            yes();
        }
        return wantToQuit;
    }

    private void inventory(){
        if (player.getInventory().size() == 0){
            System.out.println("Inventory is empty...");
        }
        else {
            String inventoryString = "You have: ";
            for (int i = 0; i < player.getInventory().size(); i++) {
                inventoryString += player.getInventory().get(i).getName();
                if (i != player.getInventory().size()-1){
                    inventoryString += ", ";
                }
            }
            System.out.println(inventoryString);
        }
    }

    private void yes(){

        if(trading){
            System.out.println(currentTrader.getQuestItem().getName() + " is removed from inventory");
            System.out.println(currentTrader.getReward().getName() + " is added to inventory");
            player.removeItem(currentTrader.getQuestItem());
            player.addItem(currentTrader.getReward());
            trading = false;
            currentTrader.setTrader(false);
        }
        else{
            System.out.println("That doesn't make sense");
        }
    }

    private void no(){
        if(trading){
            System.out.println("You decline the trade");
            trading = false;
        }
        else{
            System.out.println("That doesn't make sense");
        }
    }

    private void printHelp() 
    {
        System.out.println("You Should help Marvin by getting some food");
        System.out.println("Maybe some people will help you");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(" ");
            System.out.println(currentRoom.getLongDescription());
            System.out.println(currentRoom.getInteractablesString());

        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
