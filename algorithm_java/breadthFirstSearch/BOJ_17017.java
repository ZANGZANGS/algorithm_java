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
 */
public class BOJ_17017 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> Q = new LinkedList<>();
		
		Q.add(new int[] {N,K,0}); //N 위치, 지난 시간, 현재 K 위치 
		
		while (!Q.isEmpty()) {
			
			int[] temp = Q.poll();
			
			int cur = temp[0];
			int locK = temp[1];
			int sec = temp[2];
			
			if(locK > 500000) {
				System.out.println(-1);
				break;
			}
			
			if( cur == locK) {
				System.out.println(sec);
				break;
			}
			
			
			for (int here : new int[] {cur-1, cur+1, cur*2}) {
				if(here<0 || here > 500000) continue;
				
				Q.add(new int[] {here, locK+sec+1, sec+1});
				
			}
			
		}
		
	}

}
