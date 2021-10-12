package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: N &M (5)
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.12	성공
 */
public class BOJ_15654 {

	static int N,M;
	static StringBuilder sb;
	static int[] input;
	static int[] arr;
	static boolean[] isUsed;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		input = new int[N];
		isUsed  = new boolean[N];
		arr = new int[M];
	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
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
		
		for (int i = 0; i < N; i++) {
			
			if(!isUsed[i]) {
				isUsed[i] = true;
				arr[k] = input[i];
				func(k+1);
				isUsed[i] = false;
			}
			
		}
	}

}
