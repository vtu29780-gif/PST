import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        String doubleS = s + s;

        // Transform string for Manacher's Algorithm
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < doubleS.length(); i++) {
            sb.append(doubleS.charAt(i)).append('#');
        }
        String t = sb.toString();
        int m = t.length();
        int[] P = new int[m];

        int C = 0, R = 0;
        for (int i = 0; i < m; i++) {
            int iMir = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[iMir]);
            }
            while (i - 1 - P[i] >= 0 && i + 1 + P[i] < m && t.charAt(i - 1 - P[i]) == t.charAt(i + 1 + P[i])) {
                P[i]++;
            }
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            int maxLen = 0;
            // The rotated string starts at index k and ends at index k + n - 1 in doubleS
            int startT = 2 * k;
            int endT = 2 * (k + n - 1) + 2;

            for (int i = startT; i <= endT; i++) {
                int maxRad = Math.min(i - startT, endT - i);
                int actualRad = Math.min(P[i], maxRad);
                if (actualRad > maxLen) {
                    maxLen = actualRad;
                }
            }
            result.add(maxLen);
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine().trim();

        List<Integer> result = Result.circularPalindromes(s);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}