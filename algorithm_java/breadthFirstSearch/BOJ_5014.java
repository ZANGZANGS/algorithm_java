package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_5014  {
	static int F;	//�ǹ� ����	G �� F �� 1000000
	static int S;	//��ȣ ��ġ	1 �� S,
	static int G;	//������
	static int U;	//�ö󰡴� ��ư		0 �� U, D �� 1000000
	static int D;	//�������� ��ư
	
	static Queue<Integer> Q;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		F =Integer.parseInt(st.nextToken());
		S =Integer.parseInt(st.nextToken());
		G =Integer.parseInt(st.nextToken());
		U =Integer.parseInt(st.nextToken());
		D =Integer.parseInt(st.nextToken());
		Q = new LinkedList<>();
		
		int[] move = new int[F];
		boolean[] vis = new boolean[F];
		
		if(S == G) {//������ �ʿ䰡 ���� ��� 0 ���
			System.out.println(0);
		}else {
			vis[S-1] = true;
			Q.add(S-1);
			
			while (!Q.isEmpty()) {
				
				int cur = Q.poll();
				
				//�ö󰡱�
				if(cur+U < F) {
					//�湮�� ���ߴٸ�
					if(!vis[cur+U]) {
						vis[cur+U] = true;
						move[cur+U] = move[cur]+1;
						Q.add(cur+U);
					}
				}
				
				//��������
				if(cur-D >= 0) {
					//�湮�� ���ߴٸ�
					if(!vis[cur-D]) {
						vis[cur-D] = true;
						move[cur-D] = move[cur]+1;
						Q.add(cur-D);
					}
				}
				
			}
			
			System.out.println(move[G-1] == 0 ? "use the stairs" : move[G-1]);
		}
		
		
		
	}

}
