package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: bfs
 * @description	: 팀 프로젝트
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.10 TODO 다시 풀자
 */
public class BOJ_9466 {
	
	static int n;
	static int arr[];
	static boolean vis[];
	static boolean done[];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine()); // 2 ~ 100,000
			
			arr = new int[n+1];
			vis = new boolean[n+1];
			done = new boolean[n+1];
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int j = 1; j <= n; j++) {
				if(done[j]) continue; //팀 구성 완료인 경우
				func(j);
			}
			
			
			System.out.println(n-result);
			
		}
	}
	
	private static void func(int cur) {
		
		if(vis[cur]) {
			done[cur] = true;
			result ++;
		}else {
			vis[cur] = true;
		}
		
		int next = arr[cur];
		if(!done[next]) func(next);
		
		vis[cur] = false;
		done[cur] = true;
		
		return;
	}
}
