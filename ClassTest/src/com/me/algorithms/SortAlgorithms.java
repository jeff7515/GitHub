package com.me.algorithms;

import java.util.Random;

public class SortAlgorithms {

	int[] randomList;
	String s;
	
	public static void main(String[] args) {

		
		int[] testArray = generateRandomInts(10);

		for (int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + ", ");
		}

		System.out.println();

		int[] sortedArray = insertS(testArray);

		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + ", ");
		}
		System.out.println();
	}


	public static int[] insertS(int[] array) {

		int key;
		for (int i = 0; i < array.length; i++) {
			int j = i;
			key = array[j];
			while (j > 0 && array[j - 1] > key) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = key;

		}
		return array;
	}

	public static int[] mergeSort(int[] array) {
		if (array.length > 1) {
			int elementsInA1 = array.length / 2;
			int elementsInA2 = elementsInA1;
			if ((array.length % 2) == 1)
				elementsInA2 += 1;
			int arr1[] = new int[elementsInA1];
			int arr2[] = new int[elementsInA2];
			for (int i = 0; i < elementsInA1; i++) {
				arr1[i] = array[i];
			}
			for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
				arr2[i - elementsInA1] = array[i];
			arr1 = mergeSort(arr1);
			arr2 = mergeSort(arr2);
			int i = 0, j = 0, k = 0;
			while (arr1.length != j && arr2.length != k) {
				if (arr1[j] < arr2[k]) {
					array[i++] = arr1[j++];
				} else {
					array[i++] = arr2[k++];
				}
			}
			while (arr1.length != j) {
				array[i++] = arr1[j++];
			}
			while (arr2.length != k) {
				array[i++] = arr2[k++];
			}
		}
		return array;
	}

	static int[] generateRandomInts(int size) {
		Random random = new Random();
		int[] intList = new int[size];
		for (int i = 0; i < size; i++) {
			intList[i] = random.nextInt(size + 1);
		}
		return intList;
	}

}
