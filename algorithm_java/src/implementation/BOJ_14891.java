package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14891 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] cogwheel1 = br.readLine().split("");
		String[] cogwheel2 = br.readLine().split("");
		String[] cogwheel3 = br.readLine().split("");
		String[] cogwheel4 = br.readLine().split("");
		int K = Integer.parseInt(br.readLine());
		
		int total = 0;
		
		for (int i = 0; i < K; i++) {
			
			String input = br.readLine();
			
			int selcwheel = Integer.parseInt(input.split(" ")[0]);
			int direct = Integer.parseInt(input.split(" ")[1]);
			
			if(selcwheel == 1) {
				rotation(cogwheel1, direct);

				if( !cogwheel1[2].equals(cogwheel2[6]) ) {
					rotation(cogwheel2, -direct);
					
					if( !cogwheel2[2].equals(cogwheel3[6]) ) {
						rotation(cogwheel3, direct);
						
						if( !cogwheel3[2].equals(cogwheel4[6]) ) {
							rotation(cogwheel4, direct);
						}
					}
				}
				
			}else if(selcwheel == 2) {
				rotation(cogwheel2, direct);
				
				if( !cogwheel2[2].equals(cogwheel3[6]) ) {
					rotation(cogwheel3, -direct);
					
					if( !cogwheel3[2].equals(cogwheel4[6]) ) {
						rotation(cogwheel4, direct);
					}
				}
				
				if( !cogwheel2[6].equals(cogwheel1[2]) ) {
					rotation(cogwheel1, -direct);
				}
				
			}else if(selcwheel == 3) {
				rotation(cogwheel3, direct);
				
				if( !cogwheel3[2].equals(cogwheel4[6]) ) {
					rotation(cogwheel4, -direct);
				}
				
				if( !cogwheel3[6].equals(cogwheel2[2]) ) {
					rotation(cogwheel2, -direct);
					
					if( !cogwheel2[6].equals(cogwheel1[2]) ) {
						rotation(cogwheel1, direct);
					}
				}
				
			}else if(selcwheel == 4) {
				rotation(cogwheel4, direct);
				
				if( !cogwheel4[6].equals(cogwheel3[2]) ) {
					rotation(cogwheel3, -direct);
					
					if( !cogwheel3[6].equals(cogwheel2[2]) ) {
						rotation(cogwheel2, direct);
						
						if( !cogwheel2[6].equals(cogwheel1[2]) ) {
							rotation(cogwheel1, -direct);
						}
					}
				}
			}
		}
		
		//N극은 0
		
		if("0".equals(cogwheel1[0])) {
			total +=0;
		}else {
			total +=1;
		}
		
		if("0".equals(cogwheel2[0])) {
			total +=0;
		}else {
			total +=2;
		}
		
		if("0".equals(cogwheel3[0])) {
			total +=0;
		}else {
			total +=4;
		}
		
		if("0".equals(cogwheel4[0])) {
			total +=0;
		}else {
			total +=8;
		}
		
		
		System.out.println(total);
		
		
	}
	
	
	public static void rotation(String[] cogwheel, int direct) {
		
		String temp="";
		
		if(direct == 1) {//시계 방향
			temp =cogwheel[7];
			for (int i = 7; i > 1; i--) {
				cogwheel[i] = cogwheel[i-1];
			}
			cogwheel[0]= temp;
		}else {
			temp =cogwheel[0];
			for (int i = 0; i < cogwheel.length-1; i++) {
				cogwheel[i]= cogwheel[i+1];
			}
			cogwheel[7] = temp;
		}
		
	}

}

class Rot{
	int selcWheel;
	int direction;
}
