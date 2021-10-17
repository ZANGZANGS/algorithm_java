package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: lotto
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.18	성공
 */
public class BOJ_6603 {

	static StringBuilder sb;
	static int[] numbers; 
	static boolean[] isUsed;
	static int[] result;
	
	static int k;
	
	public static void main(String[] args) throws IOException{
		
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			numbers = new int[k];
			isUsed = new boolean[k];
			result = new int[6];
			
			for (int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			func(0);
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void func(int n) {
		if(n == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < k; i++) {
			
			if(!isUsed[i]) {
				if(n> 0 && result[n-1] > numbers[i]) continue;
				isUsed[i] = true;
				result[n] = numbers[i];
				func(n+1);
				isUsed[i] = false;
			}
			
		}
		
	}

}
