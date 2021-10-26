import java.util.ArrayList;

public class InanimateObjects extends Interactables {
    private Item foundItem;
    private boolean isChecked;
    private ArrayList<InanimateObjects> inanimateObjects;

    public InanimateObjects(String name, String shortDescription, String longDescription ,Item foundItem) {
        super(name, shortDescription, longDescription);
        this.foundItem = foundItem;
        this.inanimateObjects = inanimateObjects;
    }

    public void addInanimateObject(InanimateObjects inanimateObject) {
        this.inanimateObjects.add(inanimateObject);
    }

    public String interact(String[] interactString){
        return "";
    }

    public boolean getIsChecked(){
        return this.isChecked;
    }

    public void setIsChecked(boolean checked){
        isChecked = checked;
    }

    public Item getItem(){
        return foundItem;
    }
}
