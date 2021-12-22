package dynamicprogramming;

import java.util.Arrays;
/**
 * @source		: 프로그래머스
 * @algorithm	: dp
 * @description	: 정수 삼각형
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.22	성공
 */

public class PG_정수삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PG_정수삼각형  pg= new PG_정수삼각형();
		pg.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
		
	}

	
	public int solution(int[][] triangle) {

        int len = triangle.length;
        int[][] dp = new int[len][len];

        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < len; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
				}
				
			}
			
		}
        
        return Arrays.stream(dp[len-1]).max().getAsInt();
    }
	 
}
