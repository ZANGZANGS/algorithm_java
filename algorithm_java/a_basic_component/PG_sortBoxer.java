package a_basic_component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @source		: programmers
 * @algorithm	: sort
 * @description	: 복서 정렬하기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.07	2차원 배열 정렬하기
 */
public class PG_sortBoxer  {

	public static void main(String[] args) throws IOException{
		
		solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"});
		solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"});
		solution(new int[]{60,70,60}, new String[]{"NNN","NNN","NNN"});
		
	}
	
	 public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        int[][] boxer = new int[weights.length][4];
        
        for (int i = 0; i < weights.length; i++) {
        	int weight = weights[i];
        	int cnt = 0;
        	int win = 0;
        	int winbigman = 0;
        	
        	for (int j = 0; j < weights.length; j++) {
				char ch = head2head[i].charAt(j);
				
				if(ch != 'N') cnt++;
				if(ch == 'W') {
					win++;
					if(weights[i] <weights[j]) {
						winbigman++;
					}
				}
				
			}
        	
        	boxer[i][0] = i + 1 ; // 원본 인덱스 +1
        	boxer[i][1] = weights[i] ; // 몸무게
        	boxer[i][2] = cnt != 0 ? (int) ((1.0 *win/cnt) * 100000) : 0 ; // 승률
        	boxer[i][3] = winbigman; // 큰놈이랑 이긴 횟수
			
		}

        
        Arrays.sort(boxer, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) return o2[2]-o1[2]; //승률
				if(o1[3] != o2[3]) return o2[3]-o1[3]; //큰놈이랑 싸움
				if(o1[1] != o2[1]) return o2[1]-o1[1]; //몸무게
				return o1[0] - o2[0];
			}
		});
        
        for (int i = 0; i < boxer.length; i++) {
			answer[i] = (int)boxer[i][0]; //인덱스
			
		}
        return answer;
    }
	
}

