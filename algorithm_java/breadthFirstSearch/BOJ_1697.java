package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: 백준
 * @algorithm	: BFS
 * @description	: 숨바꼭질
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.09	10만을 안넘어가도록 범위 설정
 */
public class BOJ_1697 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//start	point
		int K = Integer.parseInt(st.nextToken());	//end point
		int[] dist = new int[100001];
		
		Queue<Integer> Q = new LinkedList<Integer>();
	
		
		Q.add(N);
		
		while (!Q.isEmpty()) {
			
			int cur = Q.poll();
			
			if(cur == K) break; // 수빈이가 동생을 찾음
			
			
			for (int tar : new int[] {cur-1,cur+1,cur*2}) {

				
				if(tar < 0 || tar > 100000) continue;
				if(dist[tar]> 0 ) continue;
				
				dist[tar] = dist[cur]+1;
				Q.add(tar);
			}
			
		}
		System.out.println(dist[K]);
	}
}
