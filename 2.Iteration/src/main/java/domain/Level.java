package domain;
import java.util.ArrayList;


public class Level {

    private int id;
    private ArrayList<Item> items;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<NPC> npcs_VC = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Home = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_ABH = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Trash = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Market = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_School = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Farm = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Well = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Alley = new ArrayList<NPC>();
    private ArrayList<NPC> npcs_Field = new ArrayList<NPC>();

    private ArrayList<InanimateObjects> iO_VC = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Home = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_ABH = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Trash = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Market = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_School = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Farm = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Well = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Alley = new ArrayList<InanimateObjects>();
    private ArrayList<InanimateObjects> iO_Field = new ArrayList<InanimateObjects>();

    public Level(int id) {

        this.id = id;
        //   this.items = items;
        this.rooms = rooms;

    }

    public Room createRooms() {
        Room Village_center, Farm, Market, Home, Field, Abandoned_House, Trash_pile, Alley, Well, School;

        Item Fish = new Item("fish", 50, "fish.png");
        Item Poster = new Item("poster", 0, "poster.png");
        Item Dog = new Item("dog",80,"dog.png");
        Item Stick = new Item("stick",0,"wand.png");
        Item Flour = new Item("flour",5,"flour.png");
        Item Scarecrow = new Item("scarecrow",0,"scarecrow.png");
        Item Chalk = new Item("chalk",1,"chalk.png");
        Item Mushrooms = new Item("mushrooms",1000,"mushrooms.png");
        Item Football = new Item("football",0,"football.pmg");
        Item Apple = new Item("apple",25,"apple.png");
        Item Rice = new Item("rice",50,"rice.png");
        Item Bread = new Item("bread",60,"bread.png");
        NPC Steve = new NPC("steve", Fish, "steve.png", "I miss my football", "Thank you for finding my football", Football);
        NPC Homeless_man = new NPC("homeless-man", Mushrooms, "homelessman.png","Have you seen my wand, i need it for my spells","Finally my beloved wand, now i can become the most powerful wizard in the whole land",Stick);
        NPC Farmer = new NPC("farmer",Flour,"flour.png","I lost my scarecrow, i think the birds hid it from me ","There it was",Scarecrow);
        NPC Teacher = new NPC("teacher",Apple,"teacher.png","I have been looking for chalk all day","Thank you soo much i needed that",Chalk);
        NPC Shopper = new NPC("shopper",Chalk,"shopper.png","I have way too much chalk, give me a poster and i will give you some","I love it",Poster);
        NPC Baker = new NPC("baker",Bread,"baker.png","I just dropped my last bag of flour, can you get me some more","thank you have a bread",Flour);
        NPC Abena = new NPC("abena",Rice,"abena.png","i lost my dog, have you seen it","Thank you, i was soo hungry",Dog);
        npcs_VC.add(Steve);
        npcs_Trash.add(Homeless_man);
        npcs_Market.add(Shopper);
        npcs_Market.add(Baker);
        npcs_School.add(Teacher);
        npcs_Farm.add(Farmer);
        npcs_Well.add(Abena);

        InanimateObjects stack_of_sticks = new InanimateObjects("stack-of-sticks", Stick, false, "stackofsticks.png");
        InanimateObjects poster = new InanimateObjects("poster", Poster,false, "poster.png");
        InanimateObjects football = new InanimateObjects("football", Football,false, "football.png");
        InanimateObjects dog = new InanimateObjects("dog", Dog,false, "dog.png");
        InanimateObjects well = new InanimateObjects("well", Scarecrow,false, "scarecrow.png");
        InanimateObjects bucket = new InanimateObjects("bucket",null,true,"bucket.png");
        InanimateObjects barrel = new InanimateObjects("barrel",null,true, "barrel.png" );

        iO_VC.add(poster);
        iO_Field.add(stack_of_sticks);
        iO_Alley.add(football);
        iO_Trash.add(dog);
        iO_Well.add(well);
        iO_Well.add(bucket);
        iO_VC.add(barrel);


        Village_center = new Room(1, "in the village center", npcs_VC, iO_VC);
        Farm = new Room(2, "at a farm",npcs_Farm ,  iO_Farm);
        Market = new Room(3, "at the market", npcs_Market, iO_Market);
        Home = new Room(4, "at your home", npcs_Home, iO_Home);
        Field = new Room(5, "in an empty field", npcs_Field, iO_Field);
        Abandoned_House = new Room(6, "at abadoned house", npcs_ABH, iO_ABH);
        Trash_pile = new Room(7, "at trash pile",npcs_Trash, iO_Trash);
        Alley = new Room(8, "at in an Alley",npcs_Alley, iO_Alley);
        Well = new Room(9, "at the good old well",npcs_Well, iO_Well);
        School = new Room(10, "at your school",npcs_School, iO_School);
            // These are the Exist that are dependent on the levels we are on.

        rooms.add(Village_center);
        rooms.add(Home);
        rooms.add(Farm);
        rooms.add(Field);
        rooms.add(Market);
        rooms.add(Abandoned_House);
        rooms.add(Trash_pile);
        rooms.add(Well);
        rooms.add(Alley);
        rooms.add(School);

        // These are the exits that are not dependent on which level we are on
        Farm.setExit("west", Village_center);
        Home.setExit("east", Village_center);
        Well.setExit("south", Village_center);
        Market.setExit("north", Village_center);
        Abandoned_House.setExit("west",Trash_pile);
        Abandoned_House.setExit("south",Home);
        Trash_pile.setExit("east",Abandoned_House);
        Farm.setExit("east", Field);
        Field.setExit("west", Farm);

        Home.setExit("south", Alley);
        Alley.setExit("north", Home);

        Market.setExit("east", School);
        School.setExit("west", Market);


        return Village_center;
    }
public void setExits(int currentLevel){
        clearCenterExits();
    switch (currentLevel){
        case 1:

            rooms.get(0).setExit("west",rooms.get(1));

            break;
        case 2:
              rooms.get(0).setExit("south", rooms.get(4));
            rooms.get(0).setExit("west", rooms.get(1));
            break;
        case 3:
            rooms.get(0).setExit("north",rooms.get(7));
            rooms.get(0).setExit("west", rooms.get(1));
            rooms.get(0).setExit("east",rooms.get(2));
            break;
        case 4:

            rooms.get(0).setExit("north", rooms.get(7));
            rooms.get(0).setExit("south", rooms.get(4));
            rooms.get(0).setExit("west",rooms.get(1));
            rooms.get(1).setExit("north",rooms.get(5));
            break;
        case 5:
            rooms.get(1).setExit("north",rooms.get(5));
            rooms.get(0).setExit("west", rooms.get(1));
            rooms.get(0).setExit("north",rooms.get(7));
            rooms.get(0).setExit("east", rooms.get(2));
            rooms.get(0).setExit("south", rooms.get(4));

    }

}
private void clearCenterExits(){
        rooms.get(0).setExit("west",null);
        rooms.get(0).setExit("east",null);
        rooms.get(0).setExit("north",null);
        rooms.get(0).setExit("south",null);
}
    public ArrayList<Room> getRooms(){
        return rooms;
    }
}
