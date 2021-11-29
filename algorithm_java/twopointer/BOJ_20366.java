package twopointer;

import java.io.*;
import java.util.*;

/**
 * @source		: baekjoon
 * @algorithm	: 투포인터
 * @description	: 같이 눈사람 만들래?
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.29	성공
 */
public class BOJ_20366 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int minDiff = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		int snow[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snow);
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int tarSnowMan = Math.abs(snow[j]-snow[i]);  
				
				// 투 포인터를 사용하여 tarSnowMan과 유사한 스노우맨 찾기
				
				int lp = 0;
				int rp = 0;
				
				while (lp<N && rp<N) {
					
					if(rp == i || rp == j) {
						 rp++;
						 continue;
					}
					if(lp == i || lp == j) {
						lp++;
						continue;
					}
					
					if(lp >= rp) {
						rp++;
						continue;
					}
					
					
					int tempSnowMan = snow[rp]-snow[lp];
					
					if(tarSnowMan>tempSnowMan) {
						rp++;
					}else if(tarSnowMan<tempSnowMan) {
						lp++;
					}else {//same
						System.out.print("0");
						return;
					}
					
					minDiff = Math.min(minDiff, Math.abs(tarSnowMan-tempSnowMan));
					
				}
				
				
			}
		}
		
		
		System.out.println(minDiff);
	}
	

}
