package puzzle;

import java.util.ArrayList;

import priorityqueue.OrderedArrayMinPriorityQueue;

public class Main {

	public static ArrayList<Board> solution(Board board) {
		int move = 0;

		int[][] desArr = new int[board.getArr().length][board.getArr().length];

		int n = 1;
		for (int i = 0; i < desArr.length; i++) {
			for (int j = 0; j < desArr.length; j++) {
				desArr[i][j] = i + j + n;

				if (i == desArr.length - 1 && j == desArr.length - 1)
					desArr[i][j] = 0;

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

			sol.add(priority.min().getBoard());

			if (priority.min().getBoard().equals(destination)) {
				break;
			}

			if (priority.min().getBoard().manhattan() == 2
					&& priority.min().getBoard().getArr()[board.getArr().length - 1][board.getArr().length - 1] == 0)
				return null;

			board = new Board(priority.deleteMin().getBoard().getArr());

		}

		return sol;
	}

	public static void main(String[] args) {
		// int[][] arr = { { 2, 3, 6 }, { 1, 5, 0 }, { 4, 7, 8 } };

		int[][] arr = { { 8, 1, 3 }, { 4, 0, 2 }, { 7, 6, 5 } };

		Board myBoard = new Board(arr);

		for (Board b : solution(myBoard)) {
			System.out.println(b);

		}

	}
}
