package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nm = br.readLine();
		int inputN = Integer.parseInt(nm.split(" ")[0]);
		int inputM = Integer.parseInt(nm.split(" ")[1]);
		
		boolean vis[][] = new boolean[inputN][inputM];
		int picture[][] = new int[inputN][inputM];
		
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		int pictureMax = 0;
		int pictureCnt = 0;
		
		Queue<Pair> queue = new LinkedList<Pair>();
		
		for (int i = 0; i < inputN; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			
			for (int j = 0; j < inputM; j++) {
				
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//bfs
		for (int i = 0; i < inputN; i++) {
			for (int j = 0; j < inputM; j++) {
				if(picture[i][j] == 1 && !vis[i][j]) {
					
					vis[i][j] = true;
					queue.add(new Pair(i,j));
					
					pictureCnt++;
					int pictureSize=1;
					
					while (!queue.isEmpty()) {
						Pair pair = queue.poll();
						
						for(int dir=0; dir<4 ;dir++) {
							int nx = pair.x + dx[dir];
							int ny = pair.y + dy[dir];
							
							if(nx<0 || ny<0 || nx >= inputN || ny >= inputM) continue;
							if(vis[nx][ny] || picture[nx][ny] == 0) continue;
							
							vis[nx][ny] = true;
							queue.add(new Pair(nx, ny));
							pictureSize++;
						}
					}
					
					if(pictureMax < pictureSize) pictureMax = pictureSize;
				}
			}
		}
		
		System.out.println(pictureCnt);
		System.out.println(pictureMax);
		
	}
}

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
