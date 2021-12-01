package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 스타트와 링크
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.01	성공
 */
public class BOJ_14889 {

	static int N;
	static int[][] team;
	static boolean[] isUsed;
	static int[] select;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		team = new int[N][N];
		isUsed = new boolean[N];
		select = new int[N/2];

		StringTokenizer st; 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		teamRecursion(0);
		
		System.out.println(min);
	}
	
	
	private static void teamRecursion(int k) {
		if(k == N/2) {
			
			int[] start = new int[N/2];
			int[] link = new int[N/2];
			
			int stIdx = 0;
			int liIdx = 0;
			
			for (int i = 0; i < isUsed.length; i++) {
				if(isUsed[i]) {
					start[stIdx++] = i; 
				}else {
					link[liIdx++] = i;
				}
				
			}
			
			
			//점수 계산하기 start팀
			int startTeamPoint =0;
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					int l =start[i];
					int r =start[j];
					
					startTeamPoint += (team[l][r] + team[r][l]);
					
				}
			}
			//점수 계산하기 link팀
			int linkTeamPoint =0;
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					int l =link[i];
					int r =link[j];
					
					linkTeamPoint += (team[l][r] + team[r][l]);
					
				}
			}
			
			min = Math.min(Math.abs(startTeamPoint-linkTeamPoint), min);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(isUsed[i]) continue;
			if(k>0 && select[k-1] > i) continue;
			
			isUsed[i] = true;
			select[k] = i;
			teamRecursion(k+1);
			select[k] = -1;
			isUsed[i] = false;
			
		}
		
	}

}
