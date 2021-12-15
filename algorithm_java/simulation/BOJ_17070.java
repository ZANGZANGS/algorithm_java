package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 구현
* @description	: 파이프 옮기기1
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.15	시간초과
* 2021.12.15	DP 풀이로 성공
*/
public class BOJ_17070 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[3][N][N]; //0가로 1세로 2대각
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		
		

		dp[0][0][1] = 1; //0가로 1세로 2대각
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) continue;
				
				//재방문 X
				if(dp[0][i][j] >0) continue;
				if(dp[1][i][j] >0) continue;
				if(dp[2][i][j] >0) continue;
				
				
				if(i-1>=0 && j-1>=0 //배열 인덱스 범위 체크 
						&& map[i-1][j] != 1 && map[i][j-1] != 1) {//벽 확인
					//대각 도착
					dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
				}
				
				if(j-1>= 0) {
					//가로 도착
					dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
				}
				
				if(i-1>=0) {
					//세로 도착
					dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
				}
				
				
				
			}
		}
		

		
		System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
		
	}
	


}
