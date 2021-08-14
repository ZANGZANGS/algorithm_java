package floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_9205 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());//테스트 케이스
		
		for (int t = 0; t < testCase; t++) {
			
			int n = Integer.parseInt(br.readLine()); // 맥주파는 편의점 개수 n
			ArrayList<int[]> list = new ArrayList<int[]>();	//좌표정보 기록
			
			int[][] graph = new int[n+2][n+2];
			
			//좌표정보를 list에 저장
			for (int i = 0; i < n+2; i++) {
				String[] place = br.readLine().split(" ");
				int cov_x = Integer.parseInt(place[0]);
				int cov_y = Integer.parseInt(place[1]);
				list.add(new int[] {cov_x, cov_y});
			}
			
			//좌표정보를 토대로 갈 수 있는 거리인지 graph에 기록
			for (int i = 0; i < n+2; i++) {
				int[] start = list.get(i); //출발 좌표
				
				for (int j = 0; j < n+2; j++) {
					if(i == j) continue;
					int[] end = list.get(j); 	//도착좌표
					
					int dist = Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
					
					graph[i][j] = dist<=1000 ? dist : Integer.MAX_VALUE;// 거리가 1000을 넘어가면 갈 수 없는 길  
				}
			}
			
			//플루이드 워셜
			for (int k = 0; k < n+2; k++) {	//중간에 거치는 좌표
				for (int i = 0; i < n+2; i++) {//출발 좌표
					for (int j = 0; j < n+2; j++) {//도착좌표
						if(i == j) continue; //자기 자신 가는 것 pass
						if(graph[i][k] == Integer.MAX_VALUE 
								||graph[k][j] == Integer.MAX_VALUE) continue; //갈 수 없는 길이면 pass
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}
			
			//집-페스티벌 장소의 좌표 값 확인
			System.out.println(graph[0][n+1] != Integer.MAX_VALUE ? "happy" : "sad");
			
		}
	}

}
