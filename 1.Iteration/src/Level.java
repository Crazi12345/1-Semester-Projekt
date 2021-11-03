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
        Room Village_center, Farm, Market, Home, Field, Abandoned_House, Trash_pile,Alley, Well, School;





        Item Fish = new Item("fish", 50, "Smells like teen spirit");
        Item Poster = new Item("poster", 0, "Poster that shows food");
        Item Dog = new Item("dog",80,"It looks very cute");
        Item Stick = new Item("stick",0,"If you are crazy enough it could be a wand");
        Item Flour = new Item("flour",5,"This could be useful");
        Item Scarecrow = new Item("scarecrow",0,"It is full of holes");
        Item Chalk = new Item("chalk",1,"The white stuff the teacher uses on the board");
        Item Mushrooms = new Item("mushrooms",1000,"I wouldnt eat that if i were you");
        Item Football = new Item("football",0,"An old beaten football, that needs a bit air");
        Item Apple = new Item("apple",25,"A good red and round juicy apple");
        Item Rice = new Item("rice",50,"a bag of boring but tasty rice");
        Item Bread = new Item("bread",60,"A big loaf of day old bread");
        NPC Steve = new NPC("steve", Fish,
                "His fingers are full of cheetoo dust and he smells fishy", "I miss my football", "Thank you for finding my football",
                Football);
        NPC Homeless_man = new NPC("homeless-man", Mushrooms, "He thinks he is a wizard","Have you seen my wand, i need it for my spells","Finally my beloved wand, now i can become the most powerful wizard in the whole land",Stick);
        NPC Farmer = new NPC("farmer",Flour,"The farmer is one of the only sources of food in the village","I lost my scarecrow, i think the birds hid it from me ","There it was",Scarecrow);
        NPC Teacher = new NPC("teacher",Apple,"Your teacher, i hope she doesnt give me homework","I have been looking for chalk all day","Thank you soo much i needed that",Chalk);
        NPC Shopper = new NPC("shopper",Chalk,"Shopper that looks confused and overwhelmed","I have way too much chalk, give me a poster and i will give you some","I love it",Poster);
        NPC Baker = new NPC("baker",Bread,"A big old man that is covered in flour","I just dropped my last bag of flour, can you get me some more","thank you have a bread",Flour);
        NPC Abena = new NPC("abena",Rice,"The girl next door abena, she is not that interesting","i lost my dog, have you seen it","Thank you, i was soo hungry",Dog);
        npcs_VC.add(Steve);
        npcs_Trash.add(Homeless_man);
        npcs_Market.add(Shopper);
        npcs_Market.add(Baker);
        npcs_School.add(Teacher);
        npcs_Farm.add(Farmer);
        npcs_Well.add(Abena);

        InanimateObjects stack_of_sticks = new InanimateObjects("stack-of-sticks","That is a lot of sticks, nobody would notice if i took one",Stick,false);
        InanimateObjects poster = new InanimateObjects("poster", "Poster that shows food", Poster,false);
        InanimateObjects football = new InanimateObjects("football","what is a football doing here, it probably belongs to someone",Football,false);
        InanimateObjects dog = new InanimateObjects("dog","a loose dog, my i could take it",Dog,false);
        InanimateObjects well = new InanimateObjects("well","It looks like there is something down in the well",Scarecrow,false);
        InanimateObjects bucket = new InanimateObjects("bucket","It looks broken",null,true);
        InanimateObjects barrel = new InanimateObjects("barrel","looks like a barrel, how interesting",null,true);

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

            switch (id){
                case 1:

                    Village_center.setExit("west",Home);

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
