package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 투포인터
* @description	: 수들의 합2
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.04	투포인터 풀이
*/
public class BOJ_2003 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int left = 0;
		int right = 0;
		
		while (left < N && right < N) {
			
			if(left > right) {//i==j 가능?
				right++;
				continue;
			}
			
			int sum = 0;
			for (int i = left; i <=right; i++) {
				sum += arr[i];
			}
			
			if(sum < M) {
				right++;
			}else if( sum > M) {
				left++;
			}else { // sum == M
				total++;
				right++;
				left++;
			}
			
		}
		
		System.out.println(total);
		
	}
	//1 1 1 2 2 2 3 3 4 5
}
