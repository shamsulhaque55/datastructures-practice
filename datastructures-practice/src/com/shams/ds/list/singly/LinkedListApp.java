package com.shams.ds.list.singly;

import java.util.Scanner;

public class LinkedListApp {
	static Scanner sc = new Scanner(System.in);
	Node head = new Node(-1);
	int size = 0;
	public static void main(String[] args) {
		LinkedListApp list1 = new LinkedListApp();
		list1.insertSorted(3);
		list1.insertSorted(2);
		list1.insertSorted(1);
		list1.insertSorted(1);
		list1.insertSorted(1);
		list1.insertSorted(100);
		list1.insertSorted(100);
		list1.insertSorted(0);
		list1.insertSorted(0);
		list1.printList("List 1");
		LinkedListApp list2 = new LinkedListApp();
		list2.insertSorted(0);
		list2.insertSorted(-1);
		list2.insertSorted(-1);
		list2.insertSorted(-2);
		list2.insertSorted(1);
		list2.insertSorted(10);
		list2.insertSorted(10);
		list2.insertSorted(1);
		list2.printList("List 2");
		LinkedListApp list3 = new LinkedListApp();
		list3.mergeSortedIntoOther(list1, list2);
		list3.printList("List 1 + List2 ");
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
	private void mergeSortedToList(LinkedListApp list1, LinkedListApp list2) {}

	private void mergeSortedIntoOther(LinkedListApp list1, LinkedListApp list2) {
//		Node head1 = list1.head;
//		Node head2 = list2.head;
//		int longestListSize = 0;
		Node longerNode;
		Node shorterNode;
		if(list1.size == 0 || list2.size == 0) {
			return;
		} else {
			size = list1.size + list2.size;
		}

		if(list1.size >= list2.size ) {
			longerNode = list1.head;
			shorterNode = list2.head;
		} else {
			longerNode = list2.head;
			shorterNode = list1.head;
		}
		Node currentShort = shorterNode;
		Node tempNode;
		while(currentShort.next != null) {
			if(currentShort != null && longerNode.next.value >= currentShort.value) {
				tempNode = currentShort;
				tempNode.next = longerNode.next;
				longerNode.next = tempNode;
				tempNode = null;
			} else {
				Node currentLong = longerNode.next;
				while(currentLong.next != null && currentLong.next.value < currentShort.value) {
					currentLong = currentLong.next;
				}
				tempNode = currentShort;
				currentLong.next = tempNode;
				tempNode.next = currentLong.next;
				longerNode.next = tempNode;
			}
			currentShort = currentShort.next;
		}
		head = longerNode;
	}
	private void insertSorted(int val) {
		Node newNode = new Node(val);
		if(head.next == null || head.next.value >= val) {
			newNode.next = head.next;
			head.next = newNode;
			size++;
		} else {
			Node last = head.next;
			while(last.next != null &&
					last.next.value < newNode.value) {
				last = last.next;
			}
			newNode.next = last.next;
			last.next = newNode;
			size++;
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
			size++;
		}
		return head;
	}


	private void printList(String msg) {
		System.out.print("\n"+msg);
		if(head.next == null) {
			System.out.println(head.value);
		} else {
			System.out.print(" Values("+size+") : ");
			Node temp = head.next;
			while(temp != null) {
				System.out.print(" -> "+temp.value);
				temp = temp.next;
			}
		}
	}
}
