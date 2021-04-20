package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] jobT = new int[n+10];
		int[] jobP = new int[n+10];
		int[] dp = new int[n+10]; // n������ ��� �ִ� ����
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			jobT[i] = Integer.parseInt(st.nextToken()); 
			jobP[i] = Integer.parseInt(st.nextToken()); 
		}

		int result = 0;

		for (int i = 1; i <= n+1; i++) {
			
			//i������ �ִ� ���� 
			dp[i] = Math.max(dp[i], result);
			
			//jobT[i]+i ���ñ����� �� �ٹ��ϼ�
            dp[jobT[i]+i] = Math.max(dp[jobT[i]+i], jobP[i]+dp[i]);
            
            result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
		
	}

}