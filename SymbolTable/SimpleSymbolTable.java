package simpletable;

import java.util.ArrayList;

public class SimpleSymbolTable<Key extends Comparable<Key>, Value> extends
		AbstractSymbolTable<Key, Value> {

	private class Node {
		Key key;
		Value value;
		Node next;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private Node list = null;

	@Override
	public void put(Key key, Value value) {
		if (key == null)
			throw new NullPointerException("AHIHI");
		Node p = list;
		while (p != null) {
			if (p.key.equals(key)) {
				p.value = value;
				return;
			}

			p = p.next;
		}
		Node q = new Node(key, value);
		q.next = list;
		list = q;

	}

	@Override
	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException("AHIHI");

		if (list == null)
			return null;
		Node p = list;
		while (p != null) {
			if (p.key.equals(key))
				return p.value;
			p = p.next;
		}
		return null;

	}

	@Override
	public int size() {
		Node p = list;
		int res = 0;

		while (p != null) {
			res += 1;
			p = p.next;
		}

		return res;
	}

	@Override
	public Iterable<Key> keys() {
		ArrayList<Key> res = new ArrayList<>();
		Node p = list;
		while (p != null) {
			res.add(p.key);
			p = p.next;
		}
		return res;
	}

}
