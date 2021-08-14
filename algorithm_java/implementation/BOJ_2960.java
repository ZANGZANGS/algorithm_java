package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] index = new boolean[N-1];
		
		int delCnt = 0;	//삭제되는 횟수 기록
		int mulNum = 1;
		int Pnum = 2;
		
		while (delCnt < N) {
			if(Pnum*mulNum> N) {
				for (int j = 0; j < N-1; j++) {
					if(index[j] == false) {
						Pnum = j+2;
						mulNum = 1;	//배수 초기화
						break;
					}
				}
			}
			
			if(!index[Pnum*mulNum-2]) { // 지워진 수인지 체크 후 삭제
				index[Pnum*mulNum-2] = true;
				//System.out.println("삭제되는 수:" + Pnum*mulNum);
				delCnt++;
				if(delCnt == K) {
					System.out.println(Pnum*mulNum);
					break;
				}
			}
			mulNum++;
		}
	}
}
