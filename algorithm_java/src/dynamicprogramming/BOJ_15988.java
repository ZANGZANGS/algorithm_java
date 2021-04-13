package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==1) {
				System.out.println(1);
			}else if(n==2) {
				System.out.println(2);
			}else if(n==3) {
				System.out.println(4);
			}else {
				long[] dp = new long[n+1];
				
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				for (int k = 4; k <= n; k++) {
					dp[k] = (dp[k-1] + dp[k-2] + dp[k-3]) % 1000000009;
				}
						
				System.out.println(dp[n]);
			}
			
		}
		
	}

}