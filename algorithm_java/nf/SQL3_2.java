package nf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class SQL3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new int[]{5, 19, 8, 1}));
		System.out.println(solution(new int[]{10, 10}));
		System.out.println(solution(new int[]{3,0,5}));
		
	}
	
	public static int solution(int A[]) {
	      int answer=0;
	      int size = A.length;
	      double B[] = new double[size];
	      double C[] = new double[size];
	      double half = 0.0;
	      double sum = 0;
	      for(int i=0;i<size;i++) {
	         B[i] = (double)A[i];
	         sum += B[i];
	      }
	      mergeSort(B);
	      for(int i=0;i<size;i++) {
	         C[i] = B[i];
	      }
	      half = sum/(2.0);
	      while(half < sum) {
	         answer++;
	         //맨끝
	         int  index = size-1;
	         sum -= (B[index]/2);
	         
	         for(; index>=0 ; index--) {
	            if(B[size-1]/2 > B[index] ) {
	               break;
	            }
	         }
	         if(index== -1) {
	            // 제일 작아지는 경우
	            C[0] = B[size-1]/2;
	            for(int i=1;i<size;i++) {
	               C[i] = B[i-1];
	            }
	         } else if(index+1 ==size-1) {
	            // 맨뒤에 있는 경우
	            C[size-1] = B[size-1]/2;
	            for(int i=0; i <index-1;i++) {
	               C[i] = B[i];
	            }
	         } else {
	            // 중간에 끼는 경우 
	            for(int i=0; i<index;i++) {
	               C[i] = B[i];
	            }
	            C[index+1] = B[size-1] /2;
	            for(int i=index+2;i<size;i++) {
	               C[i] = B[i-1];
	            }
	         }
	         // COPY
	         for(int i=0;i<size;i++) {
	            B[i] = C[i];
	         }
	      }

	      return answer;
	   }


	   
	    public static void mergeSort(double[] arr) {
	           sort(arr, 0, arr.length);
	       }

	    private static void sort(double[] arr, int low, int high) {
	        if (high - low < 2) {
	            return;
	        }

	        int mid = (low + high) / 2;
	        sort(arr, 0, mid);
	        sort(arr, mid, high);
	        merge(arr, low, mid, high);
	    }

	    private static void merge(double[] arr, int low, int mid, int high) {
	       double[] temp = new double[high - low];
	        int t = 0, l = low, h = mid;
	        while (l < mid && h < high) {
	            if (arr[l] < arr[h]) {
	                temp[t++] = arr[l++];
	            } else {
	                temp[t++] = arr[h++];
	            }
	        }

	        while (l < mid) {
	            temp[t++] = arr[l++];
	        }

	        while (h < high) {
	            temp[t++] = arr[h++];
	        }

	        for (int i = low; i < high; i++) {
	            arr[i] = temp[i - low];
	        }
	    }

}
