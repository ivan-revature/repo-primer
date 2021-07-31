package game;
import fixtures.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
	Scanner scanner = new Scanner(System.in);
	String[] cmdActionTarget;
	int testInt = 0;
		
	try {
		// Initialize Room instance variables
		RoomManager rmMgr = new RoomManager();
		rmMgr.init();
		
		// Initialize player instance
		// Debug getStartingRoom it must come from rooms[] array
		Player player = new Player(rmMgr.getStartingRoom());
		
		// System.exit(0);
		
		// Display welcome message (and instructions)
		System.out.println("Welcome to HomeTour");
		System.out.println("Whenever you wish to end HomeTour type \"quit\""
				+ "(without the quotes)");
		
		do
		{
			// game-loop start
			
			// display prompt
			// start out with initial values
			// System.out.println("iteration: " + ++testInt);
			Main.printRoom(player);
			
			// Display all the exits for the current room
			// for the player to see
			Main.printRoomExits(player);
			
			// collect input
			cmdActionTarget = Main.collectInput(scanner);

			// parse input
			Main.parse(cmdActionTarget, player);
		} while(cmdActionTarget[0] != "quit");
		scanner.close();
	}
	catch (Exception e) {
		
		System.out.println("Exception was caught: " + e.getMessage());
	}
	finally {
		System.out.println("in \"finally\"\n");
	}
	}
	
	private static void printRoom(Player player) {
		// player's current room
		Room rm = player.getCurrentRoom();
		System.out.println("You are currently in: \n"
						+ rm.getName() + ": "
							+ rm.getLongDescription());
	}
	
	private static void printRoomExits(Player player) {
		// current room's exits
		Room rm = player.getCurrentRoom();
		Map<String, Room> allExts;
		
		allExts = rm.getExits();
		System.out.println("\nThis room has exits to: \n");
		for(Object key: allExts.keySet()) {
			System.out.println(key.toString() + " ==> " + allExts.get(key).getName()
						+ "\n");
		}
	}
	
	private static boolean roomExists(Player player, String direction) {
		boolean exists = false;
		// current room's exits
		Room rm = player.getCurrentRoom();
		Map<String, Room> allExts;
		
		allExts = rm.getExits();
		for(Object key: allExts.keySet()) {
			if( key.toString().equalsIgnoreCase(direction) ) {
				exists = true;
			}
		}
		return exists;
	}
	
	private static String[] collectInput(Scanner scanner) throws Exception {
		
		// String cmd;
		String[] input = new String[2];
		
		
		try {
		System.out.println("What do you wish to do next? ");
		// Collect (1) action, (2) target of action (if any)
		// for example, go (action) east (target)
		
		input = scanner.nextLine().split(" ");
		
		//System.out.println("\nYou have entered: ");
		//for-each loop to print the string
		//for(String str: input) {
			//System.out.println(str);
		//}
		
		return input;
		} catch(Exception e) {
			System.out.println("Error (in collectInput): " + e.getMessage());
			
			
			input = scanner.nextLine().split(" ");
			return input;
		} finally {
			System.out.println("in collectInput (finally) block.");
		}
	}
	
	private static void parse(String[] playerCmdInput, Player player) {
		String msg;
		boolean lockedRoomFound = false;
		
		switch(playerCmdInput[0]) {
			case "go":
				// handle target (direction)
				if(playerCmdInput[1].equalsIgnoreCase("north")) {
					Main.processCommand("north", player);
				}else if (playerCmdInput[1].equalsIgnoreCase("south")) {
					Main.processCommand("south", player);
				}else if (playerCmdInput[1].equalsIgnoreCase("east")) {
					Main.processCommand("east", player);
				}else if (playerCmdInput[1].equalsIgnoreCase("west")) {
					Main.processCommand("west", player);
				} else {
					// throw exception
					System.out.println("else case");
				}
				break;
			case "take":
				// handle target
				switch(playerCmdInput[1]) {
				case "book":
					if( player.getCurrentRoom().getName() == "Study") {
						msg = "You picked up a good book - "
								+ "Einstein's The Theory of Relativity.";
						Main.printMsgText(msg);
					} else {
						msg = "There are no books to pick up in this room.";
						printMsgText(msg);
					}
				case "laptop":
					if( player.getCurrentRoom().getName() == "Study" ||
							player.getCurrentRoom().getName() == "Master Bedroom") {
						msg = "The laptop is running!";
						Main.printMsgText(msg);
					} else {
						msg = "There are no books to pick up in this room.";
						Main.printMsgText(msg);
					}
					break;
				case "can":
					if(player.getCurrentRoom().getName() == "Kitchen") {
						msg = "You are holding a can.";
						Main.printMsgText(msg);
					} else {
						msg = "There are no cans in this room.";
						Main.printMsgText(msg);
					}
					break;
				case "remote":
					if(player.getCurrentRoom().getName() == "Living Room") {
						msg = "You are holding the remote.";
						Main.printMsgText(msg);
					} else {
						msg = "There are no remotes in this room";
						Main.printMsgText(msg);
					}
					break;
				case "soap":
					if(player.getCurrentRoom().getName() == "Full Bathroom" ||
							player.getCurrentRoom().getName() == "Study Bathroom") {
						msg = "You are holding a soap";
						Main.printMsgText(msg);
					} else {
						msg = "There is no soap in this room";
						Main.printMsgText(msg);
					}
					break;
				case "default":
			}
				break;
			case "open":
				// handle target
				switch(playerCmdInput[1]) {
				case "refridgerator":
					if(player.getCurrentRoom().getName() == "Kitchen") {
						msg = "You open the fridge and you see loooottsss of food.";
						Main.printMsgText(msg);
					} else {
						msg = "There is no refridgerator in this room.";
						Main.printMsgText(msg);
					}
					break;
				case "cabinet":
					if(player.getCurrentRoom().getName() == "Kitchen") {
						msg = "You many cans to choose from.";
						Main.printMsgText(msg);
					} else {
						msg = "There are no cabinets in this room.";
						Main.printMsgText(msg);
					}
					break;
				case "pending":
				}
			break;
			case "unlock":
				// handle target
				
				break;
			case "pick up":
				// handle target
				
				break;
			case "walk":
				// handle target
				
				break;
			case "look":
				
				break;
			default:
				
		}
	}
	
	private static void processCommand(String target, Player player) {
		// Determine if exit actually exists
		// Room player is trying to go into
		
		if( roomExists(player, target) ) {
			Room nextRoom = player.getCurrentRoom().getExit(target);
			
			// Perform check - player might be trying to walk
			// into a locked room
			
			if(Main.checkLock(nextRoom)) {
				//System.out.println("boolean value is true");
				return; // Player is not moving
			} else {
				
				player.setCurrentRoom(nextRoom);
				System.out.println("Next room: " + nextRoom.getName());
				//printRoom(player);
			}
		} else {
			System.out.println("There is no such exit.");
			// player is not moving - room does not exit to target
		}
	}
	
	private static boolean checkLock(Room curRm) {
		String msg = null;
		if(curRm.getName().equalsIgnoreCase("The Study Room")) {
			if(curRm.getLockState()) {
				msg = "Door doesn't open!  You always keep your study "
						+ "room locked.";
				Main.printMsgText(msg);
				return true;
			} else {
				msg = "You are now in your study.";
				Main.printMsgText(msg);
				return false;
			}
		} else {
			return false;
		}
	}
	
	private static void printMsgText(String msg) {
		System.out.println("\n" + msg);
	}
}
