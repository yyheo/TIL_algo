import java.util.Arrays;

/*
 * 순열
 * 반복문 : 성능은 좋지만, 원소 개수에 따라 동적으로 구조를 변경하기 어렵다.
 * 기본 Backtracking 단원 : 후보군을 구하는 재귀함수
 * 응용 완전탐색 단원 : swap 재귀함수, 코드가 간단
*/
public class swapPerm {
	public static int[] arr = {4, 5, 6};
	public static void main(String[] args) {
		perm(arr.length, 0);
	} // end of main
	// n : 전체 원소 개수, k : 현재 단계
	public static void perm(int n, int k) {
		if (k == n) { // 종료 파트
			System.out.println(Arrays.toString(arr));
		} else { // 재귀 파트
			for (int i = k; i < arr.length; i++) {
				// k번째 값과 i번째 값을 바꾸기 (swap)
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(n, k + 1);
				// 원상복귀
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
	}
} // end of class
