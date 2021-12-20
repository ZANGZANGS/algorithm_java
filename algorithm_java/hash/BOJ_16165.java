package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 해시
* @description	: 걸그룹 마스터 준석이
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.12.19	성공
*/
public class BOJ_16165 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		Map<String, String> memberMap = new HashMap<String, String>();
		Map<String, List<String>> teamMap = new HashMap<String, List<String>>();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String teamName = br.readLine();
			int num = Integer.parseInt(br.readLine());
			List<String> memberList = new ArrayList<String>();
			for (int j = 0; j < num; j++) {
				String memberName = br.readLine();
				
				memberMap.put(memberName, teamName);
				memberList.add(memberName);
				
			}
			
			teamMap.put(teamName, memberList);
			
		}
		
		for (int i = 0; i < M; i++) {
			String target = br.readLine();
			
			int zerone = Integer.parseInt(br.readLine());
			
			
			if(zerone ==1) {//팀 이름
				String targetTeam = memberMap.get(target);
				sb.append(targetTeam);
				sb.append("\n");
			}else {//멤버 이름
				teamMap.get(target)
				.stream()
				.sorted()
				.forEach(v->{
					sb.append(v);
					sb.append("\n");
				});
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
