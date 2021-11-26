package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @source		: baekjoon
 * @algorithm	: 투포인터
 * @description	: 구간 자르기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.25	실패
 * 				70% fail
 * 2021.11.26	성공
 * 				rp +1이 증가되는데 while 문의 범위를 잘못 잡음
 * 				
 */
public class BOJ_2283 {

	public static void main(String[] args) throws IOException{
		final int maxLen = 1000000;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//학급
		int K = Integer.parseInt(st.nextToken());//학급별 학생 수
		
		int[][] arr = new int[N][2];
		
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		
		long len = 0;
		int lp = 0;
		int rp = 0;
		while (lp < maxLen && rp-1 < maxLen) {
			
			if(len == K) {
				System.out.println(lp + " " + rp);
				return;
			}
			if(len < K) {
				rp++;
				for (int[] i : arr) {
					if(i[0] < rp && rp <= i[1]) len++;
				}
//				System.out.println("rp: "+ rp + "\tlen: "+len);
				continue;
			}
			if(len > K){
				for (int[] i : arr) {
					if(i[0] <= lp && lp < i[1]) len--;
				}
//				System.out.println("lp: "+ lp + "\tlen: "+len);
				lp++;
				continue;
			}
			
		}
		
		System.out.println("0 0");
	}
	
//	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
//	@	@	@	@	@	@	@	@	@
//	@	@	@	@	@	@	@	@	@	@	@
//				@	@	@	@	@	@	@	@	@	@	@	@	@
//				@	@	@	@	@	@	@	@
//	LR																#0
//	L	R															#2
//	L								R								#26
//		L							R								#24
//		L								R							#27
//			L							R							#25
	

}
