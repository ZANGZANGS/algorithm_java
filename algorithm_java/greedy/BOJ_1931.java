package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 그리디
 * @description	: 회의실배정
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.27	재풀이
 */
public class BOJ_1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	//회의의 수
		List<int[]> list = new ArrayList<>();
		int count = 0; //스케줄 개수 
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {s,e});
		}

		Collections.sort(list, (a,b)->{
			if(a[1]==b[1]) {
				return a[0]-b[0];
			}
			return a[1]-b[1];
			
		});
		
		int now = 0;//현재 시간
		for (int i = 0; i < n; i++) {
			if(now> list.get(i)[0]) continue;	//시작시간 체크
			now = list.get(i)[1]; //선택한 회의의 종료시간으로 변경
			count++;
		}
		
		System.out.println(count);
	}

}
