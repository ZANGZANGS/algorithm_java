package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

	static int L,C;
	static char pw[];
	static char alphabet[];
	static boolean isUsed[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pw = new char[L];
		alphabet = new char[C];
		isUsed = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		bckt(0);
		
		System.out.println(sb.toString());
		
	}
	
	private static void bckt(int k) {
		if(k == L) {
			
			int moumCnt = 0;
			int jaumCnt = 0;
			
			for (char c : pw) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					moumCnt++;
				}else {
					jaumCnt++;
				}
			}
			
			if(moumCnt >= 1 && jaumCnt >= 2) {
				for (char c : pw) {
					sb.append(c);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = 0; i < C; i++) {
			
			if(k>0 && pw[k-1] > alphabet[i]) continue;
			
			if(!isUsed[i]) {
				isUsed[i] = true;
				pw[k] = alphabet[i];
				bckt(k+1);
				isUsed[i] = false;
			}
			
		}
	}

}
