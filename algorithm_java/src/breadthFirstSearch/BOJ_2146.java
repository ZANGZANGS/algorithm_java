package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

	static int n;
	static int[][] map;
	static int[][] island;
	static int[][] dist;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dist = new int[n][n];
		island = new int[n][n];
		queue = new LinkedList<int[]>();
		
		int minDist = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp; 
			}
		}
		
		//1. 섬 개수 구하기
		findIslandBfs();
		//2. 각 섬으로부터의 거리 구하기
		calDistBfs();
		
		//3. island와 dist 으로 정답 구해보자
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = j+dx[k];
					int ny = i+dy[k];
					
					//상하 좌우 범위 확인
					if(nx >= n || ny >= n || 0 > nx || 0 > ny) continue;
					if(island[ny][nx] != island[i][j]) {
						minDist= Math.min(minDist , dist[i][j]+dist[ny][nx]);
						
					}
					
				}
			}
		}
		
		System.out.println(minDist);
		
	}
	
	public static void findIslandBfs() {
		queue.clear();
		int islandNumber = 0;
		
		for (int i = 0; i < n; i++) {//y
			for (int j = 0; j < n; j++) {//x
				
				if(map[i][j] == 1 && island[i][j] == 0) {
					island[i][j] = ++islandNumber; //섬 번호 증가
					queue.add(new int[] {j,i});
					
					while (!queue.isEmpty()) {
						int[] dot = queue.poll();
						int x = dot[0];
						int y = dot[1];
						
						// 상하좌우 좌표 체크
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							//좌표 범위를 벗어나는지 체크
							if(nx >= n || ny >= n || 0 > nx || 0 > ny) continue;
							// 섬이 아닌지 체크
							if(map[ny][nx] == 0) continue;
							// 이미 지나간 곳인지 체크
							if(island[ny][nx] > 0) continue;
							queue.add(new int[] {nx,ny});
							island[ny][nx] = islandNumber;
							
						}
					}
				}
			}
		}
	}
	
	static void calDistBfs() {
        queue.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) queue.add(new int[] {j,i});//섬을 다 큐에 넣는다
				else dist[i][j] = -1;
			}
		}
		
		while (!queue.isEmpty()) {
			int[] dot = queue.poll();
			int x = dot[0];
			int y = dot[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				//상하좌우를 벗어나는지 확인
				if(nx<0 || ny <0 || nx >=n || ny >=n) continue;
				//이미 거리를 지나간 곳은 pass
				if(dist[ny][nx] != -1)continue;
				
				dist[ny][nx] = dist[y][x]+1; //거리 증가
				island[ny][nx] = island[y][x]; //섬의 범위 증가 why? dist가 어느 섬으로부터의 거리인지 확인하기 위해서
				queue.add(new int[] {nx,ny});
				
			}
		}
		
	}
	


}