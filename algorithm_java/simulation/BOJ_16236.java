package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 아기 상어
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.26	성공 
 * 				BFS를 사용하게 되면 거리 우선순위가 깨진다.
 * 				거리가 2인 먹이 위치는 다음과 같다.
 * 
 * 				? ? 1 ? ?
 *				? 2 x 3 ?
 *				4 x C x 6
 *				? 5 x 7 ?
 *				? ? 8 ? ?
 *				
 *				이는 문제에서 제시한 조건과 맞지 않다.
 *				아래와 같이 정렬이 필요하다.
 *				
 *				? ? 1 ? ?
 *				? 2 x 3 ?
 *				4 x C x 5
 *				? 6 x 7 ?
 *				? ? 8 ? ?
 *
 */
public class BOJ_16236 {
	static int N, sharkX, sharkY, sharkSize, sharkEat;
	static int[][] space;
	static int[] dx = new int[] {0,-1,0,1};
	static int[] dy = new int[] {-1,0,1,0};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9) {
					space[i][j] = 0;
					sharkY = i;
					sharkX = j;
					sharkSize = 2;
					sharkEat = 0;
				}
			}
		}
		
		int totalDist = 0;
		while(true) {
			int dist = bfs_getDist();
			totalDist += dist;
			if(dist == 0) break;
		}
		System.out.println(totalDist);
		
	}
	
	private static int bfs_getDist() {
		int[][] dist = new int[N][N];
		dist[sharkY][sharkX] = 1;
		
		Queue<int[]> bfsQ = new LinkedList<int[]>();
		Queue<int[]> nextQ = new LinkedList<int[]>();
		
		nextQ.add(new int[] {sharkY, sharkX});
		List<int[]> possaible = new ArrayList<>();
		
		while (!nextQ.isEmpty()) {
			
			while (!nextQ.isEmpty()) {
				bfsQ.add(nextQ.poll());
			}
			
			while(!bfsQ.isEmpty()) {
				int[] cur = bfsQ.poll();
				int y = cur[0];
				int x = cur[1];
				
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k]; 
					int nx = x + dx[k]; 
					
					if(nx<0 || ny<0 || nx >= N || ny >=N) continue;
					if(dist[ny][nx]> 0) continue;
					if(space[ny][nx] > sharkSize) continue;
					
					if(space[ny][nx] != 0 && space[ny][nx] < sharkSize) {
						//물고기 먹기
						possaible.add(new int[] {ny,nx});
					}
					nextQ.add(new int[] {ny,nx});
					dist[ny][nx] = dist[y][x]+1;
				}
			}
			
			if(possaible.size() > 0) break;
		}
		
		
		if(possaible.size() == 0) {
			return 0;
		}else {
			//리스트 정렬 
			Collections.sort(possaible, (a,b)-> {
				if(a[0]==b[0]) {
					return a[1]-b[1];
				}
				return a[0]-b[0];
			});
			
			int[] tmp = possaible.remove(0);
			sharkY = tmp[0];
			sharkX = tmp[1];
			
			sharkEat++;
			if(sharkEat == sharkSize) {
				sharkSize++;
				sharkEat = 0;
			}
			space[sharkY][sharkX] = 0;
			
			return dist[sharkY][sharkX]-1;
		}
		
	}

}


