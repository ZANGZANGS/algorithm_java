package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: binary search
 * @description	: 수 찾기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.28
 */
public class BOJ_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stringTokenizer;
		
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] arrM = new int[M];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		Arrays.sort(arrN);
		
		for (int i = 0; i < M; i++) {
		
			
			int target = arrM[i];
			
			int st = 0;
			int en = N-1;
			
			while (true) {
				
				if(st>en) {
					sb.append("0\n");
					break;
				}
				
				int mid = (en+st)/2;
				
				
				if(arrN[mid] > target) {
					en = mid-1;
				}
				
				if(arrN[mid] == target) {
					sb.append("1\n");
					break;
				}
				
				if(arrN[mid] < target) {
					st = mid+1;
				}
			}
			
		}
		
		System.out.println(sb.toString().trim());
		
	}

}