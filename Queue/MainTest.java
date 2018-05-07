package stackqueue.bai5;

public class MainTest {
	public static void main(String[] args) {
		
		String testKey = "(a + b) * c – d)";
		
		LinkedListQueue<String> testQueue = new LinkedListQueue<>();
		
		String[] parts = testKey.split("");

		for (String s : parts) {
			if (s == "(")
				testQueue.enqueue(s);
			
			if (s == ")")
				testQueue.dequeue();
		}
		
		for (String s : testQueue) {
			System.out.print(s + " ");
		}
		
		
		
		
		if (testQueue.isEmpty())
			System.out.println("True!");
		else
			System.out.println("False!");
		
		
		
	}
}
