package com.bridgelabz.sort;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 7, 8, 3, 2, 1 };
		int start = 0, end = arr.length - 1;

		merge_sort(arr, start, end);
		printArr(arr);
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void merge_sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int mid = (start + end) / 2;

			merge_sort(arr, start, mid);
			merge_sort(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}

	}

	private static void merge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub

		int p = start, q = mid + 1;
		int[] newArr = new int[end - start + 1];
		int j = 0;
		for (int i = start; i <= end; i++) {
			if (p > mid)
				newArr[j++] = arr[q++];
			else if (q > end)
				newArr[j++] = arr[p++];
			else if (arr[p] < arr[q])
				newArr[j++] = arr[p++];
			else
				newArr[j++] = arr[q++];
		}
		for (int k = 0; k < j; k++) {
			arr[start++] = newArr[k];
		}

	}

}
