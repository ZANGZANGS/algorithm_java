package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BOJ_2583 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] probInfo = br.readLine().split(" ");
		
		int m,n,k;
		
		m = Integer.parseInt(probInfo[0]);	// col ?
		n = Integer.parseInt(probInfo[1]);	// row ?
		k = Integer.parseInt(probInfo[2]);
		
		int[] dx = new int[] {0,1,0,-1};
		int[] dy = new int[] {1,0,-1,0};
		
		int count = 0;
		int size = 0;
		int[][] nemo = new int[n][m];
		boolean[][] vis = new boolean[n][m];
		List<Integer> list = new ArrayList<Integer>();
		boolean isSize = false;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		
		for (int i = 0; i < k; i++) {
			String[] input = br.readLine().split(" ");
			int x1, x2, y1, y2;
			x1 = Integer.parseInt(input[0]);
			y1 = Integer.parseInt(input[1]);
			x2 = Integer.parseInt(input[2]);
			y2 = Integer.parseInt(input[3]);
			
			for (int j = x1 ; j < x2 ; j++) {
				for (int p = y1 ; p < y2 ; p++) {
					nemo[j][p] = -1; //��
				}
			}
			
		}
		
		//bfs
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(nemo[i][j] == 0 && vis[i][j] == false) {
					
					queue.add(new int[] {i,j});
					vis[i][j] = true;
					count ++;
					size = 1;
				}
				
				while (!queue.isEmpty()) {
					isSize = true;
					int[] temp = queue.poll();
					
					for (int j2 = 0; j2 < 4; j2++) {
						int nx = temp[0]+dx[j2];
						int ny = temp[1]+dy[j2];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
						if(nemo[nx][ny] == -1) continue;	// ��
						if(vis[nx][ny]) continue;
						
						queue.add(new int[] {nx,ny});
						vis[nx][ny] = true;
						size++;
						
					}
				}
				
				if(isSize) {
					list.add(size);
					isSize=false;
				}
			}
		}
		
		
		System.out.println(count);
		list = list.stream().sorted().collect(Collectors.toList());	// ����
		for (int v : list) {
			System.out.print(v+" ");
		}
	}
	
}
