package z_coding.text.y2021.kmong;

import java.util.*;
import java.io.*;

public class SOL_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {2, 1, 3, 2, 2}, 2));
		System.out.println(solution(new int[] {3, 9, 5, 3, 2, 2}, 0));
	}
	
	private static int solution(int[] priorities, int location) {

		int answer = 0;
		int seq = 1; //처리 순서
		int[] prioritiesCnt = new int[10];
		Queue<int[]> Q = new LinkedList<int[]>(); // index, priority
		
		for (int idx = 0; idx < priorities.length; idx++) {
			Q.add(new int[] {idx, priorities[idx]});
			prioritiesCnt[priorities[idx]]++;
		}
		
		int p = getNowPriority(prioritiesCnt);
		
		while (!Q.isEmpty()) {
			
			int[] job = Q.poll();
			
			if(job[1] == p) {
				if(job[0] == location) { //target index
					answer = seq;
					break;
				}
				prioritiesCnt[p]--;
				seq++;
				
				p = getNowPriority(prioritiesCnt);
			}else {
				Q.add(job);
			}
		}
		return answer;
	}
	
	private static int getNowPriority(int[] prioritiesCnt) {
		
		int p = 0;
		
		for (int priority = 9; priority > 0; priority--) {
			if(prioritiesCnt[priority] > 0) {
				p = priority;
				break;
			}
		}
		
		return p;
	}

}
