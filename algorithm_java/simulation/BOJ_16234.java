package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 인구 이동
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.10	성공
 */
public class BOJ_16234 {

	static int N,L,R;
	static int[][] people;
	static final int[] dx = new int[] {0,1,0,-1};
	static final int[] dy = new int[] {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int days = 0;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); //L명 이상
		R = Integer.parseInt(st.nextToken()); //R명 이하
		
		people = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			int unionNum = 0;
			int[][] union = new int[N][N];
			Queue<int[]> Q = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(union[i][j]>0) continue; //연합 구성한 나라 pass
					
					//연합 구성 여부 확인 START
					if(!checkUnion(j,i)) continue;
					unionNum++;
					//연합 구성 여부 확인 END
						
					Q.add(new int[] {i,j});
					union[i][j] = unionNum;
					
					//BFS 연합 구하기
					while(!Q.isEmpty()) {
						int[] cur = Q.poll();
						int curX = cur[1];
						int curY = cur[0];
						
						for (int k = 0; k < 4; k++) {

							int nx = curX+dx[k];
							int ny = curY+dy[k];
							
							if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
							if(union[ny][nx] > 0) continue;
							
							int gap = Math.abs(people[curY][curX]-people[ny][nx]);
							
							if(gap >=L && gap <=R) {
								Q.add(new int[] {ny,nx});
								union[ny][nx] = unionNum;
							}
						}
						
					} 
				}
			}	
			
			if(unionNum == 0) break; //연합 구성이 불가능
			
			
			//인구 이동 START
			for (int u = 1; u <= unionNum; u++) {

				int sum = 0;
				int cnt = 0;
				
				for (int ui = 0; ui < N; ui++) {
					for (int uj = 0; uj < N; uj++) {
						if(union[ui][uj] == u) {
							sum += people[ui][uj];
							cnt++;
						}
						
					}
				}
				
				int result = sum/cnt;
				for (int ui = 0; ui < N; ui++) {
					for (int uj = 0; uj < N; uj++) {
						if(union[ui][uj] == u) {
							people[ui][uj] = result;
						}
					}
				}
			}
			//인구 이동 END
			
			days++;
		}
		
		System.out.println(days);
		
	}

	private static boolean checkUnion(int x, int y) {
		for (int k = 0; k < 4; k++) {

			int nx = x+dx[k];
			int ny = y+dy[k];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			
			int gap = Math.abs(people[y][x]-people[ny][nx]);
			
			if(gap >=L && gap <=R) {
				return true;
			}
		}
		return false;
	}
	
}
