package floydwarshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11403 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());	//도시의 개수
		int[][] graph = new int[n+1][n+1];
		
		//데이터 입력
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			
			for (int j = 1; j <=n; j++) {
				graph[i][j]= input[j-1].equals("1") ? 1 : Integer.MAX_VALUE;
			}
		}
		
		br.close(); //BufferedReader close
		
		//플루이드 워셜
		for (int k = 1; k <=n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(graph[i][k]==Integer.MAX_VALUE
							||graph[k][j] == Integer.MAX_VALUE) continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		//출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(graph[i][j] == Integer.MAX_VALUE) bw.write("0 ");
				else bw.write("1 ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}

}
