package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색
 * @description	: 숫자카드
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.26	성공
 */
public class BOJ_10815 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] hasNumbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hasNumbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(hasNumbers);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(bs(num, hasNumbers));
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int bs(int tar, int[] arr) {
		
		int st = 0;
		int ed = arr.length-1;
		while (st<=ed) {
			int mid = (st+ed)/2;
			
			
			if(tar == arr[mid]) {
				return 1;
			}
			
			if(tar > arr[mid]) {
				st = mid+1;
			}
			
			if(tar < arr[mid]) {
				ed = mid-1;
			}
		}
		
		return 0;
	}

}
