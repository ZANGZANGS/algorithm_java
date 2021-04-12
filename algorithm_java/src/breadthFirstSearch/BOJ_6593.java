package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int[] dx = new int[] {1,0,0,-1, 0, 0};
		int[] dy = new int[] {0,1,0, 0,-1, 0};
		int[] dz = new int[] {0,0,1, 0, 0,-1};
		
		
		int L = 0;
		int R = 0;
		int C = 0;
		char[][][] arr;
		int[][][] dist;
		
		int[] end = new int[] {0,0,0};
		Queue<int[]> que; 
		
		while (true) {
			
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());	//상범 빌딩의 층 수
			R = Integer.parseInt(st.nextToken());	//행
			C = Integer.parseInt(st.nextToken());	//열
			
			que = new LinkedList<int[]>();
			
			if(L == 0 && R == 0 && C == 0) break;
			
			arr = new char[L][R][C];
			dist = new int[L][R][C];
			
			for (int t = 0; t < L; t++) {	// 층수
				
				for (int i = 0; i < R; i++) {	//R
					String in = br.readLine();
					
					for (int j = 0; j < C; j++) {//C
						char at = in.charAt(j);
						arr[t][i][j] = at;
						
						if(at == 'S') {//출발
							que.add(new int[] {t,i,j});//출발점을 큐에 넣음
							dist[t][i][j] = 1;
						}else if(at == 'E') {//도착
							end = new  int[] {t,i,j};
						}
					}
					
				}
				br.readLine();
				
			}
			//bfs
			while (!que.isEmpty()) {
				
				int[] temp = que.poll();
				
				for (int k = 0; k < 6; k++) {
					int nz = temp[0] + dz[k];
					int ny = temp[1] + dy[k];
					int nx = temp[2] + dx[k];
					
					if(nx<0 || ny<0 || nz<0 || nx >= C || ny >= R || nz >= L ) continue;
					if(dist[nz][ny][nx] >0) continue; //이미 지나감
					if(arr[nz][ny][nx] == '#') continue; //벽
					
					
					que.add(new int[] {nz,ny,nx});
					dist[nz][ny][nx] = dist[temp[0]][temp[1]][temp[2]] + 1;
					
				}
				
				
			}
			
			System.out.println(dist[end[0]][end[1]][end[2]] == 0 ? "Trapped!" : "Escaped in "+(dist[end[0]][end[1]][end[2]]-1)+" minute(s).");
			
			
		}
		
		
	}

}
