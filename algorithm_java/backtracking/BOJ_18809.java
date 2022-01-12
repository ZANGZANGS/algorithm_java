package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @source		: baekjoon
 * @algorithm	: backtracking bfs
 * @description	: Gaaaaaaaaaarden
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.22	테케 8번이 혼자 틀린다.. 0%에서 틀리고 있다.
 * 2022.01.12	성공
 * 				BFS를 돌릴 때, 이미 큐에 들어온 좌표에 꽃이 피어있는지 확인한다.
 */
public class BOJ_18809 {

	static List<int[]> baeyang;
	static int N,M,G,R;
	
	static int[][] garden;
	static int[] selectBaeyang;
	static int[] selectGR;
	static boolean[] isUsedBaeyang;
	static int[] spotG, spotR;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //y
		M = Integer.parseInt(st.nextToken()); //x
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		
		garden = new int[N][M];

		
		// 0 - 호수, 못들어가는 땅
		// 1 - 배양액, 배양액을 뿌릴 수 없는 땅
		// 2 - 배양액을 뿌릴 수 있는 땅

		
		baeyang = new ArrayList<int[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				
				if(garden[i][j] == 2) {
					baeyang.add(new int[] {j,i}); //x,y
				}
			}
			
		}
		
		isUsedBaeyang = new boolean[baeyang.size()];
		spotG = new int[G];
		spotR = new int[R];
		
		Arrays.fill(spotG, -1);
		Arrays.fill(spotR, -1);
		
		findSpotG(0);
		
		System.out.println(max);
	}
	
	/**
	 * G 배양액 좌표를 백트래킹으로 구한다.
	 */
	static void findSpotG(int k) {
		if(k == G) {
			findSpotR(0); // G 배양액 좌표를 다 구하면, R 배양액 좌표를 구한다.
			return;
		}
		
		for (int i = 0; i < baeyang.size(); i++) {
			if(isUsedBaeyang[i]) continue;
			if(k > 0 && spotG[k-1] > i) continue;
			isUsedBaeyang[i] = true;
			spotG[k] = i;
			findSpotG(k+1);
			spotG[k] = -1;
			isUsedBaeyang[i] = false;
			
		}
	}
	
	/**
	 * R 배양액 좌표를 구한다.
	 */
	static void findSpotR(int k) {
		if(k == R) {
			bfs(); //G,R 배양액의 좌표를 가지고 BFS를 통해 꽃의 개수를 구한다.
			return;
		}
		
		for (int i = 0; i < baeyang.size(); i++) {
			if(isUsedBaeyang[i]) continue;
			if(k > 0 && spotR[k-1] > i) continue;
			isUsedBaeyang[i] = true;
			spotR[k] = i;
			findSpotR(k+1);
			spotR[k] = -1;
			isUsedBaeyang[i] = false;
			
		}
	}
	
	static void bfs() {
		int flower = 0;
		int[][] dist = new int[N][M];
		char[][] flw = new char[N][M];
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		for (int g : spotG) {
			int tmp[] = baeyang.get(g);
			int x = tmp[0];
			int y = tmp[1];
			
			flw[y][x] = 'G';
			dist[y][x] = 1;
			Q.add(new int[] {x,y, 0, 1}); // , G/R ,time;
		}
		
		for (int r : spotR) {
			int tmp[] = baeyang.get(r);
			int x = tmp[0];
			int y = tmp[1];
			
			flw[y][x] = 'R';
			dist[y][x] = 1;
			Q.add(new int[] {x,y, 1, 1});
		}
		
		// 0 - 호수, 못들어가는 땅
		// 1 - 배양액, 배양액을 뿌릴 수 없는 땅
		// 2 - 배양액을 뿌릴 수 있는 땅

			
		//초록 배양액 bfs
		while (!Q.isEmpty()) {
			int[] cur = Q.poll(); //x,y
			int x = cur[0];
			int y = cur[1];
			char color = cur[2] == 0 ? 'G' : 'R'; //G:0 , R:1
			int time = cur[3];
			
			if(flw[y][x] == 'F') continue; //중요! : 이미 큐에 들어온 좌표가 꽃이 되는 경우가 있다.
			
			for (int k = 0; k < 4; k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				
				if(nx<0 || ny<0 || nx>= M || ny >= N) continue;
				if(garden[ny][nx] == 0) {
					flw[ny][nx] = 'h';
					continue; //호수
				}
				if(flw[ny][nx] == 'F') continue; //이미 꽃이 피었다.
				if(flw[ny][nx] == color) continue; //같은 색상의 배양액
					
				//다른 색상의 배양색을 만날경우
				if(((color == 'G' && flw[ny][nx] == 'R')) || (color == 'R' && flw[ny][nx] == 'G')) {
					if(dist[ny][nx] == time+1) {
						flw[ny][nx] = 'F';
						flower++;
					}
					continue;
				}
				
				flw[ny][nx] = color;
				dist[ny][nx] = time+1;
				
				Q.add(new int[] {nx,ny, cur[2], time+1}); //x,y
			}
		}
		
		max = Math.max(flower, max);
		
		
	}

}


