package datastructures;

public class LinkedList<T> implements Iterable<T> {
	private static class Node<T> {
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}

		public T data;
		public Node<T> prev;
		public Node<T> next;
	}

	public LinkedList() {
		clear();
	}

	public void clear() {
		_head = new Node<T>(null, null, null);
		_tail = new Node<T>(null, _head, null);
		_head.next = _tail;
		_size = 0;
		++_mods;
	}

	public int size() {
		return _size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Add an item at the end of the list
	 * @param x data to add
	 */
	public boolean add(T x) {
		add(size(), x);
		return true;
	}

	public void add(int i, T x) {
		addBefore(getNode(i), x);
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

	private void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<T>(x, p, p.next);
		p.next.prev = newNode;
		p.next = newNode;
		++_size;
		++_mods;
	}

	private T remove(Node<T> n) {
		n.prev.next = n.next;
		n.next.prev = n.prev;
		--_size;
		++_mods;
		return n.data;
	}

	/**
	 * Get node at i
	 * @param i index of node in list
	 * @throws IndexOutOfBoundsException if i is not between 0 and size()
	 */
	private Node<T> getNode(int i) {
		Node<T> n;
		if (i < 0 || i > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (i < size() / 2) {
			n = _head;
			for (int j = 0; j < i; ++j)
				n = n.next;
		} else {
			n = _tail;
			for (int j = size(); j > i; --j)
				n = n.prev;
		}
		return n;
	}

	public java.util.Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<T> {
		private boolean _canRemove = false;
		private int _mods = LinkedList.this._mods;
		private Node<T> _current = _head.next;

		public boolean hasNext() {
			return _current != _tail;
		}

		public T next() {
			if (_mods != LinkedList.this._mods) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			T d = _current.data;
			_current = _current.next;
			_canRemove = true;
			return d;
		}

		public void remove() {
			if (_mods != LinkedList.this._mods) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!_canRemove) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(_current.prev);
			++_mods;
			_canRemove = false;
		}
	}

	private int _size;
	private int _mods = 0;
	private Node<T> _head;
	private Node<T> _tail;
}
