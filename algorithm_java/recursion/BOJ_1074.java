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
 * 2021.09.09	다시풀기
 * 2021.09.28	성공
 */
public class BOJ_1074 {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int r = Integer.parseInt(st.nextToken());  //y
		int c = Integer.parseInt(st.nextToken());  //x
		
		int result = func(N, r, c);
		
		System.out.println(result);
		
	}
	
	private static int func(int N, int r, int c) {
		
		if(N == 0) {
			return 0;
		}
		
		int half = 1 << (N-1);
		
		if(r < half && c < half) {
			return func(N-1, r, c);
		}else if(r < half && c >= half) {
			return half*half + func(N-1, r, c-half);
		}else if(r >= half && c < half) {
			return 2*half*half + func(N-1, r-half, c);
		}else {
			return 3*half*half + func(N-1, r-half, c-half);
		}
		
	}
}