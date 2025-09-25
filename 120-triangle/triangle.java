class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> tri) {
        dp = new Integer[tri.size()][tri.size()];
        return dfs(tri, 0, 0);
    }

    private int dfs(List<List<Integer>> tri, int i, int j) {
        if (i == tri.size() - 1) return tri.get(i).get(j);
        if (dp[i][j] != null) return dp[i][j];
        int down = dfs(tri, i + 1, j);
        int diag = dfs(tri, i + 1, j + 1);
        return dp[i][j] = tri.get(i).get(j) + Math.min(down, diag);
    }
}
