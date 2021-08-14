package floydwarshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());	//도시의 개수
		int m = Integer.parseInt(br.readLine());	//버스의 개수
		StringTokenizer st;
		int[][] map = new int[n+1][n+1];
		
		//map 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		//map 경로 입력
		for (int i = 0; i < m; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());	//100,000 이하..
			
			map[a][b] = Math.min(map[a][b], c);
			
		}
		
		br.close();
		
		//워셜 플루이드
		for (int k = 1; k <= n; k++) {//거쳐가는 도시
			for (int i = 1; i <= n; i++) {//출발도시
				for (int j = 1; j <= n; j++) {//도착도시
					if(i == j) continue; //시작 출발이 같은 도시는 없다.
					if(map[i][k] == Integer.MAX_VALUE 
						|| map[k][j] == Integer.MAX_VALUE) continue;
					
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		//
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				bw.write(map[i][j] == Integer.MAX_VALUE ? "0 " : map[i][j]+" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}
		
}

