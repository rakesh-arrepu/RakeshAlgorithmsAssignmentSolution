package com.gl.sort;

public class MergeSortAsc {
	public static void merge(double arr[], int beg, int mid, int end) {

		int l = mid - beg + 1;
		int r = end - mid;

		double LeftArray[] = new double[l];
		double RightArray[] = new double[r];

		for (int i = 0; i < l; ++i)
			LeftArray[i] = arr[beg + i];

		for (int j = 0; j < r; ++j)
			RightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;
		int k = beg;
		while (i < l && j < r) {
			if (LeftArray[i] < RightArray[j]) {
				arr[k] = LeftArray[i];
				i++;
			} else {
				arr[k] = RightArray[j];
				j++;
			}
			k++;
		}
		while (i < l) {
			arr[k] = LeftArray[i];
			i++;
			k++;
		}

		while (j < r) {
			arr[k] = RightArray[j];
			j++;
			k++;
		}
	}

	public static double[] sort(double arr[], int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			sort(arr, beg, mid);
			sort(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
		return arr;
	}
}
