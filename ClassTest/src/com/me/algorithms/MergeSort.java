package com.me.algorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	public int[] sort(int[] array) {
		return mergeSort(array, 0, array.length - 1, new int[array.length]);
	}

	private int[] mergeSort(int[] array, int low, int high, int[] b) {
		if (low >= high)
			return array;
		int mid = low + (high - low) / 2;
		mergeSort(array, low, mid, b);
		mergeSort(array, mid + 1, high, b);
		merge(array, low, mid + 1, high, b);
		return array;
	}

	private void merge(int[] array, int low, int midPlus1, int high, int[] b) {
		int begin = low;
		int mid = midPlus1 - 1;
		int idx = low;
		while (low <= mid && midPlus1 <= high) {
			if (array[low] < array[midPlus1]) {
				b[idx++] = array[low++];
			} else {
				b[idx++] = array[midPlus1++];
			}
		}
		while (low <= mid) {
			b[idx++] = array[low++];
		}
		while (midPlus1 <= high) {
			b[idx++] = array[midPlus1++];
		}
		while (high >= begin) {
			array[high] = b[high];
			high--;
		}
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int size = 10, range = 100;
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(range);
		}

		System.out.println("Before sort:");
		// System.out.println(Arrays.toString(array));
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println(" ");
		MergeSort ms = new MergeSort();
		ms.sort(array);
		System.out.println("After sort:");
		for (int i : ms.sort(array)) {
			System.out.print(i + ", ");
		}

		// System.out.println(Arrays.toString(array));
	}
}
