package com.bridgelabz.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 3, 2, 1 };
		insertionSort(arr);
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void insertionSort(int[] arr) {
		int key;
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

}
