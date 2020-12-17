package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mapSize = Integer.parseInt(br.readLine());
		
		char[][] map = new char[mapSize][mapSize];
		char[][] mapRB = new char[mapSize][mapSize];
		boolean[][] mapVis = new boolean[mapSize][mapSize];
		boolean[][] mapVisRB = new boolean[mapSize][mapSize];
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int rgbCnt = 0;
		int rbCnt = 0;
		
		//input map data
		for (int i = 0; i < mapSize; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = input[j];
				if(input[j] == 'G')	{
					mapRB[i][j] = 'R';	//적록색약
				}else {
					mapRB[i][j] = input[j];
				}
				
			}
		}
		
		//bfs RGB
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				
				if(!mapVis[i][j]) {//false
					queue.add(new int[] {i,j});
					rgbCnt++;
				}
				
				while (!queue.isEmpty()) {
					int[] temp = queue.poll();
					char target = map[temp[0]][temp[1]];
							
					for (int k = 0; k < 4; k++) {
						int nx = temp[0]+dx[k];
						int ny = temp[1]+dy[k];
						
						if(nx<0 || ny<0 || nx>=mapSize || ny>=mapSize) continue;
						if(target != map[nx][ny]) continue;	//다른 문자이면
						if(mapVis[nx][ny]) continue; //이미 방문함
						
						mapVis[nx][ny] = true;
						queue.add(new int[]{nx,ny});
						
					}
				}
			}
		}
		
		queue.clear();
		
		//bfs R(G)B 적록색약
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				
				if(!mapVisRB[i][j]) {//false
					queue.add(new int[] {i,j});
					rbCnt++;
				}
				
				while (!queue.isEmpty()) {
					int[] temp = queue.poll();
					char target = mapRB[temp[0]][temp[1]];
					
					for (int k = 0; k < 4; k++) {
						int nx = temp[0]+dx[k];
						int ny = temp[1]+dy[k];
						
						if(nx<0 || ny<0 || nx>=mapSize || ny>=mapSize) continue;
						if(target != mapRB[nx][ny]) continue;	//다른 문자이면
						if(mapVisRB[nx][ny]) continue; //이미 방문함
						
						mapVisRB[nx][ny] = true;
						queue.add(new int[]{nx,ny});
						
					}
				}
			}
		}
		
		System.out.println(rgbCnt+" "+ rbCnt);
	}

}
