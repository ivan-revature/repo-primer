import java.util.Scanner;
public class ExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please type in a line and hit Enter.");
		String line = scanner.nextLine();
		
		System.out.println("You have typed: " + line);
		
		String numbers = "1 2 3 5 7 9";
		scanner = new Scanner(numbers);
		
		while(scanner.hasNext()) {
			System.out.print(scanner.nextInt());
		}
		scanner.close();
	}

}
