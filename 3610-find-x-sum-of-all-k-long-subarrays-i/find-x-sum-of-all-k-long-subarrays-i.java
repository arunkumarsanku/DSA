class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        // Build frequency for the first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // Compute xSum for the first window
        result[0] = calculateXSum(freq, x);

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the element going out of window
            int out = nums[i - k];
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            // Add new element entering window
            int in = nums[i];
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            // Calculate xSum for this new window
            result[i - k + 1] = calculateXSum(freq, x);
        }

        return result;
    }

    private int calculateXSum(Map<Integer, Integer> freq, int x) {
        // Create max heap: order by frequency first, then by number
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        // Add all elements from frequency map
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        // If fewer than x distinct numbers, return total sum
        if (pq.size() < x) {
            int total = 0;
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                total += e.getKey() * e.getValue();
            }
            return total;
        }

        // Otherwise, take top x frequent numbers
        int res = 0;
        for (int i = 0; i < x && !pq.isEmpty(); i++) {
            int[] top = pq.poll();
            res += top[0] * top[1];
        }
        return res;
    }
}
