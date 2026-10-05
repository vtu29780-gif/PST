import java.io.*;
import java.util.*;

class Result {

    public static String twoStrings(String s1, String s2) {
        boolean[] charSet = new boolean[26];
        
        for (char c : s1.toCharArray()) {
            charSet[c - 'a'] = true;
        }
        
        for (char c : s2.toCharArray()) {
            if (charSet[c - 'a']) {
                return "YES";
            }
        }
        
        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            String result = Result.twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}