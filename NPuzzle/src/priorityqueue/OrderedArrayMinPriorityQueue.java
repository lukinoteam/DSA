package priorityqueue;

import java.util.Iterator;

public class OrderedArrayMinPriorityQueue<Key extends Comparable<Key>> implements MinPriorityQueue<Key> {

	class Node {
		Key key;
		Node next;

		Node(Key key) {
			this.key = key;
			this.next = null;
		}
	}

	private Node list = null;

	@Override
	public void insert(Key v) {
		Node p = new Node(v);

		Node q = list;

		/* Special case for head node */
		if (q == null || q.key.compareTo(v) >= 0) {
			p.next = list;
			list = p;

		} else {

			/* Locate the node before point of insertion. */

			while (q.next != null && q.next.key.compareTo(p.key) < 0)
				q = q.next;

			p.next = q.next;
			q.next = p;
		}

	}

	@Override
	public Key deleteMin() {

		if (size() == 0)
			throw new NullPointerException();

		Node tmp = list;
		list = list.next;
		return tmp.key;

	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Key min() {
		if (size() == 0)
			throw new NullPointerException();

		return list.key;
	}

	@Override
	public int size() {
		int n = 0;

		Node p = list;

		while (p != null) {
			n++;
			p = p.next;
		}
		return n;
	}

	public Iterator<Key> iterator() {
		return new Iterator<Key>() {

			Node current = list;

			@Override
			public boolean hasNext() {
				return (current == null) ? false : true;
			}

			@Override
			public Key next() {
				if (hasNext()) {
					Key key = current.key;
					current = current.next;
					return key;
				}
				return null;
			}

		};

	}

}
