package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) System.out.println(1);
		else {
			int[] dp = new int[n];
			
			dp[0] = 1;
			dp[1] = 3;
			
			for (int i = 2; i < n; i++) {
				dp[i] = dp[i-1] + dp[i-2]*2; 
				dp[i] %= 10007;
			}
			
			System.out.println(dp[n-1]);
		}
		
		
	}

}
