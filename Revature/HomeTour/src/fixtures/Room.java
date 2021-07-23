package fixtures;
import java.util.*;

public class Room extends Fixture {
	
	Boolean locked = false;
	
	// Rooms next to current room
	Map<String, Room> exits;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	public String getLongDescription() {
		return this.longDescription;
	}
	
	public Map<String, Room> getExits() {
		return this.exits;
	}
	
	public void setExits(int exitsNumber, Map<String, Room> room) {
		// set size of exits array
		//this.exits = new Room[exitsNumber];
		
		// set rooms that the current room
		// exits to
		this.exits = room;
	}
	
	public boolean getLockState() {
		return this.locked;
	}
	
	public void setLockState() {
		this.locked = true;
	}
	
	public Room getExit(String direction) {
		switch(direction) {
		case "north":
			return this.exits.get("north");
		case "east":
			return this.exits.get("south");
		case "south":
			return this.exits.get("east");
		case "west":
			return this.exits.get("west");
		default:
			// add default case
			return this.exits.get("north");
		}
	}
}
