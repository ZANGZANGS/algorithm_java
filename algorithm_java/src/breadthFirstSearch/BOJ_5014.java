package breadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_5014  {
	static int F;	//건물 층수	G ≤ F ≤ 1000000
	static int S;	//강호 위치	1 ≤ S,
	static int G;	//목적지
	static int U;	//올라가는 버튼		0 ≤ U, D ≤ 1000000
	static int D;	//내려가는 버튼
	
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
		
		if(S == G) {//움직일 필요가 없는 경우 0 출력
			System.out.println(0);
		}else {
			vis[S-1] = true;
			Q.add(S-1);
			
			while (!Q.isEmpty()) {
				
				int cur = Q.poll();
				
				//올라가기
				if(cur+U < F) {
					//방문을 안했다면
					if(!vis[cur+U]) {
						vis[cur+U] = true;
						move[cur+U] = move[cur]+1;
						Q.add(cur+U);
					}
				}
				
				//내려가기
				if(cur-D >= 0) {
					//방문을 안했다면
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
