package hash;

import java.io.*;
import java.util.*;
/**
* @source		: baekjoon
* @algorithm	: 해시, iterator
* @description	: 수강신청
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.14	성공
*/
public class BOJ_13414 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Set<String> set = new LinkedHashSet<>();
		
		for (int i = 0; i < L; i++) {
			String key = br.readLine();
			
			if(set.contains(key)) {
				set.remove(key);
			}
			set.add(key);
		}
		
		 Iterator<String> iter = set.iterator();
		 
		 for (int i = 0; i < K; i++) {
			 if(iter.hasNext()) {
				 sb.append(iter.next());
				 sb.append("\n");
			 }
		 }

		 System.out.println(sb.toString());
	}

}
