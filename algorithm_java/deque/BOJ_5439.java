package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5439 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t =Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().replace("[", "").replace("]",""), ",");
			
			LinkedList<Integer> lnk = new  LinkedList<Integer>();
			
			for (int j = 0; j < n; j++) {
				lnk.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean fstFlag = true;	// 처음으로 시작하는 중~
			boolean errFlag = false;
			//명령어 수
			for(char cmd : p) {
					
				if(cmd == 'R') {	//뒤집기 
					fstFlag = !fstFlag;
				}else if(cmd == 'D') {//버리기 
					if(lnk.isEmpty()) {
						errFlag = true;
						break;
					}
					
					if(fstFlag) {
						lnk.pollFirst();
					}else {
						lnk.pollLast();
					}
					
				}
			}
			
			//출력
			if(!errFlag) {
				sb.append("[");
				
				if(!lnk.isEmpty()) {
					while(!lnk.isEmpty()) {
						
						sb.append(fstFlag? lnk.poll() : lnk.pollLast());
						sb.append(",");
					}
					sb.deleteCharAt(sb.lastIndexOf(","));
				}
				
				
				sb.append("]\n");
				
				
			}else {
				sb.append("error\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}

}
