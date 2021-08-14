package z.coding.test.y2021.hyundaicard;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Sol2 {

	static int[] numbers;
    static int k = 5;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
        numbers = new int[]{1, 2, 3, 4,5};

        
        numbers.toString();
        
        while(get_next_perm()){
            for(int num : numbers){
                bw.write(String.valueOf(num) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
	}
	
	private static boolean get_next_perm(){
        int i = k-1;

        // 뒤에서부터 체크하여 현재 위치가 뒤에서부터 오름차순이 아닌 경우를 찾음
        // 뒤에서부터 오름차순이라는 것은 사전 순으로 최종 수열이라는 의미임
        while(i > 0 && numbers[i-1] >= numbers[i]) i--;

        // 이미 자체적으로 최종 순열이라면, false를 반환
        if(i <= 0) return false;

        // j는 현재 i-1위치에서 시작.
        // i-1 이후의 모든 숫자 중 큰 것을 고르는데 그 중, j의 값이 가장 큰 경우로 선택
        int j = i-1;
        while(j < k-1 && numbers[j+1] > numbers[i-1]) j++;

        // j와 i-1번째의 숫자를 swap
        swap(i-1, j);

        // i번째부터 이후의 모든 숫자를 뒤집음
        // i~n-1 사이의 숫자를 상호 뒤집어야 하므로 j 값을 n-1로 초기화
        j = k-1;
        while(i < j){
            swap(i, j);
            i+=1; j-=1;
        }
        return true;
    }

    private static void swap(int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
