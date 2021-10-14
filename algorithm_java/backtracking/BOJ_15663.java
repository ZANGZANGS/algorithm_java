package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
* @source		: baekjoon
* @algorithm	: backtracking
* @description	: N& M (9)
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.10.13	실패
* 2021.10.14	TODO 풀이보고 이해함 다시 풀어보자ㅏ
*/
public class BOJ_15663 {

	static int N,M;
	static int[] input;
	static boolean[] isUsed;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		isUsed = new boolean[N];
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
		
		int previous = -1;
		if(k == M) {
			for (int i = 0; i < k; i++) {

				sb.append(arr[i]);
				sb.append(" ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		
		
		for (int i = 0; i < N; i++) {
			
			if(!isUsed[i] && previous != input[i]) {
				
				isUsed[i] = true;
				arr[k] = input[i];
				previous = input[i];
				func(k+1);
				isUsed[i] = false;
			}
			
		}
	}
}
