package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @source		: baekjoon
 * @algorithm	: backtracking, bfs
 * @description	: 소문난 칠공주
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.20	굉장히 어려웠다.
 * 1. 25칸이 중복되지 않게 선택되도록 한다. 백트래킹을 사용했다. (로또 문제 처럼 중복 체크)
 * 2. 7명이 다 모이면 다솜이파가 4명이 포함되는지 체크한다.
 * 3. 탐색 알고리즘인 BFS를 사용하여 7명의 위치가 서로 연결되었는지 확인한다. (DFS를 사용할 경우 T자 혹은 + 모양 탐색이 불가하다.)
 */
public class BOJ_1941 {

	static char[] space;
	static int[] result;
	static boolean[] isUsed;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int totCase;
	
	public static void main(String[] args) throws IOException{

		space = new char[25];
		isUsed = new boolean[25];
		result = new int[7];
		totCase = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 5; j++) {
				space[5*i + j] = input.charAt(j);
			}
		}

		func(0);
		System.out.println(totCase);
		
	}
	
	private static void func(int k) {
		if(k == 7){
			// 1.다솜파 4명 체크
			
			int dasompa = 0;
			for (int i = 0; i < 7; i++) {
				if(space[result[i]] == 'S') dasompa++;
			}
			if(dasompa <4) return;
			
			// 2.연결 체크
			boolean[][] map7 = new boolean[5][5];
			boolean[][] vis = new boolean[5][5];

			for (int i = 0; i < 7; i++) {
				int x = result[i]%5;
				int y = result[i]/5;
				map7[y][x] = true;
			}
			
			Queue<int[]> Q = new LinkedList<int[]>();
			
			Q.add(new int[] { result[0]%5, result[0]/5 });
			vis[result[0]/5][result[0]%5] = true;
			
			int chaningCnt = 1; //연결 횟수
			
			while(!Q.isEmpty()) {
				int[] cur = Q.poll();
				
				int x = cur[0];
				int y = cur[1];
				
				for (int i = 0; i < 4; i++) {
					
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx<0 || ny<0 || nx>=5 || ny >=5) continue;
					if(vis[ny][nx]) continue;

					if(map7[ny][nx]) {
						Q.add(new int[] {nx,ny});
						vis[ny][nx] = true;
						chaningCnt++;
					}
					
				}
			}
			
			if(chaningCnt <7) return;
			totCase++;
			return;
		}
		
		
		for (int i = 0; i < 25; i++) {
			
			if(k>0 && result[k-1] > i) {
				continue;
			}
			
			if(!isUsed[i]) {
				
				isUsed[i] = true;
				result[k] = i;
				func(k+1);
				isUsed[i] = false;
			}
			
		}

	}

}
