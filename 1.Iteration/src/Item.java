public class Item {
    private String name;
    private int foodEnergy;
    private String longDescription;
    private boolean isEatable;
    private boolean isAvailable;

    public Item(String name, int foodEnergy, String longDescription,boolean isAvailable) {
        this.name = name;
        this.foodEnergy = foodEnergy;
        this.longDescription = longDescription;
        this.isEatable = foodEnergy > 0;
        this.isAvailable=isAvailable;
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
