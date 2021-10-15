package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @source		: baekjoon
* @algorithm	: backtracking
* @description	: N& M (11)
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.10.15	성공
*/
public class BOJ_15665 {

	static int N,M;
	static int[] numbers;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		func(0);
		
		System.out.println(sb.toString());
		
	}
	
	private static void func(int k) {
		if(k == M) {
			for (int i = 0; i < k; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int previous = -1;
		
		for (int i = 0; i < N; i++) {

			if(previous != numbers[i] ) {
				
				previous = numbers[i];
				arr[k] = numbers[i];
				func(k+1);
			}
			
		}
	}

}
