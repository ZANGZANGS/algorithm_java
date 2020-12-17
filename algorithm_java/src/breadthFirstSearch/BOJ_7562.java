package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {1,2,2,1,-1,-2,-2,-1};
		
		int round = Integer.parseInt(br.readLine());
		
		for (int r = 0; r < round; r++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			
			int size = Integer.parseInt(br.readLine());
			int[][] pan = new int[size][size];
			int[][] dist = new int[size][size];
			
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");
			int start_x = Integer.parseInt(start[0]);
			int start_y = Integer.parseInt(start[1]);
			int end_x = Integer.parseInt(end[0]);
			int end_y = Integer.parseInt(end[1]);
			
			queue.add(new int[] {start_x, start_y});
			dist[start_x][start_y] = 1;
			
			while (!queue.isEmpty() && dist[end_x][end_y]==0) {
				int[] temp = queue.poll();
				
				for (int i = 0; i < 8; i++) {
					int nx = temp[0]+dx[i];
					int ny = temp[1]+dy[i];
					
					if(nx<0 || ny<0 || nx>= size || ny >= size) continue;
					if(dist[nx][ny] > 0) continue; //지나간 길
					
					dist[nx][ny] = dist[temp[0]][temp[1]] +1;
					queue.add(new int[] {nx, ny});
					
				}
				
			}
			System.out.println(dist[end_x][end_y]-1);
		}
	}

}
