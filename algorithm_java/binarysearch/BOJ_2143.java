package binarysearch;

import java.io.*;
import java.util.*;

/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색
 * @description	: 두 배열의 합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.17	성공
 * 				체크할 항목들
 * 				1.lower_idx, upper_idx
 * 				2.total 개수의 자료형이 long이다.
 * 				부분합의 개수가 1000!개가 발생한다. (500500개)
 * 				모든 부분합 배열이 hit라면 500500*500500개로 int 자료형의 범위 21억개를 초과한다.
 */
public class BOJ_2143 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arrA, arrB;
		int[] subArrA, subArrB;
		StringTokenizer stA,stB;
		long total = 0; // 10억 * 10억 개의 경우가 발생한다.
		
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		stA = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		stB = new StringTokenizer(br.readLine());
		
		arrA = new int[N];
		arrB = new int[M];
		
		
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(stA.nextToken());
		}
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
		
		// 배열 A,B로 만들 수 있는 누접합 배열을 구한다.
		
		//배열 A로 만들 수 있는 누적합 배열 구하기
		int size = 0;
		int idx = 0;
		
		for (int i = 1; i <= N; i++) {
			size += i;
		}
		subArrA = new int[size];
		for (int i = 0; i < N; i++) {
			int sum=0;
			int at = i;
			while (at < N) {
				sum += arrA[at++];
				subArrA[idx++] = sum;
			}
		}
		
		//배열 B로 만들 수 있는 누적합 배열 구하기
		size = 0;
		idx = 0;
		for (int i = 1; i <= M; i++) {
			size += i;
		}
		subArrB = new int[size];
		for (int i = 0; i < M; i++) {
			int sum=0;
			int at = i;
			while (at < M) {
				sum += arrB[at++];
				subArrB[idx++] = sum;
			}
		}
		
		//Arrays.sort(subArrA);
		Arrays.sort(subArrB);
		

		//이분탐색
		for (int num : subArrA) {
			int tar = T - num; // 타겟 숫자
			
			//타겟 숫자의 왼쪽을 찾는다.
			
			int left= lower_idx(tar ,subArrB);
			//타겟 숫자의 오른쪽을 찾는다.
			int right = upper_idx(tar ,subArrB);
			
			//인덱스에 타겟 수가 있는지 확인하고 total에 더한다.
			total +=(right - left);
			
		}
		
		System.out.println(total);

		
	}
	
	private static int lower_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] >= target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
		
	}
	
	private static int upper_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] > target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
	
	}
	
}