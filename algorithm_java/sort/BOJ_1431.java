package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ_1431 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		br.close();
		
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				//1. 길이 짧은 것이 먼저 정렬
				if(o1.length() != o2.length()) {
					return o1.length() < o2.length() ? -1 : 1;
				} 
				
				//2. 길이가 같으면, 숫자합이 작은것이 먼저
				if(o1.length() == o2.length()) {
					
					int sum1=0, sum2=0;
					
					for (char ch : o1.toCharArray()) {
						if(ch >= 'A') continue;
						sum1 += ch-'0';
					}
					for (char ch : o2.toCharArray()) {
						if(ch >= 'A') continue;
						sum2 += ch-'0';
					}
					
					if(sum1 < sum2) return -1;
					if(sum1 > sum2) return 1;
				}
				
				//3. 사전순으로 비교
				for (int i = 0; i < o1.length(); i++) {
					
					if(o1.charAt(i) < o2.charAt(i)) return -1;
					if(o1.charAt(i) > o2.charAt(i)) return 1;
				}
				return 0;
				
			}
		};
		
		StringBuilder sb = new StringBuilder();
		list.stream()
		.sorted(comparator)
		.forEach(v-> sb.append(v+"\n"));
		
		System.out.println(sb.toString());

	}

}
