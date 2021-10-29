package binarysearch;

import java.io.*;
import java.util.*;


/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색
 * @description	: 나무 자르기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.29	나무의 높이 10억, 가져갈 나무의 최대 길이 20억으로 합산 시 int를 사용하면 오버플로우 발생한다.
 * 				int -> long 주의!
 */
public class BOJ_2805 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	//나무길이
		long result = 0;
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		long start = 0;
		long end = trees[N-1];
		
		while (start <= end) {
			
			long length = 0;
			long mid =  (start + end) / 2;
			
			for (int i : trees) {
				if( i > mid) {
					length += i-mid;
				}
			}
			
			if(length >= M) {	//필요이상으로 많이 잘랐다. 높이를 올린다.
				result = mid;
				start = mid+1;
				
			}else {
				end = mid-1;
				
			}
			
		}
		
		System.out.println(result);
	}

}
