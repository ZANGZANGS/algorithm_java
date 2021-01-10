package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int n,m;
	static int[] arr;
	static boolean[] isused;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		isused = new boolean[n+1]; // +1 을 하는 이유는 배열 인덱스가 0 부터 시작해서
		sb= new StringBuilder();
		
		func(0);
		System.out.print(sb.toString());
	}

	static void func(int k) {
		
		if(k == m) { // m개를 모두 택했다면
			for(int i = 0 ; i< m ; i++) {
				sb.append(arr[i]+" "); // arr에 기록해둔 수를 출력
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) { // 숫자 그대로 사용할것임
			if(!isused[i]) {// 아직 i 가 사용되지 않았으면
				arr[k] = i; // k번째 수를 i로 정함
				isused[i] = true; // i를 사용했다고 표시
				func(k+1); // 다음 수를 정하러 한 단계 더 들어감
				isused[i] = false;	// k번째 수를 i로 한 모든 경우를 확인했으니 사용하지 않음으로 변경
			}
		}
	}
}