package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15686 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int N = Integer.parseInt(input.split(" ")[0]);	//주택의 개수: N ~ 2N
		int M = Integer.parseInt(input.split(" ")[1]);	//치킨칩의 개수  M ~ 13
		
		System.out.println("N : "+ N);
		System.out.println("M : "+ M);
		
		int[][] arr = new int[N][N];
//		int result = Integer.MAX_VALUE;
		
		List<XY> house = new ArrayList<XY>();
		List<XY> chicken = new ArrayList<XY>();
		
		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if("1".equals(info[j])) {
					house.add(new XY(i,j));
				}else if("2".equals(info[j])) {
					chicken.add(new XY(i,j));
				}
			}
		}
		

		
		
		
	}
	
	public static int caldist(XY spot1, XY spot2) {
		
		return Math.abs(spot1.x - spot2.x) + Math.abs(spot1.y - spot2.y);
	}	
	
}

class XY {
	int x;
	int y;
	
	XY(int x, int y){
		this.x = x;
		this.y = y;
	}
}
