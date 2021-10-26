import java.util.ArrayList;

public class Player {
    private int energy;
    private int familyEnergy;
    private String name;
    private ArrayList inventory;

    public Player (String name, ArrayList inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energyDiff){
        energy += energyDiff;
    }

    public int getFamilyEnergy() {
        return familyEnergy;
    }

    public void setFamilyEnergy(int energyDiff) {
        familyEnergy += energyDiff;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }
}
