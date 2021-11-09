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

    public void setEnergy(int energyDiff) {
        energy += energyDiff;
        if (energy > 100) energy = 100;
        if (energy < 0) energy = 0;
    }

    public int getFamilyEnergy() {
        return familyEnergy;
    }

    public void setFamilyEnergy(int energyDiff) {
        familyEnergy += energyDiff;
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
}
