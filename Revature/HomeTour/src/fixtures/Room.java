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

	public Room[] getExits() {
		return this.exits;
	}
	
	public void setExits(int exitsNumber, Room room) {
		this.exits = new Room[exitsNumber];
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
