package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4179 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R,C;
		String[][] miro;
		int[][] dist1;
		int[][] dist2;
		Queue<int[]> fQ = new LinkedList<int[]>();
		Queue<int[]> jQ = new LinkedList<int[]>();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		String miroSize = br.readLine();
		R = Integer.parseInt(miroSize.split(" ")[0]);
		C = Integer.parseInt(miroSize.split(" ")[1]);
		
		miro = new String[R][C];
		dist1 = new int[R][C];
		dist2 = new int[R][C];
		
		//데이터 입력
		for (int i = 0; i < R; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				miro[i][j] = input[j];
				
				if("J".equals(miro[i][j])) {
					dist2[i][j] = 1;
					jQ.add(new int[] {i,j});
					
				}
				else if("F".equals(miro[i][j])) {
					 dist1[i][j] = 1;
					 fQ.add(new int[] {i,j});
					 
				}
				else if(".".equals(miro[i][j])) {
					dist1[i][j] = -1;
					dist2[i][j] = -1;
				}
				
			}
		}
		
		//fire bfs
		while (!fQ.isEmpty()) {
			
			int[] loc = fQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = loc[0]+dx[i];
				int ny = loc[1]+dy[i];
				
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) continue;	// 범위를 벗어나면 pass
				if("#".equals(miro[nx][ny])) continue;				// 벽이면 pass
				if(dist1[nx][ny] >= 1) continue;					// 이미 지나간 곳은  pass
				
				dist1[nx][ny] = dist1[loc[0]][loc[1]]+1;
				fQ.add(new int[] {nx,ny});
			}
		}
		
		//Jihoon bfs
		while (!jQ.isEmpty()) {
			
			int[] loc = jQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = loc[0]+dx[i];
				int ny = loc[1]+dy[i];
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) { 				// 범위를 벗어나면 탈출
					System.out.println(dist2[loc[0]][loc[1]]);
					return;
				}
				if("#".equals(miro[nx][ny])) continue;					// 벽이면 pass
				if(dist2[nx][ny] >= 1) continue;						// 이미 지나간 곳은  pass
				if(dist1[nx][ny] != -1 && dist2[loc[0]][loc[1]]+1 >= dist1[nx][ny] ) continue;	// 불이 지나간 자리이면서 && 불의 거리 보다 지훈이 거리가 크거나 같으면 pass
				
				
				
				dist2[nx][ny] = dist2[loc[0]][loc[1]]+1;
				jQ.add(new int[] {nx,ny});
			}
		}
		System.out.println("IMPOSSIBLE");	// 큐가 비어서 여기까지 오면 실패
	}
}
