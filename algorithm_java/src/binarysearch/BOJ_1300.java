package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		int k =  Integer.parseInt(br.readLine());

		int start=1;
		int end=k;
		int ans = 0;	//찾고자 하는 수
		
		while(start <= end) {
			int mid = (start+end)/2;
			int idxCnt = 0;		//찾고자 하는 수의 인덱스
			
			for (int i = 1; i <= n; i++) {
				idxCnt += Math.min(mid/i, n);
			}
			
			if(idxCnt < k) {	//
				start = mid+1;
			}else {
				ans = mid;
				end = mid-1;
			}
		
		}
		System.out.println(ans);
	}
}
