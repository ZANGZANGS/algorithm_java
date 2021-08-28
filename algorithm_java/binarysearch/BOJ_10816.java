package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BOJ_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stringTokenizer;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		stringTokenizer = new StringTokenizer(br.readLine());	
		for (int i = 0; i < N; i++) {
			
			int number = Integer.parseInt(stringTokenizer.nextToken());
			
			Integer tar = map.get(number);
			
			if(null == tar) {	//처음이면
				map.put(number, 1);
			}else {
				map.put(number, tar+1);
			}
			
		}
		
		int M = Integer.parseInt(br.readLine());
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			
			int number = Integer.parseInt(stringTokenizer.nextToken());
			Integer tar = map.get(number);
			
			if(null == tar) {
				sb.append("0 ");
			}else {
				sb.append(String.valueOf(tar)+" ");
			}
			
		}
		System.out.println(sb.toString().trim());
	}
}
