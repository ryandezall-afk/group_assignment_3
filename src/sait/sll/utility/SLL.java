package sait.sll.utility;

import java.io.Serializable;

/**
 * Singly linked list implementation of the LinkedListADT.
 *
 * @version 2025
 */
public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Creates an empty singly linked list.
	 */
	public SLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void append(Object data) {
		Node newNode = new Node(data);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}

		this.size++;
	}

	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNext(this.head);
			this.head = newNode;
		}

		this.size++;
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		validateInsertIndex(index);

		if (index == 0) {
			prepend(data);
			return;
		}

		if (index == this.size) {
			append(data);
			return;
		}

		Node previous = nodeAt(index - 1);
		Node newNode = new Node(data);
		newNode.setNext(previous.getNext());
		previous.setNext(newNode);
		this.size++;
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		validateElementIndex(index);
		nodeAt(index).setData(data);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		validateElementIndex(index);

		if (index == 0) {
			this.head = this.head.getNext();
			this.size--;

			if (this.size == 0) {
				this.tail = null;
			}
			return;
		}

		Node previous = nodeAt(index - 1);
		Node nodeToDelete = previous.getNext();
		previous.setNext(nodeToDelete.getNext());

		if (nodeToDelete == this.tail) {
			this.tail = previous;
		}

		this.size--;
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		validateElementIndex(index);
		return nodeAt(index).getData();
	}

	@Override
	public int indexOf(Object data) {
		Node current = this.head;
		int index = 0;

		while (current != null) {
			if (dataEquals(current.getData(), data)) {
				return index;
			}

			current = current.getNext();
			index++;
		}

		return -1;
	}

	@Override
	public boolean contains(Object data) {
		return indexOf(data) != -1;
	}

	private Node nodeAt(int index) {
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	private void validateInsertIndex(int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
		}
	}

	private void validateElementIndex(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
		}
	}

	private boolean dataEquals(Object first, Object second) {
		if (first == second) {
			return true;
		}
		if (first == null || second == null) {
			return false;
		}
		return first.equals(second);
	}
}
