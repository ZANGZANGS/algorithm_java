package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.javafx.collections.MappingChange.Map;

public class BOJ_2206 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		String nm = br.readLine();
		
		int n,m;
		
		n = Integer.parseInt(nm.split(" ")[0]);	//행 row
		m = Integer.parseInt(nm.split(" ")[1]); //열 col
		
		int[][] metrix = new int[n][m];
		int[][] dist = new int[n][m];
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		//input data metrix
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				metrix[i][j] = input.charAt(j) - '0';
			}
		}
		
		//bfs
		q.add(new int[] {0,0});
		dist[0][0] = 1;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if(nx<0 || ny<0 || nx >=n || ny>= m) continue;
				if(dist[nx][ny] >0) continue;
				if(metrix[nx][ny] == 1) continue;	//벽이면
				
				q.add(new int[] {nx,ny});
				dist[nx][ny] = dist[tmp[0]][tmp[1]] +1;
			}
			
		}
		
		if(dist[n-1][m-1] != 0) System.out.println(dist[n-1][m-1]);
		
		
		
		
		
	}

}
