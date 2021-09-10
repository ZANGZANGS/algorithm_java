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
 * @description	: 벽 부수기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.10	TODO 벽을 부순 경우 vs 안 부순 경우에 대한 방문체크를 다르게 한다.
 */
public class BOJ_2206  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		
		int N = Integer.parseInt(st.nextToken()); // Y
		int M = Integer.parseInt(st.nextToken()); // X
		
		int[][] arr = new int[N][M];
		int[][][] dist = new int[N][M][2];
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = in.charAt(j)-'0';
			}
		}
		
		Q.add(new int[] {0,0,1}); //x,y,block;
		dist[0][0][1] = 1;
		
		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			int x = temp[0];
			int y = temp[1];
			int block = temp[2]; // 0: 이미 벽 뚫음 1: 안뚫음
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				//범위
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				
				if(dist[ny][nx][1] > 0 && block == 1) continue;
				if(dist[ny][nx][0] > 0 && block == 0) continue;
				
				//벽 못 부숨
				if(arr[ny][nx] == 1 && block == 0) continue;
					
				//벽 부수기
				if(arr[ny][nx] == 1 && block == 1) {
					dist[ny][nx][0] = dist[y][x][1] +1;
					Q.add(new int[]{nx, ny, 0});
				}
				
				//그냥 길
				if(arr[ny][nx] == 0) {
					if(block == 1) {
						dist[ny][nx][1] = dist[y][x][1] +1;
					}else {
						dist[ny][nx][0] = dist[y][x][0] +1;
					}
					
					Q.add(new int[]{nx, ny, block});
				}
						
			}
		}
		
		int result = Integer.MAX_VALUE;
		if(dist[N-1][M-1][0] != 0) result = Math.min(dist[N-1][M-1][0], result);
		if(dist[N-1][M-1][1] != 0) result = Math.min(dist[N-1][M-1][1], result);
		System.out.println(result != Integer.MAX_VALUE ? result : -1);
	}
}
