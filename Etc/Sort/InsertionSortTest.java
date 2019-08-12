package com.ssafy.step3.sort;

import java.util.Arrays;

public class InsertionSortTest {
	
	public static void insertionSort(int list[]) {
		final int SIZE = list.length;
		for (int i = 1; i < SIZE; i++) { // U집합
			int temp = list[i];
			for (int j = 0; j < i; j++) { // S집합
				if (temp < list[j]) { // 삽입 위치
					for (int k = i - 1; k >= j; k--) {
						// S집합 끝부터 하나씩 삽입위치원소까지 뒤로 이동
						list[k + 1] = list[k];
					}
					list[j] = temp;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] list = { 69, 10, 30, 2, 16, 8, 31, 22, 30, 10 };
		//int[] list = { 1, 2, 3, 4, 5 };
		//int[] list = { 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(list));
		insertionSort(list);
		System.out.println(Arrays.toString(list));
	}
}
