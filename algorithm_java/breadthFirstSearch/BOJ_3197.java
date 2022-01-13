package breadthFirstSearch;

import java.io.*;
import java.util.*;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 백조의 호수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.17	시간초과
 * 2022.01.13	성공
 */
public class BOJ_3197 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int R, C;
	static char[][] map;
	static boolean[][] visSwan, visWater;
	static Queue<int[]> waterQ, waterNextQ, swanQ, swanNextQ;
	
	static int startX, startY, endX, endY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //y
		C = Integer.parseInt(st.nextToken()); //x
		
		map = new char[R][C];
		
		visSwan = new boolean[R][C];
		swanQ = new LinkedList<>();
		swanNextQ = new LinkedList<int[]>();
		
		visWater = new boolean[R][C];
		waterQ = new LinkedList<int[]>();
		waterNextQ = new LinkedList<int[]>();
		
		
		int resultDays = -1;
		
		List<int[]> startEnd = new ArrayList<int[]>();
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				
				if(temp.charAt(j) == 'X') {
					map[i][j] = 'X';
					
				}else {
					if(temp.charAt(j) == 'L') {
						startEnd.add(new int[] {j,i}); //x,y
					}
					waterQ.add(new int[] {j,i}); //x,y
					visWater[i][j] = true;
					map[i][j]='.';
				}
				
			}
		}

		startX =  startEnd.get(0)[0];
		startY =  startEnd.get(0)[1];
		endX =  startEnd.get(1)[0];
		endY =  startEnd.get(1)[1];
		
		visSwan[startY][startX] = true;
		swanQ.add(new int[] {startX, startY});

		while (!visSwan[endY][endX]) {
			waterBFS();
			swanBFS();
			resultDays++;
		}
		
		System.out.println(resultDays);
		
	}
	
	private static void swanBFS() {
		
		while (!swanNextQ.isEmpty()) {
			swanQ.add(swanNextQ.poll());
		}
		
		
		while (!swanQ.isEmpty()) {

			int[] cur = swanQ.poll();

			int x = cur[0];
			int y = cur[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R)	continue;
				if (visSwan[ny][nx]) continue;

				if (map[ny][nx] == 'X') {
					swanNextQ.add(new int[] {nx, ny});
				} else {
					swanQ.add(new int[] {nx, ny});
				}
				
				visSwan[ny][nx] = true;
			}
		}
	}
	
	private static void waterBFS() {
		while (!waterNextQ.isEmpty()) {
			int[] cur = waterNextQ.poll();
			map[cur[1]][cur[0]] = '.';
			waterQ.add(cur);
		}
		
		while (!waterQ.isEmpty()) {

			int[] cur = waterQ.poll();

			int x = cur[0];
			int y = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R)	continue;
				if (visWater[ny][nx]) continue;
				
				if (map[ny][nx] == 'X') {
					waterNextQ.add(new int[] {nx, ny});
					visWater[ny][nx] = true;
				}
				
			}
		}
	}
}
