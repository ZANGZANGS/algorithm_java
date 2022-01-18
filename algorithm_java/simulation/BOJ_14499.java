package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 주사위 굴리기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.18	성공
 */
public class BOJ_14499 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dice = new int[7]; //인덱스 0 안씀
		int[] dx = new int[] {0,1,-1, 0,0};
		int[] dy = new int[] {0, 0,0,-1,1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//지도의 세로 크기 N, 
		int M = Integer.parseInt(st.nextToken());//가로 크기 M (1 ≤ N, M ≤ 20), 
		int y = Integer.parseInt(st.nextToken());//주사위를 놓은 곳의 좌표 x, 
		int x = Integer.parseInt(st.nextToken());//y (0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1)
		int K = Integer.parseInt(st.nextToken());//명령의 개수 K (1 ≤ K ≤ 1,000)
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//주사위 이동 명령
		st= new StringTokenizer(br.readLine());
		
		for(int t =0 ; t<K ; t++) {
			int cmd = Integer.parseInt(st.nextToken());
			
			//좌표 계산
			int nx = x + dx[cmd];
			int ny = y + dy[cmd];
			
			if(nx<0 || ny<0 || ny>=N || nx>=M) continue;
			
			if(cmd == 1) {//동쪽1, 서쪽2, 북쪽3, 남쪽4
				int tmp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = tmp;
				
			}else if(cmd == 2) {
				int tmp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = tmp;
				
			}else if(cmd == 3) {
				int tmp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = tmp;
				
			}else if(cmd == 4) {
				int tmp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = tmp;
			}

			
			if(map[ny][nx] != 0) {
				//0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 
				//칸에 쓰여 있는 수는 0이 된다.
				dice[6] = map[ny][nx];
				map[ny][nx] = 0;
			}else {
				//이동한 칸에 쓰여 있는 수가 0이면, 
				//주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
				map[ny][nx] = dice[6];
			}
			
			sb.append(dice[1]);
			sb.append("\n");

			x = nx;
			y = ny;
				
		}
		System.out.println(sb.toString());
	}

}

