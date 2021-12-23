package backtracking;
/**
 * @source		: 프로그래머스
 * @algorithm	: 백트레킹
 * @description	: N-Queen
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.23	성공
 */
public class PG_N_Queen {
	
	
	public static void main(String[] args) {

		PG_N_Queen pg = new PG_N_Queen();
		pg.solution(4);
	}

	static int N;
	static int answer;
	static boolean[] isUsed1; // 세로
	static boolean[] isUsed2; // 왼 대각선
	static boolean[] isUsed3; // 오른 대각선

	public int solution(int n) {
		N = n;
		answer = 0;
		isUsed1 = new boolean[N];
		isUsed2 = new boolean[2 * N - 1];
		isUsed3 = new boolean[2 * N - 1];

		bt(0);
		return answer;
	}

	static public void bt(int k) {
		if (k == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isUsed1[i])	continue;
			if (isUsed2[k - i + N - 1])	continue;
			if (isUsed3[k + i])	continue;

			isUsed1[i] = true;
			isUsed2[k - i + N - 1] = true;
			isUsed3[k + i] = true;
			bt(k + 1);
			isUsed1[i] = false;
			isUsed2[k - i + N - 1] = false;
			isUsed3[k + i] = false;

		}

	}

}
