package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5052 {
	


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] arr = new String[n];
			String temp = "";
			boolean flag = true;
			
			for (int j = 0; j < n; j++) {
				temp = br.readLine();
				
				for (int k = 0; k < j; k++) {
					if(temp.indexOf(arr[k]) == 0) {
						flag = false;
						break;
					}
				}
				if(!flag) break;
				arr[j] = temp;
			}
			
			bw.write(flag ? "YES" : "NO");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
