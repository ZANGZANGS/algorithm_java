package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	
	static int n;
	static int count = 0;
	static boolean[] isUsed1;	// ���� ��� �Ǿ����� �Ǵ�
	static boolean[] isUsed2;	// �����ϴܿ��� ������� �������� �밢�� ������� �Ǵ�
	static boolean[] isUsed3;	// �����ϴܿ��� ������� �������� �밢�� ������� �Ǵ�

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		isUsed1 = new boolean[n];
		isUsed2 = new boolean[2*n+1];	// �밢�� ������ �� ������ 2*n-1��
		isUsed3 = new boolean[2*n+1];	// �밢�� ������ �� ������ 2*n-1��
		
		func(0);		
		System.out.println(count);
		
	}
	
	private static void func(int cur) {
		if(n == cur) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+n-1]) continue;
			
			isUsed1[i] = true;
			isUsed2[i + cur] = true;
			isUsed3[cur-i+n-1] = true;
			func(cur+1);
			isUsed1[i] = false;
			isUsed2[i + cur] = false;
			isUsed3[cur-i+n-1] = false;
		}
	}

}
