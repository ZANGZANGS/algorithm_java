package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15688 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] countArr = new int[2000001];
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			countArr[Integer.parseInt(br.readLine())+1000000]++;
		}
		
		br.close();
		
		for (int i = 0; i < countArr.length; i++) {
			if(countArr[i] == 0) continue;
			
			for (int j = 0; j < countArr[i]; j++) {
				bw.append(String.valueOf(i-1000000)+"\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

}
