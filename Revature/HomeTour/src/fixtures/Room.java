package fixtures;

public class Room extends Fixture {
	String name = null;
	String shortDescription = null;
	String longDescription = null;
	
	// Rooms next to current room
	Room[] exits;
	
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
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public void setExits(int exitsNumber, Room[] room) {
		// set size of exits array
		this.exits = new Room[exitsNumber];
		
		// set rooms that the current room
		// exits to
		this.exits = room;
	}
	public Room getExit(String direction) {
		switch(direction) {
		case "north":
			return this.exits[0];
		case "east":
			return this.exits[1];
		case "south":
			return this.exits[2];
		case "west":
			return this.exits[3];
		default:
			// add default case
			return this.exits[0];
		}
		
	}
}
