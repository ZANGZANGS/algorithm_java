package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427  {

	static int[] dx = new int[] {1,0,-1,0};
	static int[] dy = new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); //�׽�Ʈ ���̽�
		
		
		for (int t = 0; t < n; t++) { //�׽�Ʈ ����

			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<int[]> que = new LinkedList<int[]>();
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[y][x];
			int[][] distFire = new int[y][x];
			int[][] distMan = new int[y][x];
			
			int startX=0, startY = 0;
			
			for (int i = 0; i < y; i++) {
				
				String input = br.readLine();
				
				for (int j = 0; j < x; j++) {
					map[i][j] = input.charAt(j);
				}
			}
				
			//fire bfs -> get distance
			for (int i = 0; i < y; i++) {//y
				for (int j = 0; j < x; j++) {//x
					
					if(map[i][j] == '*') {
						que.add(new int[] {i,j});
						distFire[i][j] =1;
					}
					
					if(map[i][j] == '@') {
						startX = j;
						startY = i;
					}
					
				}
			}
			while (!que.isEmpty()) {
				
				int[] temp = que.poll();
				//temp[0] -> Y  
				//temp[1] -> X
				
				for (int k = 0; k < 4; k++) {
					int nx = temp[1] + dx[k];
					int ny = temp[0] + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= x || ny >= y ) continue;
					if(distFire[ny][nx]>0) continue;
				

					if(map[ny][nx] != '#') {
						distFire[ny][nx] +=  distFire[temp[0]][temp[1]]+ 1;
						que.add(new int[] {ny,nx});
					}
					
				}
			}

			
			//��� �Ÿ� ���ϱ�
			que.clear();
			distMan[startY][startX] = 1;
			que.add(new int[] {startY, startX});
			int answer = 0;
			
			while (!que.isEmpty()) {
				
				int[] temp = que.poll();
				//temp[0] -> Y  
				//temp[1] -> X
				//�ⱸ üũ
				if(temp[1] == 0 || temp[0] == 0 || temp[1] == x-1 || temp[0] == y-1) {
					answer = distMan[temp[0]][temp[1]];
					que.clear();
					break;
				}
				
				for (int k = 0; k < 4; k++) {
					int nx = temp[1] + dx[k];
					int ny = temp[0] + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= x || ny >= y ) continue;
					if(distMan[ny][nx]>0) continue;
					if(distFire[ny][nx] != 0 && distFire[ny][nx] <= distMan[temp[0]][temp[1]]+1) continue; //�̹� ���� �������� ���̸� pass
				
					if(map[ny][nx] != '#') {
						distMan[ny][nx] +=  distMan[temp[0]][temp[1]]+ 1;
						que.add(new int[] {ny,nx});
					}
					
				}
				
				
			}
				
			System.out.println(answer !=0 ? answer : "IMPOSSIBLE");
		}
		
		
	}
	

}
