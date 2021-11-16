package domain;


public class Item {
    private String name;
    private int foodEnergy;
    private String longDescription;
    private boolean isEatable;

    public Item(String name, int foodEnergy, String longDescription) {
        this.name = name;
        this.foodEnergy = foodEnergy;
        this.longDescription = longDescription;
        this.isEatable = foodEnergy > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getFoodEnergy() {
        return this.foodEnergy;
    }

    public boolean getIsEatable() {
        return this.isEatable;
    }

    public String getLongDescription() {
        return this.longDescription;
    }


}
