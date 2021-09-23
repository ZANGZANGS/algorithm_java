package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 확장게임
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.23	무난하게 풀이 성공!
 */
public class BOJ_16920 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //y
		int M = Integer.parseInt(st.nextToken()); //x
		int P = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		int[][] dist = new int[N][M];
		boolean[][] visGlobal = new boolean[N][M];
		int[] moveS = new int[P+1];
		int[] result = new int[P+1];
		

		Queue<int[]>[] Q  = new Queue[P+1];
		Queue<int[]>[] nextQ  = new Queue[P+1];
		Queue<Integer> odrQ = new LinkedList<Integer>();

		//init Q arr
		for (int i = 1; i <= P; i++) {
			Q[i] = new LinkedList<int[]>();
			nextQ[i] = new LinkedList<int[]>();
			odrQ.add(i);
		}
		
		st = new StringTokenizer(br.readLine());

		//p info
		for (int i = 1; i <= P; i++) {
			moveS[i] = Integer.parseInt(st.nextToken());
		}
		
		//board info
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				
				if(input.charAt(j) == '#') {
					board[i][j] = -1;
				}else if(input.charAt(j) == '.') {
					board[i][j] = 0;
				}else {
					 int idx =Integer.parseInt(String.valueOf(input.charAt(j)));
					 board[i][j] = idx;
					 visGlobal[i][j] = true;
					 nextQ[idx].add(new int[] {j,i});// x,y
					 result[idx]++;
				}
			}
		}
		
		
		while (!odrQ.isEmpty()) {
			
			int i = odrQ.poll(); //p의 순서
				
				if(nextQ[i].isEmpty()) continue;
				
				dist = new int[N][M];
				
				while (!nextQ[i].isEmpty()) {
					Q[i].add(nextQ[i].poll());
				}
				
				int maxMove = moveS[i];
				
				while (!Q[i].isEmpty()) {
					int[] temp = Q[i].poll();
					int x = temp[0];
					int y = temp[1];
					
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						
						if(nx < 0 || ny < 0 || nx >=M || ny >= N) continue;
						if(visGlobal[ny][nx]) continue;
						if(board[ny][nx] == -1) continue; //벽
						
						
						visGlobal[ny][nx] = true;
						result[i]++;
						
						if((dist[y][x] +1) == maxMove) {
							nextQ[i].add(new int[] {nx,ny});
						}else {
							Q[i].add(new int[] {nx,ny});
							dist[ny][nx] = dist[y][x] +1;
						}
						
						
					}
					
				}
				
				if(!nextQ[i].isEmpty()) odrQ.add(i);
			
			
		}
		
		
		StringBuilder sb= new StringBuilder();
		
		for (int i = 1; i <= P; i++) {
			sb.append(result[i]+" ");			
		}
		
		System.out.println(sb.toString().trim());
		
	}

}
