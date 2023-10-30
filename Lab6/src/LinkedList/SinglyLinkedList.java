package LinkedList;

import java.util.Arrays;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

// Returns the number of elements in the list.
	public int size() {
		return size;
	}

// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

// Returns (but does not remove) the first element in the list.
	public E first() {
		return head.getData();
	}

// Returns (but does not remove) the last element in the list.
	public E last() {
		return tail.getData();
	}

// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e, head);
		head = newNode;
		size++;

		if (head.getNext() == null) {
			tail = head;
		}
	}

// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);

		if (size == 0) {
			addFirst(e);
			return;
		}

		tail.setNext(newNode);
		tail = newNode;
		size++;
	}

// Removes and returns the first element of the list.
	public E removeFirst() {
		E element = head.getData();
		Node<E> nextNode = head.getNext();

		head.setData(null);
		head.setNext(null);
		head = nextNode;
		size--;

		if (size == 0) {
			tail = null;
		}
		return element;
	}

// Removes and returns the last element of the list.
	public E removeLast() {
		E element = tail.getData();
		Node<E> prevNode = head;
		for (int i = 0; i < size - 2; i++) {
			prevNode = prevNode.getNext();
		}

		tail.setData(null);
		tail.setNext(null);
		tail = prevNode;
		tail.setNext(null);

		size--;
		return element;
	}

	public E[] toArray() {
		E[] result = (E[]) new Object[size];
		int index = 0;
		for (Node<E> x = head; x != null; x = x.getNext()) {
			result[index++] = (E) x.getData();
		}
		return result;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();

		l1.addFirst(1);
		l1.addFirst(2);
		l1.addFirst(3);
		l1.addFirst(4);

		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);

		System.out.println(l1.removeFirst());
		System.out.println(l1.removeLast());
		System.out.println(l1.first());
		System.out.println(l1.last());
		System.out.println(Arrays.toString(l1.toArray()));
	}
}
