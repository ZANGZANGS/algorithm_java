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
 * 2021.08.25	TODO 다시풀자
 */
public class BOJ_11729 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb.append((1<<n) -1);	//total count
		sb.append("\n");
		recur(1,3,n);
		System.out.println(sb.toString());
	}
	
	private static void recur(int start, int end, int n) {

		if(n == 1) {
			sb.append(start+" "+end+ "\n");
			return ;
		}
		recur(start, 6-start-end, n-1);
		sb.append(start+" "+end+ "\n");
		recur(6-start-end, end, n-1);
		
		return ;
	}
}
