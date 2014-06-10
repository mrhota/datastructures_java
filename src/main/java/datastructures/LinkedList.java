package datastructures;

public class LinkedList<T> implements Iterable<T> {
	private static class Node<T> {

	}

	public LinkedList() {
		clear();
	}

	public void clear() {

	}

	public int size() {
		return _size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Add an item at the end of the list
	 * @param x Data to add
	 */
	public boolean add(T x) {
		add(size(), x);
		return true;
	}

	public void add(int i, T x) {
		
	}

	public T get(int i) {
		return getNode(i).data;
	}

	/**
	 * Store the given data in the ith node, and return the old data.
	 * @i index at which to store the data
	 * @newData the data to store
	 * @return old data at ith position.
	 */
	public T set(int i, T newData) {
		Node<T> p = getNode(i);
		T oldData = p.data;
		p.data = newData;
		return oldData;
	}

	public T remove(int i) {
		return remove(getNode(i));
	}

	private int _size;
	private int _mods = 0;
	private Node<T> _head;
	private Node<T> _tail;
}
