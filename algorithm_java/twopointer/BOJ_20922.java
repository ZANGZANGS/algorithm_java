package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 투포인터
* @description	: 겹치는 건 싫어
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.10	투포인터 풀이
*/
public class BOJ_20922 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] numbers = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int max = 0;
		
		while (left < N && right < N) {

			numbers[arr[right]]++;
			
			while (right<N-1 && numbers[arr[right+1]]<K) {
				right++;
				numbers[arr[right]]++;
			}
			
			max = Math.max(max, right-left+1);
			
			while(left<N-1 && right<N-1 && numbers[arr[right+1]]>=K) {
				numbers[arr[left]]--;
				left++;
			}
			
			right++;
			
			
		}
		
		System.out.println(max);
		
		
	}

}
