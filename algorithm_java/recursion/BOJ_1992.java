package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {

	static int[][] video;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		video = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < N; j++) {
				video[i][j] = temp.charAt(j) - '0';
			}
			
		}
		
		recursion(0,0,N);
		
		System.out.println(sb.toString());
	}
	
	private static void recursion(int x, int y, int k) {
		
		if(k == 0) {
			return ;
		}
		
		int pixel = video[y][x];
		
		for (int i = y; i < y+k; i++) {
			for (int j = x; j < x+k; j++) {
				if(pixel != video[i][j]) {
					
					sb.append("(");
					recursion(x,y,k/2);
					recursion(x+k/2,y,k/2);
					recursion(x,y+k/2,k/2);
					recursion(x+k/2,y+k/2,k/2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(pixel);
		return;
	}

}
