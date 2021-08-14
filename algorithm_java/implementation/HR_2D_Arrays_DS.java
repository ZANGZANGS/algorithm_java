package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HR_2D_Arrays_DS {

	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        
        int[] dx = {-1,0,1,-1,0,1};
        int[] dy = {-1,-1,-1,1,1,1};
        
        int max = Integer.MIN_VALUE;
        
        for(int i=1 ; i< 5 ; i++){  //y
            for(int j=1 ; j< 5 ; j++){  //x
                int temp = arr[i][j];
                
                for(int k=0 ; k< 6 ; k++){
                    int x = j+dx[k];
                    int y = i+dy[k];

                    temp += arr[y][x];
                }
                
                max = Math.max(temp,max);
            }   
        }
        
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
