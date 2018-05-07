package stackqueue.bai5;

import java.util.Iterator;

public class LinkedListQueue<T> implements QueueInterface<T>{

	class Node{
		T element;
		Node next;
		
		Node(T element){
			this.element = element;
		}
		
	}
	
	private Node queue = null;
	
	
	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	class QueueIterator implements Iterator<T> {

		private Node currentNode = queue;

		@Override
		public boolean hasNext() {

			return currentNode != null;
		}

		@Override
		public T next() {
			T element = currentNode.element;
			currentNode = currentNode.next;
			return element;
		}
	}

	@Override
	public void enqueue(T element) {
		Node p = new Node(element);
		
		if (queue == null) {
			queue = p;
			queue.next = null;
		}
			
		else {
			Node tmp = queue;
			while(tmp.next != null)
				tmp = tmp.next;
			tmp.next = p;
		}
		
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new NullPointerException("hihi");
		T tempElement = queue.element;
		queue = queue.next;
		return tempElement;
	}

	@Override
	public boolean isEmpty() {
		return queue == null;
	}
	
}
