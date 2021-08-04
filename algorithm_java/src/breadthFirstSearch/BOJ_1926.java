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

		int n, m;
		int pictureCnt = 0;
		int maxArea = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Queue<int[]> Q = new LinkedList<>();

		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]); // 세로 y
		m = Integer.parseInt(input[1]); // 가로 x

		int[][] arr = new int[n][m];
		boolean[][] vis = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) { // 시작점 찾기
			for (int j = 0; j < m; j++) {

				if (arr[i][j] == 0 || vis[i][j] == true) {
					continue;
				}

				Q.add(new int[] { i, j });
				vis[i][j] = true;
				pictureCnt++;

				int pSize = 1;

				while (!Q.isEmpty()) { // BFS
					int[] temp = Q.poll();

					int y = temp[0];
					int x = temp[1];

					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];

						if (nx < 0 || ny < 0 || nx >= m || ny >= n)
							continue;
						if (vis[ny][nx] == true)
							continue;
						if (arr[ny][nx] == 0)
							continue;

						vis[ny][nx] = true;
						Q.add(new int[] { ny, nx });
						arr[ny][nx] = pSize++;
					}

				}
				maxArea = Math.max(maxArea, pSize);
				
			}
		}

		System.out.println(pictureCnt);
		System.out.println(maxArea);

		}
}
