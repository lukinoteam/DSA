package simpletable;

import java.util.ArrayList;

public class Main {

	

	public static void main(String[] args) {
		SimpleSymbolTable<Integer, String> studentTable = new SimpleSymbolTable<Integer, String>();

		studentTable.put(1, "Buoi Minh Hieu");
		studentTable.put(2, "Hieu Chim");
		studentTable.put(3, "Son Tung MTP");
		studentTable.put(4, "E do");
		studentTable.put(5, "Duoc dz");

		System.out.println(studentTable.size());

		ArrayList<Integer> id = (ArrayList<Integer>) studentTable.keys();

		for (Integer i : id) {
			System.out.println(studentTable.get(i));
		}
	}
}
