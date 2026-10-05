import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (deque.size() == m) {
                if (frequencyMap.size() > maxUnique) {
                    maxUnique = frequencyMap.size();
                }
                if (maxUnique == m) {
                    break;
                }
                int removed = deque.remove();
                int count = frequencyMap.get(removed);
                if (count == 1) {
                    frequencyMap.remove(removed);
                } else {
                    frequencyMap.put(removed, count - 1);
                }
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}