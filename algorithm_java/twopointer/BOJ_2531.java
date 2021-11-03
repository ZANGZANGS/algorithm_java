package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2531 {
/**
* @source		: baekjoon
* @algorithm	: 투포인터
* @description	: 회전초밥
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.08	실패
*/
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰번호
		
		int[] arr = new int[N];
		int[] susi = new int[d+1];
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int pointer = 0;
		
		for (int i = 0; i < N; i++) {
		
			susi = new int[d+1];
			
			for (int j = i; j <= i+k; j++) {
				
				int idx = j%N;
				susi[arr[idx]] = 1;
			}
			
			int count = Arrays.stream(susi).sum();
			
			if(susi[c]==0) {
				count++;
			}
			
			max = Math.max(max, count);
			
		}
		System.out.println(max);
		
	}

}
