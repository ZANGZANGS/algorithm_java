package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 미세먼지 안녕!
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.02.07	성공
 */
public class BOJ_17144 {
	
	static int R,C,T;
	static int[][] map;
	static List<int[]> dusts;
	static List<int[]> airCleaner;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		dusts = new ArrayList<>();
		airCleaner = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) {
					//공기청정기
					airCleaner.add(new int[] {i,j});
				}else {
					dusts.add(new int[] {i,j,map[i][j]});
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			moveDust();
			runAirCleanerUp();
			runAirCleanerDown();
		}
		
		
		
		int total = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				total += map[i][j];
			}
		}
		
		System.out.println(total);
		
	}
	
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};
	
	private static void moveDust() {

		int[][] newMap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int y = i;
				int x = j;
				int w = map[i][j]/5;

				if(map[y][x] == 0) continue;
				
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if(nx<0 || ny<0 || ny>=R || nx>=C) continue;
					if(map[ny][nx] == -1) {
						continue;
					}
					
					map[i][j] -=w;
					newMap[ny][nx] += w;
				}
				
				newMap[y][x] += map[i][j];
				
			}
		}
		
		for (int[] t : airCleaner) {
			newMap[t[0]][t[1]] = -1;
		}
		
		
		map = newMap;
	}
	
	private static void runAirCleanerUp() {
		
		int[] cur =airCleaner.get(0);
		int y = cur[0];
		int x = cur[1];
		
		for (int i = x-1; i > 0; i--) {
			map[y][i] = map[y][i-1];
			
		}
		
		for (int i = y-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		
		for (int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
			
		}
		
		for (int i = 0; i < y; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		
		for (int i = C-1; i > x; i--) {
			map[y][i] = map[y][i-1];
		}
		
		map[y][x+1] = 0;
	}

	private static void runAirCleanerDown() {
		
		int[] cur =airCleaner.get(1);
		int y = cur[0];
		int x = cur[1];
		
		for (int i = x-1; i > 0; i--) {
			map[y][i] = map[y][i-1];
			
		}
		
		for (int i = y+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		
		for (int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
			
		}
		
		for (int i = R-1; i > y; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		
		for (int i = C-1; i > x+1; i--) {
			map[y][i] = map[y][i-1];
		}
		
		map[y][x+1] = 0;
	}
}
