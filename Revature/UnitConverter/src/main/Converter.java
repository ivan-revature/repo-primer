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
		double dblQty;
		
		do {
			cunits.displayMenu();
			
			/* Collect user's menu selection */
			menuSelection = scanner.nextInt();
			
			switch(menuSelection) {
			case 1:
				dblQty = Converter.collectQty("Cups", "tsp", scanner);
				dblResult = cunits.convertCupsToTeaspoons(dblQty);
				cunits.displayResult(dblResult, "tsp");
				break;
			case 2:
				dblQty = Converter.collectQty("Miles", "km", scanner);
				dblResult = cunits.convertMilestoKm(dblQty);
				cunits.displayResult(dblResult, "km");
				break;
			case 3:
				dblQty = Converter.collectQty("US gal", "Imperial gal", scanner);
				dblResult = cunits.convertUsGalToImGal(dblQty);
				cunits.displayResult(dblResult, "imperial gal");
				break;
			case 4:
				scanner.close();
				System.out.println("App is closing.");
			}
		}  while (menuSelection != 4);
	}
	
	private static double collectQty (String unit1, String unit2, Scanner scanner) {
		System.out.println("\n" + unit1 + ": ");
		return scanner.nextDouble();
	}
	
	private double convertCupsToTeaspoons(double cups) {
		final int tspInCup = 48;
		return cups * (double) tspInCup;
	}
	
	private double convertMilestoKm(double miles) {
		final double kmInMile = 1.609344;
		return miles * kmInMile;
	}
	
	private static double convertUsGalToImGal(double usgal) {
		final double imgalInUSgal = 0.83267;
		return usgal * imgalInUSgal;
	}
	
	private void displayMenu() {
		System.out.println("Unit Converter");
		System.out.println("\nPlease select an option:");
		System.out.println("1. Cups to Teaspoons");
		System.out.println("2. Miles to Kilometers");
		System.out.println("3. US Gal to Imperial Gal");
		System.out.println("4. Quit");
	}
	
	private void displayResult(int cRes, String units) {
		System.out.println("Conversion: " + cRes + " " + units);
	}
	
	private void displayResult(double cRes, String units) {
		System.out.println("Conversion: " + cRes + " " + units);
	}
}
