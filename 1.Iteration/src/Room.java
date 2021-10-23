

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Interactables> interactables;


    public Room(String description, ArrayList interactables)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.interactables = interactables;

    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    public ArrayList getInteractables(){
        return this.interactables;
    }

    public String getInteractblesString(){
        String interactablesString = "You see: ";
        for (int i = 0; i < interactables.size(); i++) {
            interactablesString += interactables.get(i).getName();
            interactablesString += ", ";
        }
        return interactablesString;
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

