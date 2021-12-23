package simulation;

/**
 * @source		: 프로그래머스
 * @algorithm	: 구현
 * @description	: 최고의 집합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.23	성공
 */

public class PG_최고의_집합 {

	public static void main(String[] args) {

		PG_최고의_집합 pg = new PG_최고의_집합();
		pg.solution(2, 9);
		pg.solution(2, 1);
		pg.solution(2, 8);
	}

	public int[] solution(int n, int s) {
		int[] answer = new int[n];

		int share = s / n;
		int remainder = s % n;

		if (share == 0)
			return new int[] { -1 };

		for (int i = n - 1; i >= 0; i--) {
			if (remainder > 0) {
				answer[i] = share + 1;
				remainder--;
			} else {
				answer[i] = share;
			}
		}
		return answer;
	}
}
