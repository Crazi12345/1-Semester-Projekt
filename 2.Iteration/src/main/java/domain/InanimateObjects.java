package domain;

import java.util.ArrayList;

public class InanimateObjects extends Interactables {
    private Item foundItem;
    private boolean isChecked;
    private String fileName;

    public InanimateObjects(String name, Item foundItem, boolean isChecked, String fileName) {
        super(name, fileName);
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

    public String getFileName() {
        return this.fileName;
    }


}
