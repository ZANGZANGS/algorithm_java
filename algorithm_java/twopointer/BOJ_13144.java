package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 투포인터
 * @description	: List of Unique Numbers
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.22	실패
 * 				1.메모리 초과
 * 				2.시간 초과
 * 				
 * 2021.11.22	성공
 * 				1. 투 포인터
 * 				2. total 의 최대값은 100억으로 long 변수 여야 한다.
 */
public class BOJ_13144 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		long total = 0;
		
		int[] count = new int[100001];
		
		
		int lp=0;
		int rp=-1;
//		int rp=0;
//		count[rp]++;
		
		while(lp< N) {
			
			//right 오른 쪽으로 한칸 이동
			//같은 숫자 나올 때 까지
			while (rp+1 < N && count[seq[rp+1]] == 0) {
				rp++;
				count[seq[rp]]++;
				
			}
			
			total += (rp-lp+1);
			

			// left 오른 쪽으로 한칸 이동
			count[seq[lp]]--;
			lp++;
		}
		
		
		
		System.out.println(total);
		
	}

}
