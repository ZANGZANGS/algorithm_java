package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 숨바꼭질3
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.14	순간이동은 시간이 0초, 먼저 0초일 때 이동 다시킴.
 * 2021.09.14	우선순위 큐 풀이
 */
public class BOJ_13549 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[100001];
		Arrays.fill(arr, -1);
		
		PriorityQueue<int[]> Q = new PriorityQueue<>((a,b)-> a[1]-b[1]);
		
		
		Q.add(new int[] {N,0});
		arr[N] = 0;

		while (!Q.isEmpty()) {
			
			int[] temp =Q.poll();
			int cur = temp[0];
			int dist = temp[1];
		
			//순간이동
			if( 2*cur <= 100000) {
				
				if(arr[2*cur] == -1) {
					arr[2*cur] = dist;
					Q.add(new int[] {2*cur,dist});
				}else if(arr[2*cur] > dist) {
					arr[2*cur] = dist;
					Q.add(new int[] {2*cur,dist});
				}
			}
			

			for (int tar : new int[] {cur-1, cur +1}) {
				if(tar< 0 || tar > 100000) continue;
				if(arr[tar] != -1) continue;
				arr[tar] = dist+1;
				Q.add(new int[] {tar, dist+1});
			}
			
		}
		
		System.out.println(arr[K]);
		
	}

}
