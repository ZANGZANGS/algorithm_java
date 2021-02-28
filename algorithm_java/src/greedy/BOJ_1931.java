package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	//회의의 수
		
		List<int[]> list = new ArrayList<int[]>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {s,e});
		}
		Comparator<int[]> comparator = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return  o1[0] - o2[0]; //틀린이유: 동일 종료 시간일 경우 시작시간 오름차순 정렬을 생각하지 않음
				}
				return  o1[1] - o2[1];
			}
			
		};

		// 종료 시간 기준으로 정렬
		list = list.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
		
		int time = 0;//현재 시간
		int ans = 0; //스켸줄 개수
		//그리디~
		for (int i = 0; i < n; i++) {
			
			if(time> list.get(i)[0]) continue;	//시작시간
			time = list.get(i)[1];//종료시간
			ans ++;
		}
		
		System.out.println(ans);
	}

}
