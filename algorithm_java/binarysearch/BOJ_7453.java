package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색
 * @description	: 합이 0인 네 정수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.21	성공
 * 				1. int의 범위가 (2^31)-1 인데 2^28이 더 크다고 착각하여 long으로 설정하여 시간초과 남
 * 				2. 총 개수가 4000 * 4000 * 4000 * 4000 을 초과하면 int 범위를 넘어가므로 count 변수를 long으로 해주지 않아 실패 뜸
 */
public class BOJ_7453 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long count = 0;
		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());

		}

		int[] subAB = new int[n * n];
		int[] subCD = new int[n * n];

		int idx = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				subAB[idx] = A[i] + B[j];
				subCD[idx] = C[i] + D[j];

				idx++;

			}

		}

		Arrays.sort(subCD);

		for (int number : subAB) {
			int target = number;

			int lp = lower_idx(-target, subCD);
			int up = upper_idx(-target, subCD);

			count += (up - lp);

		}

		System.out.println(count);
	}

	private static int lower_idx(int target, int[] arr) {

		int lp = 0;
		int rp = arr.length;

		while (lp < rp) {

			int mid = (lp + rp) / 2;

			if (arr[mid] < target) {
				lp = mid + 1;
			} else {
				rp = mid;
			}

		}

		return lp;
	}

	private static int upper_idx(int target, int[] arr) {

		int lp = 0;
		int rp = arr.length;

		while (lp < rp) {

			int mid = (lp + rp) / 2;

			if (arr[mid] <= target) {
				lp = mid + 1;
			} else {
				rp = mid;
			}

		}

		return lp;
	}

}