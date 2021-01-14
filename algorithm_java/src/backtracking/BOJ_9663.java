package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	
	static int n;
	static int count = 0;
	static boolean[] isUsed1;	// 행이 사용 되었는지 판단
	static boolean[] isUsed2;	// 좌측하단에서 우측상단 방향으로 대각선 사용유무 판단
	static boolean[] isUsed3;	// 우측하단에서 좌측상단 방향으로 대각선 사용유무 판단

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		isUsed1 = new boolean[n];
		isUsed2 = new boolean[2*n+1];	// 대각선 방향의 총 갯수는 2*n-1개
		isUsed3 = new boolean[2*n+1];	// 대각선 방향의 총 갯수는 2*n-1개
		
		func(0);		
		System.out.println(count);
		
	}
	
	private static void func(int cur) {
		if(n == cur) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+n-1]) continue;
			
			isUsed1[i] = true;
			isUsed2[i + cur] = true;
			isUsed3[cur-i+n-1] = true;
			func(cur+1);
			isUsed1[i] = false;
			isUsed2[i + cur] = false;
			isUsed3[cur-i+n-1] = false;
		}
	}

}
