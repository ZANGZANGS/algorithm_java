package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BOJ_15683 {

	static int[][] arr ;
	static List<int[]> list = new ArrayList<>();
	static int n;
	static int m;
	static int cctvArea;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		n = input[0]-'0'; 
		m = input[2]-'0';
		
		arr = new int[n][m];
		
		
		for (int i = 0; i < n; i++) {
			input = br.readLine().replaceAll(" ", "").toCharArray();
			for (int j = 0; j <m; j++) {
				int temp = input[j]-'0';
				arr[i][j] = temp;
				if(temp > 0 && temp <6)list.add(new int[] {i,j});
			}
		}
		
		func(0);
		
		
		System.out.println();
	}

	public static void func(int k) {
		
		
		if(list.size()-1 == k) {
			int tempMax = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j] == 0) tempMax++;
				}
			}
			
			cctvArea = Math.max(cctvArea, tempMax); // 계산하고,,
			return;	//리스트 마지막에오면 그냥 반환.
		}
		
		int[] temp = list.get(k);
		int x = temp[0];
		int y = temp[1];
		Stack<int[]> stack = new Stack<int[]>();
		
		if(arr[x][y] == 1) {
			//1.
			for (int i = x+1; i < n; i++) {
				
				if(arr[i][y] == 6)break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					stack.add(new int[] {i,y});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			
			//2.
			for (int i = 0; i < x; i++) {
				
				if(arr[i][y] == 6)break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					stack.add(new int[] {i,y});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			//3.
			for (int i = 0; i < y; i++) {
				
				if(arr[x][i] == 6)break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					stack.add(new int[] {x,i});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			//4.
			for (int i = y+1; i < m; i++) {
				
				if(arr[x][i] == 6)break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					stack.add(new int[] {x,i});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			
			
		}else if(arr[x][y] == 2) {
			
			//1.
			for (int i = 0; i <n; i++) {
				
				if(arr[i][y] == 6)break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					stack.add(new int[] {i,y});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			//2.
			for (int i = 0; i < m; i++) {
				
				if(arr[x][i] == 6)break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					stack.add(new int[] {x,i});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			
		}else if(arr[x][y] == 3) {
			//1.
			for (int i = 0; i <n; i++) {
				if(i>n) break;
				if(arr[i][y] == 6)break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					stack.add(new int[] {i,y});
				}
			}
			for (int i = y+1; i < m; i++) {
				if(i>m) break;
				if(arr[x][i] == 6)break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					stack.add(new int[] {x,i});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
			
		}else if(arr[x][y] == 4) {
			
		}else if(arr[x][x] == 5) {
			for (int i = 0; i <n; i++) {
				
				if(arr[i][y] == 6)break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					stack.add(new int[] {i,y});
				}
			}
			for (int i = 0; i < m; i++) {
				
				if(arr[x][i] == 6)break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					stack.add(new int[] {x,i});
				}
			}
			func(k+1);
			stack.forEach(v-> arr[v[0]][v[1]] = 1);
			stack.clear();
		}
	}
}
