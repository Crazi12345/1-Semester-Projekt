
public abstract class Interactables {

    private String name;
    private String longDescription;

    public Interactables(String name, String longDescription){
        this.name = name;
        this.longDescription = longDescription;
    }


    public String getName(){
        return this.name;
    };
    public String getLongDescription(){
        return this.longDescription;
    }
}
