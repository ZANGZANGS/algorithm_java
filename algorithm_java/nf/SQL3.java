package nf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SQL3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new int[]{5, 19, 8, 1}));
		System.out.println(solution(new int[]{10, 10}));
		System.out.println(solution(new int[]{3,0,5}));
		System.out.println(solution(new int[]{0,0,0}));
		
		System.out.println(solution(new int[]{10,10,10,10,10,10}));
	}
	
	static public int solution(int[] A) {

		double[] doubleA = new double[A.length];
		
		for (int i = 0; i < A.length; i++) {
			doubleA[i] = A[i];
		}
		
		double originPoint = Arrays.stream(A).sum() / 2.0;
		double afterPoint = Arrays.stream(A).sum();
		int filterCnt = 0;
		
		List<Double> list = Arrays.stream(doubleA).boxed().collect(Collectors.toList());
		
		while (originPoint < afterPoint) {

//			Arrays.sort(doubleA);
			
			Collections.sort(list, Collections.reverseOrder());
			
			list.set(0, list.get(0)/2);
			
			filterCnt++;
			afterPoint = list.stream().mapToDouble(Double::doubleValue).sum();
					
		}
		
        return filterCnt;
    }

}
