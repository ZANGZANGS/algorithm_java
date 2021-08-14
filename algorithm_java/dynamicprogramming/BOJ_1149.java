package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][3];
		
		//arr[i][j]
		// i번째 집에 j(R,G,B) 비용
		
		StringTokenizer st ;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());	//R 빨강
			arr[i][1] = Integer.parseInt(st.nextToken());	//G 초록
			arr[i][2] = Integer.parseInt(st.nextToken());	//B 파랑
		}
		
		int[][] d = new int[n+1][3]; //거리 정보를 담을 배열
		
		/*
		 * i번째 집까지 칠할 떄 비용의 최솟값, j는 색상
		 d[i][0] R
		 d[i][1] G
		 d[i][2] B
		 */
		
		d[1][0] = arr[1][0];
		d[1][1] = arr[1][1];
		d[1][2] = arr[1][2];
		
		for (int i = 2; i < d.length; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2])+arr[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2])+arr[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1])+arr[i][2];
		}
		
		System.out.println(Math.min(d[n][0], Math.min(d[n][1], d[n][2])));
	}

}
