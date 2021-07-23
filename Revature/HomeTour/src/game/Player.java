package game;
import fixtures.*;

public class Player {
	Room currentRoom;
	
	public Player(Room curRm) {
		this.currentRoom = curRm;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room curRm) {
		currentRoom = curRm;
	}
}
