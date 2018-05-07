package binary;

public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	
	public void delete(Key key) {
		put(key, null);
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
}
