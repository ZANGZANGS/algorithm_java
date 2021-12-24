package binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 * @source		: 백준
 * @algorithm	: 이진 탐색 트리
 * @description	: 이중 우선순위 큐
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.24	성공
 */
public class BOJ_7662 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> tree = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				String cmd = st.nextToken();
				int number = Integer.parseInt(st.nextToken());

				if (cmd.equals("I")) {
					if(tree.get(number) != null) {
						tree.put(number, tree.get(number)+1);
					}else {
						tree.put(number, 1);
					}
					
				} else if (cmd.equals("D")) {
					if (tree.isEmpty())	continue;

					if (number == 1) { // 최댓값 삭제
						Entry<Integer, Integer> entry = tree.pollLastEntry();
						if(entry.getValue() > 1) {
							tree.put(entry.getKey(), entry.getValue()-1);
						}
						
					} else if (number == -1) { // 최솟값 삭제
						Entry<Integer, Integer> entry = tree.pollFirstEntry();
						if(entry.getValue() > 1) {
							tree.put(entry.getKey(), entry.getValue()-1);
						}
					}
				}

			}
			if (tree.isEmpty()) {
				sb.append("EMPTY");
			} else {
				int max = tree.lastKey();
				int min = tree.firstKey();
				sb.append(max + " " + min);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
