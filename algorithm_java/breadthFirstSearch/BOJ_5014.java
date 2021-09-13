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
 * @description	: 스타트링크
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.13	이동가능한 층수는 1~ 100000이다.
 */
public class BOJ_5014  {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F =Integer.parseInt(st.nextToken()); //건물층수
		int S =Integer.parseInt(st.nextToken()); //start
		int G =Integer.parseInt(st.nextToken()); //end
		int U =Integer.parseInt(st.nextToken()); //up
		int D =Integer.parseInt(st.nextToken()); //down
		Queue<Integer> Q = new LinkedList<>();
		
		int[] dist = new int[F+1];
		Arrays.fill(dist, -1);
		
		Q.add(S);
		dist[S] = 0;
		
		while (!Q.isEmpty()) {
			int cur = Q.poll();
			
			for (int tar : new int[] {cur+U, cur-D}) {
				if(tar <=0 || tar >F) continue; // 0은 없는 층이다.
				if(dist[tar] != -1) continue; //이미 방문
				
				Q.add(tar);
				dist[tar] = dist[cur]+1;
			}
		}
		
		if(dist[G] == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(dist[G]);
		}
		
	}

}
