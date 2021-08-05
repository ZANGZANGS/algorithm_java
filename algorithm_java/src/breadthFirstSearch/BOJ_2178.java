package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: 백준
 * @algorithm	: BFS
 * @description	: 미로탐색
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.05	조건에 맞는 좌표는 Queue에 넣자.
 */
public class BOJ_2178 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int N = Integer.parseInt(st.nextToken());	//Y
		int M = Integer.parseInt(st.nextToken());	//X
		
		int[][] arr = new int[N][M];
		boolean[][] vis= new boolean[N][M];
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			char[] in = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = in[j] -'0';
			}
		}
		
		Q.add(new int[] {0,0});	//order by x,y 
		vis[0][0] = true;
		
		while(!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || ny < 0 || nx>= M || ny >= N) continue;
				if(vis[ny][nx] == true) continue;
				if(arr[ny][nx] == 0) continue;
				
				arr[ny][nx] = arr[y][x] +1;
				vis[ny][nx] = true;
				
				Q.add(new int[] {nx,ny});
			}
			
		}
		
		System.out.println(arr[N-1][M-1]);
		
	}
}
