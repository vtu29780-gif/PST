class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowelsInFirstHalf = 0;
        int vowelsInSecondHalf = 0;
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                vowelsInFirstHalf++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                vowelsInSecondHalf++;
            }
        }   
        return vowelsInFirstHalf == vowelsInSecondHalf;
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}