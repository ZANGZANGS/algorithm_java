package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11728 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[n];	// 배열 A
		int[] arrB = new int[m];	// 배열 B

		int idxA = 0;	//배열 인덱스 A
		int idxB = 0;	//배열 인덱스 B
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arrA[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) arrB[i] = Integer.parseInt(st.nextToken());
		
		br.close();
		
		
		while (idxA <n || idxB <m) {
		
			if(idxA == n) {
				bw.write(arrB[idxB]+" ");
				idxB++;
				continue;
			}else if(idxB == m) {
				bw.write(arrA[idxA]+" ");
				idxA++;
				continue;
			}else if(arrA[idxA] > arrB[idxB]) {
				bw.write(arrB[idxB]+" ");
				idxB++;
			}else {
				bw.write(arrA[idxA]+" ");
				idxA++;
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

}
