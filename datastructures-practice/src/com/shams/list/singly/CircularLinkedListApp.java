package com.shams.list.singly;

public class CircularLinkedListApp {
	CircularNode<?> head = new CircularNode<>(null);

	public static void main(String[] args) {
		CircularLinkedListApp app = new CircularLinkedListApp();
		app.appendNode("786");
		app.appendNode(112);
		app.appendNode("Hello");
		app.appendNode("LOL");
		app.appendNode("LMFAO");
		app.appendNode("ROFL");
		app.appendNode("LEL");
		app.appendNode("LUL");
		app.printNode();

	}

	@SuppressWarnings("unchecked")
	private <T> void appendNode(T value) {
		CircularNode<T> newNode = new CircularNode<T>(value);
		if(head.next == null) {
			head.next = newNode;
			newNode.next = head;
		} else {
			CircularNode<?> current = head.next;
			while(current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
		
	}
	
	private <T> void printNode() {
		CircularNode<?> temp = head.next;
		while(temp != head) {
			System.out.print("->"+temp.value);
			temp = temp.next;
		}
	}

}
