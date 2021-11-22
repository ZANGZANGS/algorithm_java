package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		int count = 0;
		
		boolean[] isUsed = new boolean[100001];
		
		
		
		for (int i = 0; i < N; i++) {
			
			if(i>0)	isUsed[i-1] = false;
			
			for (int j = i; j < seq.length; j++) {

				int tar = seq[j];
				
				if(isUsed[tar]) break;
				isUsed[tar] = true;
				count++;
				
				
			}
		}
		
		System.out.println(count);
		
	}

}
