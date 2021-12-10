package domain;


public class Item {
    private String name;
    private int foodEnergy;
    private String fileName;
    private boolean isEatable;

    public Item(String name, int foodEnergy, String fileName) {
        this.name = name;
        this.foodEnergy = foodEnergy;
        this.fileName = fileName;
        this.isEatable = foodEnergy > 0;
    }

    public int getFoodEnergy() {
        return this.foodEnergy;
    }

    public boolean getIsEatable() {
        return this.isEatable;
    }

    public String getFileName() {
        return this.fileName;
    }


}
