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
		
		int start = 0;
		int end = N-1;
		long sum = Long.MAX_VALUE;
		
		long result[] = new long[2];
		
		while (start< end) {
			
			if(Math.abs(sum) >= Math.abs(arr[start] + arr[end])) {
				sum = arr[start] + arr[end];
				result[0] = arr[start];
				result[1] = arr[end];
			}
			
			if(arr[start] + arr[end] == 0) {
				break;
			}else if(arr[start] + arr[end] > 0) {
				end -=1;
			}else if(arr[start] + arr[end] < 0) {
				start += 1;
			}
			
		}
		
		System.out.println(result[0] + " " + result[1]);
	}

}
