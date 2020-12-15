package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		
		n = Integer.parseInt(br.readLine());
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		char[][] nemo = new char[n][n];
		boolean[][] vis= new boolean[n][n];
		int count =0;
		int size = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		
		Queue<int[]> queue = new LinkedList<int[]>(); 
		
		//data
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				nemo[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(nemo[i][j] == '1' && !vis[i][j]) {
					queue.add(new int[]{i,j});
					vis[i][j] = true;
					count++;
					size++;
				}
				
				while (!queue.isEmpty()) {
					
					int[] temp = queue.poll();
					
					for (int k = 0; k < 4; k++) {
						int nx = temp[0] + dx[k];
						int ny = temp[1] + dy[k];
					
						if(nx<0 || ny <0 || nx >=n ||ny >=n ) continue;
						if(vis[nx][ny]) continue;
						if(nemo[nx][ny] == '0') continue;
						
						size++;
						queue.add(new int[] {nx,ny});
						vis[nx][ny] = true;
						
					}
				}
				
				if(size>0) {
					list.add(size);
					size = 0;
				}
				
			}
		}
		
		System.out.println(count);
		//list = list.stream().sorted().collect(Collectors.toList());	//Á¤·Ä
		Collections.sort(list);
		for (int num : list) {
			System.out.println(num);
		}
		
	}
}
