package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 백조의 호수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.17	TODO 시간초과
 */
public class BOJ_3197 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); //y
		int C = Integer.parseInt(st.nextToken()); //x
		
		char[][] map = new char[R][C];
		boolean[][] vis = new boolean[R][C];
		int[][] distStart = new int[R][C];
		int[][] distEnd = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				distStart[i][j] = -1;
				distEnd[i][j] = -1;
			}
		}
		
		
		List<int[]> startEnd = new ArrayList<int[]>();
		
		int resultDays = Integer.MAX_VALUE;
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				
				if(temp.charAt(j) == 'L') {
					startEnd.add(new int[] {j,i}); //x,y
				}
					
			}
			
		}
		
		int startX =  startEnd.get(0)[0];
		int startY =  startEnd.get(0)[1];
		
		int endX =  startEnd.get(1)[0];
		int endY =  startEnd.get(1)[1];

//		Queue<int[]> Q = new LinkedList<int[]>();
		PriorityQueue<int[]> Q = new PriorityQueue<int[]>((a,b)-> a[2]-b[2]);
		
		Q.add(new int[] {startX, startY, 0});
		vis[startY][startX] = true;
		distStart[startY][startX] = 0;
		
		while (!Q.isEmpty()) {
			 int[] cur = Q.poll();
			 
			 int x = cur[0];
			 int y = cur[1];
			 int distance = cur[2];
			 
			 for (int k = 0; k < 4; k++) {
				
				 int nx = x + dx[k];
				 int ny = y + dy[k];
				 
				 if(nx<0 || ny < 0 || nx >= C || ny >= R) continue;
				 if(vis[ny][nx]) continue;
				 
				 
				 vis[ny][nx] = true;
//				 Q.add(new int[] {nx,ny});
				 
				 if(map[ny][nx] == 'X' ) {
					 Q.add(new int[] {nx,ny, distance+1});
					 distStart[ny][nx] = distance+1;
				 }else {
					 Q.add(new int[] {nx,ny, distance});
					 distStart[ny][nx] = distance;
				 }
				 
				
			}
			
		}
		
		
		
		/*********************/
		vis = new boolean[R][C];
		Q = new PriorityQueue<int[]>((a,b)-> a[2]-b[2]);
		
		Q.add(new int[] {endX, endY, 0});
		vis[endY][endX] = true;
		distEnd[endY][endX] = 0;
		
		while (!Q.isEmpty()) {
			 int[] cur = Q.poll();
			 
			 int x = cur[0];
			 int y = cur[1];
			 int distance = cur[2];
			 
			 for (int k = 0; k < 4; k++) {
				
				 int nx = x + dx[k];
				 int ny = y + dy[k];
				 
				 if(nx<0 || ny < 0 || nx >= C || ny >= R) continue;
				 if(vis[ny][nx]) continue;
				 
				 
				 vis[ny][nx] = true;
//				 Q.add(new int[] {nx,ny});
				 
				 if(map[ny][nx] == 'X' ) {
					 Q.add(new int[] {nx,ny, distance+1});
					 distEnd[ny][nx] = distance+1;
				 }else {
					 Q.add(new int[] {nx,ny, distance});
					 distEnd[ny][nx] = distance;
				 }
				 
				
			}
			
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(distStart[i][j] == distEnd[i][j]) {
					resultDays = Math.min(resultDays, distStart[i][j]);
				}else if(distStart[i][j] > distEnd[i][j]) {
					resultDays = Math.min(resultDays, distStart[i][j]-1);
				}
					
			}
		}
		
		System.out.println(resultDays);
		
	}
	
	
}
