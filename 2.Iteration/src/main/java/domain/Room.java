
package domain;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Room {
    private int id;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<NPC> NPCs;
    private ArrayList<InanimateObjects> inanimateObjects;

    public Room(int id, String description, ArrayList<NPC> NPCs, ArrayList<InanimateObjects> inanimateObjects) {
        this.id = id;
        this.description = description;
        exits = new HashMap<String, Room>();
        this.NPCs = NPCs;
        this.inanimateObjects = inanimateObjects;

    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    public ArrayList<NPC> getNPCs() {
        return this.NPCs;
    }

    public ArrayList<InanimateObjects> getInanimateObjects() {
        return this.inanimateObjects;
    }

    public String getInteractablesString() {
        String interactablesString = "You see: ";
        for (int i = 0; i < NPCs.size(); i++) {
            interactablesString += NPCs.get(i).getName();
            interactablesString += ", ";
        }
        for (int i = 0; i < inanimateObjects.size(); i++) {
            interactablesString += inanimateObjects.get(i).getName();
            interactablesString += ", ";
        }
        return interactablesString;
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }


    public int getId() {
        return id;
    }

    public String getInanimateObjectsName(int i){
        return inanimateObjects.get(i).getName();
    }

    public Boolean getInanimateObjectsIsChecked(int i){
        return inanimateObjects.get(i).getIsChecked();
    }

    public void setInanimateObjectsIsChecked(int i, boolean checked){
        inanimateObjects.get(i).setIsChecked(checked);
    }

    public Item getInanimateObjectsItem(int i){
        return inanimateObjects.get(i).getItem();
    }

    public String getInanimateObjectsString(int i){
        return getInanimateObjectsName(i) + " is added to inventory";
    }

    public String getNPCsName(int i){
        return NPCs.get(i).getName();
    }

    public boolean getNPCsTrader(int i){
        return NPCs.get(i).getTrader();
    }


}

