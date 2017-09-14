
public class SlidingPuzzle {

	private final String state;

	public SlidingPuzzle() {
		state = "12345678 ";
	}

	public SlidingPuzzle(String initialState) {
		state = initialState;
	}

	public SlidingPuzzle shuffle(int iterations) {
		SlidingPuzzle puzzle = this;
		for (int i = 0; i < iterations; i++) {
			puzzle = puzzle.randomMove();
		}
		return puzzle;
	}

	public SlidingPuzzle randomMove() {
		SlidingPuzzle puzzle = this;
		while (puzzle == this) {
			try {
				int dir = (int) (Math.random() * 4);
				switch (dir) {
				case 0:
					puzzle = puzzle.moveUp();
					break;

				case 1:
					puzzle = puzzle.moveRight();
					break;

				case 2:
					puzzle = puzzle.moveDown();
					break;

				case 3:
					puzzle = puzzle.moveLeft();
					break;
				}
			} catch (InvalidMove e) {
				// try again
			}
		}
		return puzzle;
	}

	public SlidingPuzzle moveLeft() throws InvalidMove {
		int pos = findBlank();
		if ((pos % 3) > 0) {
			StringBuilder sb = new StringBuilder(state);
			sb.setCharAt(pos, sb.charAt(pos - 1));
			sb.setCharAt(pos - 1, ' ');
			return new SlidingPuzzle(sb.toString());
		}
		throw new InvalidMove();
	}

	public SlidingPuzzle moveDown() throws InvalidMove {
		int pos = findBlank();
		if (pos < 6) {
			StringBuilder sb = new StringBuilder(state);
			sb.setCharAt(pos, sb.charAt(pos + 3));
			sb.setCharAt(pos + 3, ' ');
			return new SlidingPuzzle(sb.toString());
		}
		throw new InvalidMove();
	}

	public SlidingPuzzle moveRight() throws InvalidMove {
		int pos = findBlank();
		if ((pos % 3) < 2) {
			StringBuilder sb = new StringBuilder(state);
			sb.setCharAt(pos, sb.charAt(pos + 1));
			sb.setCharAt(pos + 1, ' ');
			return new SlidingPuzzle(sb.toString());
		}
		throw new InvalidMove();
	}

	public SlidingPuzzle moveUp() throws InvalidMove {
		int pos = findBlank();
		if (pos >= 3) {
			StringBuilder sb = new StringBuilder(state);
			sb.setCharAt(pos, sb.charAt(pos - 3));
			sb.setCharAt(pos - 3, ' ');
			return new SlidingPuzzle(sb.toString());
		}
		throw new InvalidMove();
	}

	public int findBlank() {
		return state.indexOf(' ');
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(state.charAt(i * 3 + j));
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	public String getState() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof SlidingPuzzle) {
			SlidingPuzzle puzzle = (SlidingPuzzle) obj;
			return state.equals(puzzle.getState());
		}
		return false;
	}
}
