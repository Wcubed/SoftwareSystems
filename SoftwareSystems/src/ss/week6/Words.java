package ss.week6;

import java.util.Scanner;


public class Words {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean running = true;

		while (running) {
			System.out.print("Line (or \"end\"): ");
			scanner.hasNextLine();
			String line = scanner.nextLine();
			
			int i = 0;
			Scanner wordScan = new Scanner(line);
			
			while (wordScan.hasNext()) {
				String word = wordScan.next();
				
				if (i == 0 && word.equals("end")) {
					running = false;
					break;
				} else {
					System.out.println(String.format("Word %d: %s", i, word));
					i++;
				}
			}
			wordScan.close();
		}

	}
}
