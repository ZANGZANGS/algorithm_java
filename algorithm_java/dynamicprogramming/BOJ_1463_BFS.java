package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_BFS {
	
	static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//1. X가 3으로 나누어 떨어지면 3으로 나눈다.
		//2. X가 2로 나누어 떨어지면 2로 나눈다.
		//3. 1을 뺸다.
		
		cnt = 0;
		
		int[] dist = new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE); //배열 초기화
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(n);
		dist[n]=0;
		
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			if(idx < 1) continue;	//1이면 pass
			
			if(idx%3 == 0) {
				if(dist[idx/3] > dist[idx]+1) {
					dist[idx/3] = dist[idx]+1;
					queue.add(idx/3);
				}
			}
			
			if(idx%2 == 0) {
				if(dist[idx/2] > dist[idx]+1) {
					dist[idx/2] = dist[idx]+1;
					queue.add(idx/2);
				}
			}
			
			if(dist[idx -1] > dist[idx]+1) {
				dist[idx -1] = dist[idx]+1;
				queue.add(idx -1);
			}
			
		}
		
		System.out.println(dist[1]);
		
	}

}
