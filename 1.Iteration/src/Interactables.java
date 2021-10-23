public abstract class Interactables {

    private String name;
    private String shortDescription;
    private String longDescription;

    public Interactables(String name, String shortDescription, String longDescription){
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getName(){
        return this.name;
    };
    public String getShortDescription(){
        return this.shortDescription;
    };
}
