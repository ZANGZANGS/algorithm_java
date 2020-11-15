/**
 * ��Ϲ���
 */
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14891 {
	static int[][] wheel;
	public static void main(String[] args) throws IOException {
		
		int round; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		wheel = new int[4][8];
		
		for (int i = 0; i < 4; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = temp[j]-'0';
			}
		}
		
		round = Integer.parseInt(br.readLine());
		for (int i = 0; i < round; i++) {
			String temp = br.readLine();
			int target = Integer.parseInt(temp.split(" ")[0])-1;//�迭�̶� 1 �A��.
			int direction= Integer.parseInt(temp.split(" ")[1]);
			
			left(target-1, -direction);
			right(target+1, -direction);
			rotateWheel(target, direction);
			
		}
		
		//���� ���
//		1�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 1��
//		2�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 2��
//		3�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 4��
//		4�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 8��
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += wheel[i][0] * (1<<i);
			
		}
		System.out.println(result);
	}
	
	public static void left(int target, int direction) {
		if (target <0) return;
		
		if(wheel[target][2] != wheel[target+1][6]) {
			left(target-1, -direction);
			rotateWheel(target, direction);
		}
		
	}
	
	public static void right(int target, int direction) {
		if (target >3) return;
		
		if(wheel[target][6] != wheel[target-1][2]) {
			right(target+1, -direction);
			rotateWheel(target, direction);
			
		}
	}
	
	public static void rotateWheel(int target, int direction) {
		int temp;
		if(direction == 1) {// �ð���� ȸ��
			temp = wheel[target][7];
			for (int i = 7; i > 0; i--) {
				wheel[target][i] = wheel[target][i-1];
			}
			wheel[target][0] = temp;
			
		}else if(direction == -1){// �ݽð�
			temp = wheel[target][0];
			for (int i = 0; i <7 ; i++) {
				wheel[target][i] = wheel[target][i+1];
			}
			wheel[target][7] = temp;
		}
	}
}

