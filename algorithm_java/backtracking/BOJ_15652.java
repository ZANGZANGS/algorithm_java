package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: N &M (4)
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.12	성공
 */
public class BOJ_15652 {
	static int N,M;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
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
		
		for (int i = 1; i <= N; i++) {
			
			if(k > 0 && arr[k-1] > i) {
				continue;
			}
			
			arr[k] = i;
			func(k+1);
		}
	}

}
