import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SlidingPuzzleSolver {

	class Node {
		int moves;
		SlidingPuzzle puzzle;
		List<SlidingPuzzle> neighbors;

		public Node(SlidingPuzzle puzzle, int moves) {
			this.puzzle = puzzle;
			this.moves = moves;
			neighbors = new LinkedList<>();
		}
	}

	private HashSet<String> visited;
	private LinkedList<Node> queue;

	public int solve(SlidingPuzzle puzzle) {
		visited = new HashSet<>();
		queue = new LinkedList<>();

		Node start = new Node(puzzle, 0);
		SlidingPuzzle end = new SlidingPuzzle();

		queue.addLast(start);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			visited.add(current.puzzle.getState());

			if (current.puzzle.equals(end)) {
				System.out.println("Visited size: " + visited.size());
				return current.moves;
			}

			SlidingPuzzle next = null;
			for (int i = 0; i < 4; i++) {
				try {
					switch (i) {
					case 0:
						next = current.puzzle.moveUp();
						break;
					case 1:
						next = current.puzzle.moveRight();
						break;
					case 2:
						next = current.puzzle.moveDown();
						break;
					case 3:
						next = current.puzzle.moveLeft();
						break;
					}
					if (!visited.contains(next.getState())) {
						visited.add(next.getState());
						queue.addLast(new Node(next, current.moves + 1));
					}
				} catch (InvalidMove e) {
					// ignore this movement
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("saida-puzzle.txt");
		Scanner s = new Scanner(new FileInputStream("entrada-puzzle.txt"));
		s.useDelimiter("\n");

		SlidingPuzzleSolver solver = new SlidingPuzzleSolver();

		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			String state = s.next();
			ps.println(solver.solve(new SlidingPuzzle(state)));
		}

		s.close();
		ps.close();
	}

}
