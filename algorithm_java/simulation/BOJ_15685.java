package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 드래곤 커브
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.20	성공
 */

public class BOJ_15685 {
	
	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
		
			map[y][x] = true;
			List<Integer> dir = new ArrayList<>();
			dir.add(d);
			dragonCurve(x, y, dir, 0, g);
			
		}
		
		int square = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				if(!map[i][j]) continue;
				if(!map[i+1][j]) continue;
				if(!map[i][j+1]) continue;
				if(!map[i+1][j+1]) continue;
				
				square++;
				
			}
		}
		
		System.out.println(square);
		
	}
	
	private static void dragonCurve(int x, int y, List<Integer> list, int gen, int targetGen) {
		
		if(gen == 0) {
			int dir = list.get(0);
			
			if(dir == 0) { //x증가하는 방향
				x++;
			} else if(dir == 1) { // y 감소하는 방향
				y--;
			} else if(dir == 2) {//x 감소
				x--;
			} else if(dir == 3) {//y 증가
				y++;
			}
			map[y][x] = true;
			
			if(gen == targetGen) return;
			
			dragonCurve(x, y, list, gen+1, targetGen);
			
		}else {
		
			int len = list.size();
			List<Integer> temp = new ArrayList<>();
			Stack<Integer> stk = new Stack<Integer>();

			for (int i = 0; i < len; i++) {
				int dir = list.get(i);
				int cur = (dir+1)%4;
				
				if(cur == 0) { //x증가하는 방향
					x++;
				} else if(cur == 1) { // y 감소하는 방향
					y--;
				} else if(cur == 2) {//x 감소
					x--;
				} else if(cur == 3) {//y 증가
					y++;
				}
				map[y][x] = true;
				stk.add(cur);
			}
			
			if(gen == targetGen) return;
			
			while (!stk.isEmpty()) {
				temp.add(stk.pop());
			}
			
			for (int i = 0; i < len; i++) {
				temp.add(list.remove(0));
			}
			
			dragonCurve(x,y, temp, gen+1, targetGen);
		}
		
		
		
		

		
		
	}

}
