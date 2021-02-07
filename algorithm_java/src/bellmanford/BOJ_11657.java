package bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node11657{
	int start;
	int end;
	int dist;
	
	public Node11657(int start, int end, int dist) {
		this.start = start;
		this.end = end;
		this.dist = dist;
	}
}

public class BOJ_11657 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //노드의 갯수  
		int m = Integer.parseInt(st.nextToken()); //간선의 갯수 
		
		List<Node11657> list = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
	
			list.add(new Node11657(start, end, dist));
		}
		
		bellmanFord(n, list);

	}
	
	static void bellmanFord(int n, List<Node11657> list) {
		
		boolean flag = false;
		
		long[] distance = new long[n+1];
	
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0; //자기자신 초기
		
		for (int i = 0; i < n; i++) {
			
			//모든 간선 확
			for (int j = 0; j < list.size(); j++) {
				int s = list.get(j).start;
				int e = list.get(j).end;
				int d = list.get(j).dist;
				
				if(distance[s] != Integer.MAX_VALUE && distance[e] > distance[s] + d) {
					distance[e] = distance[s] + d;
					
					if(i == n-1) flag = true; // 마지막 반복에서도 값이 갱신된다면 음의 순환 존재 
				}
				
			}
		}
		
		if(flag) {
			System.out.println("-1");
		}else {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 2; i <= n; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					sb.append("-1\n");
				}else {
					sb.append(distance[i]+"\n");
				}
			}
			
			System.out.println(sb.toString());
		}
		
		
	}

}
