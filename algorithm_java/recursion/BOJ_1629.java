package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: recursion
 * @description	: 곱샘 a^b %c
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.24	TODO 다시 풀기
 */
public class BOJ_1629 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		
		System.out.println(pow(a,b,c));
	
		
	}
	
	
	public static long pow(long a, long b, long c) {
		if(b == 1) {
			return a%c;
		}
		
		long val = pow(a,b/2,c);
		val = val * val % c;
		
		if(b%2 == 0) {
			return val;
		}else {
			return val * a % c;
		}
		
	}
}

