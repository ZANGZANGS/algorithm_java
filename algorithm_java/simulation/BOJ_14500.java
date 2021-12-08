package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 테트로미노
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.08	실패.. ㅜ_ㅜ
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
		
		int[][] paper = new int[N][M];
		
		int maxVal = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				maxVal = Math.max(maxVal, paper[i][j]);
			}
		}
		
		for (int lv = maxVal; lv > 0; lv--) {
			boolean[][] temp = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(paper[i][j]>=lv) temp[i][j] = true;
				}
			}
			

			//순회 start
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if(!temp[i][j]) continue;
					//DFS
					Stack<int[]> stack = new Stack<>();
					
					
					stack.add(new int[] {i,j});
					int[][] dist = new int[N][M];
					dist[i][j] = 1;
					
					while(!stack.isEmpty()) {
						int[] cur = stack.pop();
						
						int y = cur[0];
						int x = cur[1];
						
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = x + dy[k];
							
							if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
							
							if(dist[ny][nx]>0) continue;
							if(!temp[ny][nx]) continue;
							
							stack.add(new int[] {ny,nx});
							dist[ny][nx] = dist[y][x]+1;
							
							if(dist[ny][nx] == 4) {
								//테트리스 반단하기
								System.out.println("");
							}
						}
						
					}
					
				}
			}//순회 end
		}
		

	}

}
