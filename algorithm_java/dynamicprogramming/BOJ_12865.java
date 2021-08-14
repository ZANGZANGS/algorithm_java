package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());// 물품 수
		int k = Integer.parseInt(st.nextToken());// 버틸 수 있는 무게
		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); //무게
			v[i] = Integer.parseInt(st.nextToken()); //가치
			
		}
		
		int[][] dp = new int[n+1][k+1];
		// x축 : 배낭무게  ..k
		// y축 : 물건       ..n
		
		for (int i = 1; i <= n; i++) { // 물건
			for (int j = 1; j <= k; j++) { // 무게
				
				if(j < w[i]) {
					dp[i][j] = dp[i-1][j];
				}else {
					//i 번쨰 물건, j배낭 무게
					
					int before = dp[i-1][j];	//이전 물건을 담았을 때 배낭의 가치
					int now = dp[i-1][j-w[i]]+v[i]; //지금 물건을 담을때 배낭의 가치 -- > 내 물건 만큼의 무게를 뺏을 때의 이전 무게 + 지금 가치 
					dp[i][j] = Math.max(before, now) ;
				}
			}
		}
		
		System.out.println(dp[n][k]);
		
	}

}
