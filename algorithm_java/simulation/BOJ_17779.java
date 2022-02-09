package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 게리맨더링 2
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.02.09	TODO fail
 */
public class BOJ_17779 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int x = 0; x < N-2; x++) {
//			d1 + d2 <= N - x
					
			for (int d1 = 1; d1 < N-x-1; d1++) {
				
				for (int d2 = 1; d2 < N-x-d1; d2++) {
					if(x+d1+d2 > N-1) break;
					
					
					for (int y = d1; y < N-d2; y++) {
						System.out.println("x = " + x + " d1 = " + d1 + " d2 = " + d2 + " y = "+y);
						gm(x,y,d1,d2, map);
					}
					
					System.out.println("=======");
				}
				
			}
			
		}
		
	}

	private static void gm(int r, int c, int d1, int d2, int[][] map) {
		
		map = new int[6][6];
		for (int i = 0; i <= d1; i++) {
			map[r+i][c-i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			map[r+i][c+i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			map[r+d1+i][c-d1+i] = 5;
		}
		for (int i = 0; i <= d1; i++) {
			map[r+d2+i][c+d2-i] = 5;
		}
		//
		
		//1 영역
		for (int i = 0; i < r; i++) {
			for (int j = 0; j <= c; j++) {
				map[i][j] =1;
			}
		}
		int temp = c;
		for (int i = r; i < r+d2; i++) {
			temp--;
			for (int j = 0; j <= c; j++) {
				map[i][j] =1;
			}
			
		}
		
		System.out.println();
	}
}
