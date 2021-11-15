import java.util.ArrayList;

public class Player {
    private int energy;
    private int familyEnergy;
    private String name;
    private ArrayList<Item> inventory;

    public Player(String name, ArrayList<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
        this.energy = 0;
        this.familyEnergy = 0;
    }

    public void levelStartEnergyPlayer() {
        setEnergy(100);
    }

    public void levelStartEnergyFamily() {
        setFamilyEnergy(100);
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergyFromItem(int i){
        energy += getItemEnergy(i);
        if (energy > 100) energy = 100;
        if (energy < 0) energy = 0;
    }

    public void setEnergy(int i){
        energy += i;
        if (energy > 100) energy = 100;
        if (energy < 0) energy = 0;
    }

    public int getFamilyEnergy() {
        return familyEnergy;
    }

    public void setFamilyEnergyFromItem(int i) {
        familyEnergy += getItemEnergy(i)/2;
        setEnergy(getItemEnergy(i)/2);
        if (familyEnergy > 100) familyEnergy = 100;
        if (familyEnergy < 0) familyEnergy = 0;
    }

    public void setFamilyEnergy(int i){
        familyEnergy += i;
        if (familyEnergy > 100) familyEnergy = 100;
        if (familyEnergy < 0) familyEnergy = 0;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getItem(int i){
        return this.inventory.get(i);
    }

    public String getItemName(int i){
        return getItem(i).getName();
    }

    public int getItemEnergy(int i){
        return getItem(i).getFoodEnergy();
    }

    public String familyEatString(int i){
        return "You and your family ate the " + getItemName(i);
    }

    public String eatString(int i){
        return "You ate the " + getItemName(i);
    }

}
