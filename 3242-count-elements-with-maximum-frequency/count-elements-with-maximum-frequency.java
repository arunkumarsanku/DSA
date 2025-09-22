class Solution {
    public int maxFrequencyElements(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] freq = new int[101];   
        int max = 0;
        int res = 0;

        for (int n : nums) {
            freq[n]++;
            int f = freq[n];

            if (f > max) {
                max = f;
                res = f;        // reset result to this new max frequency
            } else if (f == max) {
                res += f;       // add this element's frequency (which equals max)
            }
        }
        return res;
    }
}
