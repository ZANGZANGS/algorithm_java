package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;


/**
 * @source		: baekjoon
 * @algorithm	: recursion
 * @description	: 별 찍기 - 10
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.29
 */
public class BOJ_2447 {

	
	
	
	static char[][] stars;
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		
		for (char[] starline : stars) {
			Arrays.fill(starline, '*');
		}
		
		recursion(0,0,N);
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void recursion(int x, int y, int k) {
		
		int next = k/3; //  
		
		if(next == 0) {
			return;
		}
		
		
		for (int i = y + next; i < y+2*next; i++) {
			for (int j = x + next; j < x+2*next; j++) {
				stars[i][j] = ' ';
				
			}
		}
		
		recursion(x, y ,next);
		recursion(x+next, y ,next);
		recursion(x+2*next, y ,next);
		
		recursion(x, y+next ,next);
		recursion(x+2*next, y+next ,next);
		
		recursion(x, y+2*next ,next);
		recursion(x+next, y+2*next ,next);
		recursion(x+2*next, y+2*next ,next);
		
	}

}
