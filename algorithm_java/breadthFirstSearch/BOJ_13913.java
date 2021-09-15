package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 숨바꼭질4
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.15	이동경로를 출력해야하는 문제
 */
public class BOJ_13913 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] time = new int[100001];
		int[] loc = new int[100001];
		Arrays.fill(time, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.add(N);
		time[N] = 0;

		while (!Q.isEmpty()) {
			
			int cur =Q.poll();
		

			for (int tar : new int[] {cur-1, cur +1, 2*cur}) {
				if(tar< 0 || tar > 100000) continue;
				if(time[tar] != -1) continue;
				
				time[tar] = time[cur] +1;
				loc[tar] = cur; //이동하기 직전 위치
				Q.add(tar);
			}
			
		}
		
		System.out.println(time[K]);
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.add(K);
		int back = K;
		while (back != N) {
			stack.add(loc[back]);
			back = loc[back];
			
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
