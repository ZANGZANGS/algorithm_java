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
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visSwan;
	static boolean[][] visNextSwan;
	static boolean[][] visWater;
	static boolean[][] visNextWater;
	static Queue<int[]> waterQ;
	static Queue<int[]> waterNextQ;
	static Queue<int[]> swanQ;
	static Queue<int[]> swanNextQ;
	
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //y
		C = Integer.parseInt(st.nextToken()); //x
		
		map = new char[R][C];
		visSwan = new boolean[R][C];
		visNextSwan = new boolean[R][C];
		visWater = new boolean[R][C];
		visNextWater = new boolean[R][C];
		
		waterQ = new LinkedList<int[]>();
		waterNextQ = new LinkedList<int[]>();
		swanQ = new LinkedList<int[]>();
		swanNextQ = new LinkedList<int[]>();
		
		int resultDays = 0;
		
		List<int[]> startEnd = new ArrayList<int[]>();
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				
				if(temp.charAt(j) == 'L') {
					startEnd.add(new int[] {j,i}); //x,y
				}
			}
		}
		
		
		//두 백조가 같은 위치인 경우
		if(startEnd.size() == 1) {
			System.out.println(0);
			return;
		}
		
		startX =  startEnd.get(0)[0];
		startY =  startEnd.get(0)[1];
		endX =  startEnd.get(1)[0];
		endY =  startEnd.get(1)[1];
		

		swanQ.add(new int[] {startX, startY});
		visSwan[startY][startX] = true;
		
		swanBFS();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.' && !visWater[i][j]) {
					waterQ.add(new int[] {j,i});
					visWater[i][j] = true;
					waterBFS();
				}
				
			}
			
		}
		
		while (!visSwan[endY][endX]) {
			resultDays++;
			changeMap();
			swanBFS();
			waterBFS();
		}
		
		System.out.println(resultDays);
		
	}
	
	private static void swanBFS() {
		
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
					if(!visNextSwan[ny][nx]) {
						swanNextQ.add(new int[] { nx, ny });
						visNextSwan[ny][nx] = true;
					}
				} else {
					swanQ.add(new int[] { nx, ny });
					visSwan[ny][nx] = true;
				}
			}
		}
	}
	
	private static void waterBFS() {
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
					
					if(!visNextWater[ny][nx]) {
						waterNextQ.add(new int[] { nx, ny });
						visNextWater[ny][nx] = true;
					}
				} else {
					waterQ.add(new int[] { nx, ny });
					visWater[ny][nx] = true;
				}
			}
		}
	}
	
	private static void changeMap() {
		
		while (!swanNextQ.isEmpty()) {
			int[] temp =swanNextQ.poll();
			int x = temp[0];
			int y = temp[1];
			map[y][x] = '.';
			
			swanQ.add(temp);
			visSwan[y][x] = true;
		}
		
		while (!waterNextQ.isEmpty()) {
			int[] temp =waterNextQ.poll();
			int x = temp[0];
			int y = temp[1];
			map[y][x] = '.';
			
			waterQ.add(temp);
			visWater[y][x] = true;
		}
	}
	
	
}
