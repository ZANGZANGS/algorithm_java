package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 연산자 끼워넣기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.04	성공
 */
public class BOJ_14888 {
	
	static int N;
	static boolean isUsed[];
	static char[] arr, result;
	static int[] seq;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] operator = new int[4]; //+ - x /
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		arr = new char[N-1];
		result = new char[N-1];
		isUsed = new boolean[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		for (int i = 0; i < 4; i++) {

			char ch = '?';
			if(i == 0) ch = '+';
			else if(i == 1) ch = '-';
			else if(i == 2) ch = '*';
			else ch = '/';
			
			for (int j = 0; j < operator[i]; j++) {
				arr[idx++] = ch;
			}
		}
		
		bt(0);
		System.out.println(max + "\n" + min);
	}
	
	private static void bt(int k) {
		if(k == N-1) {
			//계산하기
			int total = 0;
			
			for (int i = 0; i < N; i++) {
				
				if(i == 0) total = seq[i];
				else {
					char opr = result[i-1];
					
					if(opr == '+') total += seq[i];
					else if(opr == '-') total -= seq[i];
					else if(opr == '*')total *= seq[i];
					else total /= seq[i];
				}
				
			}
			
			max = Math.max(max, total);
			min = Math.min(min, total);

		}
		
		for (int i = 0; i < N-1; i++) {
			
			if(isUsed[i]) continue;
			
			isUsed[i] = true;
			result[k] = arr[i];
			bt(k+1);
			isUsed[i] = false;
		}
	}

}
