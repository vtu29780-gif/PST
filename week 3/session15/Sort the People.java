import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = map.get(heights[n - 1 - i]);
        }

        return sortedNames;
    }
}