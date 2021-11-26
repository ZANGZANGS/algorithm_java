package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: BFS
 * @description	: 연구소
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.26	성공
 * 				1.3개의 벽을 놓을 자리를 선택한다.
 * 					1-1. N*M개의 수를 정렬한다. X는 번호%M 이고 Y는 번호/M 이다.
 * 				2. 3개의 벽을 추가한 후 BFS
 * 				3. 안전지역 세기 
 */
public class BOJ_14502 {

	static int N,M;
	static int map[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int wall[];
	static Queue<int[]> Q;
	
	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//y 
		M = Integer.parseInt(st.nextToken());//x
		
		map = new int[N][M];
		Q = new LinkedList<>();
		
		int sfaeArea = Integer.MIN_VALUE;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 2) {
					Q.add(new int[] {i,j}); //y,x
				}
			}
		}
		
		wall = Arrays.stream(map).flatMapToInt(v -> Arrays.stream(v)).toArray();


		for (int i = 0; i < N*M; i++) {	//첫번쨰 벽
			
			if(wall[i] != 0) continue;
			
			int x1 = i%M;
			int y1 = i/M;
			
			int[][] cur = new int[3][2];
			
			for (int j = i+1; j < N*M; j++) {	//두번쨰 벽
			
				if(wall[j] != 0) continue;
				
				int x2 = j%M;
				int y2 = j/M;
				
			
				for (int k = j+1; k < N*M; k++) {	//세번쨰 벽

					if(wall[k] != 0) continue;
					
					int x3 = k%M;
					int y3 = k/M;
					
					cur[0][0] = x1;
					cur[0][1] = y1;
					
					cur[1][0] = x2;
					cur[1][1] = y2;
					
					cur[2][0] = x3;
					cur[2][1] = y3;
					
					sfaeArea = Math.max(sfaeArea, bfs(cur));
				}
			}
		}
		
		
		System.out.println(sfaeArea);
		
		
		
	}
	
	private static int bfs(int[][] cur) {
		
		int[][] copyMap = new int[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> virus = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone(); 
		}
		
		//신축 벽 건설
		for (int[] xy : cur) {
			int x = xy[0];
			int y = xy[1];
			copyMap[y][x] = 1; //새로운 벽
		}
		
		
		
		for (int i = 0; i < Q.size(); i++) {
			
			int[] tmp = Q.poll(); //y,x
			Q.add(tmp);
			
			virus.add(tmp);
			dist[tmp[0]][tmp[1]] = 1;
		}
		
		
		while (!virus.isEmpty()) {
			
			int[] tmp = virus.poll();
			
			int y = tmp[0];
			int x = tmp[1];
			
			for (int k = 0; k < 4; k++) {
				
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if(nx <0 || nx >=M || ny <0 || ny>=N) continue;
				if(copyMap[ny][nx] != 0) continue; //벽or바이러스
				if(dist[ny][nx] > 0) continue; //이미 방문
				
				dist[ny][nx] = dist[y][x] +1;
				virus.add(new int[] {ny,nx});
					
			}
			
		}
		
		//영역 세기
	
		return  N*M - virusAreaSize(dist) - wallAreaSize(copyMap);
	}
	
	private static int virusAreaSize(int[][] safe) {
		
		return 	(int)Arrays.stream(safe)
				.flatMapToInt(v -> Arrays.stream(v))
				.filter(v-> v>0)
				.count();
		
	}
	
	private static int wallAreaSize(int[][] copyMap) {
		
		return 	(int)Arrays.stream(copyMap)
				.flatMapToInt(v -> Arrays.stream(v))
				.filter(v-> v==1)
				.count();
		
	}
		
		

}





