package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 불켜기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.21	전구를 키면 주변에서 방문가능한지 체크해야 한다.
 */
public class BOJ_11967 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] vis = new boolean[N][N];
		boolean[][] isLight = new boolean[N][N];
		
		List<int[]>[][] switchList = new ArrayList[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			
			if(null == switchList[y][x]) {
				switchList[y][x] = new ArrayList<int[]>();
			}
			
			switchList[y][x].add(new int[] {a,b}); 
						
		}

		Queue<int[]> Q = new LinkedList<int[]>();
		Q.add(new int[] {0,0});
		vis[0][0] = true;
		isLight[0][0] = true;
		int result = 1;
		
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			
			//turn on the bulb
			if(switchList[y][x] != null) {
				List<int[]> swichList = switchList[y][x];
				
				for (int[] swich : swichList) {
					if(!isLight[swich[1]][swich[0]]) {
						isLight[swich[1]][swich[0]] = true;
						
						for (int k = 0; k < 4; k++) {
							int nx = swich[0] + dx[k];
							int ny = swich[1] + dy[k];							
							if(nx < 0 || ny < 0 || nx>= N || ny >= N) continue;
							if(vis[ny][nx]) { 
								Q.add(new int[] {nx,ny});	//important
								break;
							}
						}
						
						result++;
					}
					
				}
			}
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx < 0 || ny < 0 || nx>= N || ny >= N) continue;
				if(vis[ny][nx]) continue;
				if(isLight[ny][nx]) {
					Q.add(new int[] {nx,ny});
					vis[ny][nx] = true;
				}
				
				
			}
			
		}
		
		System.out.println(result);
		
	}

}
