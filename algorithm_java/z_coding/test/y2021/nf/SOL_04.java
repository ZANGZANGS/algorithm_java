package z_coding.test.y2021.nf;

import java.util.LinkedList;
import java.util.*;

public class SOL_04 {

	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		
		arr[0] = new int[] {1, -7, -2, 1, -1};
		arr[1] = new int[] {2, 3, 0, -1, -2};
		arr[2] = new int[] {1, -1, 6, -1, -2};
		arr[3] = new int[] {-1, 1, -2, 0, 4};
		arr[4] = new int[] {-10, 5, -3, -1, 1};
		
		//[1, -7, -2, 1, -1],
		//[2, 3, 0, -1, -2],
		//[1, -1, 6, -1, -2]
		//[-1, 1, -2, 0, 4]
		//[-10, 5, -3, -1, 1]
		
		System.out.println(solution(arr));

	}

	 public static int solution(int[][] board) {
	        
	        int n = board[0].length;
	        
	        int[][] score = new int[n][n];
	        boolean[][] isNotFirst = new boolean[n][n];
	        
	        int[] dx = new int[]{1,0};
	        int[] dy = new int[]{0,1};
	        
	        score[0][0] = board[0][0];
	               
	        Queue<int[]> Q = new LinkedList<>();
	        
	        Q.add(new int[] {0,0});
	        
	        while (!Q.isEmpty()) {
				int[] cur = Q.poll();
				
				int x = cur[0];
				int y = cur[1];
				
	        	
	        	for (int k = 0; k < 2; k++) {
					
	        		int nx = x + dx[k];
	        		int ny = y + dy[k];
	        		
	        		if(nx>=n || ny>=n) continue; //범위를 벗어남.
	        		
	        		int newScore = 0;
	        		
	        		if(board[ny][nx] == 0 ) {
	        			newScore = score[y][x]<0 ? score[y][x]*( -1) : score[y][x]; //부호 바꾸기
	        		}else {
	        			newScore = score[y][x] + board[ny][nx];
	        		}
	        		
	        		if(isNotFirst[ny][nx]) {//재방문인경우
	        			score[ny][nx] = Math.max(score[ny][nx], newScore);
	        		}else {//처음인경우
	        			score[ny][nx] = newScore;
	        			isNotFirst[ny][nx] = true;
	        		}
	        		
	        		Q.add(new int[] {nx,ny});
				}
				
			}
	        
	        
	        
	        
	        return score[n-1][n-1];
	 }
	
}
