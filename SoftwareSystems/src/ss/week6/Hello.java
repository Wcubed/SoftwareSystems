package ss.week6;

import java.util.Scanner;


public class Hello {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		
		while (running) {
			System.out.print("What is your name? ");
			
			scanner.hasNextLine();
			String line = scanner.nextLine();
			
			if (line.equals("")) {
				running = false;
			} else {
				System.out.println("Hello " + line);
			}
		}

	}

}
