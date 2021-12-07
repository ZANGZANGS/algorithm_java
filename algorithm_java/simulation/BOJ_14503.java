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
 * @description	: 로봇 청소기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.07	성공
 */
public class BOJ_14503 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); //0:북 1:동 2:남 3:서
		
		
		int[][] room = new int[N][M];
		boolean[][] clean = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		Q.add(new int[] {r,c,d});
		
		while (!Q.isEmpty()) {
			int[] tmp = Q.poll();
			int dr = tmp[0]; //y
			int dc = tmp[1]; //x
			int direction = tmp[2];
			
			//1.현재 위치 청소
			clean[dr][dc] = true;
			
			
			for (int i = 0; i < 4; i++) {
				int nextDirection = (direction-1+4)%4;
				int nr = dr;
				int nc = dc;
				
				if(nextDirection == 0) {//북
					nr -=1;
//					nc = dc;
				}else if(nextDirection == 1) {//동
//					nr = dr;
					nc +=1;
				}else if(nextDirection == 2) {//남
					nr += 1;
//					nc = dc;
				}else if(nextDirection == 3) {//서
//					nr = dr;
					nc -= 1;
				}
				
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) {
					direction = nextDirection;
					continue;
				}
				if(room[nr][nc] == 1) {
					direction = nextDirection;
					continue; //벽
				}
				if(clean[nr][nc]) {
					direction = nextDirection;
					continue; //이미 청소됨
				}
				
				Q.add(new int[] {nr,nc, nextDirection});
				break;
			}
			
			//다 막혔으면
			if(Q.isEmpty()) {
				int nr = dr;
				int nc = dc;
//				direction = (direction+1)%4;
				
				if(direction == 0) {//북
					nr +=1;
//					nc = dc;
				}else if(direction == 1) {//동
//					nr = dr;
					nc -=1;
				}else if(direction == 2) {//남
					nr -= 1;
//					nc = dc;
				}else if(direction == 3) {//서
//					nr = dr;
					nc += 1;
				}
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) {
					break;
				}
				if(room[nr][nc] == 1) {
					break; //벽
				}
				
				Q.add(new int[] {nr,nc,direction});
				
			}
			
			
		}
		int total = 0;
		for (boolean[] cln : clean) {
			for (boolean is : cln) {
				if(is) total++;
			}
		}
		
		System.out.println(total);
	}

}
