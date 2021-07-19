package main;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter cunits = new Converter();
		
		int menuSelection1, menuSelection2;
		Scanner scanner = new Scanner(System.in);
		
		double dblResult = 0.0;
		double dblQty;
		
		do {
			cunits.displayMenu1();
			
			/* Collect user's menu selection */
			menuSelection1 = scanner.nextInt();
			menuSelection2 = cunits.displayMenu2(menuSelection1, scanner);
			
			switch(menuSelection1) {
			case 1:
				/* Volume */
				switch(menuSelection2) {
				case 1:
					dblQty = Converter.collectQty("Teaspoons: ", "tbsp", scanner);
					dblResult = cunits.convertTspToTbsp(dblQty);
				case 2:
					dblQty = Converter.collectQty("Teaspoons: ", "cups", scanner);
					dblResult = cunits.convertTspToCups(dblQty);
				case 3:
					dblQty = Converter.collectQty("Teaspoons: ", "liters", scanner);
					dblResult = cunits.convertTspToLiters(dblQty);
				}
				cunits.displayResult(dblResult, "tsp");
				break;
			case 2:
				/* Distance */
				switch(menuSelection2) {
				case 1:
					dblQty = Converter.collectQty("Miles: ", "km", scanner);
					dblResult = cunits.convertMilesToKm(dblQty);
				case 2:
					dblQty = Converter.collectQty("Miles: ", "feet", scanner);
					dblResult = cunits.convertMilesToFeet(dblQty);
				case 3:
					dblQty = Converter.collectQty("Miles: ", "yards", scanner);
					dblResult = cunits.convertMilesToYards(dblQty);
				}
				cunits.displayResult(dblResult, "km");
				break;
			case 3:
				/* Time */
				switch(menuSelection2) {
				case 1:
					dblQty = Converter.collectQty("Seconds: ", "min", scanner);
					dblResult = cunits.convertSecondsToMinutes(dblQty);
				case 2:
					dblQty = Converter.collectQty("Seconds: ", "hr", scanner);
					dblResult = cunits.convertSecondsToHours(dblQty);
				case 3:
					dblQty = Converter.collectQty("Seconds: ", "days", scanner);
					dblResult = cunits.convertSecondsToDays(dblQty);
				}
				cunits.displayResult(dblResult, "min");
				break;
			case 4:
				scanner.close();
				System.out.println("App is closing.");
			}
		}  while (menuSelection1 != 4);
	}
	
	private static double collectQty (String unit1, String unit2, Scanner scanner) {
		System.out.println("\n" + unit1 + ": ");
		return scanner.nextDouble();
	}
	
	private double convertTspToTbsp(double tsp) {
		final double tspInTbsp = 3.0;
		return tsp / tspInTbsp;
	}
	
	private double convertTspToCups(double tsp) {
		final double tspInCups = 48.0;
		return tsp / tspInCups;
	}
	
	private double convertTspToLiters(double tsp) {
		final double tspInLiters = 202.884136;
		return tsp / tspInLiters;
	}
	
	private double convertMilesToKm(double miles) {
		final double kmInMile = 1.609344;
		return miles * kmInMile;
	}
	
	private double convertMilesToFeet(double miles) {
		final double feetInMile = 5280;
		return miles * feetInMile;
	}
	
	private double convertMilesToYards(double miles) {
		double yardsInMile = 1760;
		return miles * yardsInMile;
	}
	
	private double convertSecondsToMinutes(double seconds) {
		double secondsInMinutes = 60.0;
		return seconds / secondsInMinutes;
	}
	
	private double convertSecondsToHours(double seconds) {
		double secondsInHours = 3600.0;
		return seconds / secondsInHours;
	}
	
	private double convertSecondsToDays(double seconds) {
		double secondsInDays = 86400.0;
		return seconds / secondsInDays;
	}
	
	private void displayMenu1() {
		System.out.println("Unit Converter");
		System.out.println("\nType of unit:");
		System.out.println("1. Volume");
		System.out.println("2. Distance");
		System.out.println("3. Time");
		System.out.println("4. Quit");
	}
	
	private int displayMenu2(int menuSel1, Scanner scanner) {
		int menuSel2;
		
		switch(menuSel1) {
		case 1:
			System.out.println("1. Teaspoons to tablespoons");
			System.out.println("2. Teaspoons to cups");
			System.out.println("3. Teaspoons to ounces");
			break;
		case 2:
			System.out.println("1. Miles to kilometers");
			System.out.println("2. Miles to feet");
			System.out.println("3. Miles to yards");
			break;
		case 3:
			System.out.println("1. Seconds to minutes");
			System.out.println("2. Seconds to hours");
			System.out.println("3. Seconds to days");
			break;
		default:
			System.out.println("Please select from the given options");
		}
		menuSel2 = scanner.nextInt();
		return menuSel2;
	}
	
	private void displayResult(double cRes, String units) {
		System.out.println("Conversion: " + cRes + " " + units);
	}
}
