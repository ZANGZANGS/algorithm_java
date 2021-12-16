package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 구현
* @description	: 마법사 상어와 비바라기
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.16	시간초과
*/
public class BOJ_21610 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//대각선은 좌표 범위 제한을 받아 계산하여 물이 늘어난다.
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			} 
		}
		
		

		List<int[]> clound = new ArrayList<>();
		
		clound.add(new int[] {N-1, 0}); //(N, 1)
		clound.add(new int[] {N-1, 1}); //(N, 2)
		clound.add(new int[] {N-2, 0}); //(N-1, 1)
		clound.add(new int[] {N-2, 1}); //(N-1, 2)
		
		int[] dx = new int[] {1,1,-1,-1};
		int[] dy = new int[] {1,-1,1,-1};
		
		for (int c = 0; c < M; c++) {
			st = new StringTokenizer(br.readLine());

			//←, ↖, ↑, ↗, →, ↘, ↓, ↙
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			

			
			if(d == 1) {//←
				for (int[] cu : clound) {
					cu[1] -= s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
				}
				
				
			}else if(d == 2) {//↖
				for (int[] cu : clound) {
					cu[1] -= s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
					
					cu[0] -= s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
				
			}else if(d == 3) {//↑
				for (int[] cu : clound) {
					cu[0] -= s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
				
			}else if(d == 4) {//↗
				for (int[] cu : clound) {
					cu[1] += s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
					
					cu[0] -= s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
			}else if(d == 5) {//→
				for (int[] cu : clound) {
					cu[1] += s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
				}
				
			}else if(d == 6) {//↘
				for (int[] cu : clound) {
					cu[1] += s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
					
					cu[0] += s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
			}else if(d == 7) {//↓
				for (int[] cu : clound) {
					cu[0] += s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
			}else if(d == 8) {//↙
				for (int[] cu : clound) {
					cu[1] -= s; //x
					cu[1] %= N; 
					if(cu[1]<0) cu[1] +=N;
					
					cu[0] += s; //y
					cu[0] %= N; 
					if(cu[0]<0) cu[0] +=N;
				}
			}
			//이동 END
			
			//구름이 있는 칸에 비가 1씩 내리고 구름은 사라진다.
			for (int[] cu : clound) {
				map[cu[0]][cu[1]]++;
			}
			
			//대각선 방향에 따라 물이 증가한다.
			
			
			for (int[] cu : clound) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					
					int ny = cu[0]+dy[k];
					int nx = cu[1]+dx[k];
					
					if(ny <0 || nx<0 || ny>=N || nx>=N) continue;
					if(map[ny][nx]>0) cnt++;
				}
				
				map[cu[0]][cu[1]]+=cnt;
				
			}
			
			// 2이상인 칸의 물의 양이 2만큼 줄어든다.
			
			List<int[]> cloundNext = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(map[i][j] < 2) continue;
					
					boolean isCloud = false;
					for (int[] cd : clound) {			// 구름이 있던 칸 제외
						if(i == cd[0] && j == cd[1]) {
							isCloud = true;
							break;
						}
					}
					if(isCloud) continue;
					
					
					map[i][j] -=2;
					cloundNext.add(new int[] {i,j});
				}
				
			}
			clound = cloundNext;
			
//			System.out.println("======="+c+"번째=======");
//			for (int m[] : map) {
//				for (int i : m) {
//					System.out.print(i+" ");
//				}
//				System.out.println();
//			}
			
			
		}
		
		int sum = 0;
		
		for (int ma[] : map) {
			for (int m : ma) {
				sum+=m;
			}
		}
		
		System.out.println(sum);

		
		
	}

}
