import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int T = Integer.parseInt(line.trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();
            int[] freq = new int[26];
            int mid = n / 2;
            for (int i = 0; i < mid; i++) {
                freq[s.charAt(i) - 'a']++;
                freq[s.charAt(n - 1 - i) - 'a']--;
            }
            boolean isLapindrome = true;
            for (int count : freq) {
                if (count != 0) {
                    isLapindrome = false;
                    break;
                }
            }
            if (isLapindrome) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}