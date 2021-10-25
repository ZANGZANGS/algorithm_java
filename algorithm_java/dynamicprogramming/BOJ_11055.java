package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: dp
 * @description	: 가장 큰 증가 부분 수열
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.25	백트레킹 풀이는 시간초과
 */
public class BOJ_11055 {
	
	static int N;
	static int[]  arr;
	static int[] result;
	static int max = 0;
	static boolean[] isUsed;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N];
		isUsed = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, new int[N]);
		
		System.out.println(max);
		
	}
	
	private static void func(int k, int[] array) {
		
		if(k == N) {
			
			int sum = 0;
			int prev = 0;
			
			for (int num : array) {
				if(num == 0) continue;

				if(prev > num) return;
					
				prev = num;
				sum+=num;
			}
			
			max = Math.max(max, sum);
			return;
		}
		
			func(k+1, array);
			
			array[k] = arr[k];
			func(k+1, array);
			array[k] = 0;
			
	}

}
