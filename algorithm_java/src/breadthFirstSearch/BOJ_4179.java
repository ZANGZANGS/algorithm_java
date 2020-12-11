package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4179 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R,C;
		String[][] miro;
		int[][] dist1;
		int[][] dist2;
		Queue<int[]> fQ = new LinkedList<int[]>();
		Queue<int[]> jQ = new LinkedList<int[]>();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		String miroSize = br.readLine();
		R = Integer.parseInt(miroSize.split(" ")[0]);
		C = Integer.parseInt(miroSize.split(" ")[1]);
		
		miro = new String[R][C];
		dist1 = new int[R][C];
		dist2 = new int[R][C];
		
		//������ �Է�
		for (int i = 0; i < R; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				miro[i][j] = input[j];
				
				if("J".equals(miro[i][j])) {
					dist2[i][j] = 1;
					jQ.add(new int[] {i,j});
					
				}
				else if("F".equals(miro[i][j])) {
					 dist1[i][j] = 1;
					 fQ.add(new int[] {i,j});
					 
				}
				else if(".".equals(miro[i][j])) {
					dist1[i][j] = -1;
					dist2[i][j] = -1;
				}
				
			}
		}
		
		//fire bfs
		while (!fQ.isEmpty()) {
			
			int[] loc = fQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = loc[0]+dx[i];
				int ny = loc[1]+dy[i];
				
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) continue;	// ������ ����� pass
				if("#".equals(miro[nx][ny])) continue;				// ���̸� pass
				if(dist1[nx][ny] >= 1) continue;					// �̹� ������ ����  pass
				
				dist1[nx][ny] = dist1[loc[0]][loc[1]]+1;
				fQ.add(new int[] {nx,ny});
			}
		}
		
		//Jihoon bfs
		while (!jQ.isEmpty()) {
			
			int[] loc = jQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = loc[0]+dx[i];
				int ny = loc[1]+dy[i];
				
				if(nx <0 || ny <0 || nx >= R || ny >= C) { 				// ������ ����� Ż��
					System.out.println(dist2[loc[0]][loc[1]]);
					return;
				}
				if("#".equals(miro[nx][ny])) continue;					// ���̸� pass
				if(dist2[nx][ny] >= 1) continue;						// �̹� ������ ����  pass
				if(dist1[nx][ny] != -1 && dist2[loc[0]][loc[1]]+1 >= dist1[nx][ny] ) continue;	// ���� ������ �ڸ��̸鼭 && ���� �Ÿ� ���� ������ �Ÿ��� ũ�ų� ������ pass
				
				
				
				dist2[nx][ny] = dist2[loc[0]][loc[1]]+1;
				jQ.add(new int[] {nx,ny});
			}
		}
		System.out.println("IMPOSSIBLE");	// ť�� �� ������� ���� ����
	}
}
