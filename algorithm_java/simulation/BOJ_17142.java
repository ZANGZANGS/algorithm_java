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
 * @description	: 연구소 3
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.02.03	BFS
 * 				비활성화 바이러스 처리가 관건
 */
public class BOJ_17142 {

	static int N,M, time;
	static List<int[]> list;
	static int[] virus;
	static boolean[] isUsed;
	static int[][] lab;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new int[M];
		list = new ArrayList<int[]>();
		lab = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					list.add(new int[] {i,j});
				}
			}
			
		}
		//퍼지는데 비활성이면 안가냐
		isUsed = new boolean[list.size()];
		time = Integer.MAX_VALUE;
		bt(0);
		
		if(time == Integer.MAX_VALUE)time = -1;
		System.out.println(time);
	}
	
	public static void bt(int k) {
		if(k == M) {
			bfs();
			return ;
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			if(isUsed[i]) continue;
			if(k>0 && virus[k-1]>= i) continue;
			isUsed[i] = true;
			virus[k] = i;
			bt(k+1);
			isUsed[i] = false;
		}
	}
	
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};
	
	public static void bfs() {
	
		Queue<int[]> Q = new LinkedList<int[]>();
		
		int[][] dist = new int[N][N];
		for (int[] is : dist) {
			Arrays.fill(is, -1);
		}
		
		for (int idx : virus) {
			int tmp[] = list.get(idx);
			dist[tmp[0]][tmp[1]] = 0;
			Q.add(new int[] {tmp[0],tmp[1]}); //y,x,dist;
		}

		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(lab[ny][nx] == 1) continue; //벽
				if(dist[ny][nx]>-1) continue;
				
				
				dist[ny][nx] = dist[y][x]+1;
				Q.add(new int[] {ny,nx});
				
			}
		}

		for (int[] cur : list) {
			dist[cur[0]][cur[1]] = 0;
		}
		
		//
		
		int sec = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(lab[i][j] == 1) continue;
				else {
					if(dist[i][j] == -1) return;
					sec = Math.max(sec, dist[i][j]);
				}
				
			}
			
		}

		time = Math.min(time, sec);

	}
}
