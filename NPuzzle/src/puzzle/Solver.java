package puzzle;

import java.util.ArrayList;

import priorityqueue.OrderedArrayMinPriorityQueue;

public class Solver {

	private Board board;
	private int move;

	public Solver(Board initial) {
		this.board = initial;
		this.move = 0;
	}

	// public boolean isSolvable() {
	//
	// }
	//
	// public int moves() {
	// }

	public Iterable<Board> solution() {

		int[][] desArr = new int[board.getArr().length][board.getArr().length];

		int n = 1;
		for (int i = 0; i < desArr.length; i++) {
			for (int j = 0; j < desArr.length; j++) {
				desArr[i][j] = i + j + n;
			}
			n += desArr.length - 1;
		}

		Board destination = new Board(desArr);

		ArrayList<Board> sol = new ArrayList<>();

		OrderedArrayMinPriorityQueue<NodeFind> priority = new OrderedArrayMinPriorityQueue<>();

		priority.insert(new NodeFind(board, move));

		sol.add(board);

		while (!board.equals(destination)) {
			move += 1;
			for (Board b : board.neighbors()) {
				priority.insert(new NodeFind(b, move));
			}

			sol.add(priority.deleteMin().getBoard());

			if (priority.min().getBoard().equals(destination)) {
				sol.add(priority.min().getBoard());
				break;
			}

			board = new Board(priority.deleteMin().getBoard().getArr());

		}

		return sol;
	}

}
