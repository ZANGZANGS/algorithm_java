package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: backtracking
 * @description	: 계란으로 계란치기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.21	구현 조건을 자세히 보자.
 * 1. 자기 자신은 계란으로 치지 못한다. (이건 했음)
 * 2. 모든 계란을 치지 못하면 내려놓고 다음 계란을 집어든다. (이걸 잘 못 구현 헀다.)
 */
public class BOJ_16987 {

	static int[][] eggs;
	static int N;
	static int max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[2][N]; //0 - 내구도, 1 - 무게
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			eggs[0][i] = Integer.parseInt(st.nextToken());	//내구도
			eggs[1][i] = Integer.parseInt(st.nextToken());	// 무게
		}
		
		func(0);
	
		System.out.println(max);
	}
	
	private static void func(int k) { //k 번째 계란을 든다.
		
		if(k == N) { //마지막 계란
			int brokenEggs = 0;
			for(int i=0; i< N ; i++) {
				if(eggs[0][i] <= 0) {
					brokenEggs++;
				}
			}
			
			max = Math.max(max, brokenEggs);
			
//			System.out.println("brokenEggs: "+brokenEggs);
			return;
		}
		
		if(eggs[0][k] <= 0) { // 꺠진 계란이면 다음 계란으로
			func(k+1);
		}else {
			// 손에 든 계란이 내구도가 있다.
			int hitCnt = N-1;
			for (int i = 0; i < N; i++) {
			
				if(k == i) {
					//func(k+1); //자기 자신의 계란을 깰 수는 없다. continue;
					continue;
				}else if(eggs[0][i] <= 0) { // 계란이 이미 깨짐
					hitCnt--;
				}else {
//					System.out.println("i have k egg: "+ k + "\t hit the egg: "+i );
					
					eggs[0][i] -= eggs[1][k];
					eggs[0][k] -= eggs[1][i];
						
					func(k+1);
						
					eggs[0][i] += eggs[1][k];
					eggs[0][k] += eggs[1][i];
				}
					
			}
			if(hitCnt == 0) {
				func(k+1);
			}
		}
		
	}

	
}
