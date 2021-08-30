package nf;

public class SQL2 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 0, 0, 1, 1 }, new int[] { 2 }));
		System.out.println(solution(new int[] { 0, 0, 0, 0, 2, 3, 3 }, new int[] { 2, 5, 6 }));
		System.out.println(solution(new int[] { 0, 0, 1, 2 }, new int[] { 1, 2 }));
		System.out.println(solution(new int[] { 0, 3, 0, 0, 5, 0, 5 }, new int[] { 4, 2, 6, 1, 0 }));
		System.out.println(solution(new int[] { 0 }, new int[] { 0 }));

	}

	public static boolean used[];
	public static int parent[];

	public static int solution(int T[], int A[]) {
		int Tsize = T.length;
		int Asize = A.length;
		used = new boolean[Tsize];
		parent = new int[Tsize];
		for (int i = 0; i < Tsize; ++i) {
			if (i != 0) {
				parent[i] = T[i];
			}
		}
		int answer = 0;
		for (int i = 0; i < Asize; i++) {
			answer += Q(A[i]);
		}
		return answer;
	}

	private static int Q(int i) {
		if (used[i]) {
			// 사용되었다면 ? return 0;
			return 0;
		}
		used[i] = true;
		if (i == 0)
			return 1;
		// 안되었다면 부모꺼 + 자기자신
		return Q(parent[i]) + 1;
	}

}
