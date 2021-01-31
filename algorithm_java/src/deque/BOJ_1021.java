package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n,m;
		int target, targetIdx;
		int moveCnt=0;
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		
		LinkedList<Integer> lnk = new  LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			lnk.add(i);
		}
		
		for (int i = 0; i < m; i++) {
			target = Integer.parseInt(st.nextToken());
			
			targetIdx = lnk.indexOf(target);
			
			//2번으로 돌릴지 3번으로 돌릴지 결정하자
			if(targetIdx <= lnk.size()/2) { //2번으로 돌리자. 
				for (int j = 0; j < targetIdx; j++) {
					int temp = lnk.pop();
					lnk.add(temp);
					moveCnt++;
				}
				
			}else {//3번으로 돌리자.
				for (int j = 0; j < lnk.size()-targetIdx; j++) {
					int temp = lnk.pollLast();
					lnk.push(temp);
					moveCnt++;
				}
				
			}
			
			lnk.pop();
			
		}
		
		System.out.println(moveCnt);
	}

}
