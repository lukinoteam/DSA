package binarysearch;

public class BinarySearch {
	public static int binarySearch(int[] arr, int x) {
		return binarySearch(arr, x, 0, arr.length - 1);
	}

	public static int binarySearch(int[] arr, int x, int u, int v) {

		if (u == v) {
			return (arr[u] == x) ? u : -1;
		}

		if (arr[u] == x)
			return u;
		if (arr[v] == x)
			return v;

		int m = u + (v - u) / 2;

		if (arr[m] == x)
			return m;

		if (arr[m] > x)
			return binarySearch(arr, x, u, m - 1);
		else
			return binarySearch(arr, x, m + 1, v);

	}

	public static void main(String[] args) {

	}
}
