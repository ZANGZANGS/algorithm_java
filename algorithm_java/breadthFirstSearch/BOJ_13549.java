package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 숨바꼭질3
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.14	순간이동은 시간이 0초, 먼저 0초일 때 이동 다시킴.
 */
public class BOJ_13549 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[100001];
		Arrays.fill(arr, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.add(N);
		arr[N] = 0;

		while (!Q.isEmpty()) {
			
			int cur =Q.poll();
		
			if(2*cur <= 100000 && arr[2*cur] == -1) {
				for (int i = cur; i < arr.length; i=2*i) {
					if(arr[i] != -1) continue;
					
					arr[i] = arr[cur];
					Q.add(i);
				}
			}
			


			for (int tar : new int[] {cur-1, cur +1}) {
				if(tar< 0 || tar > 100000) continue;
				if(arr[tar] != -1) continue;
				
				arr[tar] = arr[cur]+1;
				Q.add(tar);
			}
			
		}
		
		System.out.println(arr[K]);
		
	}

}
