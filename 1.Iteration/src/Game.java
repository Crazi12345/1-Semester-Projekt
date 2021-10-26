import java.sql.SQLOutput;
import java.util.ArrayList;

public class Game
{
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
            player.getInventory().get(i).getName() == command.getSecondWord()){
                player.setEnergy(player.getInventory().get(i).getFoodEnergy());
                player.getInventory().remove(i);
                break;
                //checks for name and isEatable, if those are true, it adds the energy to the player and
                //removes the item
            }
        }{
            
        }

    }

    public void Look(Command command){
        for (int i = 0; i < currentRoom.getInanimateObjects().size(); i++) {
            if (currentRoom.getInanimateObjects().get(i).getName() == command.getSecondWord()
            && currentRoom.getInanimateObjects().get(i).getClass().getName() == "InanimateObjects"){
                currentRoom.getInanimateObjects().get(i).setIsChecked(true);
                player.addItem(currentRoom.getInanimateObjects().get(i).getItem());
                System.out.println(currentRoom.getInanimateObjects().get(i).getLongDescription());
                System.out.println(currentRoom.getInanimateObjects().get(i).getItem().getName() + " is added to inventory");
                return;
            }
        }
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            if(currentRoom.getNPCs().get(i).getName() == command.getSecondWord()
            && currentRoom.getNPCs().get(i).getClass().toString() == "NPC"){
                System.out.println(currentRoom.getNPCs().get(i).getLongDescription());
                return;
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
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.EAT){
            Eat(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
            System.out.println(player.getInventory().toString());
        }
        else if (commandWord == CommandWord.LOOK){
            Look(command);
        }
        return wantToQuit;
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
