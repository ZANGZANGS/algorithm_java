package a_basic_component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class PG_sortBoxer  {

	public static void main(String[] args) throws IOException{
		
//		solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"});
//		solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"});
		solution(new int[]{60,70,60}, new String[]{"NNN","NNN","NNN"});
		
	}
	
	public static int[] solution(int[] weights, String[] head2head) {
        
		
		List<Boxer> list = new ArrayList<Boxer>();
		
		for (int i = 0; i < head2head.length; i++) {
			
			double winCnt = 0;
			double totalGame= 0;
			int winBigman = 0;
			
			Boxer boxer = new Boxer(i, weights[i]);
			
			for (int j = 0; j < head2head.length; j++) {
				char[] chArr = head2head[i].toCharArray();
				
				if(chArr[j] == 'W') {
					winCnt++;
					totalGame++;
					
					if(weights[j] > weights[i]) {
						winBigman++;
					}
					
				}else if(chArr[j] == 'L') {
					totalGame++;
				}
			}
			
			
			boxer.rateOfWin = Math.floor(OptionalDouble.of(winCnt/totalGame*100).orElse(0))/100;
			boxer.winBigman = winBigman;
			
			list.add(boxer);
		}
		
		Comparator<Boxer> comparator = new Comparator<Boxer>() {
			
			@Override
			public int compare(Boxer o1, Boxer o2) {
				// TODO Auto-generated method stub
				
				if(o1.rateOfWin > o2.rateOfWin) {
					return -1;
					
				}else if(o1.rateOfWin < o2.rateOfWin){
					return 1;
					
				}else {
					 if(o1.winBigman > o2.winBigman) {
						 return -1;
					 }else if(o1.winBigman < o2.winBigman) {
						 return 1;
					 }else {
						 if(o1.weight > o2.weight) {
							 return -1;
						 }else if(o1.weight < o2.weight) {
							 return 1;
						 }else {
							 if(o1.index < o2.index) {
								 return -1;
							 }else {
								 return 1;
							 }
						 }
					 }
				}
			}
		};
		
		//정렬
        return list.stream().sorted(comparator).mapToInt(v -> v.index+1).toArray();
        
    }
	
}

class Boxer{
	
	int index;
	double rateOfWin;
	int winBigman;
	int weight;
	
	public Boxer(int index, int weight) {
		this.index = index;
		this.weight = weight; 
	}
}
