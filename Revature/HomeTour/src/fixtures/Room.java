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
		Room rm;
		switch(direction) {
		case "north":
			rm = this.exits.get("north");
			break;
		case "south":
			rm = this.exits.get("south");
			break;
		case "east":
			rm = this.exits.get("east");
			break;
		case "west":
			rm = this.exits.get("west");
			break;
		default:
			// add default case
			System.out.println("getExit(dir) default exec'd");
			//return this.exits.get("north");
			rm = null;
		}
		return rm;
	}
}
