package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class BOJ_1753 {
	
	private static final int INF = Integer.MAX_VALUE;
    static int v,e,k;
    static List<Node>[] graph;
    static int[] dist;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] in = br.readLine().split(" ");
		
		v = Integer.parseInt(in[0]); //정점
		e = Integer.parseInt(in[1]); //간선
		k = Integer.parseInt(br.readLine()); //출발점
		
		int[] distance = new int[v];
		graph = new ArrayList[v + 1];
		Arrays.fill(distance, INF);

		
		for (int i = 0; i < v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			in = br.readLine().split(" ");
			int U = Integer.parseInt(in[0]);
			int V = Integer.parseInt(in[1]);
			int W = Integer.parseInt(in[2]);
			
			graph[U-1].add(new Node(V, W));
		}
		
		br.close();
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		pQ.add(new Node(k,0));
		distance[k-1] = 0;
		
		boolean[] check = new boolean[v];
		
		while (!pQ.isEmpty()) {
			Node curNode = pQ.poll();
           int cur = curNode.end;

           if(check[cur-1] == true) continue;
           check[cur-1] = true;
			// 이미 처리된 노드이면 pass
//			if(distance[cur-1] < curNode.weight ) continue;
			
	        for(Node node : graph[cur-1]){
	               if(distance[node.end-1] > distance[cur-1] + node.weight){
	            	   distance[node.end-1] = distance[cur-1] + node.weight;
	                   pQ.add(new Node(node.end-1, distance[node.end-1]));
	               }
	           }
			
		}
		
		for(int i : distance) {
			if(i != Integer.MAX_VALUE) bw.append(i+"\n");
			else bw.append("INF\n");
		}
		bw.flush();
		
	}

}
