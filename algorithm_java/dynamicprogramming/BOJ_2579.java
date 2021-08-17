package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @source		: 백준
 * @algorithm	: DP
 * @description	: 계단 오르기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.09	n == 1 일때 설정
 */
public class BOJ_2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][3]; //거리 정보를 담을 배열
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//dp[i][j] >> 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때 점수 합의 최댓값, 단 i번째 계단은 반드시 밟아야한다.
		
		if(n == 1) {
			System.out.println(arr[1]);
			return;
		}
		
		dp[1][1] = arr[1];
		dp[2][1] = arr[2];
		dp[2][2] = arr[1]+arr[2]; //2번째 계단까지 2개를 밟았을 때
		
		for (int i = 2; i <= n; i++) {
			dp[i][2] = dp[i-1][1] +arr[i]; //d
			dp[i][1] = Math.max(dp[i-2][2], dp[i-2][1]) +arr[i];
		}
		
		System.out.println(Math.max(dp[n][1], dp[n][2]));
		
	}

}
