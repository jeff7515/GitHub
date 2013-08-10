package com.me.dataStructure;

public class LinkedNotes {

	private Note head;

	private static class Note {
		Note nextEle;
		int value;
	}

	public LinkedNotes add(int value) {

		Note newNote = new Note();
		newNote.value = value;
		newNote.nextEle = null;

		Note note = head;
		if (head == null) {
			head = newNote;
		} else {
			while (note.nextEle != null) {
				note = note.nextEle;
			}
			note.nextEle = newNote;
		}
		System.out.println("Add " + value);

		return this;
	}

	public void add(int index, int value) {

		Note newNote = new Note();
		newNote.value = value;
		newNote.nextEle = null;

		int listIndex = 0;

		Note beforeNote = head;
		Note afterNote = null;

		if (index == 0) {
			newNote.nextEle = head;
			head = newNote;
			System.out.println("Add index " + index);
			return;
		} else {
			while (listIndex != index - 1) {
				if (beforeNote.nextEle == null) {
					System.out.println("Add index " + index + " out of bound");
					return;
				}
				beforeNote = beforeNote.nextEle;
				listIndex++;
			}
			if (beforeNote.nextEle != null) {
				afterNote = beforeNote.nextEle;
				newNote.nextEle = afterNote;
			}
			beforeNote.nextEle = newNote;
		}

		System.out.println("Add index " + index);
		return;
	}

	public void remove() {
		if (head == null) {
			return;
		}
		Note afterNote = head.nextEle;
		head = afterNote;
	}

	public void remove(int index) {
		int listIndex = 0;
		Note before = head;
		Note after = null;

		if (index == 0) {
			after = head.nextEle;
			head = after;
			return;
		}

		while (listIndex != index - 1) {
			if (before.nextEle == null) {
				System.out.println("Remove IndexOutBound");
				return;
			}
			before = before.nextEle;
		}
		before.nextEle = before.nextEle.nextEle;
		System.out.println("Remove index " + index);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Note note = head;
		if (head != null) {
			sb.append(note.value + ", ");
		}
		while (note.nextEle != null) {
			sb.append(note.nextEle.value + ", ");
			note = note.nextEle;
		}
		return sb.toString();
	}
}
