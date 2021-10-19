public class Item{
    private String name;
    private int foodEnergy;
    private String shortDescription;
    private boolean isEatable;

    public Item(String name, int foodEnergy,String shortDescription){
        this.name = name;
        this.foodEnergy = foodEnergy;
        this.shortDescription = shortDescription;
        this.isEatable = foodEnergy > 0;
    }

    public String getName(){
        return this.name;
    }

    public int getFoodEnergy(){
        return this.foodEnergy;
    }

    public String getShortDescription(){
        return this.shortDescription;
    }

    public boolean getIsEatable(){
        return this.isEatable;
    }




}
