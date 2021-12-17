package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 구현
* @description	:
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.17	성공
* 				- snake head 방향주의, 사과를 삭제 체크
*				
* 
*/
public class BOJ_3190 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//보드 크기
		int K = Integer.parseInt(br.readLine());//사과 개수
		
		int[][] board = new int[N][N];
		
		StringTokenizer st;
		
		for (int i = 0; i < K; i++) { //사과 자리
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			board[y-1][x-1] = 1;
			
		}
		
		Deque<int[]> snake = new LinkedList<>();
		snake.addFirst(new int[] {0,0});
		int snakeHead = 0; //0동 1남 2서 3북
		
		int L = Integer.parseInt(br.readLine());//방향 전환
		int[] dir = new int[10001];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			if(d.equals("L")) dir[sec] = -1;
			else if(d.equals("D")) dir[sec] = 1;
			
		}
		
		int second = 0;
		while (true) {
			second++;
			
			int[] head =snake.peekFirst();
			
			int ny = head[0];
			int nx = head[1];
			if(snakeHead == 0) {//동
				nx += 1;
			} else if(snakeHead == 1) {//남
				ny += 1;
			} else if(snakeHead == 2) {//서
				nx -= 1; 
			} else if(snakeHead == 3) {//북
				ny -= 1;
			}
			
			//벽 부딪힘 check
			if(nx<0 || ny<0 || nx >=N || ny>=N) break;
			
			//몸통 부딪힘 check
			Iterator<int[]> iter= snake.iterator();
			boolean isBody = false;
			while (iter.hasNext()) {
				int[] tmp = iter.next();
				if(ny == tmp[0] && nx == tmp[1]) {
					isBody = true;
					break;
				}
			}
			if(isBody)break;
			

			snake.addFirst(new int[] {ny,nx});//머리 이동
			if(board[ny][nx] == 1) {
				board[ny][nx] = 0; //사과 삭제
			}else {
				snake.removeLast();//사과 안먹었으면 꼬리 이동
			}
			
			if(dir[second] != 0) {
				snakeHead += dir[second];
				if(snakeHead<0) snakeHead += 4;
				snakeHead %= 4;
			}
			 
		}
		
		System.out.println(second);
	}

}
