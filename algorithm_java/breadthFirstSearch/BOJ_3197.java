package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 백조의 호수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.17	TODO 시간초과
 */
public class BOJ_3197 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); //y
		int C = Integer.parseInt(st.nextToken()); //x
		
		char[][] map = new char[R][C];
		boolean[][] vis = new boolean[R][C]; 
		
		List<int[]> startEnd = new ArrayList<int[]>();
		
		int resultDays = -1;
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				
				if(temp.charAt(j) == 'L') {
					startEnd.add(new int[] {j,i}); //x,y
				}
					
			}
			
		}
		
		int startX =  startEnd.get(0)[0];
		int startY =  startEnd.get(0)[1];
		
		int endX =  startEnd.get(1)[0];
		int endY =  startEnd.get(1)[1];

		while(!vis[endY][endX]) {

			//vis array init false;
			for(boolean[] inner : vis) {
				for (int i = 0; i < inner.length; i++) {
					inner[i] = false;
					
				}
			}
			
			/******************/
			Queue<int[]> Q = new LinkedList<int[]>();
			
			Q.add(startEnd.get(0)); //x,y
			
			vis[startY][startX] = true;
			
			while (!Q.isEmpty()) {
				int[] cur = Q.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int k = 0; k < 4; k++) {
					int nx = x+ dx[k];
					int ny = y+ dy[k];
					
					if(nx<0 || ny< 0|| nx>=C || ny>= R) continue;//범위
					if(vis[ny][nx]) continue;
					if(map[ny][nx] == 'X')continue;
					
					vis[ny][nx] = true;
					Q.add(new int[] {nx,ny});
					
					
				}
			}
			/******************/
			
			resultDays ++;
			map = melt(map);
		}
	
		System.out.println(resultDays);
		
		
	}
	
	
	public static char[][] melt(char[][] map) {
		int r = map.length;		//y
		int c = map[0].length;	//x
		
		char[][] after = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				
				if( map[i][j] != 'X') {
					after[i][j] = map[i][j];	
				}else {
					//X 기준으로 물을 만나는지 4방향 확인.
					after[i][j] = 'X';
					
					for (int k = 0; k < 4; k++) {
						int nx = j+ dx[k];
						int ny = i+ dy[k];
						
						if(nx<0 || ny< 0|| nx>=c || ny>= r)continue;//범위
						
						//빙판이 호수와 접촉하면 녹음
						if(map[ny][nx] == '.') {
							after[i][j] = '.';
							break;
						}
						
					}
				}
				
				
			}
			
		}
		
		return after;
		
	}

}
