package game;
import fixtures.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] cmdActionTarget;
		
		// Initialize Room instance variables
		String rmName = "Portal";
		String rmShortDesc = "Renassaince-style portal";
		String rmLongDesc = "";
		Room room = new Room(rmName, rmShortDesc, rmLongDesc);
		
		Main controller = new Main();
		Player player = new Player(room);
		// System.exit(0);
		
		do
		{
			// game-loop starts
			System.out.println("Welcome to HomeTour");
			
			// display prompt
			// start out with initial values
			Main.printRoom(player);
			
			// collect input
			cmdActionTarget = Main.collectInput();

			Main.parse(cmdActionTarget, player);
			
			// parse input
		} while(cmdActionTarget[0] != "quit");
		
	}
	
	private static void printRoom(Player player) {
		// player's current room
	}
	
	private static String[] collectInput() {
		Scanner scanner = new Scanner(System.in);
		String[] input = new String[2];
		
		// Collect (1) action, (2) target of action (if any)
		// for example, go (action) east (target)
		input[0] = scanner.next();
		input[1] = scanner.next();
		
		scanner.close();
		return input;
	}
	
	private static void parse(String[] playerCmdInput, Player player) {
		Room[] playRoom;
		Room currentRoom = null;
		String msg;
		boolean lockedRoomFound = false;
		
		switch(playerCmdInput[0]) {
			case "go":
				// handle target (direction)
				if( playerCmdInput[1] == "north") {
					Main.processCommand("north", player);
				}else if (playerCmdInput[1] == "south") {
					Main.processCommand("south", player);
				}else if (playerCmdInput[1] == "east") {
					Main.processCommand("east", player);
				}else if (playerCmdInput[1] == "west") {
					Main.processCommand("west", player);
				} else {
					// throw exception
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
		Room currentRoom = player.getCurrentRoom().getExit(target);
		if(Main.checkLock(currentRoom)) {
			return; // Player is not moving
		} else {
			player.setCurrentRoom(currentRoom);
			printRoom(player);
		}
	}
	
	private static boolean checkLock(Room curRm) {
		if(curRm.getName() == "study") {
			if(curRm.getLockState()) {
				String msg = "Door doesn't open!  You always keep your study "
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
