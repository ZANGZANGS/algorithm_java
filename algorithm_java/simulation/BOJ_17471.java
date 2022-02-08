package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 게리맨더링
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.02.08	성공
 */
public class BOJ_17471 {
	
	static int N;
	static List<Integer>[] map;
	static int min = Integer.MAX_VALUE;
	static int[] people;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new ArrayList[N]; 
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
			
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < t; j++) {
				int s = Integer.parseInt(st.nextToken())-1;
				map[i].add(s);
			}
		}
		
		for (int i = 1; i <= N/2; i++) {
			comb(0, i, new int[i], new boolean[N]);
		}
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	 

	private static void comb(int k, int lev, int[] arr, boolean[] isUsed) {
		if(k == lev) {
			int[] other = new int[N-arr.length];
			int idx = 0;
			for(int i=0;i<N;i++) {
				boolean is = true;
				for (int ar : arr) {
					if(i == ar)  {
						is = false;
						break;
					}
				}
				
				if(is) {
					other[idx] = i;
					idx++;
				}
			}
			
			if(bfs(arr) && bfs(other)) {
				int gap = 0;
				for (int i : arr) {
					gap +=people[i];
				}
				for (int i : other) {
					gap -=people[i];
				}
				
				min = Math.min(min, Math.abs(gap));
			}
			
			return;
		}
		
		for (int i = 0; i < isUsed.length; i++) {
			
			if(isUsed[i]) continue;
			if(k>0 && arr[k-1] > i) continue;
			isUsed[i] = true;
			arr[k] = i;
			comb(k+1, lev, arr, isUsed);
			isUsed[i] = false;
		}
		
	}
	
	private static boolean bfs(int[] arr) {
		boolean isConnet[] = new boolean[N];
		Queue<Integer> Q = new LinkedList<>();
		Q.add(arr[0]);
		isConnet[arr[0]] = true;
		
		while (!Q.isEmpty()) {
			int cur = Q.poll();
			
			if(map[cur].size() == 0) continue;
			
			for (Integer i : map[cur]) {
				if(isConnet[i]) continue;
				for(int t = 1 ; t < arr.length; t ++) {
					if(i == arr[t]) {
						isConnet[i] = true;
						Q.add(i);
					}
				}
				
			}
		}
		
		for (int ar : arr) {
			if(!isConnet[ar]) {
				return false;
			}
		}
		
		return true;
	}
}
