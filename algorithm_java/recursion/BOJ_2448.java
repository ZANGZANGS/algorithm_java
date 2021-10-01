package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source		: baekjoon
 * @algorithm	: recursion
 * @description	: 별찍기 11
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.01	성공!
 */
public class BOJ_2448 {
	
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][2*N];
		
		//init arrays
		for (char[] ar : arr) {
			Arrays.fill(ar, ' ');
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int j = N - i-1; j < N + i; j++) {
				arr[i][j] = '*';
				
			}
		}
		
		recursion(N-1, N-1, N/2);
		
		//for print
		for (char[] ar : arr) {
			for (char at : ar) {
				sb.append(at);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	private static void recursion(int x, int y, int k) {
		
		if(k == 1) {
			arr[y-1][x] = ' ';
			return;
		}

		
		for (int i = 0; i < k; i++) {
			for (int j = x - i ; j < x+i+1; j++) {
				
				arr[y-i][j] = ' ';
				
			}
			
		}
		
		recursion(x - k, y,k/2);
		recursion(x + k, y,k/2);
		recursion(x, y-k ,k/2);
		
	}

}
