package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: BFS
 * @description	: 불!
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.09	런타임 에러 (NullPointer)
 */
public class BOJ_4179 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());	//x
		int C = Integer.parseInt(st.nextToken());	//y
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		Queue<int[]> fQ = new LinkedList<int[]>();	//fire
		Queue<int[]> jQ = new LinkedList<int[]>();	//jihoon
		
		String[][] miro = new String[C][R];
		int[][] fireDist = new int[C][R];
		int[][] jihoonDist = new int[C][R];
		
		
		for (int i = 0; i < C; i++) {	//y
			String[] miroInput = br.readLine().split("");
			for (int j = 0; j < R; j++) {	//x
				miro[i][j] = miroInput[j];
				
				if("J".equals(miro[i][j])) {
					jihoonDist[i][j] = 1;
					jQ.add(new int[] {j,i});	//지훈이 출발점 x,y
					
				}
				else if("F".equals(miro[i][j])) {
					 fireDist[i][j] = 1;
					 fQ.add(new int[] {j,i});	//불 출발점 x,y
					 
				}
				else if(".".equals(miro[i][j])) {	//이동 가능한 곳 -1로 초기화
					fireDist[i][j] = -1;
					jihoonDist[i][j] = -1;
				}
				
			}
		}
		
		//fire bfs
		while (!fQ.isEmpty()) {  
			
			int[] loc = fQ.poll();
			
			int x = loc[0];
			int y = loc[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) continue;	// 배열 범위 체크
				if("#".equals(miro[ny][nx])) continue;				// 벽체크
				if(fireDist[ny][nx] >= 1) continue;					// 이미 지나간 곳은  pass
				
				fireDist[ny][nx] = fireDist[y][x]+1;
				fQ.add(new int[] {nx,ny});
			}
		}
		
		//Jihoon bfs
		while (!jQ.isEmpty()) {
			
			int[] loc = jQ.poll();
			
			int x = loc[0];
			int y = loc[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) {
					System.out.println(jihoonDist[y][x]); //지훈이가 배열 범위를 벗어나는 순간 탈출 성공
					return;
				}
				if("#".equals(miro[ny][nx])) continue;				// 벽체크
				if(jihoonDist[ny][nx] >= 1) continue;	// 이미 지훈이가 지나간 곳
				if(fireDist[ny][nx] != -1 && jihoonDist[y][x]+1 >= fireDist[ny][nx] ) continue;	//불이 이미 지나갔는지
				
				jihoonDist[ny][nx] = jihoonDist[y][x]+1;
				jQ.add(new int[] {nx,ny});
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
