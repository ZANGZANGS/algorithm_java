package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: hash set
 * @description	: 회사에 있는 사람
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.09	성공
 */
public class BOJ_7785 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String key = st.nextToken();
			String inout = st.nextToken();
			
			
			if(inout.equals("enter")) {
				set.add(key);
			}else{
				set.remove(key);
			}
		}
		
		String[] names = set.stream()
				.sorted(Collections.reverseOrder())
				.toArray(String[]::new);
		
//		for (String name : names) {
//			sb.append(name);
//			sb.append("\n");
//		}
//		
//		System.out.println(sb.toString());
		System.out.println(String.join("\n", names));
		
	}
	
	

}
