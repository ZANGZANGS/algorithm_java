package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 감시
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.05	성공
 */
public class BOJ_15683 {

	static int[][] office;
	static List<int[]> list = new ArrayList<>();
	static int N, M;
	static int max = 0;
	static int[] cctvView;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];
		int wall = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if( 1 <= office[i][j] && office[i][j] <= 5) {
					list.add(new int[] {office[i][j], i,j});
				}else if(office[i][j] == 6) wall++;
				
			}

		}

		cctvView = new int[list.size()];
		bt(0);
		
		System.out.println(N*M -(max + wall));
	}

	//1번 4가지 1 2 3 4
	//2번 2가지 5 6
	//3번 4가지 7 8 9 10
	//4번 4가지 11 12 13 14
	//5번 1가지 15
	
	private static void bt(int k) {
		if(k == list.size()) {
			
			int[][] see = new int[N][M];
			
			for (int i = 0 ; i< list.size() ; i++) {
				int[] info = list.get(i);
				
				int cctvType = info[0]; //cctv종류
				int y = info[1];
				int x = info[2];
				
				if(cctvType == 1) {
					
					if(cctvView[i] == 1) {//1 동
						seeEast(see, x, y);//동
					}else if(cctvView[i] == 2) {//2 서
						seeWest(see, x, y);//서
					}else if(cctvView[i] == 3) {//3 남
						seeSouth(see, x, y);//남
					}else if(cctvView[i] == 4) {//4 북
						seeNorth(see, x, y);//북						
					}
				}else if(cctvType == 2) {
					
					if(cctvView[i] == 5) { //5 동서
						seeEast(see, x, y);//동
						seeWest(see, x, y);//서
						
					}else if(cctvView[i] == 6) { //6 남북
						seeSouth(see, x, y);//남
						seeNorth(see, x, y);//북						
					}
					
				}else if(cctvType == 3) {
					

					if(cctvView[i] == 7) { //7 북동
						seeEast(see, x, y);//동
						seeNorth(see, x, y);//북	
					} else if(cctvView[i] == 8) { //8 동남
						seeEast(see, x, y);//동
						seeSouth(see, x, y);//남
					} else if(cctvView[i] == 9) { //9 남서
						seeWest(see, x, y);//서
						seeSouth(see, x, y);//남
					} else if(cctvView[i] == 10) { //10 서북
						seeWest(see, x, y);//서
						seeNorth(see, x, y);//북	
						
					}
						
					
				}else if(cctvType == 4) {
					if(cctvView[i] == 11) { //11 서북동
						seeEast(see, x, y);//동
						seeWest(see, x, y);//서
						seeNorth(see, x, y);//북
					} else if(cctvView[i] == 12) { //12 북동남
						seeEast(see, x, y);//동
						seeSouth(see, x, y);//남
						seeNorth(see, x, y);//북
					} else if(cctvView[i] == 13) { //13 동남서
						seeEast(see, x, y);//동
						seeWest(see, x, y);//서
						seeSouth(see, x, y);//남
					} else if(cctvView[i] == 14) { //14 남서북
						seeWest(see, x, y);//서
						seeSouth(see, x, y);//남
						seeNorth(see, x, y);//북
					}
						
				}else {//5번
					seeEast(see, x, y);//동
					seeWest(see, x, y);//서
					seeSouth(see, x, y);//남
					seeNorth(see, x, y);//북
				}
			}
			
	
			int total = 0;
			for (int[] rows : see) {
				for (int cur : rows) {
					total += cur;
				}
			}
			
			max = Math.max(total, max);
			return;
		}
		
		int[] tmp = list.get(k);
		

		if(tmp[0] == 1) {
			for (int i=1; i<=4; i++) {
				cctvView[k] = i;
				bt(k+1);
			}
		}else if(tmp[0] == 2) {
			for (int i=5; i<=6; i++) {
				cctvView[k] = i;
				bt(k+1);
			}
		}else if(tmp[0] == 3) {
			for (int i=7; i<=10; i++) {
				cctvView[k] = i;
				bt(k+1);
			}
		}else if(tmp[0] == 4) {
			for (int i=11; i<=14; i++) {
				cctvView[k] = i;
				bt(k+1);
			}
		}else {
			cctvView[k] = 15;
			bt(k+1);
		}
		

	}
	
	
	private static void seeEast(int[][] map, int x, int y) { //동
		while (x<M) {
			if(office[y][x] == 6) break;
			map[y][x] = 1;
			x++;
		}
	}
	private static void seeWest(int[][] map, int x, int y) {//서
		while (0<=x) {
			if(office[y][x] == 6) break;
			map[y][x] = 1;
			x--;
		}
		
	}
	private static void seeSouth(int[][] map, int x, int y) {//남
		while (0<=y) {
			if(office[y][x] == 6) break;
			map[y][x] = 1;
			y--;
		}
		
	}
	private static void seeNorth(int[][] map, int x, int y) {//북
		while (y<N) {
			if(office[y][x] == 6) break;
			map[y][x] = 1;
			y++;
		}
	}
	
	
}
