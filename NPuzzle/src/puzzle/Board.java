package puzzle;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private int[][] arr;

	public int[][] getArr() {
		return arr;
	}

	public Board(int[][] blocks) {
		this.arr = blocks;
	}

	public int dimension() {
		return arr.length;
	}

	private int[] destination(int x) {
		int n = 1;
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == arr[0].length - 1 && j == arr.length - 1)
					continue;

				if (i + j + n == x) {
					int[] res = { i, j };
					return res;
				}
			}
			n += dimension() - 1;
		}
		int[] def = { -1, -1 };
		return def;
	}

	public int manhattan() {
		int sum = 0;

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0)
					continue;

				sum += Math.abs(i - destination(arr[i][j])[0]) + Math.abs(j - destination(arr[i][j])[1]);
			}
		}
		return sum;
	}

	public boolean isGoal() {
		int n = 1;
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == arr[0].length - 1 && j == arr.length - 1 && arr[i][j] == 0)
					break;

				if (arr[i][j] != i + j + n) {
					return false;
				}
			}
			n += dimension() - 1;
		}
		return true;
	}

	public Board twin() {
		int[][] tempArr = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}

		Random rd = new Random();

		int i = rd.nextInt(arr.length);
		int j = rd.nextInt(arr.length);

		int m = rd.nextInt(arr.length);
		int n = rd.nextInt(arr.length);

		while (arr[i][j] == 0 || arr[m][n] == 0 || (i == m && j == n)) {
			i = rd.nextInt(arr.length);
			j = rd.nextInt(arr.length);

			m = rd.nextInt(arr.length);
			n = rd.nextInt(arr.length);
		}

		int tmp = tempArr[i][j];
		tempArr[i][j] = tempArr[m][n];
		tempArr[m][n] = tmp;

		Board res = new Board(tempArr);

		return res;

	}

	public boolean equals(Object y) {
		Board o = (Board) y;

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != o.getArr()[i][j])
					return false;
			}
		}

		return true;

	}

	private int[][] createSwap(int[][] arr1, int a, int b, int m, int n) {
		int[][] arr2 = new int[arr1[0].length][arr1.length];

		for (int i = 0; i < arr2[0].length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}

		int t = arr2[a][b];
		arr2[a][b] = arr2[m][n];
		arr2[m][n] = t;

		return arr2;
	}

	public Iterable<Board> neighbors() {
		ArrayList<Board> res = new ArrayList<>();

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					if (i > 0)
						res.add(new Board(createSwap(arr, i, j, i - 1, j)));

					if (i < arr.length - 1)
						res.add(new Board(createSwap(arr, i, j, i + 1, j)));

					if (j > 0)
						res.add(new Board(createSwap(arr, i, j, i, j - 1)));

					if (j < arr.length - 1)
						res.add(new Board(createSwap(arr, i, j, i, j + 1)));

				}
			}
		}

		return res;

	}

	public String toString() {
		String str = "";

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				str += arr[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}
}
