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
* 2021.10.13	TODO 실패
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
		if(k == M) {
			for (int i = 0; i < M; i++) {

				sb.append(arr[i]);
				sb.append(" ");
			}
			
			sb.append("\n");
			
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			
			if(!isUsed[i]) {
				
				if( i>0 && input[i-1] == input[i]) {
					arr[k] = input[i];
					func(k+1);
					continue;
				}

				isUsed[i] = true;
				arr[k] = input[i];
				func(k+1);
				isUsed[i] = false;
			}
			
			
			
		}
	}

}
