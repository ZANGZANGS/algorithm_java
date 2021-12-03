package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 상어 초등학교
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.03	성공
 */
public class BOJ_21608 {
	
	public static void main(String[] args) throws IOException{
		final int dx[] = new int[] {0,1,0,-1};
		final int dy[] = new int[] {1,0,-1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] fav = new int[N*N][5];
		int[][] classRoom = new int[N][N];
		
		
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				fav[i][j] = Integer.parseInt(st.nextToken()); 
			}
			
		}
		
		
		for (int[] likes : fav) {
			int tar = likes[0];
			int[][] score = new int[N][N];
			List<int[]> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(classRoom[i][j] >0) continue;
					
					int likePos = 0;
					int emtyPos = 0;
					
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(nx<0 || ny<0 || nx>=N ||ny>=N) continue;
						
						if(classRoom[ny][nx] == 0) {
							emtyPos++;
							continue;
						}else {
							for(int like : Arrays.copyOfRange(likes, 1, 5)) {
								if(classRoom[ny][nx] == like) {
									likePos++;
									break;
								}
							}
							
						}
						
					}
					
					list.add(new int[] {i,j,likePos, emtyPos});
					
				}
			}
			
			//최적 좌표찾기
			int[] fitPos = (int[])list.stream()
					.max((a,b)-> {
						if(a[2]-b[2]==0) {//좋아하는 친구 근접 개수
							
							if(a[3]-b[3]==0) { //빈 공간 개수
								if(a[0]-b[0] == 0) { //row
									return b[1]-a[1];	//col  
								}else {
									return b[0]-a[0];
								}
							}else {
								return a[3]-b[3]; 
							}
							
						}else {
							return a[2]-b[2]; 
						}
						
						
						
					})
					.get();
			
			classRoom[fitPos[0]][fitPos[1]] = tar;
		}
		
		
		Arrays.sort(fav,(a,b)->a[0]-b[0]);
		
		//만족도 계산
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int student = classRoom[i][j];
			
				int count = 0;
				
				for (int s = 1; s < 5; s++) {
					
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];

						if(nx<0 || ny<0 || nx>=N ||ny>=N) continue;
						
						if(fav[student-1][s] == classRoom[ny][nx]) {
							count++;
							break;
						}
					}
				}
				
				if(count > 0) {
					total += (int)Math.pow(10, count-1);
				}
			}
		}
		System.out.println(total);
	}
}
