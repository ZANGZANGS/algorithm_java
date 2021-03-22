package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206  {

	static int col;
	static int row;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<int[]> Q;
	
	//1. ���� ����
	static int[][] map;
	//2. �Ÿ�����
	static int[][] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		//1. ���� ����
		map = new int[col][row];
		//2. �Ÿ� ����
		dist = new int[col][row];
		
		Q = new LinkedList<>();
		
		//���� ���� �Է�
		for (int i = 0; i < col; i++) {
			char[] input = br.readLine().toCharArray();
			
			for (int j = 0; j < row; j++) {
				map[i][j] = input[j]-'0';
			}
		}
		
		dist[0][0] = 1;
		Q.add(new int[] {0,0,0});//x,y, �� ���� Ƚ��

		bfs();
		
		System.out.println(dist[col-1][row-1] == 0 ? "-1" :dist[col-1][row-1]);
	}
	
	static void bfs() {
		
		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				boolean isBroken = temp[2]==1 ? true : false;
				
				// ����1 ���� ������� Ȯ��
				if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
				
				//����2 �湮 ���� Ȯ��
				if(dist[ny][nx] > 0 && isBroken) continue;
				
				//����3 ���� �Ұ� ���� ������, �̹� ���� �μ�
				if(map[ny][nx] == 1 && isBroken) {
					continue;
					
				} 
				//����4 ���� �������� ���� �μ� �� ����
				if(map[ny][nx] == 1 && !isBroken) {
					dist[ny][nx] = dist[temp[1]][temp[0]]+1;
					Q.add(new int[] {nx,ny, 1});
					
				}
				
				//���̿��� ��� ����
				if(map[ny][nx] == 0 ) {//����
					dist[ny][nx] = dist[temp[1]][temp[0]]+1;
					Q.add(new int[] {nx,ny, temp[2]});
					
				}
			}
		
		}
	}
}
