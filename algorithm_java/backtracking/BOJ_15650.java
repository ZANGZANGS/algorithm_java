package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: N & M (2)
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.11	성공
 */
public class BOJ_15650 {

	static StringBuilder sb;
	static int N,M;
	static boolean[] isUsed;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isUsed = new boolean[N+1];
		arr = new int[M];
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
		
		for (int i = 1; i <= N; i++) {
			
			if(!isUsed[i]) {
				if(k > 0 && arr[k-1] > i) {
					continue;
				}
				isUsed[i] = true;
				arr[k] = i;
				func(k+1);
				isUsed[i] = false;
			}
		}
		
	}

}
