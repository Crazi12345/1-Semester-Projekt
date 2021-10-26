import java.util.ArrayList;

public class Level {

    private int id;
    private ArrayList<Item> items;
    private ArrayList<Interactables> interactables;
    private ArrayList<Room> rooms;

    public Level(int id, ArrayList<Room> rooms) {

        this.id = id;
        this.items = items;
        this.rooms = rooms;

    }
    public Room createRooms()
    {
        Room Village_center, Farm, Market, Home, Field;
        Item Fish = new Item("fish",69,"Smells like teen spirit");
        NPC Steve = new NPC("Steve","Fat and looks like a nerd",Fish,
                "His fingers are full of cheetoo dust and he smells fishy");
        ArrayList<NPC> npcs= new ArrayList<NPC>();
        npcs.add(Steve);
        Village_center = new Room(1,"in the village center",npcs,new ArrayList<InanimateObjects>());
        Farm = new Room(2,"at a farm", new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        Market = new Room(3,"at the market", new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        Home = new Room(4,"at your home", new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        Field = new Room(5,"in an empty field", new ArrayList<NPC>(),new ArrayList<InanimateObjects>());

        Village_center.setExit("east", Farm);
        Village_center.setExit("south", Market);
        Village_center.setExit("west", Home);

        Farm.setExit("west", Village_center);
        Farm.setExit("east", Field);

        Home.setExit("east", Village_center);

        Market.setExit("north", Village_center);

        Field.setExit("west",Farm);


        return Village_center;
    }


}
