package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[][] d = new int[n+1][3]; //거리 정보를 담을 배열
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//d[i][j] >> 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때 점수 합의 최댓값, 단 i번째 계단은 반드시 밟아야한다.
		
		if(n == 1) {
			System.out.println(arr[1]);
			
		}else {//계단이 2개 이상인 경우
			d[1][1] = arr[1];
			d[1][2] = 0;
			
			d[2][1] = arr[2];
			d[2][2] = arr[1]+arr[2];
			
			
			for (int i = 3; i <= n; i++) {
				
				for (int j = 1; j <= 2; j++) {
					//1개의 계단을 연속으로 밟은 경우
					if(j == 1) {
						d[i][j] = Math.max(d[i-2][1], d[i-2][2]) + arr[i];
					}
					//2개의 계단을 연속으로 밟은 경우
					if(j == 2) {
						d[i][j] = d[i-1][1] + arr[i];
					}
					
				}
				
			}
			
			System.out.println(Math.max(d[n][1], d[n][2]));
		}
		
		
		
	}

}
