package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1780 {
	
	static int N;
	static int[][] paper;
	static int[] result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		result = new int[3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		recursion(0,0,N);
		
		
		Arrays.stream(result).forEach(System.out::println);
		
	}
	
	private static void recursion(int x, int y, int k) {
		
		if(k == 0) return;
		
		int stNum = paper[y][x];
		
		for (int i = y; i < y+k; i++) {
			for (int j = x; j < x+k; j++) {
				if(stNum != paper[i][j]) {
					
					recursion(x,y,k/3);
					recursion(x+k/3,y,k/3);
					recursion(x+(k/3)*2,y,k/3);
					recursion(x,y+k/3,k/3);
					recursion(x,y+(k/3)*2,k/3);
					recursion(x+k/3,y+k/3,k/3);
					recursion(x+k/3,y+(k/3)*2,k/3);
					recursion(x+(k/3)*2,y+k/3,k/3);
					recursion(x+(k/3)*2,y+(k/3)*2,k/3);
					
					return;
				}
				
			}
			
		}
		
		result[stNum+1]++;
	}

}
