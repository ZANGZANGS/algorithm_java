package depthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405 {

	static double[] ewsn = new double[4];
	static int[] dx ={1,-1,0,0};
	static int[] dy ={0,0,-1,1};
	
	
	static boolean[][] vis = new boolean[29][29];
	
	static int n;		//이동 횟수
	static double prob = 0; //확률 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 4; i++) {
			ewsn[i] = Integer.parseInt(st.nextToken())/100.0;
		}
		
		//0,0이 왼쪽 끝 .. 14, 14 가 중앙.. 28,28가 오른쪽 끝
		
		vis[14][14] = true;
		dfs(14,14,0,1.0);
		
		System.out.println(prob);
	}
	
	public static void dfs(int x, int y, int depth, double percent) {
		if(depth == n) {
			prob += percent;
			return;
		}
		
		//4방향 탐색
		for (int i = 0; i < 4; i++) {
			if(ewsn[i] == 0) continue; //확률인 0인 방향은 가지 않는다.
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(!vis[ny][nx]) {
				vis[ny][nx] = true;
				dfs(nx, ny, depth+1, ewsn[i]*percent);
				vis[ny][nx] = false;
			}
		}
	}
}
