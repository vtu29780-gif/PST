import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            int lineIdx = x - 1;
            int posIdx = y - 1;
            
            if (lineIdx >= 0 && lineIdx < lines.size() && posIdx >= 0 && posIdx < lines.get(lineIdx).size()) {
                System.out.println(lines.get(lineIdx).get(posIdx));
            } else {
                System.out.println("ERROR!");
            }
        }
        scanner.close();
    }
}