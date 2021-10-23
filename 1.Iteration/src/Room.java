

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Interactables> interactables = new ArrayList<Interactables>();


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

