package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: hashmap, binarysearch
 * @description	: 숫자 카드 2
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.28	hashmap
 * 2021.08.29	binarysearch
 */
public class BOJ_10816 {

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
		
		Arrays.sort(arrN);
		
		int M = Integer.parseInt(br.readLine());
		
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tar = Integer.parseInt(stringTokenizer.nextToken());
			
			int stIdx = lower_idx(arrN, tar);
			int enIdx = upper_idx(arrN, tar);
			
			sb.append(enIdx-stIdx + " ");
		}
		
		
		System.out.println(sb.toString().trim());
		
	}

	private static int lower_idx(int[] arr, int target) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			if(arr[mid] >= target) {
				en = mid;
			}else {
				st = mid+1;
			}
		}
		return st;
	}
	
	private static int upper_idx(int[] arr, int target) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			if(arr[mid] > target) {
				en = mid;
			}else {
				st = mid +1;
			}
		}
		return st;
	}
}
