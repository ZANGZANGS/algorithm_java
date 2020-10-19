package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		int area = 0;
		
		// 색칠하기
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			// 넓이
			for (int k = X-1; k < X-1+10; k++) {
				for (int j = Y-1; j < Y-1+10; j++) {
					if(!paper[k][j]) {//색이 칠해져 있지 않은경우
						area ++;
						paper[k][j] = true;
					}
				}
			}
		}
		System.out.println(area);
	}
}
