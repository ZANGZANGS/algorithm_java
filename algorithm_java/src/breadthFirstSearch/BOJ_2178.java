package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nm = br.readLine();
		
		int n = Integer.parseInt(nm.split(" ")[0]);
		int m = Integer.parseInt(nm.split(" ")[1]);
		
		int[][] miro = new int[n][m];
		int[][] dist = new int[n][m];
		
		Queue<Dot> que = new LinkedList<Dot>();
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				miro[i][j] = input.charAt(j) -'0';
			}
		}
		
		//bfs
		
		dist[0][0] = 1;
		que.add(new Dot(0,0));
		
		while (!que.isEmpty()) {
			Dot dot = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dot.x+dx[i];
				int ny = dot.y+dy[i];
				 
				if(nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
				if(miro[nx][ny] == 0 || dist[nx][ny] >0) continue;
				
				que.add(new Dot(nx, ny));
				dist[nx][ny]= dist[dot.x][dot.y]+1;
				
			}
			
		}
		
		System.out.println(dist[n-1][m-1]);
	
	
		
	}
}

class Dot{
	int x;
	int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
