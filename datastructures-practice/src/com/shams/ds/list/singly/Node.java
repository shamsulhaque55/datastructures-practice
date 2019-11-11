package com.shams.ds.list.singly;

public class Node {
	// stores actual value
	public int value;
	//stores reference to next node
	public Node next;
	/**
	 * @param value
	 * @param next
	 */
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	/**
	 *  Default Constructor
	 */
	public Node() {
	}
	
}
