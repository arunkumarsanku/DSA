class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Step 1: Separate positive and negative numbers
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        // Step 2: Rearrange alternately
        int[] ans = new int[n];
        int i = 0, j = 0, k = 0;

        // Alternate between positive and negative
        while (i < pos.size() && j < neg.size()) {
            ans[k++] = pos.get(i++);
            ans[k++] = neg.get(j++);
        }

        // Step 3: Append remaining elements (if any)
        while (i < pos.size()) ans[k++] = pos.get(i++);
        while (j < neg.size()) ans[k++] = neg.get(j++);

        return ans;
    }
}
