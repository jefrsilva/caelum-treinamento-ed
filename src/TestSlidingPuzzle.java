import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestSlidingPuzzle {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("entrada-puzzle.txt");

		int numPuzzles = 100;
		ps.println(numPuzzles);
		SlidingPuzzle slidingPuzzle = null;
		for (int i = 0; i < numPuzzles; i++) {
			slidingPuzzle = new SlidingPuzzle();
			slidingPuzzle = slidingPuzzle.shuffle(5000);
			ps.println(slidingPuzzle.getState());
		}

		ps.close();
	}
}
