package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468  {
	
	static int N;
	static int[][] area;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N];

		int maxHeight = 0;
		int ans=1; //�ƹ������� ������ ��찡 �����Ƿ� ������ 1,,
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				
				maxHeight = Math.max(maxHeight, area[i][j]);
			}
		}
		
		
		for (int i = 1; i < maxHeight; i++) {
			int temp = bfs(i);
			ans = Math.max(ans, temp);
		}
		
		
		System.out.println(ans);
		
	}
	
	static int bfs(int h) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue<int[]> que = new LinkedList<int[]>();

		int areaCnt = 0;
		
		boolean[][] vis = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(area[i][j]>h && !vis[i][j]) {
					//bfs
					que.add(new int[] {i,j});	//y,x ��ǥ
					vis[i][j] = true;
					areaCnt++;
					
					while (!que.isEmpty()) {
						int[] temp = que.poll();
						
						for (int k = 0; k < 4; k++) {
							int ny = temp[0] + dy[k]; 
							int nx = temp[1] + dx[k];
							
							if(nx <0 || ny< 0 || nx >= N || ny >= N) continue;
							if(vis[ny][nx]) continue;
							if(area[ny][nx] <= h) continue;//��������̸� pass
							
							vis[ny][nx] = true;
							que.add(new int[] {ny,nx});
						}
						
					}
					
				}
			}
		}
		
		return areaCnt;
	}

}
