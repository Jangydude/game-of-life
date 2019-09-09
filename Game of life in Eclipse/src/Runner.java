import java.util.Scanner;

/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int size = -1;
		while (size < 0) {
			System.out.println("Please type the size of your square grid");
			System.out.println("The game suggests sizes of 30 to 60 in order to experience the beautiful graphics.");
			size = kb.nextInt();
			if (size <= 0) {
				System.out.println("Please type a positive value!");

			}
		}

		GoL newGame = new GoL(size);
		//
		int man = 0;

		int whe = -1;

		while (whe != 0 && whe != 1) {
			System.out.println("Press 0 for random game in string, and press 1 for graphics");
			whe = kb.nextInt();
			if (whe != 0 && whe != 1) {
				System.out.println("Please type a valid method. ");
			}
		}
		
		System.out.println("Please type the amount of generations you want.");
		System.out.println("As a reference, the size of the grid times 10 would be enough generations.");
		int numOfGen = kb.nextInt();

		if (whe == 1) {
			
			System.out.println("Press 0 to play a random game, and press 1 for a manual game.");
			System.out.println("For the manual game, you need to press the screen once, and it will start.");
			man = kb.nextInt();
		}
		
		
		

		if (whe == 0) {
			newGame.random();
		}

		if (man == 1) {
			newGame.setUp();
			newGame.initializeStdDraw(size);
		}
		if (man == 0 && whe == 1) {
			newGame.random();
			newGame.initializeStdDraw(size);
		}
		
	
		while (numOfGen > 0) {
			if (whe == 0) {
				System.out.println(newGame.toString());
			} else {

				newGame.graphics();

			}
			newGame.nextGen();
			numOfGen--;
		}

	}
}
