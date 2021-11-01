package z_coding.test.y2021.nf;

import java.io.IOException;
import java.util.*;

public class SOL_03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] temp = solution(new String[] {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"});
		
		for (String st : temp) {
			System.out.println(st);
		}
	}

	public static String[] solution(String[] logs) throws IOException{
        String[] answer = {};
        
        Set<String> result = new HashSet<String>();
        
        //수험번호 - 문제 번호 - 받음 점수
        
        Map<String, int[]> idMap = new HashMap<>();
        
        
        for (String log : logs) {
			
        	StringTokenizer st = new StringTokenizer(log);
        	
        	String id = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
        	int score = Integer.parseInt(st.nextToken());
        
        	
        	if(!idMap.containsKey(id)) {
        		int[] ans = new int[101];
        		Arrays.fill(ans, -1); // -1로 초기화
        		ans[num] = score;
        		idMap.put(id, ans);	
        	}else {
        		int[] ans = idMap.get(id);
        		ans[num] = score;
        		idMap.put(id, ans);
        		
        	}
        	
		}
        
        String[] keys = idMap.keySet().toArray(new String[]{});
        
        for (int i = 0; i < keys.length; i++) {
        	for (int j = i+1; j < keys.length; j++) {
				
				
        		
        		int[] ans1 = idMap.get(keys[i]);
        		int[] ans2 = idMap.get(keys[j]);
        		
        		int eqSolve = 0; //동일 번호 문제를 푼 것
        		
        		for (int k = 1; k <= 100; k++) {
					if(ans1[k] == -1) continue; //문제를 안풀음
					
					if(ans1[k] == ans2[k]) eqSolve++;
					
				}
        		
        		if(eqSolve < 5) continue;
        		
        		if(eqSolve >= 5) {
        			result.add(keys[i]);
        			result.add(keys[j]);
        		}
				
				
			}
        	
			
		}
        
        if(result.size() >0) {
        
        	answer = result.toArray(new String[] {});
            Arrays.sort(answer);
        }else {
        	answer = new String[] {"None"};
        }
        
        
        
        return answer; 
        
        
        
    }
}
