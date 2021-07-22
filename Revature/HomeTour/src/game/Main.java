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
		
		switch(playerCmdInput[0]) {
			case "go":
				// handle target (direction)
				// player.currentRoom = "room";
				break;
			case "take":
				// handle target
				break;
			case "open":
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
}
