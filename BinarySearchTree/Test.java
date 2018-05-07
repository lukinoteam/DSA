package binary;


import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void printTree(int[] arr) {
		int x = 1;
		int k = 1;

		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			if (k == x) {
				System.out.println();
				x *= 2;
			}

			System.out.print(arr[i] + " ");
			k++;

		}
	}

	public static void main(String[] args) {
		BinaryTreeSymbolTable<Integer, String> test = new BinaryTreeSymbolTable<>();

		Scanner sc = new Scanner(System.in);

		Scanner scStr = new Scanner(System.in);

		int k = -1;

		System.out.println("1. Size" + "\n2. Empty " + "\n3. Put" + "\n4. Delete" + "\n5. Contains" + "\n6. Get"
				+ "\n7. PrintAll" + "\n8. Help");

		while (k != 0) {
			System.out.println();
			System.out.print("cmd: ");
			k = sc.nextInt();
			System.out.println();

			switch (k) {
			case 0:
				System.out.println("EXIT!");
				break;

			case 1:
				System.out.println("Size: " + test.size());
				break;
			case 2:
				System.out.println("Empty: " + test.isEmpty());
				break;
			case 3:
				System.out.print("Key: ");
				int a = sc.nextInt();
				System.out.print("Value: ");
				String str = scStr.nextLine();
				test.put(a, str);
				System.out.println("Put Success!");
				break;
			case 4:
				System.out.print("Key: ");
				int b = sc.nextInt();
				test.delete(b);
				System.out.println("Delete Success!");
				break;
			case 5:
				System.out.print("Key: ");
				int c = sc.nextInt();
				System.out.println("Contain: " + test.contains(c));

				break;
			case 6:
				System.out.print("Key: ");
				int d = sc.nextInt();
				System.out.println(test.get(d));

				break;
			case 7:
				ArrayList<Integer> keys = (ArrayList<Integer>) test.keys();
				for (Integer i : keys) {
					System.out.print(i + " ");
				}
				System.out.println();
				for (int i = 0; i < keys.size(); i++){
					System.out.print(test.get(keys.get(i)) + " ");
				}
				break;
				
			case 8:
				System.out.println("1. Size" + "\n2. Empty " + "\n3. Put" + "\n4. Delete" + "\n5. Contains" + "\n6. Get"
						+ "\n7. PrintAll" + "\n8. Help");
				break;
			default:
				break;
			}

		}

		sc.close();
		scStr.close();

	}
}
