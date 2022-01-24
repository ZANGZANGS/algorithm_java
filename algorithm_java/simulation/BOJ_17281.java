package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 야구
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.24	성공
 */
public class BOJ_17281 {
	static int N;
	static int[][] player;
	static int[] order = new int[9];
	static boolean[] isUsed = new boolean[9];
	static int maxScore = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		player = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isUsed[0] = true; 
		order[3] = 0;//가장 좋아하는 1번 선수를 4번 타자로 지명

		bt(0);
		
		System.out.println(maxScore);
	}

	public static void bt(int k) {
		if(k == 9) {
			game();
			return;
		}
		
		if(k == 3) { //4번 타자는 pass
			bt(k+1);
		}else {
			for (int i = 0; i < 9; i++) {
				if(isUsed[i]) continue;
				
				isUsed[i] = true;
				order[k] = i;
				bt(k+1);
				isUsed[i] = false;
			}
		}
		
		
		
	}
	
	public static void game() {
		int innings = 0;
		int score = 0;
		int idx = 0;
		
		while (innings < N) {
			int outCount = 0;
			int[] ru = new int[3];
			
			while(outCount<3) {
				idx = idx%9;
				int tar = order[idx++];
				int hit = player[innings][tar];
				
				if(hit == 1) {
					score += ru[2];
					
					ru[2] = ru[1];
					ru[1] = ru[0]; 
					ru[0] = 1;
					
				} else if(hit == 2) {
					score += ru[2];
					score += ru[1];
					
					ru[2] = ru[0]; //1루 -> 3루
					ru[1] = 1;//타수 -> 2루 
					ru[0] = 0;//1루 -> 없음
					
				} else if(hit == 3) {
					//모든 선수가 들어오고, 3루에 선수 1명
					score += ru[2];
					score += ru[1];
					score += ru[0];
					
					ru[2] = 1;
					ru[1] = 0;
					ru[0] = 0;
					
				} else if(hit == 4) {
					for(int i=0; i<3 ; i++) {
						score += ru[i];
						ru[i] = 0;
					}
					score+=1;
				}else {
					outCount++;
				}
				
			}
			
			//3 OUT 이후 이닝수 증가
			innings++;
			
		}
		
		//경기 종료
		maxScore = Math.max(score, maxScore);
		
	}

}
