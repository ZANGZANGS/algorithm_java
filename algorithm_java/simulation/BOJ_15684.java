package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 사다리 조작
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.19	성공
 */
public class BOJ_15684 {
	
	static int N,M,H,result;
	static int[][] ladder;
	static int[] ord;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		ladder = new int[N][H];
		ord = new int[3];
		Arrays.fill(ord, -1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			//가로선의 정보는 두 정수 a과 b로 나타낸다. 
			//(1 ≤ a ≤ H, 1 ≤ b ≤ N-1) 
			//b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미이다.
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			ladder[b][a] = 1;
		}
	
		bt(0,0);
		
		if(result>3) result = -1;
		System.out.println(result);
	}
	
	private static void bt(int k, int lineCnt) {

		boolean isConnect = true;
		for (int i = 0; i < N; i++) {
			if(i!=check(i)) {
				isConnect = false;
				break;
			}
		}
		
		if(isConnect)result = Math.min(result, lineCnt);
		
		if(k == 3) {
			return;
		}
		

		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < H; j++) {
				if(ladder[i][j] == 1) continue;
				if(i>0 &&ladder[i-1][j] == 1) continue;
				if(i<N-1 &&ladder[i+1][j] == 1) continue;
				if(k>0 && ord[k-1] >= i*N+j) continue; //중복 체크
				
				ladder[i][j] = 1;
				ord[k] = i*N+j;
				bt(k+1, lineCnt+1);
				ord[k] = -1;
				ladder[i][j] = 0;
				
			}
		} 
	}
	
	private static int check(int n) {
		//n번 사다리 출발
		int y=n;
		for (int i = 0; i < H; i++) {
			if(ladder[y][i] == 1) {
				y++;
				continue;
			}
			if(y>0 && ladder[y-1][i] == 1) {
				y--;
				continue;
			}
		}
//		System.out.println(n+"번에서 " + y + "번으로" );
		return y;
	}

}
