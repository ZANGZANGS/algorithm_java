package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source		: baekjoon
 * @algorithm	: recursion
 * @description	: 하노이 탑 이동 순서
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.25	다시풀자
 * 2021.09.27	성공!
 */
public class BOJ_11729 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, n) - 1 + "\n");
		
		hanoi(1,3,n);
		
		System.out.println(sb.toString());
		
	}
	private static void hanoi(int a, int b, int k) {
		
		if(k == 1) {
			sb.append(a+" "+ b+"\n");
			return;
		}
		
		hanoi(a,6-a-b,k-1);
		hanoi(a,b,1);
		hanoi(6-a-b,b,k-1);
	}
}
