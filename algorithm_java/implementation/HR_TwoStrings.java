package implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] alphbet = new int[26];
        int sum = 0;
        
        //배열에 해당 알파벳이 나올 때마다 값 증가
        for(char c : s1.toCharArray()){
            alphbet[c-'a']++;
        }
        
        //배열에 해당 알파벳이 나올 때마다 값 감소.
        for(char c : s2.toCharArray()){
        	if(alphbet[c-'a']>0) alphbet[c-'a']--;	//단, 값이 있는 경우.
        }
        sum = Arrays.stream(alphbet).sum();
        
        
        //s1 문자열의 길이와 배열의 합이 다르면 겹치는 알파벳이 있는 것
        return s1.length() !=sum ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
 