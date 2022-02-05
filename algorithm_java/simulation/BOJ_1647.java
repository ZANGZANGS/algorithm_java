package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 도시 분할 계획
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.02.04	실패
 * 2022.02.05	TODO 답지 보고 겨우 풀었음,, 다시 풀어보자
 */
public class BOJ_1647 {
	
	static int[] cycle;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		cycle = new int[N];
		for (int i = 0; i < N; i++) {
			cycle[i] = i;
		}
		
		int[][] road = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int C = Integer.parseInt(st.nextToken());
			road[i] = new int[]{A,B,C};
		}
		
		Arrays.sort(road,(a,b)->a[2]-b[2]);
		
		int count = 0;
		int total = 0;
		for (int[] cur : road) {
			
			if( count >=N-2) break;
			int y = cur[0];
			int x = cur[1];
			int val = cur[2];
			
			if(find(y) != find(x)) {
				total += val;
				count++;
				
				union(x, y);
			}
			
			
		}

		System.out.println(total);
		
	}
	
	private static int find(int tar) {
		
		if(tar == cycle[tar]) {
			return tar;
		}
		cycle[tar] = find(cycle[tar]);
		return cycle[tar];
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) cycle[y]=x;
	}

}
