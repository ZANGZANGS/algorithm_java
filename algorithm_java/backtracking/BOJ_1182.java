package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: 부분수열의 합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.09
 */
public class BOJ_1182 {

	
	static int N,S;
	static int cnt=0;
	static int[] arr;
	static boolean[] isused;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	//정수의 개수
		S = Integer.parseInt(st.nextToken());	//부분 수열의 합
		
		arr= new int[N];
		isused = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		func(0, 0);
		if(S == 0) cnt--;
		System.out.println(cnt);
		
	}
	
	private static void func(int k, int sum) {
		
		if(k == N) {
			if(sum == S) cnt+=1;
			return;
		}
		
		func(k+1, sum); //안더하기
		func(k+1, sum+arr[k]); // 더하기
		
	}
	
	
}
