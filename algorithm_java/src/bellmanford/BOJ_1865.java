package bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


class Node1865{
	int end;
	int weight;
	
	public Node1865(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}


public class BOJ_1865 {

	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); // 노드 
			int m = Integer.parseInt(st.nextToken()); // 양방향 간선 (도로) 
			int w = Integer.parseInt(st.nextToken()); // 단방향 간선 (웜홀)
			
			
			// 그래프 정보 생
			List<Node1865>[] graph = new ArrayList[n+1];
			
			//table 초기화
			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<>();
			}
			
			//도로 정보 입력 
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				//양방향 도로 이동 정보 
				graph[s].add(new Node1865(e,t));
				graph[e].add(new Node1865(s,t));
			}
			//웜홀 정보 
			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				//웜홀은 시간이 뒤로가므로 간선에 음수를 붙인다. 
				graph[s].add(new Node1865(e,-t));
			}
			
			BellmanFord(n, graph);
		}
	}
	
	public static void BellmanFord(int n, List<Node1865>[] graph) {		
		
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 1; i <= n; i++) {
			//출발점 i
			distance[i] = 0; //출발점 0으로 초기
			for (int j = 1; j <= n; j++) {//도착점 j
				
				List<Node1865> nodeList= graph[i];
				
				for(Node1865 node: nodeList) {
					int end = node.end;
					int weight = node.weight;
					
					int cost = 0;
				}
				
			}
			
			
			
		}
		
	}

}
