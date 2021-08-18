package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: DP
 * @description	: RGB거리
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.18	
 */
public class BOJ_1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		//init
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		
		//dp
		for (int i = 2; i <= N; i++) {
			dp [i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp [i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp [i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		//find minimum value
		int result = Integer.MAX_VALUE;
		for (int amt : new int[]{dp[N][0], dp[N][1], dp[N][2]}) {
			result = Math.min(amt, result);
		}
		
		System.out.println(result);
	}
}
