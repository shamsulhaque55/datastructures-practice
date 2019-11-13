package com.shams.ds.list.singly;

import java.util.Scanner;

public class LinkedListApp {
	static Scanner sc = new Scanner(System.in);
	Node head = new Node(-1);
	int size = 0;
	public static void main(String[] args) {
		LinkedListApp list1 = new LinkedListApp();
		list1.insertSorted(9);
		list1.insertSorted(9);
		list1.insertSorted(9);
		list1.insertSorted(9);
		list1.insertSorted(9);
		list1.insertSorted(9);
//		list1.insertSorted(100);
//		list1.insertSorted(100);
//		list1.insertSorted(0);
//		list1.insertSorted(0);
		list1.printList("List 1");
		LinkedListApp list2 = new LinkedListApp();
		list2.insertSorted(0);
		list2.insertSorted(1);
		list2.insertSorted(1);
		list2.insertSorted(2);
		list2.insertSorted(1);
		list2.insertSorted(9);
//		list2.insertSorted(10);
//		list2.insertSorted(10);
//		list2.insertSorted(1);
		list2.printList("List 2");
		LinkedListApp list3 = new LinkedListApp();
		//list3.printList(list3.mergeSortedToList(list1.head, list2.head), "Merged");
		
		list3.printList(list3.addTwoList(list1.head, list2.head), "Summed");
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
	private Node mergeSortedToList(Node list1, Node list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		if (list1.value < list2.value) {
			list1.next = mergeSortedToList(list1.next, list2); // Generates all the recurrence equation for this less than condition
			this.size++;
			return list1;
		} else {
			list2.next = mergeSortedToList(list1, list2.next); // Generates all the recurrence equation for this greater than condition
			this.size++;
			return list2;
		}
	}
	
	private Node addTwoList (Node l1, Node l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		int  carry = 0;
		int sum = l1.value + l2.value + carry;
	    if(l1.next != null || l2.next != null) {
	    	carry = sum / 10;
	    	sum = sum % 10;
	    } 
	    l1.value = sum;
	    if(l1.next != null) {
	    	l1.next.value += carry;
	    } else {
	    	
	    }
	    l1.next = addTwoList(l1.next, l2.next);
		return l1;
		
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
	
	private void printList(Node head, String msg) {
		System.out.print("\n"+msg);
		if(head.next == null) {
			System.out.print(" Value : ");
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
