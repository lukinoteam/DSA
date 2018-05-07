package submission;

public class MergeArray {

	public static int[] mergeArray(int[] a, int[] b) {
		int i = 0;
		int j = 0;

		int[] c = new int[a.length + b.length];

		for (int k = 0; k < c.length; k++) {
			if (k < a.length) {
				c[k] = a[k];
			} else {
				c[k] = b[k - a.length];
			}
		}

		for (int k = 0; k < c.length; k++) {
			if (i > a.length - 1)
				c[k] = b[j++];
			else if (j > b.length - 1)
				c[k] = a[i++];
			else if (a[i] < b[j]) {
				c[k] = a[i];
				i++;
			} else {
				c[k] = b[j];
				j++;

			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 8, 10 };
		int[] b = { 0, 3, 7, 12 };

		for (int i : mergeArray(a, b)) {
			System.out.print(i + " ");
		}

	}
}