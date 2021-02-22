package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11652 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());//100000 이하
		
		long[] arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);//quick sort;
		
		int cnt=1;
		int maxCnt = 1;
		long curNum = arr[0];
		
		for (int i = 1; i < n; i++) {
			if(arr[i] == arr[i-1]) {
				cnt++; 
			}else {
				cnt=1;
			}
			
			if(maxCnt<cnt) {
				maxCnt = cnt;
				curNum = arr[i];
			}
		}
		
		System.out.println(curNum);
		
	}

}
