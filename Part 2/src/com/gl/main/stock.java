package com.gl.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import com.gl.search.LinearSearch;
import com.gl.sort.MergeSortAsc;
import com.gl.sort.MergeSortDesc;

public class stock {

	public static void main(String[] args) {
		int riseCounter = 0;
		int fallCounter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of companies");
		int size = sc.nextInt();
		double[] arr = new double[size];
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the stock price of the current company-" + (i + 1));
			BigDecimal bd = new BigDecimal(sc.nextDouble()).setScale(2, RoundingMode.HALF_UP);
			arr[i] = bd.doubleValue();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			if (sc.nextBoolean()) {
				riseCounter++;
			} else {
				fallCounter++;
			}
		}

		boolean doExit = true;
		while (doExit) {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				double[] asc = MergeSortAsc.sort(arr, 0, arr.length - 1);
				System.out.println("Stock prices in ascending order are :");
				for (int i = 0; i < asc.length; i++) {
					System.out.print(asc[i] + " ");
				}
				System.out.print("\n");
				break;
			case 2:
				double[] dsc = MergeSortDesc.sort(arr, 0, arr.length - 1);
				System.out.println("Stock prices in descending order are :");
				for (int i = 0; i < dsc.length; i++) {
					System.out.print(dsc[i] + " ");
				}
				System.out.print("\n");
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today :" + riseCounter);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today :" + fallCounter);
				break;
			case 5:
				System.out.println("Enter the key value");
				double key = sc.nextDouble();
				boolean isFound = LinearSearch.searchElement(arr, key);
				if (isFound)
					System.out.println("Stock of value " + key + " is present");
				else
					System.out.println("Stock of value " + key + " is not present");
				break;
			case 6:
				doExit = false;
				System.out.println("Exited successfully!!");
				break;
			default:
				System.out.println("Invalid Option. Please select correct option");
				break;
			}
		}

	}

}
