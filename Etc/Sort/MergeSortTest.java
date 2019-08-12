package com.ssafy.step3.sort;

import java.util.Arrays;

public class MergeSortTest {
	public static void mergeSort(int[] list, int start, int end) {
		// 현집합을 반으로 나누어 정렬
		if (start == end) return;
		
		int half = (start + end) / 2;
		// 왼쪽집합 정렬해오기
		mergeSort(list, start, half);
		// 오른쪽집합 정렬해오기
		mergeSort(list, half+1, end);
		// 정렬된 두 집합 이용하여 합치기
		merge(list, start, half, end);
	}

	private static void merge(int[] list, int start, int half, int end) {
		int newArr[] = new int[end - start + 1];
		int left = start, right = half + 1;
		int i = 0;
		
		do {
			if (list[left] < list[right]) {
				newArr[i++] = list[left++];
			} else {
				newArr[i++] = list[right++];
			}
		} while (left <= half && right <= end);
		
		// 왼쪽 집합이 남은 경우 (오른쪽 집합은 다 처리됨)
		while (left <= half) newArr[i++] = list[left++];
		// 오른쪽 집합이 남은 경우 (왼쪽 집합은 다 처리됨)
		while (right <= half) newArr[i++] = list[right++];
		
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}
	
	public static void main(String[] args) {
		int[] list = { 69, 10, 30, 2, 16, 8, 31, 22 };
		System.out.println(Arrays.toString(list));
		mergeSort(list, 0, list.length - 1);
		System.out.println(Arrays.toString(list));
	}
}
