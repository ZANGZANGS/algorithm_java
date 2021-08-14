package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
		
			int n = Integer.parseInt(br.readLine());
			
			long[] dp = new long[n+1];
			
			
			if(n == 1 || n == 2 || n == 3) {
				System.out.println(1);
			}else {
				dp[1] = 1;
				dp[2] = 1;
				dp[3] = 1;
				
				for (int k = 4; k <= n; k++) {
					dp[k] = dp[k-2] + dp[k-3];
				}
				
				System.out.println(dp[n]);
			}
			
			
		}
		
	}

}
