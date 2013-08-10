package com.me.dataStructure;

import java.util.NoSuchElementException;

/**
 * Your linked list implementation.
 */
public class LinkedList<E> implements List<E> {

	private Node<E> head, tail;
	int length = 0;

	public LinkedList() {
		// Your code here
	}

	public boolean isEmpty() {
		if (length == 0)
			return true;
		else
			return false;
	}

	public void add(E item) {
		Node<E> newNode = new Node<E>(item, null);
		if (length == 0) {
			head = newNode;
			tail = head;
		} else {
			tail.setLink(newNode);
			tail = newNode;
		}
		length++;
	}

	public void add(E... items) {
		for (int i = 0; i < items.length; i++) {
			E e = items[i];
			add(e);
		}
	}

	public void add(E item, int pos) throws IndexOutOfBoundsException {

		Node<E> newNode = new Node<E>(item, null);
		Node<E> before = head;
		Node<E> after;
		int index = 0;

		if (pos == 0) {
			newNode.setLink(head);
			head = newNode;
			length++;
			return;
		} else if (pos > length) {
			throw new IndexOutOfBoundsException();
		} else {
			while (index != pos - 1) {
				before = before.getLink();
				index++;
			}
			if (pos != length - 1) {
				after = before.getLink();
				newNode.setLink(after);
			}
			before.setLink(newNode);
			length++;
		}

	}

	public void remove(int pos) throws IndexOutOfBoundsException {
		int index = 0;
		Node<E> before = head;
		Node<E> after;

		if (pos == 0) {
			after = head.getLink();
			head = after;
			length--;
			return;
		} else if (pos > length - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			while (index != pos - 1) {
				before = before.getLink();
				index++;
			}
			if (pos != length - 1) {
				after = before.getLink();
				before.setLink(before.getLink().getLink());
				length--;
			} else {
				before.setLink(null);
				length--;
			}
		}
	}

	public E get(int pos) throws IndexOutOfBoundsException {
		Node<E> node = head;
		if (pos > length - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 0; i < pos; i++) {
				node = node.getLink();
			}
			return node.getData();
		}
	}
	
	public Node<E> getNode(int pos) throws IndexOutOfBoundsException {
		Node<E> node = head;
		if (pos > length - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 0; i < pos; i++) {
				node = node.getLink();
			}
			return node;
		}
	}

	public int length() {
		return length;
	}

	public boolean contains(E target) {
		Node<E> node = head;
		while (node.getLink() != null) {
			if (node.getData().equals(target)) {
				return true;
			} else {
				node = node.getLink();
			}
		}
		return false;

	}

	public int findFirst(E target) throws NoSuchElementException {
		int index = 0;
		Node<E> node = head;
		while (index <= length) {
			if (node.getData().equals(target)) {
				return index;
			} else if (index == length) {
				throw new NoSuchElementException();
			} else {
				node = node.getLink();
				index++;
			}
		}
		return 0;

	}

	public void reverse() {

		Node<E> beforeNode = null;
		Node<E> linkedNode = null;

		Node<E> first = (Node) getNode(length-1);
		linkedNode = first;
		for (int i = length - 2; i >= 0; i--) {
			beforeNode = (Node<E>) getNode(i);
			linkedNode.setLink(beforeNode);
			linkedNode = beforeNode;
		}
		head = first;

	}

	public void printList() {
		System.out.println("Length: " + length);
		StringBuffer sb = new StringBuffer();
		Node<E> node = head;
		int index = 0;
		System.out.println("Data: ");
		while (index != length-1) {
			sb.append(node.getData() + ", ");
			node = node.getLink();
			index++;
		}
		System.out.println(sb);
		System.out.println("Head: " + head.getData());
		System.out.println("Tail: " + tail.getData());
	}
}