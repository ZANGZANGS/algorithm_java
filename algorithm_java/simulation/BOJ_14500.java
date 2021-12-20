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
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 테트로미노
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.08	실패.. ㅜ_ㅜ
 * 2021.12.20	시간초과
 * 2021.12.20	틀렸습니다...
 */
public class BOJ_14500 {

public static void main(String[] args) throws IOException{
		
		final int[] dx = new int[] {0,1,0,-1};
		final int[] dy = new int[] {1,0,-1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		int[][] papper = new int[N][M];
		
		int maxVal = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				papper[i][j] = Integer.parseInt(st.nextToken());
				maxVal=Math.max(maxVal, papper[i][j]);
			}
		}
		
		for (int lev = maxVal; lev > 0; lev--) {
			
			int[][] map = new int[N][M];
			boolean isOver = false;
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(papper[i][j] != lev) continue;
					
					int num = 1;
					
					Queue<int[]> Q = new LinkedList<int[]>();
					Q.add(new int[] {i,j});
					map[i][j] = num++;
					
					while (!Q.isEmpty()) {
						int[] cur = Q.poll();
						
						int y = cur[0];
						int x = cur[1];
							
						for (int k = 0; k < 4; k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];
							
							if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
							if(papper[ny][nx] < lev) continue;
							if(map[ny][nx] > 0) continue;
							
							Q.add(new int[] {ny,nx});
							map[ny][nx] = num++;
							
						}
						
					}
					
					//가 되나 확인하기
					if(num > 4) isOver = true;
					
					
				}
			}
			
			if(isOver) {
				//4개 연결이 되니 찾기 ㄱㄱ
				
				//순회 start
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {

						if(map[i][j]==0) continue;
						
						List<int[]> tetromino = new ArrayList<>();
						
						
						tetromino.add(new int[] {i,j,papper[i][j]});
						boolean[][] isUsed = new boolean[N][M];
						isUsed[i][j] = true;
						
						List<int[]> next = new ArrayList<>(); //다음 갈 수 있는 좌표들	
						
						
						for (int idx = 0; idx < 3; idx++) {
							int[] cur  =tetromino.get(idx);
							
							for (int k = 0; k < 4; k++) {
								int ny =cur[0]+dy[k];
								int nx =cur[1]+dx[k];
								
								if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
								if(isUsed[ny][nx]) continue;
								if(map[i][j]==0) continue;
								
								next.add(new int[] {ny,nx,papper[ny][nx]});
								
							}
							
							
							if(next.isEmpty()) {
								break;
							}
							
							//테트로미노 추가
							Collections.sort(next, (a,b)->b[2]-a[2]); 
							int[] maxDot = next.remove(0);
							tetromino.add(maxDot);
							isUsed[maxDot[0]][maxDot[1]] = true;
							
							
						}
						
						
						if(tetromino.size() == 4) {
							int sum = 0;
							for (int[] tet : tetromino) {
								sum +=tet[2];
							}
							
							result = Math.max(result, sum);
						}
						
						
					}
				}//순회 end
				if(result>0) {
					break;
				}
				
			}
			
		}
		
		System.out.println(result);
	}		
}
