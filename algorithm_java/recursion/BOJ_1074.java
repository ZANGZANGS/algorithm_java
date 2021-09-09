package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: beakjoon
 * @algorithm	: recursion
 * @description	: Z
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.09
 */
public class BOJ_1074 {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int r = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken()); 
		
		System.out.println(func(N,r,c));
	}
	
	private static int func(int n, int r, int c) {
	
		if(n ==0) {
			return 0;
		}
		int half = 1 << (n-1);
		
		if( c < half && r < half) {
			return func(n-1, r, c); //1번 사각형
		}else if( c >= half && r < half) {
			return half*half + func(n-1, r, c-half); //2번 사각형
		}else if( c < half && r >= half) {
			return 2*half*half + func(n-1, r-half, c); //3번 사각형
		}else {
			return 3*half*half + func(n-1, r-half, c-half); //4번 사각형
		}
	}
}




