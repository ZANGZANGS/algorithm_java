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
 * 2021.08.24	다시 풀기
 * 2021.09.24	성공!
 */
public class BOJ_1629 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		System.out.println(func(a,b,c));
	}
	
	private static long func(long a, long b, long c) {
		if(b==1) {
			return a%c;
		}

		long val = func(a,b/2,c);
		
		if(b%2 == 0) {
			return val * val % c;
			
		}else {
			return (val * val % c) * a % c;
		}
		
		
	}
	
	
}

