class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int pos = n - 1; pos >= 0; pos--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
        }
        return result;
    }
}