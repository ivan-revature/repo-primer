package game;
import fixtures.*;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	
	public RoomManager(Room startRoom, Room[] rms) {
		this.startingRoom = startRoom;
		this.rooms = rms;
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public Room[] getRooms() {
		return this.rooms;
	}
	
	public void init() {
		Room porch = new Room(
					"The Porch",
					"a port-covered, 4-by-10 ft porch",
					"A nice, ordinary porch surrounded by"
					+ "a big tree, grass, and lots of"
					+ "shade." + "\n"
					+ "The sheet of concrete leads you"
					+ "north into the front door");
		this.rooms[0] = porch;
		
		Room livingRoom = new Room(
					"The Living Room",
					"A pretty, roomy, well-lit living room",
					"In the living room one sees a"
					+ "three-piece sofa set, a center"
					+ "table, a stackable, sectional shelf"
					+ "and a 55-in TV.");
		this.rooms[1] = livingRoom;
		
		this.startingRoom = porch;
		this.rooms[0].setExits(1, this.rooms[1]);
	}
}
