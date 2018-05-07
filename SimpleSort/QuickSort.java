package quicksort;

public class QuickSort {

	public static void quickSort(int[] a, int i, int j) {
		if (i < j) {
			int k = findKey(a, i, j);

			quickSort(a, i, k - 1);
			quickSort(a, k + 1, j);
		}
	}

	public static int findKey(int[] a, int i, int j) {
		if (j - i == 1) {
			if (a[i] > a[j]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			return i;
		}

		int first = i;
		int k = i + 1;
		while (k <= j) {
			if (a[k] > a[first] && a[j] < a[first]) {
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k++;
				j--;
			}

			else if (a[k] < a[first])
				k++;
			else if (a[j] > a[first])
				j--;

		}

		int temp = a[k - 1];
		a[k - 1] = a[first];
		a[first] = temp;
		return k - 1;

	}

	public static void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = { 15, 12, 70, 3, 0, 2, 9, 4 };

		sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}
}
