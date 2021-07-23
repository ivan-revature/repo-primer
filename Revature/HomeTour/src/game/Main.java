package game;
import fixtures.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] cmdActionTarget;
		// Set starting room
		String rmName = "porch";
		String rmSDesc = "a port-covered, 4-by-10 ft porch";
		String rmLDesc = "A nice, ordinary porch surrounded by "
				+ "a big tree, grass, and lots of "
				+ "shade." + "\n"
				+ "The sheet of concrete leads you "
				+ "north into the front door.";
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
			Main.printRoom(player);
			
			// collect input
			cmdActionTarget = Main.collectInput();

			// parse input
			Main.parse(cmdActionTarget, player);
		} while(cmdActionTarget[0] != "quit");
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
	
	private static String[] collectInput() {
		Scanner scanner = new Scanner(System.in);
		String cmd;
		String[] input = new String[2];
		
		System.out.println("What do you wish to do next? ");
		// Collect (1) action, (2) target of action (if any)
		// for example, go (action) east (target)
		
		cmd = scanner.nextLine();
		
		input = cmd.split(" ", 2);
		
		scanner.close();
		return input;
	}
	
	private static void parse(String[] playerCmdInput, Player player) {
		//Room[] playRoom;
		//Room currentRoom = null;
		String msg;
		boolean lockedRoomFound = false;
		
		switch(playerCmdInput[0]) {
			case "go":
				// handle target (direction)
				System.out.println("In case \"go\".");
				System.out.println("Size of second element: "
						+ playerCmdInput[1].length() + ".");
				if(playerCmdInput[1].equalsIgnoreCase("north")) {
					System.out.println("got target \"north\".");
					Main.processCommand("north", player);
				}else if (playerCmdInput[1] == "south") {
					Main.processCommand("south", player);
				}else if (playerCmdInput[1] == "east") {
					Main.processCommand("east", player);
				}else if (playerCmdInput[1] == "west") {
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
		// Room player is trying to go into
		Room nextRoom = player.getCurrentRoom().getExit(target);
		
		// Perform check - player might be trying to walk
		// into a locked room
		System.out.println("Entered processCommand.");
		if(Main.checkLock(nextRoom)) {
			System.out.println("boolean value is true");
			return; // Player is not moving
		} else {
			System.out.println("attempting to setCurrentRoom.");
			player.setCurrentRoom(nextRoom);
			printRoom(player);
		}
	}
	
	private static boolean checkLock(Room curRm) {
		String msg = null;
		if(curRm.getName() == "study") {
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
