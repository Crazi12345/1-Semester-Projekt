public class NPC extends Interactables{
    private Item reward;

    public NPC(String name, String shortDescription, Item reward, String longDescription){
        super(name, shortDescription, longDescription);
        this.reward = reward;
    }

    public Item getReward(){
        return this.reward;
    }

    public void Dialogue(){

    }

}
