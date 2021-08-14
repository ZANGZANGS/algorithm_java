package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M,H;
		int[][][] box ;
		int[][][] dist ;
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] dx = {0,0,1, 0, 0,-1};
		int[] dy = {0,1,0, 0,-1, 0};
		int[] dz = {1,0,0,-1, 0, 0};
		int result = 0;

		String nm = br.readLine();
		StringTokenizer st = new StringTokenizer(nm, " ");
		N = Integer.parseInt(st.nextToken());	//��
		M = Integer.parseInt(st.nextToken());	//��
		H = Integer.parseInt(st.nextToken());	// ����
	
		box = new int[H][M][N];
		dist = new int[H][M][N];
		
		for (int z = 0; z < H; z++) {	// H
			for (int y = 0; y < M; y++) {	// M
				String input = br.readLine();
				st = new StringTokenizer(input, " ");

				for (int x = 0; x < N ; x++) {	//N
					box[z][y][x] = Integer.parseInt(st.nextToken());
					
					if(box[z][y][x] == 0) {
						dist[z][y][x] = -1;
					}
					else if(box[z][y][x] == 1) {
						queue.add(new int[] {z,y,x});	//������� ť�� �ִ´�. dist �迭�� 0
					}
					
				}
			}
		}
		
		//bfs
		while (!queue.isEmpty()) {
			int[] loc = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nz = loc[0] +dz[i];
				int ny = loc[1] +dy[i];
				int nx = loc[2] +dx[i];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
				if(box[nz][ny][nx] == -1) continue;
				if(dist[nz][ny][nx] >= 0) continue;
				
				dist[nz][ny][nx] = dist[loc[0]][loc[1]][loc[2]] +1;
				queue.add(new int[] {nz,ny,nx});
			}
		}
		
		for (int z = 0; z < H; z++) {	// H
			if(result == -1) break;
			for (int y = 0; y < M; y++) {	// M
				if(result == -1) break;
				for (int x = 0; x < N; x++) {	// N
					if(dist[z][y][x] == -1) {
						result = -1;
						return;
					}else if(result != -1 && dist[z][y][x] > result){
						result = dist[z][y][x];
					}
				}
			}
		}
		
		System.out.println(result);
		
	}
}
