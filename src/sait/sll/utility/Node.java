package sait.sll.utility;

import java.io.Serializable;

/**
 * Represents a single node in the singly linked list.
 *
 * @version 2025
 */
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object data;
	private Node next;

	/**
	 * Creates a node with the specified data.
	 *
	 * @param data data stored in the node.
	 */
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Gets the data stored in the node.
	 *
	 * @return node data.
	 */
	public Object getData() {
		return this.data;
	}

	/**
	 * Sets the data stored in the node.
	 *
	 * @param data new node data.
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets the next node reference.
	 *
	 * @return next node, or null if this is the last node.
	 */
	public Node getNext() {
		return this.next;
	}

	/**
	 * Sets the next node reference.
	 *
	 * @param next next node reference.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
