package binary;

import java.util.ArrayList;

public class BinaryTreeSymbolTable<Key extends Comparable<Key>, Value> extends
		AbstractSymbolTable<Key, Value> {

	class Node {
		Key key;
		Value value;
		Node left;
		Node right;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;

		}
	}

	private Node root = null;
	private int count = 0;

	public BinaryTreeSymbolTable() {

	}

	private Node put(Node p, Key key, Value value) {
		if (p == null) {
			count++;
			return new Node(key, value);
		}

		else {
			int c = key.compareTo(p.key);

			if (c > 0)
				p.right = put(p.right, key, value);
			else if (c < 0)
				p.left = put(p.left, key, value);
			else {
				p.value = value;

			}
			count++;
			return p;
		}

	}

	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	@Override
	public Value get(Key key) {
		Node p = root;

		while (p != null) {
			int c = key.compareTo(p.key);

			if (c > 0)
				p = p.right;

			else if (c < 0)
				p = p.left;
			else
				return p.value;

		}

		return null;
	}

	@Override
	public int size() {
		return count;
	}

	private void keys(ArrayList<Key> list, Node p) {
		if (p == null) {
			return;
		}

		list.add(p.key);

		if (p.left == null && p.right == null) {
			return;
		} else {
			keys(list, p.left);
			keys(list, p.right);
		}

	}

	@Override
	public Iterable<Key> keys() {
		ArrayList<Key> res = new ArrayList<>();

		keys(res, root);

		return res;
	}

}
