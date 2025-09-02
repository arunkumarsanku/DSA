import java.util.*;

class Solution {

    // Custom comparator: sort by x descending, then y ascending
    private static class PairComparator implements Comparator<int[]> {
        public int compare(int[] p, int[] q) {
            if (p[0] != q[0]) return q[0] - p[0]; // descending x
            return p[1] - q[1]; // ascending y
        }
    }

    public int numberOfPairs(int[][] P) {
        Arrays.sort(P, new PairComparator());
        int n = P.length;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            int y = Integer.MAX_VALUE;
            int yi = P[i][1];

            for (int j = i + 1; j < n; j++) {
                int yj = P[j][1];
                if (yj >= yi && y > yj) {
                    ans++;
                    y = yj;
                }
            }
        }
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] P = { {3, 1}, {2, 2}, {3, 2}, {1, 4} };
        System.out.println(sol.numberOfPairs(P)); // Output depends on input
    }
}
