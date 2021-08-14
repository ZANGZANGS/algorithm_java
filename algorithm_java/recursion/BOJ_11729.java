/**
 * �ϳ��� ž
 */
package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb.append( (1<<n)-1+"\n");
		movePlate(1, 3, n);
		
		System.out.println(sb);
	}

	//���� n���� ��� a���� b�� �ű�� �Լ�
	private static void movePlate(int a, int b, int n) {
		if(n == 1) {
			sb.append(a+" "+b+"\n");
			
		}else {
			movePlate(a, 6-a-b, n-1);		// n-1���� �ٸ� ������� �Ű�
			sb.append(a+" "+b+"\n");		// n�� ������ ���� �ű���� ������� �Ű�
			movePlate(6-a-b, b, n-1);		// �ٸ� ��տ� �Ű�� n-1���� ������ �ű�� �ߴ� ������� �Ű� 
		}
	}

}
