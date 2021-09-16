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
 * @description	: 말이 되고픈 원숭이
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.16	점프 횟수에 따라 dist 배열을 다르게 한다.
 */
public class BOJ_1600 {
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	static int[] hx = {1,2, 2, 1,-1,-2,-2,-1};
	static int[] hy = {2,1,-1,-2,-1,-1, 1, 2};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken()); //x
		int H = Integer.parseInt(st.nextToken()); //y
		
		int[][] map = new int[H][W];
		int[][][] dist = new int[K+1][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					dist[i][j][k] = -1;
				}
			}
		}
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		Q.add(new int[] {0,0,K}); // x,y, k(말따라 점프 가능 횟수)
		dist[K][0][0] = 0;
		
		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			int x = temp[0];
			int y = temp[1];
			int k = temp[2];
			
			//점프하는 경우
			if(k>0) {
				for (int i = 0; i < 8; i++) {
					int nx = x+hx[i];
					int ny = y+hy[i];
					
					if(nx<0||ny<0 || nx>=W || ny>=H) continue;
					if(map[ny][nx] == 1) continue;
					
					if(dist[k][ny][nx] > 0) continue;
					if(dist[k-1][ny][nx] > 0) continue;
					
					dist[k-1][ny][nx] = dist[k][y][x] +1;
					Q.add(new int[] {nx,ny,k-1});
					
				}
			}
			
			//상하좌우 움직이는 경우
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||ny<0 || nx>=W || ny>=H) continue;
				if(map[ny][nx] == 1) continue;
				
				if(dist[k][ny][nx] > 0) continue;
				
				dist[k][ny][nx] = dist[k][y][x] +1;
				Q.add(new int[] {nx,ny,k});
				
			}
			
		}
		
		int result = -1;
		
		for (int k = 0; k <= K; k++) {
			if(dist[k][H-1][W-1] == -1) continue;
			
			if(result == -1) {
				result = dist[k][H-1][W-1];
			}else {
				result = Math.min(result, dist[k][H-1][W-1]);
			}
			
		}
		
		
		System.out.println(result);
		
	}

}
