package priorityqueue;

public class TestPro {

	public static void main(String[] args) {
		OrderedArrayMinPriorityQueue<Integer> test = new OrderedArrayMinPriorityQueue<>();

		System.out.println(test.size());
		System.out.println(test.isEmpty());

		test.insert(3);

		test.insert(4);

		test.insert(5);
		
		test.insert(1);
		
		

		System.out.println(test.size());
		System.out.println(test.isEmpty());

		for (Integer i : test) {
			System.out.print(i + " ");
		}

		System.out.println();

		System.out.println(test.deleteMin());
		for (Integer i : test) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println(test.size());
	}

}
