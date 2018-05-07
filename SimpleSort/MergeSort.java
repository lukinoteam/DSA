package mergesort;

public class MergeSort {

	public static void mergeSort(int[] a, int u, int v) {
		if (u < v) {
			int m = u + (v - u) / 2;

			mergeSort(a, u, m);
			mergeSort(a, m + 1, v);

			merge(a, u, m, v);
		}
	}

	public static void merge(int[] a, int u, int m, int v) {
		int i = u;
		int j = m + 1;
		int[] b = new int[a.length];
		for (int k = 0; k < a.length; k++)
			b[k] = a[k];

		for (int k = u; k <= v; k++) {
			if (i > m)
				a[k] = b[j++];
			else if (j > v)
				a[k] = b[i++];

			else if (b[i] > b[j]) {
				a[k] = b[j];
				j++;
			} else {
				a[k] = b[i];
				i++;
			}
		}

	}

	public static void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	
	
	
	public static void main(String[] args) {

		int[] arr = { 8, 5, 3, 1, 9, 0 };

		System.out.println("Before sort:");
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
		sort(arr);
		System.out.println("After sort:");
		for (int i : arr)
			System.out.print(i + " ");
	}
}
