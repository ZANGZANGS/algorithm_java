package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 그리디
 * @description	: 선 긋기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.28	성공
 */
public class BOJ_2170 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] line = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line,(a,b)->{
			if(a[1]==b[1]) {
				return a[0]-b[0]; //시작점 오름 차순
			}
			return b[1]-a[1];//끝점 내림 차순 (10, 7, 5, 1 ..)
		});
		
		int start = line[0][0]; 
		int end = line[0][1]; 
		int length = 0;
		
		for (int i = 1; i < N; i++) {
			if(start<=line[i][1] && line[i][1]<=end) {//새로운 선의 끝점이 연장되는 경우
				start =Math.min(start, line[i][0]); //start를 더 길게 바꾸고
			}else {
				length += end-start;
				start =line[i][0];
				end =line[i][1];
				
			}
			
		}
		
		length += end-start;
		System.out.println(length);
	}

}
