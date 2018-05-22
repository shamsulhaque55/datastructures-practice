package com.shams.list.singly;

public class CircularLinkedListApp {
	CircularNode<?> head = new CircularNode<>(null);

	public static void main(String[] args) throws Exception {
		CircularLinkedListApp app = new CircularLinkedListApp();
		app.appendNode("786");
		app.appendNode(112);
		app.appendNode("Hello");
		app.appendNode("LOL");
		app.appendNode("LMFAO");
		app.appendNode("ROFL");
		app.appendNode("LEL");
		app.appendNode("LUL");
		System.out.println("Initial Values");
		app.printNode();
		app.removeNode(112);
		app.removeNode("786");
		System.out.println("\nAfter Delete");
		app.printNode();
	}

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
		System.out.println();
	}
	
	private <T> void removeNode(T value) throws Exception {
		boolean dataFound = false;
		if(head.next ==  null) {
			throw new Exception("Attempt to remove node from empty list");
		} else {
			CircularNode<?> current = head;
			while(current.next.next != head) {
				if(current.next.equals(value)) {
					dataFound = true;
					break;
				}
				current = current.next;
			}
			if(dataFound) {
				current.next = current.next.next;
				System.out.println("\nDeleted Data \""+value+"\"");
			}
			else
				System.out.println("\nData \""+value+"\" is not present");
		}
	}
	
	/*private void removeNode(int pos) throws Exception {
		if(head.next ==  null) {
			throw new Exception("Attempt to remove node from empty list");
		} else {
			
		}
	}*/

}
