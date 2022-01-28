package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 연구소 2
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.28	성공
 */
public class BOJ_17141 {
	static int N,M,time;
	static int[][] lab;
	static List<int[]> curVirus, emptyBolck;
	static boolean[] isUsed;
	static int[] result;
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		lab = new int[N][N];
		curVirus = new ArrayList<int[]>();
		emptyBolck = new ArrayList<int[]>();
		time = Integer.MAX_VALUE;
		result = new int[M];
		
		for (int i = 0; i < N; i++) {
			st = new  StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				lab[i][j] = Integer.parseInt(st.nextToken());
				
				if(lab[i][j] == 2) {
					curVirus.add(new int[] {i,j});
				}
				if(lab[i][j] != 1) {
					emptyBolck.add(new int[] {i,j});
				}
			}
		}
		
		isUsed = new boolean[curVirus.size()];
		
		bt(0);
		if(time == Integer.MAX_VALUE) time = -1;
		System.out.println(time);
	}
	

	
	private static void bt(int k) {
		if(k == M) {
			bfs();
			return;
		}
		
		for (int i = 0; i < curVirus.size(); i++) {
			if(isUsed[i]) continue;
			if(k>0 && result[k-1] > i) continue;
			
			isUsed[i] = true;
			result[k] = i;
			bt(k+1);
			isUsed[i] = false;
			
		}
		
	}
	
	private static void bfs() {
		int[][] dist = new int[N][N];
		for (int[] col : dist) {
			Arrays.fill(col, -1);
		}
		
		Queue<int[]> Q = new LinkedList<int[]>();
		for (int idx : result) {
			int[] cur = curVirus.get(idx);
			Q.add(cur);
			
			dist[cur[0]][cur[1]] = 0; //바이러스
		}
		
		while (!Q.isEmpty()) {
			 int[] cur = Q.poll();
			 
			 int y = cur[0];
			 int x = cur[1];
			 
			 for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(lab[ny][nx] == 1) continue;
				if(dist[ny][nx]>-1) continue;
				
				Q.add(new int[] {ny,nx});
				dist[ny][nx] = dist[y][x] +1;
			}
		}
		
		int bfsTime=0;
		for (int[] cur : emptyBolck) {
			if(dist[cur[0]][cur[1]] == -1)return;
			bfsTime = Math.max(bfsTime, dist[cur[0]][cur[1]]);
		}
		
		time = Math.min(bfsTime, time);

	}

}
