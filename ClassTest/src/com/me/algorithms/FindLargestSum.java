package com.me.algorithms;

import java.util.Random;

public class FindLargestSum {

	public static void main(String[] args) {

		// int[] in = generateRandom(5, 5);
		// int[] in = { 5, 3, -1, -2, 1, 2, 5 };
		// int[] in = { -2, 4, 0, 1, -2 };
		// int[] in = { 5, -3, -2, -1, 3, 1, -1, 3, -3, 4, 1};
		// int[] in = { -4, 5, -6, 3, 1, -1, 3, -3, 4, 1};
		// int[] in = { -5, -3, -5, -2, -1, -3, -1, -6 };
		int[] in = { 1, -1, -1, 2, -1, 2 };

		for (int i : in) {
			System.out.print(i + ", ");
		}

		System.out.println("");
		int i = findLargest2(in);
		System.out.println("out:" + i);

	}

	public static int[] generateRandom(int size, int maxNum) {
		Random random = new Random();
		int[] intArray = new int[size];
		for (int i = 0; i < intArray.length; i++)
			intArray[i] = random.nextInt(maxNum * 2 + 1) - maxNum;
		return intArray;
	}

	public static int findLargest2(int[] in) {
		int temp = 0;
		int max = 0;
		for (int i = 0; i < in.length; i++) {
			temp += in[i];
			if (temp > max) {
				max = temp;
			}
			if (temp < 0) {
				temp = 0;
			}
		}
		return max;
	}

}
