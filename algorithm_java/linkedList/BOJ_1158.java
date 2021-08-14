package linkedList;

import java.io.*;
import java.util.*;

public class BOJ_1158 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		br.close();
		
		LinkedList<Integer> lnk = new LinkedList<Integer>();

		//add data
		for (int i = 1; i <= n; i++) {
			lnk.add(i);
		}
		
		int idx = 0;	//현재 인덱스를 담을 변수
		bw.write("<");
		while (!lnk.isEmpty()) {
			
			idx +=k-1;
			int size = lnk.size();
			while (idx >size-1) { // list 사이즈를 넘어가면 처리
				 idx = idx - size;
			}
			
			bw.write(lnk.remove(idx)+"");
			
			if(!lnk.isEmpty()) bw.write(", ");
			else bw.write(">");
			
		}
		
		bw.flush();
		bw.close();
	}

}
