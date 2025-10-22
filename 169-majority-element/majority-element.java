class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find potential candidate
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Return candidate (guaranteed by problem)
        return candidate;
    }
}
