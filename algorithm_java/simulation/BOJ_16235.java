package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 나무 재테크
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.25	시간초과
 * 2022.01.25	성공 (우선순위 큐를 활용하여 시간 단축)
 */
public class BOJ_16235 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dr = new int[] {-1,-1,-1,0,0,1,1,1};
		int[] dc = new int[] {-1,0,1,-1,1,-1,0,1};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//양분 정보
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
//		List<Integer>[][] tree  = new ArrayList[N][N];
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b)-> a[2]-b[2]); //나이가 적은 순으로 정렬
		//상도가 심은 나무의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;//위에서 떨어진 칸 
			int y = Integer.parseInt(st.nextToken())-1;//왼쪽에서 떨어진 칸
			int z = Integer.parseInt(st.nextToken()); //나이
		
			pQ.add(new int[] {x,y,z});
		}
		
		//처음 땅에는 양분이 5씩 들어있다.
		int[][] map = new int[N][N];
		for (int[] m : map) {
			Arrays.fill(m, 5);
		}
		
		int year = 0;
		while(year < K) {
			//봄, 여름
			Queue<int[]> summerQ = new LinkedList<>(); 
			Queue<int[]> nextQ = new LinkedList<>(); 
			while (!pQ.isEmpty()) {
				int[] cur = pQ.poll();
				int r = cur[0];
				int c = cur[1];
				int age = cur[2];
				
				if(map[r][c] < age) {
					summerQ.add(cur);
				}else {
					map[r][c] -= age;
					nextQ.add(new int[] {r,c,age+1});
				}
				
			}
			//여름
			while(!summerQ.isEmpty()) {
				int[] cur = summerQ.poll();
				int r = cur[0];
				int c = cur[1];
				int age = cur[2];
				
				map[r][c] += age/2;
			}
			
			//가을
			while(!nextQ.isEmpty()) {
				int[] cur = nextQ.poll();
				int r = cur[0];
				int c = cur[1];
				int age = cur[2];

				pQ.add(cur);
				
				//번식
				if(age%5 == 0) {
					for (int k = 0; k < 8; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						
						if(nr<0 || nc<0 || nc >= N || nr >= N) continue;
						
						pQ.add(new int[] {nr,nc,1});
						
					}
				}
			}

			for (int i = 0; i < N; i++) { //r
				for (int j = 0; j < N; j++) { //c 
					//겨울
					map[i][j] += A[i][j];
				}
			}
			
			year++; //년도 증가
		}
		
		System.out.println(pQ.size());
		
	}

}
