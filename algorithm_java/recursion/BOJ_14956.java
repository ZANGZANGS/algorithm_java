package recursion;

import java.util.*;
import java.io.*;



/**
 * @source		: baekjoon
 * @algorithm	: recursion
 * @description	: Philosopher’s Walk
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.06	fail
 */
public class BOJ_14956 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //n = 2^k ( 0 < k 15)
		int m = Integer.parseInt(st.nextToken()); //
		
	}

	private static int[] recursion(int n, int ord) {
		if(n==0) return null;
		
		int quarterSize = n*n/4;
		
		if(ord > 0 && ord <= quarterSize) { //좌측 하단
			int[] temp = recursion(n/2 , ord-quarterSize);
			int x = temp[0]; 
			int y = temp[1]; 
		}else if(ord > quarterSize && ord <= quarterSize*2) { //좌측 상단
			int[] temp = recursion(n/2 , ord-quarterSize);
			int x = temp[0]; 
			int y = temp[1]; 
		}else if(ord > quarterSize *2 && ord <= quarterSize*3) { //우측 상단
			
		}else {//우측 하단
			
		}
		
		return null;
	}
}
