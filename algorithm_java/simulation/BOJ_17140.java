package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 시물레이션
 * @description	: 이차원 배열과 연산
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.27	성공
 */
public class BOJ_17140 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		int[][] arrA = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arrA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int time = 0;
		while(!(arrA.length >= r && arrA[0].length >= c) 
				|| arrA[r-1][c-1] != k) {
			
			if(arrA.length >= arrA[0].length) {
				arrA = processR(arrA); // r>=c
			}else {
				arrA = processC(arrA); // r<c
			}
			
			time++;
			if(time>100) {
				time = -1;
				break;
			}
		}
		
		
		System.out.println(time);
		
//		A[r][c] 
//		R 연산: 모든 행(c)에 대해서 정렬. 행의 개수(c) ≥ 열의 개수(r)인 경우에 적용된다.
//		C 연산: 모든 열(r)에 대해서 정렬. 행의 개수(c) < 열의 개수(r)인 경우에 적용된다.

	}

	//R 연산: 모든 행(c)에 대해서 정렬. 행의 개수(c) ≥ 열의 개수(r)인 경우에 적용된다.
	private static int[][] processR(int[][] arr) {
		
		int col = arr.length;
		int row = arr[0].length;
		
		int maxLen = 0;
		
		Map<Integer, Integer> map;
		List<int[]>[] list = new ArrayList[col];
		
		for (int i = 0; i < col; i++) {
			map = new HashMap<>();
			list[i] = new ArrayList<>();
			
			for (int j = 0; j < row; j++) {
				int key = arr[i][j];
				
				if(key == 0) continue; //0은 담지 않는다.
				
				if(map.get(key) == null) {
					map.put(key, 1);
				}else {
					int val = map.remove(key);
					map.put(key, val+1);
				}
			}
			
			
			for(Integer key: map.keySet()) {
				list[i].add(new int[] {key, map.get(key)});
			}
			
			Collections.sort(list[i],
					(a,b)->{
						
						if(a[1]==b[1]) {
							return a[0]-b[0];
						}
						return a[1]-b[1];
					});
			
			arr[i] = list[i].stream().flatMapToInt(v-> Arrays.stream(v)).toArray();
			
			maxLen = Math.max(maxLen, arr[i].length);
		}
		
		
		
		for (int i = 0; i < col; i++) {
			int[] ar = arr[i];

			
			if(maxLen >ar.length) {
				if(maxLen>100) maxLen = 100; //100개 초과시 100으로 맞춘다.
				int[] temp = new int[maxLen];
				
				for (int j = 0; j < ar.length; j++) {
					if(j == 100) break; //100개 넘어가면 stop
					temp[j] = ar[j];
				}
				arr[i] = temp;
			}
			
		}
		
		return arr;
		
	}
	
	//C 연산: 모든 열(r)에 대해서 정렬. 행의 개수(c) < 열의 개수(r)인 경우에 적용된다.
	private static int[][] processC(int arr[][]) {
		
		int col = arr.length;
		int row = arr[0].length;
		
		int maxLen = 0;
		
		Map<Integer, Integer> map;
		List<int[]>[] list = new ArrayList[row];
		List<int[]> newList = new ArrayList<>();
		
		for (int i = 0; i < row; i++) { //x
			map = new HashMap<>();
			list[i] = new ArrayList<>();
			
			for (int j = 0; j < col; j++) { //y
				int key = arr[j][i];
				
				if(key == 0) continue; //0은 담지 않는다.
				
				if(map.get(key) == null) {
					map.put(key, 1);
				}else {
					int val = map.remove(key);
					map.put(key, val+1);
				}
			}
			
			
			for(Integer key: map.keySet()) {
				list[i].add(new int[] {key, map.get(key)});
			}
			
			Collections.sort(list[i],
					(a,b)->{
						
						if(a[1]==b[1]) {
							return a[0]-b[0];
						}
						return a[1]-b[1];
					});
			
			int[] temp = list[i].stream().flatMapToInt(v-> Arrays.stream(v)).toArray();
			newList.add(temp);
			maxLen = Math.max(maxLen, temp.length);
		}
		
		
		if(maxLen>100) maxLen = 100; //100개 초과시 100으로 맞춘다.
		int[][] newArr = new int[maxLen][row];
		
		for (int i = 0; i < newList.size(); i++) {
			
			int[] temp = newList.get(i);
			
			for (int j = 0; j < temp.length; j++) {
				if(j == 100) break; //100개 초과시 stop
				newArr[j][i] = temp[j];
				
			}
		}
		
		return newArr;
	}
}
