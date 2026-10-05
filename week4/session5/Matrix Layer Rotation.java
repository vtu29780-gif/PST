import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;
        
        int[][] result = new int[m][n];

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> elements = new ArrayList<>();
            
            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }
            for (int i = layer + 1; i < m - layer - 1; i++) {
                elements.add(matrix.get(i).get(n - 1 - layer));
            }
            for (int j = n - 1 - layer; j >= layer; j--) {
                elements.add(matrix.get(m - 1 - layer).get(j));
            }
            for (int i = m - 2 - layer; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            int len = elements.size();
            int shift = r % len;

            int idx = shift;

            for (int j = layer; j < n - layer; j++) {
                result[layer][j] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            for (int i = layer + 1; i < m - layer - 1; i++) {
                result[i][n - 1 - layer] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            for (int j = n - 1 - layer; j >= layer; j--) {
                result[m - 1 - layer][j] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            for (int i = m - 2 - layer; i > layer; i--) {
                result[i][layer] = elements.get(idx);
                idx = (idx + 1) % len;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}