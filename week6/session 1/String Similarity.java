import java.io.*;
import java.util.*;

class Result {

    public static long stringSimilarity(String s) {
        int n = s.length();
        int[] Z = new int[n];
        
        Z[0] = n; 
        
        int L = 0, R = 0;
        long totalSimilarity = Z[0];

        for (int i = 1; i < n; i++) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            
            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
            
            totalSimilarity += Z[i];
        }

        return totalSimilarity;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            long result = Result.stringSimilarity(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}