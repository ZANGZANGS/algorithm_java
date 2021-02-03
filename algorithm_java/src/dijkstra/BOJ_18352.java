package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); //도시의 개수 
		int m = Integer.parseInt(st.nextToken()); //도로의 개수
		int k = Integer.parseInt(st.nextToken()); //거리 정보
		int x = Integer.parseInt(st.nextToken()); //출발 번호
		
		//node data
		Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<>();
		for (int i = 0; i < m; i++) {
			char[] in = br.readLine().toCharArray();
			int node = in[0]-'0';
			int next = in[2]-'0';

			if(!graph.containsKey(node)) {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				lst.add(next);
				graph.put(node, lst);
				continue;
			}
			
			ArrayList<Integer> lst = graph.get(node);
			lst.add(next);
			graph.put(node, lst);
			
			
		}

		//거리를 최대값으로 초기화
		int[] distance = Arrays.stream(new int[n]) 
				.map(v-> Integer.MAX_VALUE).toArray(); 
		
		
		//PriorityQueue 생성	//int[] 거리, 노드 순서로 저장
		Comparator<int[]> comparator = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]>o2[0] ? 1 : -1;
			}
		};
		PriorityQueue<int[]> pQ = new PriorityQueue<>(comparator);
		
		pQ.add(new int[] {0, x});
		distance[x-1] = 0; //노드 번호 - 1== 거리 배열의 인덱스
		
		while (!pQ.isEmpty()) {
			int[] temp = pQ.poll();
			int dist = temp[0];
			int node = temp[1];
			
			//선택된 노드가 이미 처리된 노드라면 pass
			if(distance[node-1] < dist) continue;

			//선택된 노드에서 연결되는 길이 없으면 pass
			if(!graph.containsKey(node)) continue;
			
			//현재 노드와 연결된 다른 인접한 노드들을 확인
			ArrayList<Integer> lst = graph.get(node);
			for(int next : lst) {
				int cost = dist + 1;//모든 노드의 거리값이 1
				if(cost <distance[next-1]) {
					if(cost == k) sb.append(next+"\n");
					distance[next-1] = cost;
					pQ.add(new int[] {cost,next});
				}
			}
		}
		
		String result = sb.toString();
		System.out.println("".equals(result)?"-1":result);
		
	}
	

}
