package priorityqueue;

public interface MinPriorityQueue<Key extends Comparable<Key>> extends Iterable<Key>{

	public void insert(Key v);

	public Key deleteMin();

	public boolean isEmpty();

	public Key min();

	public int size();

}
