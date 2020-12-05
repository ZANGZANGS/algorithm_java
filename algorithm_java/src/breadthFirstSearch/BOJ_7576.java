package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputBox;
		int N,M;
		int[][] box;
		int[][] dist;
		boolean[][] vis;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue<Dot2> queue = new LinkedList<Dot2>();
		
		inputBox = br.readLine();
		N = Integer.parseInt(inputBox.split(" ")[1]);
		M = Integer.parseInt(inputBox.split(" ")[0]);
		box = new int[N][M];
		dist = new int[N][M];
		vis = new boolean[N][M];
		
		boolean isGo = false;

		//box data
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for (int j = 0; j < M; j++) {
				box[i][j]= Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) {
					queue.add(new Dot2(i,j));
					//dist[i][j] = 0;
				}else if(box[i][j] == 0) {
					dist[i][j] = -1;
				}
			}
		}
		
		//bfs
		while (!queue.isEmpty()) {
			Dot2 temp = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = temp.x + dx[k];
				int ny = temp.y + dy[k];
				
				if(nx <0 || ny <0 || nx>= N || ny >= M) continue;
				if(box[nx][ny] == -1 ) continue;	//막힌경우
				if(dist[nx][ny] >= 0 ) continue;	//이미 토마토가 익음 (0부터 익은 토마토)
				
				dist[nx][ny] = dist[temp.x][temp.y]+1;
				queue.add(new Dot2(nx, ny));
					
			}
		}
		
		int result=0;
		
			for (int i = 0; i < N; i++) {
				if(result == -1) break;
				for (int j = 0; j < M; j++) {
					if(dist[i][j] == -1) {
						result = -1;
						break;
					}else if(result < dist[i][j]){
						result = dist[i][j];
					}
				}
			}
		
		System.out.println(result);
		
		
	}
}

class Dot2{
	int x;
	int y;
	
	public Dot2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}