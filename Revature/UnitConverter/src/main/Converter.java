package main;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter cunits = new Converter();
		
		int menuSelection;
		Scanner scanner = new Scanner(System.in);
		
		int intResult;
		double dblResult;
		
		do {
			cunits.displayMenu();
			
			/* Collect user's menu selection */
			menuSelection = scanner.nextInt();
			
			switch(menuSelection) {
			case 1:
				System.out.println("\nCups: ");
				intResult = cunits.convertCupsToTeaspoons(scanner.nextInt());
				cunits.displayResult(intResult, "tsp");
				break;
			case 2:
				System.out.println("\nMiles: ");
				dblResult = cunits.convertMilestoKm(scanner.nextDouble());
				cunits.displayResult(dblResult, "km");
				break;
			case 3:
				System.out.println("\nUS Gal: ");
				dblResult = cunits.convertUsGalToImGal(scanner.nextDouble());
				cunits.displayResult(dblResult, "imperial gal");
				break;
			case 4:
				scanner.close();
				System.out.println("App is closing.");
			}
		}  while (menuSelection != 4);
	}
	
	public int convertCupsToTeaspoons(int cups) {
		final int tspInCup = 48;
		return cups * tspInCup;
	}
	
	public double convertMilestoKm(double miles) {
		final double kmInMile = 1.609344;
		return miles * kmInMile;
	}
	
	public double convertUsGalToImGal(double usgal) {
		final double imgalInUSgal = 0.83267;
		return usgal * imgalInUSgal;
	}
	
	public void displayMenu() {
		System.out.println("Unit Converter");
		System.out.println("\nPlease select an option:");
		System.out.println("1. Cups to Teaspoons");
		System.out.println("2. Miles to Kilometers");
		System.out.println("3. US Gal to Imperial Gal");
		System.out.println("4. Quit");
	}
	
	public void displayResult(int cRes, String units) {
		System.out.println("Conversion: " + cRes + " " + units);
	}
	
	public void displayResult(double cRes, String units) {
		System.out.println("Conversion: " + cRes + " " + units);
	}
}
