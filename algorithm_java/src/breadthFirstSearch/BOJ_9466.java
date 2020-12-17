package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9466 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		
		for (int i = 0; i < round; i++) {
			int stuNumber = Integer.parseInt(br.readLine());
			int[] arr = new int[stuNumber+1];
			boolean[] vis = new boolean[stuNumber+1];
			int count=stuNumber;
			
			String[] input = br.readLine().split(" ");
			
			for (int j = 1; j < arr.length; j++) {
				//stack.clear();	//초기화
				int first = j;
				stack.add(first);
				
				if(vis[first]) continue;	//  이미 방문한 곳이면 continue
				
				while (! stack.isEmpty()) {
					int temp = stack.peek();
					int next = Integer.parseInt(input[temp-1]);
					
					if(vis[temp] || vis[next]) {
						stack.clear();
						break;	//  이미 방문한 곳이면 continue
					}
					
					if(first == next){
						stack.add(next);
						while (! stack.isEmpty()) {
							int aa = stack.pop(); 
							if(!vis[aa]) {
								vis[aa] = true; 
								 count--;
							 }
							
						}
					
					}else if(temp == next){
						stack.clear();
					}else if(first != next) {
						stack.add(next);
					} 
					
				}
				
			}
			
			
			System.out.println(count);
		}
	}
}
