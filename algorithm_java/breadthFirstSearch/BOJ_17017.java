package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 숨바꼭질 5
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.22	TODO 메모리초과 - Q에 누적이 너무 된다. 추가 조건이 필요한데..
 * 2021.09.22	이미 방문한 곳은 2초마다 다시 재방문이 가능하다.
 * 				홀수 방문 시간, 짝수 방문 시간으로 구분한다.
 * 				K의 위치가 범위를 벗어나는지도 체크해야한다.
 */
public class BOJ_17017 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int timeArr[][] = new int[2][500001];
		
		Queue<int[]> Q = new LinkedList<>();

		for (int[] time : timeArr) {
			Arrays.fill(time, -1);
		}
		
		
		Q.add(new int[] {N,K,0}); //N 위치, 현재 K 위치, 현재 시간
		timeArr[0][N] = 0;
		
		while (!Q.isEmpty()) {
			
			int[] temp = Q.poll();
			
			int cur = temp[0];
			int locK = temp[1];
			int sec = temp[2];
			
			if(locK > 500000) {
				System.out.println(-1);
				return;
			}
			
			if(timeArr[sec%2][locK] > -1) {
				System.out.println(sec);
				return;
			}
			
			
			for (int here : new int[] {cur-1, cur+1, cur*2}) {
				if(here<0 || here > 500000) continue;
				
				if(timeArr[(sec+1)%2][here] >-1) continue;
				
				Q.add(new int[] {here, locK+sec+1, sec+1});
				timeArr[(sec+1)%2][here] = sec+1;
				
			}
			
		}
		
		
	}

}
