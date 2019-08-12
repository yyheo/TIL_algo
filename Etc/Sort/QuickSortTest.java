
package com.ssafy.step1.divide;

import java.util.Arrays;

public class QuickSortTest {
	
	static int[] arr = { 69, 10, 30, 30, 2, 16, 8, 31, 22 };
	
	public static void main(String[] args) {
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] arr, int start, int end) {
		if (start < end) {						// 집합의 크기가 2이상일 경우만 정렬 시도
			int pivot = fixPivot(arr, start, end);
			quickSort(arr, 0, pivot - 1); // 왼쪽
			quickSort(arr, pivot + 1, end); // 오른쪽
		}
	}

	private static int fixPivot(int[] arr2, int start, int end) {
		int pivot = start;
		int left = start + 1;
		int right = end;
		do {
			while (left < end && arr[left] < arr[pivot]) left += 1;
			while (right > start && arr[right] >= arr[pivot]) right -= 1;
			
			if (left < right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		} while (left < right);
		
		int tmp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = tmp;
		return right;
	}
	
}
