package backtracking;

import java.io.*;
import java.util.ArrayList;
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
 * 2021.10.22	TODO 테케 8번이 혼자 틀린다.. 0%에서 틀리고 있다.
 */
public class BOJ_18809 {

	static List<int[]> baeyang;
	static int N,M,G,R;
	
	static int[][] garden;
	static int[] selectBaeyang;
	static int[] selectGR;
	static boolean[] isUsedBaeyang;
	static boolean[] isUsedGR;
	
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
		selectBaeyang = new int[G+R];

		isUsedGR = new boolean[G+R];
		selectGR = new int[G];
		
		
//		System.out.println("===========");
		recursionBaeyang(0);
		
		System.out.println(max);
	}
	
	private static void recursionBaeyang(int k) {
		if(k == G+R) {
			
			
//			StringBuilder sb = new StringBuilder();
//			
//			sb.append("배양액 찾기\n");
//			for (int is : selectBaeyang) {
//				sb.append(is);
//				sb.append(" ");
//			}
//			sb.append("\n");
//			sb.append("---------");
//			
//			System.out.println(sb.toString());
			
			recursionGR(0);
			
			return;
		}
		
		for (int i = 0; i < baeyang.size() ; i++) {
			
			if(k>0 && selectBaeyang[k-1] > i) continue;
			if(!isUsedBaeyang[i]) {
				isUsedBaeyang[i] = true;
				selectBaeyang[k] = i;
				recursionBaeyang(k+1);
				isUsedBaeyang[i] = false;
			}
			
			
		}
	}
	
	
	private static void recursionGR(int k) {
		if(k == G) {
//			StringBuilder sb = new StringBuilder();
//			
//			
//			for (int is : selectGR) {
//				sb.append(is);
//				sb.append(" ");
//			}
//			
//			System.out.println(sb.toString());
			
			BFS();
			
			return;
		}
		
		for (int i = 0; i < G+R; i++) {
			
			if(k>0 && selectGR[k-1] > selectBaeyang[i]) continue;
			if(!isUsedGR[i]) {
				isUsedGR[i] = true;
				selectGR[k] = selectBaeyang[i];
				recursionGR(k+1);
				isUsedGR[i] = false;
			}
			
		}
		
		
	}
	
	private static void BFS() {
		
		int bloomFlowers = 0;
		Queue<int[]> greenQ = new LinkedList<int[]>(); //x,y
		Queue<int[]> greenNextQ = new LinkedList<int[]>(); //x,y
		Queue<int[]> redQ = new LinkedList<int[]>(); //x,y 
		Queue<int[]> redNextQ = new LinkedList<int[]>(); //x,y 
		
		int[][] greenDist = new int[N][M];
		int[][] redDist = new int[N][M];
		boolean[][] isBloom = new boolean[N][M];
		
		for (int by : selectBaeyang) {
			
			int GR = 1;
			for (int gr : selectGR) {
				//G : 0		//R : 1
				if(by == gr) {
					GR = 0;
					break;
				}
			}

			int[] cur = baeyang.get(by);
			
			if(GR == 0) {
				greenQ.add(new int[] {cur[0], cur[1]});
				greenDist[cur[1]][cur[0]] = 1;
			}else {
				redQ.add(new int[] {cur[0], cur[1]});
				redDist[cur[1]][cur[0]] = 1;
			}
			
		}
		
		
		
		while (!greenQ.isEmpty() || !redQ.isEmpty()) {
			
			//green
			while (!greenQ.isEmpty()) {
				
				int[] info = greenQ.poll();
				int x = info[0];
				int y = info[1];
				
				if(isBloom[y][x]) continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = x+ dx[k];
					int ny = y+ dy[k];
					
					if(nx<0 || ny< 0 || nx>= M || ny >= N) continue;
					if(garden[ny][nx] == 0 ) continue;
					if(greenDist[ny][nx] > 0)continue;
					if(isBloom[ny][nx]) continue;
					
					if(redDist[ny][nx] >0) {
						if( redDist[ny][nx] == greenDist[y][x] + 1) { //꽃이 피다.
							bloomFlowers++;
							isBloom[ny][nx] = true; //더이상 배양하지 못하는 장소로 변환
						}
						continue;
					}
					greenNextQ.add(new int[] {nx,ny});
					greenDist[ny][nx] = greenDist[y][x] + 1;
				}
			}
			
			//red
			while (!redQ.isEmpty()) {
				
				int[] info = redQ.poll();
				int x = info[0];
				int y = info[1];
				
				if(isBloom[y][x]) continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = x+ dx[k];
					int ny = y+ dy[k];
					
					if(nx<0 || ny< 0 || nx>= M || ny >= N) continue;
					if(garden[ny][nx] == 0 ) continue;
					if(redDist[ny][nx] > 0)continue;
					if(isBloom[ny][nx]) continue;
					
					if(greenDist[ny][nx] >0) {
						if(greenDist[ny][nx] == redDist[y][x] + 1) { //꽃이 피다.
							bloomFlowers++;
							isBloom[ny][nx] = true; //더이상 배양하지 못하는 장소로 변환
						}
						continue;
					}
					redNextQ.add(new int[] {nx,ny});
					redDist[ny][nx] = redDist[y][x] + 1;
				}
			}
			
			if(!greenNextQ.isEmpty()){
				greenQ.add(greenNextQ.poll());
			}
			
			if(!redNextQ.isEmpty()){
				redQ.add(redNextQ.poll());
			}

		}
		

//		System.out.println("bloomFlowers: "+bloomFlowers);
		
		max = Math.max(bloomFlowers, max);
		
	}

}
