package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 치킨 배달
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.06	성공
 */
public class BOJ_15686 {
	
	static int N,M;
	static int[][] map;
	static List<int[]> chicken,home;
	static int[] store;
	static boolean[] isUsed;
	static int result = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		chicken = new ArrayList<>();
		home = new ArrayList<>();
				
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					home.add(new int[] {i,j});
				}else if(map[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
				
			}
			
		}
		
		store = new int[M];
		isUsed = new boolean[chicken.size()];
		bt(0);
		
		System.out.println(result);
		
	}
	
	private static void bt(int k) {
		if(k == M) {
			
			int[] homeDist = new int[home.size()];
			Arrays.fill(homeDist, Integer.MAX_VALUE);
			
			for (int storeNum: store) {
				int[] cur = chicken.get(storeNum);
				int cy = cur[0];
				int cx = cur[1];
				
				//치킨집과 모든 집과의 거리 계산
				
				for (int i=0; i<home.size(); i++) {
					int hy = home.get(i)[0];
					int hx = home.get(i)[1];
					
					int dist=Math.abs(cx-hx) + Math.abs(cy-hy);
					
					homeDist[i] = Math.min(dist, homeDist[i]);
				}
			}
			
			result = Math.min(result, Arrays.stream(homeDist).sum());
			return;
		}
		
		for (int i = 0; i < isUsed.length; i++) {
			if(isUsed[i]) continue;
			if(k>0 && store[k-1] > i) continue;
			
			isUsed[i] = true;
			store[k] = i;
			bt(k+1);
			isUsed[i] = false;
		}
	}

}
