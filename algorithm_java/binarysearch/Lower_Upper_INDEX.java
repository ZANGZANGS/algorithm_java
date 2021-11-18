package binarysearch;

import java.util.Arrays;

public class Lower_Upper_INDEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {4,15,4,12,6,7,3,7,8,35,4,7,35673,2,43,5,546,12,23,12,58};

		Arrays.sort(arr);
		
		int left =  lower_idx(12, arr);
		int right = upper_idx(12, arr);
		
		System.out.println(right-left);
		
	}

private static int lower_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] >= target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
		
	}
	
	private static int upper_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] > target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
	
	}
}
