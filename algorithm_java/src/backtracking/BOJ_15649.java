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
		isused = new boolean[n+1]; // +1 �� �ϴ� ������ �迭 �ε����� 0 ���� �����ؼ�
		sb= new StringBuilder();
		
		func(0);
		System.out.print(sb.toString());
	}

	static void func(int k) {
		
		if(k == m) { // m���� ��� ���ߴٸ�
			for(int i = 0 ; i< m ; i++) {
				sb.append(arr[i]+" "); // arr�� ����ص� ���� ���
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) { // ���� �״�� ����Ұ���
			if(!isused[i]) {// ���� i �� ������ �ʾ�����
				arr[k] = i; // k��° ���� i�� ����
				isused[i] = true; // i�� ����ߴٰ� ǥ��
				func(k+1); // ���� ���� ���Ϸ� �� �ܰ� �� ��
				isused[i] = false;	// k��° ���� i�� �� ��� ��츦 Ȯ�������� ������� �������� ����
			}
		}
	}
}