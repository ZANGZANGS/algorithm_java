package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: Puyo Puyo
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.17	성공
 */
public class BOJ_11559 {

	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		boolean isPosBroke = true;
		int count = -1;
		
		
		
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
			//R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
		}
		
		while(isPosBroke) {
			count++;
			isPosBroke = bfs();
			dropBuyo();
		}

		System.out.println(count);
	}
	
	
	public static boolean bfs() {
		int[] dx = new int[] {0,1,0,-1};
		int[] dy = new int[] {1,0,-1,0};
		
		boolean[][] vis = new boolean[12][6];
		Queue<int[]> Q = new LinkedList<>();
		
		int removeCount = 0;
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] == '.') continue;
				
				
				Q.add(new int[] {i,j}); //y,x
				vis[i][j] = true;

				List<int[]> list = new ArrayList<>();
				list.add(new int[] {i,j});
				
				while(!Q.isEmpty()) {
					int[] cur = Q.poll();
					
					int y = cur[0];
					int x = cur[1];
					
					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						
						if(nx<0 || ny<0 || nx>=6 || ny>=12) continue;
						if(vis[ny][nx]) continue;
						if(map[ny][nx] == '.') continue;
						if(map[ny][nx] != map[i][j]) continue; //다른 색상의 뿌요

						
						Q.add(new int[] {ny,nx});//y,x
						vis[ny][nx] = true;
						list.add(new int[] {ny,nx});
					}
				}
				
				
				//뿌요가 4개
				if(list.size()>=4) {
					removeCount++; //뿌요터진 횟수 증가
					
					while (!list.isEmpty()) {
						int[] cur = list.remove(0);
						map[cur[0]][cur[1]] = '.';
					}
				}
				
			}
		}
		
		return removeCount>0 ? true : false;
		
	}
	
	static public void dropBuyo() {
		
		Stack<Character> stk = new Stack<>();
		
		for (int j = 0; j < 6; j++) {
			
			for (int i = 0; i < 12; i++) {
				if(map[i][j] != '.') {
					stk.add(map[i][j]);
					map[i][j] = '.';
				}
				
			}
			
			int idx = 12;
			while (!stk.isEmpty()) {
				map[--idx][j] = stk.pop();
			}
		}
	}

}
