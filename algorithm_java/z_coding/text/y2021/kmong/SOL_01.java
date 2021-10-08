package z_coding.text.y2021.kmong;

import java.util.*;
import java.io.*;

/**
 * 
 * @source		:
 * @algorithm	:
 * @description	:
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.08
 * 문제 설명
 */
public class SOL_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {3, 2, 1, 3}));
	}
	
	private static int solution(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int[] numArray = new int[10000001];
		
		for (int number : arr) {
			max = Math.max(max, number);
			numArray[number]++;
		}
		
		return numArray[max];
		
	}

}
