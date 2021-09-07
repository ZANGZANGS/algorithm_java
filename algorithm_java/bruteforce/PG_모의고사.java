package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source		: programmers
 * @algorithm	: bruteforce
 * @description	: 모의고사
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.07
 */
public class PG_모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[] {1,2,3,4,5});
		solution(new int[] {1,3,2,4,2});
	}
	
	public static int[] solution(int[] answers) {
        
		int[] supoja1 = {1,2,3,4,5};
		int[] supoja2 = {2,1,2,3,2,4,2,5};
		int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};
		
		
		int[] Idx = new int[3];
		int[] Cnt = new int[3];
		
		
		for (int i = 0; i < answers.length; i++) {
			
			//수포자 1
			if(Idx[0] >= supoja1.length) Idx[0] = 0;
			if(Idx[1] >= supoja2.length) Idx[1] = 0;
			if(Idx[2] >= supoja3.length) Idx[2] = 0;
			
			if(answers[i] == supoja1[Idx[0]++]) Cnt[0]++;
			if(answers[i] == supoja2[Idx[1]++]) Cnt[1]++;
			if(answers[i] == supoja3[Idx[2]++]) Cnt[2]++;
			
		}
		
		int maxCnt = Arrays.stream(Cnt).max().getAsInt();
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < Cnt.length; i++) {
			if(Cnt[i] == maxCnt) {
				list.add(i);
			}
		}
		
		
        return list.stream().mapToInt(v -> v+1).toArray();
    }

}
