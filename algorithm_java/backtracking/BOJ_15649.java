package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: N과 M (1)
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.07	다시 풀자..
 * 2021.10.07	성공! 재귀 연습한 효과가 있었따~
 */
public class BOJ_15649 {
	
	static int N,M;
	static int[] arr;
	static boolean[] isused;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //숫자 까지~
		M = Integer.parseInt(st.nextToken());
		arr = new int[M]; // 배열 담을 갯수
		isused = new boolean[10]; // 숫자 사용 여부
		
		func(0);
		
		System.out.println(sb.toString());

		
	}
	
	private static void func(int k) {
		if(k == M) {
			for(int i=0; i < M ; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			
			if(isused[i]) continue;
			
			isused[i] = true;
			arr[k] = i;
			func(k+1);
			isused[i] = false;
			
		}
	}
	
}