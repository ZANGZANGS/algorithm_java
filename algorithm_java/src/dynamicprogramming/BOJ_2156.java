package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if(n == 1) {
			System.out.println(arr[0]);
		}else if(n == 2) {
			System.out.println(arr[0]+arr[1]);
		}else {
			dp[0] = arr[0];
			dp[1] = arr[1] + arr[0];
			dp[2] = Math.max(Math.max(arr[0]+ arr[2], arr[1]+arr[2]), dp[1]);
			
			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(arr[i-1]+dp[i-3], dp[i-2]) + arr[i];
				
				//포도주를 연속해서 안마셔도 된다.
				//이전 값이 더 클수도 있으므로 확인,,
				dp[i] = Math.max(dp[i], dp[i-1]);
			}
			
			System.out.println(dp[n-1]);
		}

		
	}

}
