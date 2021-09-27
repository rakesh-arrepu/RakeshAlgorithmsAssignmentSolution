package com.gl.search;

public class LinearSearch {

	public static boolean searchElement(double[] arr, double key) {
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i])
				return true;
		}
		return false;
	}
}
