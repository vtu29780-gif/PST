import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxEndingHere = arr.get(0);
        int maxSubarraySum = arr.get(0);

        int maxSubsequenceSum = 0;
        int maxElement = arr.get(0);
        boolean hasPositive = false;

        for (int num : arr) {
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
            if (num > maxElement) {
                maxElement = num;
            }
        }

        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }

        for (int i = 1; i < arr.size(); i++) {
            maxEndingHere = Math.max(arr.get(i), maxEndingHere + arr.get(i));
            maxSubarraySum = Math.max(maxSubarraySum, maxEndingHere);
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}