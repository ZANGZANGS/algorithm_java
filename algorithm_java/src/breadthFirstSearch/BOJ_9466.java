package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {

	static int[] arr;
	static boolean[] vis;
	static boolean[] done;
	static int n;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			vis = new boolean[n+1];
			done = new boolean[n+1];
			result=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 1; j <= n; j++) {
				if(done[j]) continue;
				bfs(j);
			}
			
			System.out.println(n-result);
			
		}
				
		
	}
	static void bfs(int n) {
		
		if(vis[n]) {
			//이미 방문한 곳이면
			done[n] = true;
			result++;
		}else {
			vis[n]=true;
		}
		
		int next = arr[n];
		
		if(!done[next]) {
			bfs(next);
		}
		
		vis[n] = false;
		done[n] = true;
		
	}
}
