import java.util.*;

class Solution {

    // Check if we can achieve at least 'minPower' for all stations using at most 'k' extra power
    private static boolean check(long minPower, int[] stations, int r, long k, int n) {
        long power = 0;

        // Initial power for the first window [0, r]
        for (int i = 0; i <= Math.min(r, n - 1); i++) {
            power += stations[i];
        }

        for (int i = 0; i < n; i++) {
            if (power < minPower) {
                long need = minPower - power;
                if (need > k) return false; // Not enough extra power
                k -= need;

                int pos = Math.min(n - 1, i + r);
                stations[pos] += need; // Greedily add at rightmost of window
                power += need;
            }

            // Slide window: remove leftmost
            if (i - r >= 0) power -= stations[i - r];
            // Slide window: add next rightmost
            if (i + r + 1 < n) power += stations[i + r + 1];
        }

        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = 0, right = 0;

        // Maximum possible power = sum(stations) + k
        for (int val : stations) right += val;
        right += k;

        long ans = 0;

        // Binary search on answer
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, Arrays.copyOf(stations, n), r, k, n)) {
                ans = mid;      // feasible, try higher
                left = mid + 1;
            } else {
                right = mid - 1; // not feasible, try lower
            }
        }

        return ans;
    }
}
