class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // stores the maximum sum found so far
        int currentSum = 0;              // stores the current subarray sum

        for (int num : nums) {
            currentSum += num;           // include current element
            maxSum = Math.max(maxSum, currentSum); // update maxSum if needed

            if (currentSum < 0) {
                currentSum = 0;          // reset if current sum is negative
            }
        }
        return maxSum;
    }
}
