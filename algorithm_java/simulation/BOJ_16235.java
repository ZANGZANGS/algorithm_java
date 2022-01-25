package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 나무 재테크
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.25	시간초과
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
		
		List<Integer>[][] tree  = new ArrayList[N][N];
		
		//상도가 심은 나무의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;//위에서 떨어진 칸 
			int y = Integer.parseInt(st.nextToken())-1;//왼쪽에서 떨어진 칸
			int z = Integer.parseInt(st.nextToken()); //나이
			
			if(tree[x][y] == null) {
				tree[x][y] = new ArrayList<Integer>();
			}
			
			tree[x][y].add(z);
		}
		
		//처음 땅에는 양분이 5씩 들어있다.
		int[][] map = new int[N][N];
		for (int[] m : map) {
			Arrays.fill(m, 5);
		}
		
		int year = 0;
		while(year < K) {
			//봄, 여름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(tree[i][j] == null || tree[i][j].size() == 0 ) {
						continue;
					}
					
					List<Integer> now = tree[i][j];
					Collections.sort(now); //나이순으로 정렬
					List<Integer> after = new ArrayList<Integer>();
					
					//봄
					while(!now.isEmpty()) {
						if(now.get(0)>map[i][j]) break;
						
						int age = now.remove(0);
						map[i][j] -= age;
						after.add(age+1); //1살 자란 나무
					}

					tree[i][j] = after;
					
					//여름
					while(!now.isEmpty()) {
						map[i][j] += now.remove(0)/2;
					}
					
				}
			}
			

			for (int i = 0; i < N; i++) { //r
				for (int j = 0; j < N; j++) { //c 
					
					if(tree[i][j] != null && tree[i][j].size() != 0) {
						long size = tree[i][j].stream().filter(v-> v%5 == 0).count();
						
						if(size > 0) {
							//가을
							for (int k = 0; k < 8; k++) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								
								if(nr<0 || nc< 0 || nr>=N || nc>= N) continue;
								
								if(tree[nr][nc] == null ) {
									tree[nr][nc] = new ArrayList<Integer>();
								}
								
								for (int t = 0; t < size; t++) {
									tree[nr][nc].add(1); //1살 나무 추가
								}
								
							}
						}
						
					}
					
					//겨울
					map[i][j] += A[i][j];
				}
			}
			
			year++; //년도 증가
		}
		
		int totalTree = 0;
		for (int i = 0; i < N; i++) { //r
			for (int j = 0; j < N; j++) { //c
				if(tree[i][j] == null ) {
					continue;
				}
				totalTree+=tree[i][j].size();
			}
		}
		System.out.println(totalTree);
		
	}

}
