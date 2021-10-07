package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: N-Queen
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.08	다시 풀기 ... 넘나 어려운 백트래킹..
 * 2021.10.07	성공
 */
public class BOJ_9663 {
	

	static int N;
	static boolean[] isused1;
	static boolean[] isused2;
	static boolean[] isused3;
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		isused1 = new boolean[N];
		isused2 = new boolean[2*N-1];  //X+Y
		isused3 = new boolean[2*N-1];	//X-Y + N-1
		
		func(0);
		System.out.println(cnt);
		
	}
	
	static void func(int cur) {
		if(cur == N) {
			cnt++;
			return;
		}
	
		for (int i = 0; i < N; i++) {//x
			if(isused1[i]) continue;
			if(isused2[cur+i]) continue;
			if(isused3[i-cur+N-1]) continue;
			
			isused1[i] = true;
			isused2[cur+i] = true;
			isused3[i-cur+N-1] = true;
			func(cur+1);
			isused1[i] = false;
			isused2[cur+i] = false;
			isused3[i-cur+N-1] = false;
			
		}
		
	}

}
