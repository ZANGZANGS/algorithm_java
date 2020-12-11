package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m,n,k;
		int x,y;
		
		int round;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		round = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < round; i++) {
			String testCase = br.readLine();
			m = Integer.parseInt(testCase.split(" ")[0]);
			n = Integer.parseInt(testCase.split(" ")[1]);
			k = Integer.parseInt(testCase.split(" ")[2]);
			
			int[][] bat = new int[m][n];
			boolean[][] vis = new boolean[m][n];
			Queue<int[]> queue = new LinkedList<int[]>();
			int count = 0;
			
			for (int j = 0; j < k; j++) {
				String input = br.readLine();
				x = Integer.parseInt(input.split(" ")[0]);
				y = Integer.parseInt(input.split(" ")[1]);
				
				bat[x][y] = 1;
				
			}
			
			//bfs
			for (int q = 0; q < m; q++) {
				for (int p = 0; p < n; p++) {
					
					if(bat[q][p] == 1 && !vis[q][p]) {
						vis[q][p] = true;
						queue.add(new int[] {q,p});
						count++;
					}
					
					while (!queue.isEmpty()) {
						
						int[] temp = queue.poll();
						
						for (int j = 0; j < 4; j++) {
							int nx = temp[0]+ dx[j];
							int ny = temp[1]+ dy[j];
							
							if(nx <0 || ny < 0 || nx >=m || ny >= n) continue; //범위
							if(vis[nx][ny]) continue;	//이미 방문한 곳
							if(bat[nx][ny] == 0) continue;	// 배추가 없는 곳
							
							vis[nx][ny] = true;
							queue.add(new int[] {nx,ny});
						}
						
						
						
					}
					
					
				}
			}
			
			System.out.println(count);
		}
	}

}
