import java.util.ArrayList;

public class Level {

    private int id;
    private ArrayList<Item> items;
    private ArrayList<Interactables> interactables;
    private ArrayList<Room> rooms;

    public Level(int id, ArrayList<Item> items, ArrayList<Room> rooms) {

        this.id = id;
        this.items = items;
        this.rooms = rooms;

    }
    private Room createRooms()
    {
        Room outside, theatre, pub, lab, office;

        outside = new Room(1,"outside the main entrance of the university", new ArrayList<Interactables>());
        theatre = new Room(2,"in a lecture theatre", new ArrayList<Interactables>());
        pub = new Room(3,"in the campus pub", new ArrayList<Interactables>());
        lab = new Room(4,"in a computing lab", new ArrayList<Interactables>());
        office = new Room(5,"in the computing admin office", new ArrayList<Interactables>());

        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        return outside;
    }


}
