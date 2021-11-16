package domain;
public class NPC extends Interactables{
    private Item reward;
    private Item questItem;
    private String quest;
    private String questComplete;
    private boolean trader = true;

    public NPC(String name, Item reward, String longDescription, String quest, String questComplete, Item questItem){
        super(name, longDescription);
        this.reward = reward;
        this.questItem = questItem;
        this.quest = quest;
        this.questComplete = questComplete;
    }

    public String getQuest(){
        return quest;
    }

    public String getQuestComplete(){
        return questComplete;
    }

    public Item getQuestItem(){
        return questItem;
    }

    public String getQuestItemName(){
        return questItem.getName();
    }

    public boolean getTrader(){
        return trader;
    }

    public void setTrader(boolean trader){
        this.trader = trader;
    }

    public Item getReward(){
        return this.reward;
    }

    public String answerQuest(){
        return "Do you want to give " + getName() + " the " +  getQuestItemName() + "?";
    }

    public String getRewardName(){
        return reward.getName();
    }

}
