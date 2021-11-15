import java.util.ArrayList;

public class InanimateObjects extends Interactables {
    private Item foundItem;
    private boolean isChecked;

    public InanimateObjects(String name, String longDescription ,Item foundItem,boolean isChecked) {
        super(name, longDescription);
        this.foundItem = foundItem;
        this.isChecked = isChecked;
    }

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    public Item getItem() {
        return foundItem;
    }


}
