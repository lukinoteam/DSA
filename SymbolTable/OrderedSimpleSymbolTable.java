package orderedsimpletable;

import java.util.ArrayList;

public class OrderedSimpleSymbolTable<Key extends Comparable<Key>, Value>
		implements OrderedSymbolTable<Key, Value> {

	private Key[] keyArray = null;
	private Value[] valueArray = null;
	private int n = 0;
	private int default_capacity = 100;

	@SuppressWarnings("unchecked")
	public OrderedSimpleSymbolTable() {
		keyArray = (Key[]) new Object[default_capacity];
		valueArray = (Value[]) new Object[default_capacity];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(Key key, Value value) {
		if (key == null)
			throw new NullPointerException("Ahihi");

		for (int i = 0; i < n; i++) {
			if (key.equals(keyArray[i])) {
				valueArray[i] = value;
				return;
			}
		}

		n++;
		if (n > default_capacity) {
			default_capacity += 100;
			Key[] tmpKey = (Key[]) new Object[default_capacity];

			Value[] tmpValue = (Value[]) new Object[default_capacity];

			for (int i = 0; i < n - 1; i++) {
				tmpKey[i] = keyArray[i];
				tmpValue[i] = valueArray[i];
			}

			keyArray = tmpKey;
			valueArray = tmpValue;
		}

		keyArray[n - 1] = key;
		valueArray[n - 1] = value;

	}

	@Override
	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException("Ahihi");

		for (int i = 0; i < n; i++) {
			if (key == keyArray[i]) {
				return valueArray[i];
			}
		}

		return null;
	}

	@Override
	public void delete(Key key) {
		put(key, null);
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return n;

	}

	@Override
	public Iterable<Key> keys() {
		ArrayList<Key> res = new ArrayList<>();
		for (Key k : keyArray)
			res.add(k);
		return res;
	}

	@Override
	public Key min() {
		if (n == 0)
			throw new NullPointerException("Ahihi");

		return keyArray[0];
	}

	@Override
	public Key max() {
		if (n == 0)
			throw new NullPointerException("Ahihi");
		return keyArray[n - 1];
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size(Key u, Key v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		// TODO Auto-generated method stub
		return null;
	}

}
