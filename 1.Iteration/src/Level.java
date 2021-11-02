import java.util.ArrayList;

public class Level {

    private int id;
    private ArrayList<Item> items;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<NPC> npcs = new ArrayList<>();
    private ArrayList<InanimateObjects> inanimateObjects = new ArrayList<InanimateObjects>();

    public Level(int id) {

        this.id = id;
        //   this.items = items;
        this.rooms = rooms;

    }

    public Room createRooms() {
        Room Village_center, Farm, Market, Home, Field, Abandoned_House, Trash_pile,Alley, Well, School;

        Village_center = new Room(1, "in the village center", npcs, inanimateObjects);
        Farm = new Room(2, "at a farm", new ArrayList<NPC>(), new ArrayList<InanimateObjects>());
        Market = new Room(3, "at the market", new ArrayList<NPC>(), new ArrayList<InanimateObjects>());
        Home = new Room(4, "at your home", new ArrayList<NPC>(), new ArrayList<InanimateObjects>());
        Field = new Room(5, "in an empty field", new ArrayList<NPC>(), new ArrayList<InanimateObjects>());
        Abandoned_House = new Room(6, "at abandoned house", new ArrayList<NPC>(), new ArrayList<InanimateObjects>());
        Trash_pile = new Room(7, "at trash pile",new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        Alley = new Room(8, "at in an Alley",new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        Well = new Room(9, "at the good old well",new ArrayList<NPC>(),new ArrayList<InanimateObjects>());
        School = new Room(10, "at your school",new ArrayList<NPC>(),new ArrayList<InanimateObjects>());



        Item Fish = new Item("fish", 50, "Smells like teen spirit");
        Item Poster = new Item("poster", 0, "Poster that shows food");
        NPC Steve = new NPC("Steve", Fish,
                "His fingers are full of cheetoo dust and he smells fishy", "i want poster", "that is a nice poster",
                Poster);

        npcs.add(Steve);

        InanimateObjects poster = new InanimateObjects("Poster", "Poster that shows food", Poster);
        inanimateObjects.add(poster);



            this.rooms.add(Village_center);
            this.rooms.add(Farm);
            this.rooms.add(Market);
            this.rooms.add(Home);
            this.rooms.add(Field);
            // These are the Exist that are dependent on the levels we are on.

            switch (id){
                case 1:
                    Village_center.setExit("east", Farm);
                    Farm.setExit("east", Field);
                    break;
                case 2:
                    Village_center.setExit("south", Market);
                    Village_center.setExit("west", Home);
                    break;
                case 3:
                    Village_center.setExit("north",Well);
                    Village_center.setExit("west", Home);
                    break;
                case 4:
                    Village_center.setExit("north",Well);
                    Village_center.setExit("east", Farm);
                    Village_center.setExit("south", Market);
                    break;
                case 5:
                    Village_center.setExit("west", Home);
                    Village_center.setExit("north",Well);
                    Village_center.setExit("east", Farm);
                    Village_center.setExit("south", Market);

                    Home.setExit("north",Abandoned_House);
                    Abandoned_House.setExit("south",Home);
                    Abandoned_House.setExit("west",Trash_pile);
                    Trash_pile.setExit("east",Abandoned_House);
                    break;
                default:
                    System.out.println("The Program reached a fatal error");
                    break;

            }
            // These are the exits that are not dependent on which level we are on
            Farm.setExit("west", Village_center);
            Home.setExit("east",Village_center);
            Well.setExit("south",Village_center);
            Market.setExit("north",Village_center);

            Farm.setExit("east",Field);
            Field.setExit("west",Farm);

            Home.setExit("south",Alley);
            Alley.setExit("north",Home);

            Market.setExit("east",School);
            School.setExit("west",Market);





        return Village_center;
    }


}
