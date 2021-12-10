
package domain;

import java.util.Set;
import java.util.HashMap;
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
    public HashMap<String,Room> getExits(){
        return exits;
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

    public String getNPCsName(int i){
        return NPCs.get(i).getName();
    }
}

