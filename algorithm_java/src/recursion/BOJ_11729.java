/**
 * 하노이 탑
 */
package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb.append( (1<<n)-1+"\n");
		movePlate(1, 3, n);
		
		System.out.println(sb);
	}

	//뭔판 n개를 기둥 a에서 b로 옮기는 함수
	private static void movePlate(int a, int b, int n) {
		if(n == 1) {
			sb.append(a+" "+b+"\n");
			
		}else {
			movePlate(a, 6-a-b, n-1);		// n-1개를 다른 기둥으로 옮겨
			sb.append(a+" "+b+"\n");		// n번 원판을 내가 옮기려는 기둥으로 옮겨
			movePlate(6-a-b, b, n-1);		// 다른 기둥에 옮겼던 n-1개의 원판을 옮기려 했던 기둥으로 옮겨 
		}
	}

}
