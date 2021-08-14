package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: BFS
 * @description	: 토마토
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.06	
 */
public class BOJ_7576 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int M = Integer.parseInt(st.nextToken());	//X
		int N = Integer.parseInt(st.nextToken());	//Y
		
		int[][] arr = new int[N][M];
		boolean[][] vis= new boolean[N][M];
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {	// Y
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					Q.add(new int[] {j,i}); //(x,y)
					vis[i][j] = true;
				}
			}
		}
		
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for (int k = 0; k < 4 ; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || ny <0 || nx>=M || ny>= N) continue;
				if(arr[ny][nx] == -1) continue;
				if(vis[ny][nx] == true) continue;
				
				arr[ny][nx] = arr[y][x]+1;
				Q.add(new int[] {nx,ny}); //(x,y)
				vis[ny][nx] = true;
				
			}
		}
		
		int result = 0;
		
		for (int[] row : arr) {
			if(result == -1) break;
			for (int tmt : row) {
				if(tmt == 0) {
					result = -1;
					break;
				}
				result = Math.max(result, tmt);
			}
		}
		
		if(result != -1) result = result -1;
		System.out.println(result);
		
	}
}
