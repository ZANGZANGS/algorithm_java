package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[41][2];
			arr[0][0] = 1;
			arr[0][1] = 0;
			
			arr[1][0] = 0;
			arr[1][1] = 1;
			
			for (int j = 2; j <= n; j++) {
				arr[j][0] = arr[j-1][0] + arr[j-2][0];
				arr[j][1] = arr[j-1][1] + arr[j-2][1];
			}
			
			System.out.println(arr[n][0]+" "+arr[n][1]);
			
			
			
		}
	}

}
