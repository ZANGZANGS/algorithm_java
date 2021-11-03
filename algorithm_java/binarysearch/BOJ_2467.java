package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
* @source		: baekjoon
* @algorithm	: 이분탐색 , 투포인터
* @description	: 용액
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.02	투포인터로 풀었넴..
* 2021.11.03	이분탐색
*/
public class BOJ_2467 {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		long result[] = new long[2];
		long sum = Long.MAX_VALUE;
		
		for (int i = 0; i<N ; i++) {
			long tar = arr[i]; 
		
			int start = i+1;
			int end = N-1;
			
			
			while (start<= end) {
				
				int mid = (start + end)/2;
				
				if(sum > Math.abs(arr[mid] + tar) ) {
					sum = Math.abs(arr[mid] + tar);
					result[0] = arr[i];
					result[1] = arr[mid];
				}
				
				
				if(arr[mid] + tar  == 0) {
					System.out.println(result[0] + " " + result[1]);
					return;
				}else if(arr[mid] + tar  > 0) {
					end = mid-1;
				}else if(arr[mid] + tar  < 0) {
					start = mid +1;
				}
				
			}
		}
		
		
		
		System.out.println(result[0] + " " + result[1]);
	}

}
