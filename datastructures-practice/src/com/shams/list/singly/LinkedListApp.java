package com.shams.list.singly;

import java.util.Scanner;

public class LinkedListApp {
	static Scanner sc = new Scanner(System.in);
	Node head = new Node(-1);
	public static void main(String[] args) {
		LinkedListApp app = new LinkedListApp();
		app.insertSorted(3);
		app.insertSorted(2);
		app.insertSorted(1);
		app.insertSorted(1);
		app.insertSorted(1);
		app.insertSorted(100);
		app.insertSorted(1);
		app.insertSorted(10);
		app.insertSorted(1);
		app.printList();
		/*int inputs = 0;
		while((inputs = promptInput()) > 0) {
			LinkedListApp app = new LinkedListApp();
			int c = 1;
			while( inputs > 0) {
				System.out.print("Enter value :>> "+ (inputs - (inputs - c)));
				app.insertSorted(Integer.valueOf(sc.nextLine()));
				inputs --;
				c++;
			}
			app.printList();
			break;
		}*/

	}
	private void insertSorted(int val) {
		Node newNode = new Node(val);
		if(head.next == null || head.next.value >= val) {
			newNode.next = head.next;
			head.next = newNode;
		} else {
			Node last = head.next;
			while(last.next != null && 
					last.next.value < newNode.value) {
				last = last.next;
			}
			newNode.next = last.next;
			last.next = newNode;
		}
	}
	private static int promptInput () {
		System.out.print("Vaule to be entered :");
		int numOfInputs = Integer.parseInt(sc.nextLine());
		return numOfInputs;
	}
	//append
	private Node insert(int val) {
		Node newNode = new Node(val);
		if(head.next == null) {
			head.next = newNode;
		} else {
			Node last = head.next;
			while(last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return head;
	}

	
	private void printList() {
		if(head.next == null) {
			System.out.println(head.value);
		} else {
			System.out.print("Values : ");
			while(head.next != null) {
				System.out.print(head.next.value +" ");
				head.next = head.next.next;
			}
		}
	}
}
