package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 구현
* @description	: 파이프 옮기기1
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.15	시간초과
*/
public class BOJ_17070 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
	
		//방향 정보. 끝점?
		Queue<int[]> Q = new LinkedList<int[]>();
		
		Q.add(new int[] {1,0,0}); //0가로 1세로 2대각
		
		

		int count = 0;
		
		
		
		while (!Q.isEmpty()) {
			int[] tmp = Q.poll();
			
			int x = tmp[0];
			int y = tmp[1];
			int dir = tmp[2]; //0가로 1세로 2대각

			if(x == N-1 && y == N-1) count++;
			
			if(dir == 0) {
				//가로 -> 가로
				if(right(x,y)) Q.add(new int[] {x+1,y,0});

				//가로 -> 대각
				if(cross(x, y)) Q.add(new int[] {x+1,y+1,2});
	
				
			} else if(dir == 1) {
				//세로 -> 세로
				if(down(x, y)) Q.add(new int[] {x,y+1,1});
				//세로 -> 대각
				if(cross(x, y)) Q.add(new int[] {x+1,y+1,2});
			} else if(dir == 2) {
				//대각 -> 가로
				if(right(x,y)) Q.add(new int[] {x+1,y,0});
				
				//대각 -> 세로
				if(down(x, y)) Q.add(new int[] {x,y+1,1});
				
				//대각 -> 대각
				if(cross(x, y)) Q.add(new int[] {x+1,y+1,2});
			}
			
		}
		
		System.out.println(count);
		
	}
	
	private static boolean right(int x, int y) {
		int nx = x + 1;
		int ny = y + 0;
		
		if(nx<0 || ny<0 || nx>=N || ny>= N) return false;
		if(map[ny][nx]==1) return false;
		
		return true;
	}

	private static boolean down(int x, int y) {
		int nx = x + 0;
		int ny = y + 1;
		
		if(nx<0 || ny<0 || nx>=N || ny>= N) return false;
		if(map[ny][nx]==1) return false;
		
		return true;
	}

	private static boolean cross(int x, int y) {
		
		int[] dx = new int[] {1,0,1};
		int[] dy = new int[] {0,1,1};
		
		for (int k = 0; k < 3; k++) {
			
			int cx = x + dx[k];
			int cy = y + dy[k];
			
			if(cx<0 || cy<0 || cx>=N || cy>= N) return false;
			if(map[cy][cx]==1) return false;
		}
		
		return true;
	}

}
