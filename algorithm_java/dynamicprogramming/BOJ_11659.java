package dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * d[i]
		 * i번째 수까지의 누적 합
		 */
		int[] d = new int[n+1];
		
		//d[1] = arr[1];
		
		for (int i = 1; i <= n; i++) {
			d[i] = d[i-1]+ arr[i];
		}
		
		// m번
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(d[e]-d[s-1]+"\n");
			
			
		}
		
		System.out.println(sb.toString());
		
	}

}
