package game;
import fixtures.*;
import java.util.*;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	
	public RoomManager() {
		rooms = new Room[13];
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room startRm) {
		this.startingRoom = startRm;
	}
	
	public Room[] getRooms() {
		return this.rooms;
	}
	
	public void init() {
		Map<String,Room> allExits;
		// Collection<Room> colAllExits;
		// Room[] allExitsArray;
		
		Room porch = new Room(
					"The Porch",
					"a port-covered, 4-by-10 ft porch",
					"A nice, ordinary porch surrounded by"
					+ "a big tree, grass, and lots of"
					+ "shade." + "\n"
					+ "The sheet of concrete leads you "
					+ "north into the front door");
		this.rooms[0] = porch;
		
		Room livingRoom = new Room(
					"The Living Room",
					"A pretty, roomy, well-lit living room",
					"In the living room one sees a "
					+ "three-piece sofa set, a center "
					+ "table, a stackable, sectional shelf "
					+ "and a 55-in TV.");
		this.rooms[1] = livingRoom;
		
		Room partitioningWall = new Room(
					"Dividing wall",
					"A divding wall with a built-in bar",
					"The dividing wall separates the "
					+ "living room from the rear section "
					+ "of the house.  Seats are placed "
					+ "along the bar and on both sides");
		this.rooms[2] = partitioningWall;
		
		Room diningRoom = new Room(
					"The Dining Room",
					"A neat, comfortable dining room",
					"At the center sits an expensive-looking dark "
					+ "wooden table with 6 padded chairs.  Place mats "
					+ "are set as well as water carafes with several "
					+ "glasses spread around the dining table");
		this.rooms[3] = diningRoom;
		
		Room backYard = new Room(
					"The Back Yard",
					"A back yard with trees, shade, and flowers.",
					"A port gives shade to the section right out of "
					+ "the back door.  The lemon tree is strong, "
					+ "and healthy-looking on the corner.  And the "
					+ "flowers adorn the back section along the wall.");
		this.rooms[4] = backYard;
		
		Room kitchen = new Room(
					"The Kitchen",
					"The kitchen with several appliances.",
					"The kitchen counts with a stove, sink, a "
					+ "refridgerator, a microwave, a radio "
					+ "attached to the bottom of a cabinet of "
					+ "which there is a nice a set.");
		this.rooms[5] = kitchen;
		
		Room study = new Room(
					"The Study Room",
					"A dark, dimly-lit study room",
					"A lamp sits on top of the big desk in "
					+ "the center, dim lights come out from "
					+ "under the floating shelves.  Bookcases "
					+ "line the walls.");
		study.setLockState();
		
		this.rooms[6] = study;
		
		Room studyBathroom = new Room(
					"Study Bathroom",
					"A tiny half bathroom",
					"A porcelain zinc with underneath storage compartments, "
					+ "toiletries, and a toilet.  A fresh, clean scent "
					+ "can be felt around the room");
		this.rooms[7] = studyBathroom;
		
		Room hallway = new Room(
					"The Hallway",
					"A hallway introduces you to the east side of the house.",
					"A narrow hallway with wall switches, thermostats, "
					+ "framed pictures and a large two-tier cabinet at "
					+ "the long end.");
		this.rooms[8] = hallway;
		
		Room masterBedroom = new Room(
					"The Master Bedroom",
					"A master bedroom with a king-size bed.",
					"A carpeted room, white-decorated, a big, "
					+ "tall bed, a large mirrow over the "
					+ "headrest, walk-in closet, and a wardrobe.");
		this.rooms[9] = masterBedroom;
		
		Room laundryRoom = new Room(
					"The Laundry Room",
					"The laundry room is compact, but sophisticated space.",
					"The laundry room is equipped with a washing "
					+ "machine and a dryer pair.  A single shelf hangs up "
					+ "over the washer and dryer, and in front a four-tier "
					+ "tower-style shelf sits by the water heater.");
		this.rooms[10] = laundryRoom;
		
		Room fullBathroom = new Room(
					"The Full Bathroom",
					"A full bathroom with blue tile and a towel closet.",
					"The full bathroom has a walk-in shower, a medicine "
					+ "cabinet and a beautiful fragance dominates the room.");
		this.rooms[11] = fullBathroom;
		
		Room garage = new Room(
					"The Garage",
					"A usually car-free garage hosting a huge variety of objects.",
					"Old machines, discarded clothes, packaging boxes, "
					+ "bottled chemicals, tool bags, old furniture, etc...");
		this.rooms[12] = garage;
		
		// Set all the exits to all the rooms
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[1]);
		this.rooms[0].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[2]);
		allExits.put("south", this.rooms[0]);
		this.rooms[1].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[3]);
		allExits.put("south", this.rooms[1]);
		this.rooms[2].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[4]); // exit to the backyard
		allExits.put("south", this.rooms[3]); // exit to dividing wall
		allExits.put("east", this.rooms[8]); // exit to hallway
		allExits.put("west", this.rooms[5]); // exit to the kitchen
		this.rooms[3].setExits(allExits.size(), allExits); // Dining Room
		
		allExits = new HashMap<String, Room>();
		allExits.put("south", this.rooms[3]);
		this.rooms[4].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("south", this.rooms[6]); // exit to the study
		allExits.put("east", this.rooms[3]); // exit to the dining room
		this.rooms[5].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("west", this.rooms[7]); // exit to private bathroom
		allExits.put("north", this.rooms[5]); // exit to kitchen
		this.rooms[6].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("south", this.rooms[6]); // exit to study
		this.rooms[7].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[9]); // exit to master bedroom
		allExits.put("south", this.rooms[10]); // exit to laundry room
		allExits.put("east", this.rooms[11]); // exit to full bathroom
		allExits.put("west", this.rooms[3]); // exit back to dining room
		this.rooms[8].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("south",this.rooms[8]); // exit to hallway
		this.rooms[9].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[8]); // exit to the hallway
		allExits.put("south", this.rooms[12]); // exit to the garage
		this.rooms[10].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[8]); // exit to the hallway
		this.rooms[11].setExits(allExits.size(), allExits);
		
		allExits = new HashMap<String, Room>();
		allExits.put("north", this.rooms[10]); // exit to the hallway
		this.rooms[12].setExits(allExits.size(), allExits); // exit to the hallway
		
		// Set starting room
		this.startingRoom = this.rooms[0];
	}
}
