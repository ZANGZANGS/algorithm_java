package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		int n = Integer.parseInt(st.nextToken());	//start	point
		int k = Integer.parseInt(st.nextToken());	//end point
		int[] dist = new int[100001];
		
		Arrays.fill(dist, -1);
		dist[n] = 0;
		
		Queue<Integer> Q = new LinkedList<>();
		Q.add(n);
		
		while (dist[k] == -1) {
			
			int cur = Q.poll();
			
			for (Integer next : new int[]{cur-1, cur+1, cur*2}) {
				if(next <0 || next>100000) continue;
				if(dist[next] != -1) continue;
				
				dist[next] = dist[cur]+1;
				Q.add(next);
			}
		}
		System.out.println(dist[k]);
	}
}
