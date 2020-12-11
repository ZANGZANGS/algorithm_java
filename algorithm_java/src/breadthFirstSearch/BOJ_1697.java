package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class BOJ_1697 {

	public static void main(String[] args) throws IOException{
		int n,k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input.split(" ")[0]);
		k = Integer.parseInt(input.split(" ")[1]);
		
		int[] dist = new int[100001];	// ����!! �����̰� �����̴� ������ 0 �� N �� 100,000 �̴�!
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		
		while (! queue.isEmpty()) {
			
			int temp = queue.poll();
			
			if(temp==k) {
				System.out.println(dist[temp]);
				return;
			}

			//1. ��ĭ�̵� +
			if(temp+1 <100001 && dist[temp+1] == 0){
				queue.add(temp+1);
				dist[temp+1] = dist[temp]+1;
				
			}
			//2. ��ĭ�̵� -
			if(temp-1 >=0 && dist[temp-1] == 0){
				queue.add(temp-1);
				dist[temp-1] = dist[temp]+1;
				
			}
			//3. �����̵� 2���̵�
			if(2*temp < 100001 && dist[2*temp] == 0){
				queue.add(2*temp);
				dist[2*temp] = dist[temp]+1;
				
			}
				
		}
		
	}

}
