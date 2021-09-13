package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 다리만들기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.13
 */
public class BOJ_2146 {

	static int N;
	static int[][] map;
	static int[][] island;
	static int ord;

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		island = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findIsland();
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 1; i <= ord; i++) {
			result = Math.min(result, calBridge(i));
		}
		System.out.println(result);
		
	}
	
	private static void findIsland() {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		boolean[][] vis = new boolean[N][N];
		
		ord = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(map[i][j] != 1) continue;
				if(vis[i][j]) continue;
				
				Q.add(new int[] {i,j}); // y,x
				vis[i][j] = true;
				island[i][j] = ++ord;
				
				while (!Q.isEmpty()) {
					int[] temp = Q.poll();
					
					int x = temp[1];
					int y = temp[0];
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						
						if(nx<0 || ny< 0 || nx>=N || ny>= N) continue;
						
						if(vis[ny][nx]) continue;
						if(map[ny][nx] == 0) continue;
						
						island[ny][nx] = ord;
						Q.add(new int[] {ny, nx});
						vis[ny][nx] = true;
						
					}
				}
			}
		}
	}
	
	private static int calBridge(int order) {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		int[][] dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(island[i][j] != order) continue;
				if(map[i][j] != 1) continue;

				Q.add(new int[] {i,j});	//y,x
				dist[i][j] = 0;
				
			}
		}
		
		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			int x = temp[1];
			int y = temp[0];
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || ny< 0 || nx>=N || ny>= N) continue;
				
				if(dist[ny][nx] >0) continue; //중복방문 체크
				
				if(island[ny][nx] != 0 && island[ny][nx] !=order) {
					//물도 아니고, 다른 대륙을 밟으면, 최단거리 대륙 찾은 것
					return dist[y][x];
				}
				if(map[ny][nx] == 1) continue;
				
				Q.add(new int[] {ny, nx});
				dist[ny][nx] = dist[y][x] +1;
				
			}
		}
		
		return -1;
	}
	
}