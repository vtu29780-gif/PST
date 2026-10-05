class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (map1[w - 'a'] == 0 && map2[p - 'a'] == 0) {
                map1[w - 'a'] = p;
                map2[p - 'a'] = w;
            } else if (map1[w - 'a'] != p || map2[p - 'a'] != w) {
                return false;
            }
        }
        return true;
    }
}x