package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @source		: 프로그래머스
 * @algorithm	: 투 포인터
 * @description	: 보석 쇼핑
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.21	성공
 */
public class PG_보석_쇼핑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A1 = solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" });
		Arrays.stream(A1).forEach(v -> System.out.print(v + ", "));

		System.out.println();
		int[] A2 = solution(new String[] { "AA", "AB", "AC", "AA", "AC" });
		Arrays.stream(A2).forEach(v -> System.out.print(v + ", "));

		System.out.println();
		int[] A3 = solution(new String[] { "XYZ", "XYZ", "XYZ" });
		Arrays.stream(A3).forEach(v -> System.out.print(v + ", "));

		System.out.println();
		int[] A4 = solution(new String[] { "ZZZ", "YYY", "NNNN", "YYY", "BBB" });
		Arrays.stream(A4).forEach(v -> System.out.print(v + ", "));

		System.out.println();
		int[] A5 = solution(new String[] { "A", "A", "B" });
		Arrays.stream(A5).forEach(v -> System.out.print(v + ", "));


//	[3, 7]
//	[1, 3]
//	[1, 1]
//	[1, 5]
//	[2, 3]
	}

	static public int[] solution(String[] gems) {

		int jewelCount = Arrays.stream(gems).collect(Collectors.toSet()).size();

		int lp = 0;
		int rp = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();
		List<int[]> list = new ArrayList<int[]>();

		while (lp < gems.length && rp < gems.length +1) {

			int len = map.size();

			if (len < jewelCount && rp < gems.length ) {

				int cnt = map.get(gems[rp]) == null ? 0 : map.remove(gems[rp]);
				map.put(gems[rp], cnt + 1);
				rp++;
			} else {
				
				if(map.size() == jewelCount) list.add(new int[] { lp+1, rp });

				int cnt = map.remove(gems[lp]);

				if (cnt > 1) {
					map.put(gems[lp], cnt - 1);
				}

				lp++;
				
				
			}

		}

		list.sort((a, b) -> {
			if (a[1] - a[0] == b[1] - b[0]) {
				return a[0] - b[0];
			}
			return (a[1] - a[0]) - (b[1] - b[0]);
		});

		return list.get(0);


	}
}
